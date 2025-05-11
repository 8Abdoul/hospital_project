package cours2.hospital.repositories;

import cours2.hospital.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationReository extends JpaRepository<Consultation, Long> {

}
