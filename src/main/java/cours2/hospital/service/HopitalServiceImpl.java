package cours2.hospital.service;

import cours2.hospital.entities.Consultation;
import cours2.hospital.entities.Medecin;
import cours2.hospital.entities.Patient;
import cours2.hospital.entities.RendezVous;
import cours2.hospital.repositories.ConsultationReository;
import cours2.hospital.repositories.MedecinRepository;
import cours2.hospital.repositories.PatientRepository;
import cours2.hospital.repositories.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class HopitalServiceImpl implements IHospitalService {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private MedecinRepository medecinRepository;
    @Autowired
    private RendezVousRepository rendezVousRepository;
    @Autowired
    private ConsultationReository consultationReository;

    public HopitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationReository consultationReository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationReository = consultationReository;
    }



    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezvous) {
        rendezvous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezvous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationReository.save(consultation);
    }
}
