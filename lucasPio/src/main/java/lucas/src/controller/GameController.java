package lucas.src.controller;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lucas.src.domain.Game;
import lucas.src.requests.GamePostRequestBody;
import lucas.src.requests.GamePutRequestBody;
import lucas.src.service.GameService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/games")
public class GameController {
    private final GameService gameService;

    @GetMapping
    public ResponseEntity<Page<Game>> listAll(Pageable pageable) {
        return ResponseEntity.ok(gameService.listAll(pageable));
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
    public ResponseEntity<Game> save(@RequestBody @Valid GamePostRequestBody anime) {
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
