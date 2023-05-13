package Service;


import Model.Film;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmService {

    private final List<Film> films = new ArrayList<>();
    public FilmService() {
        films.add(new Film(1, "Jeden", "Fantasy"));
        films.add(new Film(2, "Dwa", "Horror"));
        films.add(new Film(3, "Trzy", "Action"));
    }

    public List<Film> getFilms(){
        return films;
    }

    public Film getFilmById(int id){
        for( Film film : films){
            if(film.getId() == id) return film;
        }
        return null;
    }

    public void addFilm(Film film) {
        films.add(film);
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
    }

    public void deleteFilm(int id){
        Film movieToDelete = getFilmById(id);
        if (movieToDelete != null){
            films.remove(movieToDelete);
        }else {
            throw new IllegalArgumentException("Nie udało się usunąć, film o id " + id + " nie został odnaleziony w bazie");
        }
    }

}
