package forum.forum.Repository;

import forum.forum.Controller.DTO.MessageDTO;
import forum.forum.Modello.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepo extends JpaRepository<Message, Integer> {
    public List<Message> findAllByThreadAppartenenza(int id);
}
