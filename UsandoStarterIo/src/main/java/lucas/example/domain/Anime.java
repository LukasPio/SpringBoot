package lucas.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Anime {
    public String name;
    public Long id;
}
