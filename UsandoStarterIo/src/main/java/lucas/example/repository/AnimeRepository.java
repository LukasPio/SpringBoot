package lucas.example.repository;

import lucas.example.domain.Anime;

import java.util.List;

public interface AnimeRepository {
    List<Anime> listAll();
}
