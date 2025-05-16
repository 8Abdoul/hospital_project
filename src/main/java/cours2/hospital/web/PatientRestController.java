package cours2.hospital.web;

import cours2.hospital.entities.Patient;
import cours2.hospital.repositories.PatientRepository;
import jdk.jfr.Registered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
    @Autowired
    private PatientRepository patientRepository;
    @GetMapping("/patients")
    public List<Patient> patientList() {
        return patientRepository.findAll();
    };


}
