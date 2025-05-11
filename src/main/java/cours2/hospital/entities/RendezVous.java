package cours2.hospital.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @NoArgsConstructor
@AllArgsConstructor

public class RendezVous {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Temporal(TemporalType.DATE)
    private Date date;
    private StatusRDV status;
    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;
    @ManyToOne()
    private Medecin medecin;
    @OneToOne
    @JoinColumn(name = "consultation_id") //
    private Consultation consultation;

}
