package lucas.src.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public class GamePutRequestBody {
    private String name;
    private Integer id;
}
