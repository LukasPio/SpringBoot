package lucas.src.service;

import lombok.RequiredArgsConstructor;
import lucas.src.domain.Game;
import lucas.src.mapper.GameMapper;
import lucas.src.repository.GameRepository;
import lucas.src.requests.GamePostRequestBody;
import lucas.src.requests.GamePutRequestBody;
import lucas.src.utils.Utils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GameService {

    private final Utils utils;
    private final GameRepository gameRepository;

    public List<Game> listAll() {
        return gameRepository.findAll();
    }

    public List<Game> findByName(String name){return gameRepository.findByName(name);}

    public Game findByIdOrThrowBadRequestException(int id) {
        return utils.findGameOrThrowNotFound(id, gameRepository);
    }

    public Game save(GamePostRequestBody gamePostRequestBody) {
        return gameRepository.save(GameMapper.INSTANCE.toGame(gamePostRequestBody));
    }

    public void delete(int id) {
        gameRepository.delete(utils.findGameOrThrowNotFound(id, gameRepository));
    }

    public void replace(GamePutRequestBody gamePutRequestBody) {
        Game gameSaved = findByIdOrThrowBadRequestException(gamePutRequestBody.getId());
        Game game = GameMapper.INSTANCE.toGame(gamePutRequestBody);
        game.setId(gameSaved.getId());
        gameRepository.save(game);
    }
}