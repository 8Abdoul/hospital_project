package cours2.hospital;

import cours2.hospital.entities.*;
import cours2.hospital.repositories.ConsultationReository;
import cours2.hospital.repositories.MedecinRepository;
import cours2.hospital.repositories.PatientRepository;
import cours2.hospital.repositories.RendezVousRepository;
import cours2.hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Bean
    CommandLineRunner start(IHospitalService hospitalService, PatientRepository patientRepository,RendezVousRepository rendezVousRepository, MedecinRepository medecinRepository) {
        return args -> {
            Stream.of("Souna", "Mami", "Malika")
                    .forEach(name -> {
                        Patient patient = new Patient();
                        patient.setName(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        patientRepository.save(patient);
                    });
            Stream.of("Aymane", "Hannane", "Yasmine")
                    .forEach(name -> {
                        Medecin medecin = new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(name+"@gmail.com");
                        medecin.setSpecialite(Math.random()>0.5? "Cardio": "Dentiste");
                        medecinRepository.save(medecin);
                    });
            Medecin medecin = medecinRepository.findByNom("Yasmine");
            Patient patient = patientRepository.findById(1L).orElse(null);
            Patient patient1 = patientRepository.findByName("Mohamed");
            RendezVous rdv = new RendezVous();
            rdv.setDate(new Date());
            rdv.setStatus(StatusRDV.pending);
            rdv.setPatient(patient);
            rdv.setMedecin(medecin);
            RendezVous saveRDV = hospitalService.saveRDV(rdv);
            System.out.println(saveRDV.getId());
            RendezVous rdv1 = rendezVousRepository.findAll().get(0);
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezvous(rdv1);
            consultation.setRapport("Rapport de la consultation..................");
            hospitalService.saveConsultation(consultation);


        };
    }
}

