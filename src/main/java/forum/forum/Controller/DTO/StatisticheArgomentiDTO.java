package forum.forum.Controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatisticheArgomentiDTO {
    private HashMap<String, Integer> hashMap = new HashMap<>();

}
