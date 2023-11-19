package lucas.example.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lucas.example.domain.Anime;
import lucas.example.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("anime")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {
    private final DateUtil dateUtil;

    @GetMapping(path = "list")
    public List<Anime> animeList() {
        log.info(dateUtil.formatLocalDatetimaToDataBaseStyle(LocalDateTime.now()));
        return List.of(new Anime("DBZ"), new Anime("Berserk"));
    }

    @GetMapping(path = "list2")
    public List<Anime> animeList2() {
        log.info(dateUtil.formatLocalDatetimaToDataBaseStyle(LocalDateTime.now()));
        return List.of(new Anime("Jorge"), new Anime("Berserk"));
    }
}
