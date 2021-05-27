package ma.emsi.tp_jpa.web;
       
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ma.emsi.tp_jpa.entities.Patient;
import ma.emsi.tp_jpa.repositories.PatientRepository;

@Controller
public class PatientsController {
	@Autowired
	private PatientRepository patientRepository;
	@GetMapping(path="/patients")
	public String list(Model model,
			@RequestParam (name="page",defaultValue="0")int page,
			@RequestParam (name="size",defaultValue="10")int size,
			@RequestParam (name="keyword",defaultValue="")String mc){
		Page<Patient> pagePatients = patientRepository.findByNomContains(mc,PageRequest.of(page, size));
		model.addAttribute("patients",pagePatients.getContent());
		model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
		model.addAttribute("currentPage",page);
		
		model.addAttribute("keyword",mc);
		return "patients";
	}
	@GetMapping("/patients/{id}")
	public Patient patients(@PathVariable long id){
		return patientRepository.findById(id).get();
	}
	@GetMapping(path = "/index")
	public String index() {
		return "index";
	}
	@GetMapping(path = "/deletePatient")
	public String delete(Long id) {
		patientRepository.deleteById(id);
		return "redirect:/patients";
	}
	@GetMapping(path= "/formPatient")
	public String formPatient(Model model) {
		model.addAttribute("patient", new Patient());
		model.addAttribute("mode","new");
		return "formPatient";
	}
	@PostMapping(path= "/savePatient")
	public String savePatient(@Valid Patient patient, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) return "formPatient";
		patientRepository.save(patient);
		return "confirmation";
	}
	@GetMapping(path= "/editPatient")
	public String editPatient(Model model,Long id) {
		Patient p=patientRepository.findById(id).get();
		model.addAttribute("patient", p);
		model.addAttribute("mode", "edit");
		return "formPatient";
	}
	
	
	}

	

 