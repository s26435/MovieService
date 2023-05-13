package Controller;

import Model.Film;
import Service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService){
        this.filmService = filmService;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Film>> getAllFilms(){
        if(filmService.getFilms() == null){
            return ResponseEntity.ok(filmService.getFilms());
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Film> getMovieById(@PathVariable Long id) {
        if (filmService.getFilmById(id) != null) {
            return ResponseEntity.ok(filmService.getFilmById(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/movies")
    public ResponseEntity<Film> addMovie(@RequestBody Film film) {
        if (film != null) {
            filmService.addFilm(film);
            return ResponseEntity.ok(film);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/movies/isAvaiable/{id}")
    public ResponseEntity<Void> updateFilmIsAvailable(@PathVariable Long id){
        filmService.changeIsA(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<Film> updateMovie(@PathVariable Long id, @RequestBody Film film) {
        if (getMovieById(id) != null) {
            film.setId(id);
            filmService.updateMovie(film);
            return ResponseEntity.ok(film);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        if(getMovieById(id) != null){
            filmService.deleteFilm(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
