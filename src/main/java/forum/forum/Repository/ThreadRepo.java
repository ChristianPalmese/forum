package forum.forum.Repository;

import forum.forum.Modello.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import forum.forum.Modello.Thread;

import java.util.List;

public interface ThreadRepo extends JpaRepository<Thread,Integer> {
    List<Thread> findAllByArgomentoOrderByDataCreazioneDesc(String argomento);
}
