package lucas.src.utils;

import lombok.AllArgsConstructor;
import lucas.src.Exceptions.BadRequestException;
import lucas.src.domain.Game;
import lucas.src.repository.GameRepository;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@AllArgsConstructor
public class Utils {

    public String formatLocalDateTimeToDatabaseStyle(LocalDateTime localDateTime) {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime);
    }

    public Game findGameOrThrowNotFound(int id, GameRepository gameRepository) {
        return gameRepository
                .findById(id)
                .orElseThrow(() -> new BadRequestException("Anime Not Found"));
    }

}