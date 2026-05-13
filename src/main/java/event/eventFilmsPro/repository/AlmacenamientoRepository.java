package event.eventFilmsPro.repository;

import event.eventFilmsPro.model.Almacenamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlmacenamientoRepository extends JpaRepository<Almacenamiento, Long> {
}