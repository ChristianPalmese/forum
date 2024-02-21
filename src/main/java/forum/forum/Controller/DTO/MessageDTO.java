package forum.forum.Controller.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {
    private int id;
    @NotBlank
    private String testo;
    @NotBlank
    private LocalDate dataInvio;
    @NotNull
    private int like;
    @NotNull
    private int utenteID;
    @NotNull
    private int threadID;

    public MessageDTO(int id, String testo, LocalDate dataInvio, int like) {
        this.id = id;
        this.testo = testo;
        this.dataInvio = dataInvio;
        this.like = like;
    }
}
