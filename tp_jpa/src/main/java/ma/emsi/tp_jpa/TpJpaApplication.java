package ma.emsi.tp_jpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ma.emsi.tp_jpa.entities.Patient;
import ma.emsi.tp_jpa.repositories.PatientRepository;

@SpringBootApplication
public class TpJpaApplication implements CommandLineRunner{
	@Autowired
private PatientRepository patientRepository;
	public static void main(String[] args) {
		SpringApplication.run(TpJpaApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		
		patientRepository.save(new Patient(045456, "Hamada", null, 59 , true));
		/*patientRepository.save(new Patient(03356, "HAD", null, 33, false));
		patientRepository.save(new Patient(0, "SAAD", null, 0, true));
		patientRepository.save(new Patient(54906, "Souad", null, 044, false));
		patientRepository.save(new Patient(03211, "FARAH", null, 23, true));
		patientRepository.findAll().forEach(p->{
			System.out.println(p.toString());
			});*/
		
		/*System.out.println("*************************");
		Patient patient=patientRepository.findById((long) 4).get();
		System.out.println(patient.getScore());
		
		System.out.println("*************************");
		List<Patient> patients=patientRepository.findByNomContains("D");
		patients.forEach(p->{
			System.out.println(p.toString());
		});
		
		System.out.println("*************************");
		List<Patient> patients2=patientRepository.findByMalade(true);
		patients2.forEach(p->{
			System.out.println(p.toString());
		});
		System.out.println("*************************");
		List<Patient> patients3=patientRepository.findByNomContainsAndMalade("I",false);
		patients3.forEach(p->{
		System.out.println(p.toString());
		});
		
		//patientRepository.deleteById(3L);
		
		System.out.println("*************************!!");
		Page<Patient> pagePatient=patientRepository.findAll(PageRequest.of(0,3 ));
		List<Patient> listPatients = pagePatient.getContent();
		listPatients.forEach(p->{
			System.out.println(p.toString());
		});	*/
	}
}
