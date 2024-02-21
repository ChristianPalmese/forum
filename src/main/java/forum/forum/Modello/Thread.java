package forum.forum.Modello;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
public class Thread {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titolo;
    private LocalDate dataCreazione;
    private String argomento;

    @OneToMany(mappedBy = "threadAppartenenza")
    private List<Message> messaggi;

    public Thread(String titolo, LocalDate dataCreazione, String argomento) {
        this.titolo = titolo;
        this.dataCreazione = dataCreazione;
        this.argomento = argomento;
    }
}
