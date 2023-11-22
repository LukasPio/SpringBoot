package lucas.src.dient;

import lombok.extern.log4j.Log4j2;
import lucas.src.domain.Game;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Log4j2
public class SpringClient {
    public static void main(String[] args) {
        ResponseEntity<Game> entity = new RestTemplate().getForEntity("http://localhost:8080/games/39", Game.class);
        log.info(entity);

        Game object = new RestTemplate().getForObject("http://localhost:8080/games/39", Game.class);

        log.info(object);
    }
}
