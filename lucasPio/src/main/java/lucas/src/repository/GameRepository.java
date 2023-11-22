package lucas.src.repository;
import lucas.src.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface GameRepository extends JpaRepository<Game, Integer>{

    List<Game> findByName(String name);
}
