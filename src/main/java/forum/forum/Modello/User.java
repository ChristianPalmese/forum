package forum.forum.Modello;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String nomeCompleto;

    @OneToMany(mappedBy = "autore")
    private List<Message> messaggiInviati;

    public User(String username, String nomeCompleto) {
        this.username = username;
        this.nomeCompleto = nomeCompleto;
    }
}
