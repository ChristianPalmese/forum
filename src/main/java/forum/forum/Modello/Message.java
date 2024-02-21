package forum.forum.Modello;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String testo;
    private LocalDate dataInvio;
    private int numeroLikeRicevuti;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private User autore;

    @ManyToOne
    @JoinColumn(name = "thread_id")
    private Thread threadAppartenenza;

    public Message(String testo, LocalDate dataInvio, int numeroLikeRicevuti) {
        this.testo = testo;
        this.dataInvio = dataInvio;
        this.numeroLikeRicevuti = numeroLikeRicevuti;
    }
}
