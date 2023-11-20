package lucas.src.utils;

import lombok.AllArgsConstructor;
import lucas.src.domain.Game;
import lucas.src.repository.GameRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Component
@AllArgsConstructor
public class Utils {

    public String formatLocalDateTimeToDatabaseStyle(LocalDateTime localDateTime) {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime);
    }

    public Game findGameOrThrowNotFound(int id, GameRepository gameRepository) {
        return gameRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Anime Not Found"));
    }

}