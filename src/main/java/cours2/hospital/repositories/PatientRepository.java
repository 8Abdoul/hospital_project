package cours2.hospital.repositories;

import cours2.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface PatientRepository extends JpaRepository <Patient, Long> {

    Patient findByName(String name);
}
