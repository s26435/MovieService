package Repository;

import Model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Film, Long> {
    @Override
    Optional<Film> findById(Long aLong);

    @Override
    <S extends Film> S save(S entity);

    @Override
    void deleteById(Long aLong);

    @Override
    List<Film> findAll();
}
