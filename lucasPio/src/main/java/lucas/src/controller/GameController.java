package lucas.src.controller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lucas.src.domain.Game;
import lucas.src.requests.GamePostRequestBody;
import lucas.src.requests.GamePutRequestBody;
import lucas.src.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/games")
public class GameController {
    private final GameService gameService;

    @GetMapping
    public ResponseEntity<List<Game>> listAll() {
        return ResponseEntity.ok(gameService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Game> findById(@PathVariable int id) {
        return ResponseEntity.ok(gameService.findByIdOrThrowBadRequestException(id));
    }

    @GetMapping(path = "/find")
    public ResponseEntity<List<Game>> findByName(@RequestParam String name) {
        return ResponseEntity.ok(gameService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<Game> save(@RequestBody GamePostRequestBody anime) {
        return ResponseEntity.ok(gameService.save(anime));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        gameService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody GamePutRequestBody game) {
        gameService.replace(game);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
