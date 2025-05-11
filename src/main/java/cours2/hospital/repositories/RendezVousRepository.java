package cours2.hospital.repositories;

import cours2.hospital.entities.Patient;
import cours2.hospital.entities.RendezVous;
import org.aspectj.apache.bcel.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {
}
