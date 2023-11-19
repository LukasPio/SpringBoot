package lucas.example.service;

import lucas.example.domain.Anime;
import lucas.example.repository.AnimeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AnimeService {

    private static List<Anime> animes;

    static {
        animes = new ArrayList<>(List.of(
                new Anime("Hero", 1L),
                new Anime("Berserk", 2L),
                new Anime("One Piece", 3L),
                new Anime("Naruto", 4L),
                new Anime("Attack on Titan", 5L),
                new Anime("Death Note", 6L),
                new Anime("Fullmetal Alchemist", 7L),
                new Anime("My Hero Academia", 8L),
                new Anime("Demon Slayer", 9L),
                new Anime("Dragon Ball Z", 10L),
                new Anime("Hunter x Hunter", 11L)));
    }

    // private final AnimeRepository animeRepository
    public List<Anime> listAll() {
        return animes;
    }

    public Anime findById(long id) {
        return animes.stream().filter(anime -> anime.getId().
                equals(id)).
                findFirst().
                orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not Found"));
    }

    public Anime saveAnime(Anime anime) {
        anime.setId(ThreadLocalRandom.current().nextLong(12, 1000000));
        animes.add(anime);
        return anime;
    }

    public void deleteAnime(long id) {
        animes.remove(findById(id));
    }

    public void replaceAnime(Anime anime) {
        deleteAnime(anime.getId());
        animes.add(anime);
    }
}