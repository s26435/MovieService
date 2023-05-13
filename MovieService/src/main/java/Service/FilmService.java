package Service;

import Exceptions.*;
import Model.Film;
import Repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    private final MovieRepository movieRepository;

    public FilmService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Film> getFilms(){
        return movieRepository.findAll();
    }

    public Film getFilmById(Long id){
        return movieRepository.findById(id).orElseThrow(MovieNotFoundException::new);
    }

    public void addFilm(Film film) {
        movieRepository.save(film);
    }

    public void updateMovie(Film filmWithUpdatedData){
        Film movieInBase = getFilmById(filmWithUpdatedData.getId());
        if(movieInBase != null){
            if(filmWithUpdatedData.getName() != null){
                movieInBase.setName(filmWithUpdatedData.getName());
            }
            if(filmWithUpdatedData.getCategory() != null){
                movieInBase.setCategory(filmWithUpdatedData.getCategory());
            }
            if(filmWithUpdatedData.getDescription() != null){
                movieInBase.setDescription(filmWithUpdatedData.getDescription());
            }
        }else {
            throw new IllegalArgumentException("Nie udało sie zaktualizować, film o id " + filmWithUpdatedData.getId() + " nie został odnaleziony w bazie");
        }
        movieRepository.save(movieInBase);
    }

    public void deleteFilm(Long id){
        Film movieToDelete = getFilmById(id);
        if (movieToDelete != null){
          movieRepository.deleteById(id);
        }else {
            throw new IllegalArgumentException("Nie udało się usunąć, film  id = " + id + ", nie został odnaleziony w bazie");
        }
    }

    public void changeIsA(Long id) {
       Film target = getFilmById(id);
       target.setIsAvailable(!target.getIsAvailable());
       movieRepository.save(target);
       }
    }

