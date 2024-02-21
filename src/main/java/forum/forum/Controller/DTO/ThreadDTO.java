package forum.forum.Controller.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThreadDTO {
    private int id;
    @NotBlank
    private String titolo;
    @NotBlank
    private LocalDate dataCreazione;
    @NotBlank
    private String argomento;

}
