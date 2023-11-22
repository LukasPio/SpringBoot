package lucas.src.requests;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
public class GamePostRequestBody {
    @NotEmpty(message = "Game name can't be empty")
    private String name;
}
