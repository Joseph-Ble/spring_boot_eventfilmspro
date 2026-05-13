package event.eventFilmsPro.service;

import event.eventFilmsPro.model.Almacenamiento;
import event.eventFilmsPro.repository.AlmacenamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AlmacenamientoService {

    @Autowired
    private AlmacenamientoRepository repository;

    // 1. Insertar
    public Almacenamiento guardar(Almacenamiento almacenamiento) {
        return repository.save(almacenamiento);
    }

    // 2. Listar
    public List<Almacenamiento> listarTodos() {
        return repository.findAll();
    }

    // 3. Actualizar
    public Almacenamiento actualizarUbicacion(Long id, String nuevaUbicacion) {
        Optional<Almacenamiento> opcional = repository.findById(id);
        if (opcional.isPresent()) {
            Almacenamiento alm = opcional.get();
            alm.setUbicacion(nuevaUbicacion);
            return repository.save(alm);
        }
        return null;
    }
}