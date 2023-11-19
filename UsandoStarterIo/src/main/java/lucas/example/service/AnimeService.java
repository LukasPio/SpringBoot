package lucas.example.service;

import lombok.RequiredArgsConstructor;
import lucas.example.domain.Anime;
import lucas.example.repository.AnimeRepository;
import lucas.example.requests.AnimePostRequestBody;
import lucas.example.requests.AnimePutRequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {



    private final AnimeRepository animeRepository;
    public List<Anime> listAll() {
        return animeRepository.findAll();
    }

    public Anime findByIdOrThrowBadRequestException(long id) {
        return animeRepository.findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not Found"));
    }

    public Anime saveAnime(AnimePostRequestBody animePostRequestBody) {
        Anime anime = Anime.builder().name(animePostRequestBody.getName()).build();
        return animeRepository.save(anime);
    }

    public void deleteAnime(long id) {
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replaceAnime(AnimePutRequestBody animePutRequestBody) {

        Anime savedAnime = findByIdOrThrowBadRequestException(animePutRequestBody.getId());

        Anime anime = Anime.builder().
                name(animePutRequestBody.getName()).
                id(savedAnime.getId()).
                build();
        animeRepository.save(anime);
    }
}