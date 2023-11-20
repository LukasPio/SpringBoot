package lucas.src.mapper;

import lucas.src.domain.Game;
import lucas.src.requests.GamePostRequestBody;
import lucas.src.requests.GamePutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class GameMapper {
    public static final GameMapper INSTANCE = Mappers.getMapper(GameMapper.class);
    public abstract Game toGame(GamePostRequestBody gamePostRequestBody);
    public abstract Game toGame(GamePutRequestBody gamePutRequestBody);
}
