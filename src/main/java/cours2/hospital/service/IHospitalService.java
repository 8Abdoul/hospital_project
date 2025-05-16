package cours2.hospital.service;

import cours2.hospital.entities.Consultation;
import cours2.hospital.entities.Medecin;
import cours2.hospital.entities.Patient;
import cours2.hospital.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezvous);
    Consultation saveConsultation(Consultation consultation);

}
