package teampearl.cvgenerator.back_end.presentation_layer.controllers.abstract_controllers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import teampearl.cvgenerator.back_end.data_access_layer.entities.IEntity;

import javax.persistence.EntityNotFoundException;
import java.net.URI;
import java.util.Optional;

// Generic E: Entity & Generic D: Dto
public abstract class AbstractController <E extends IEntity, D>  {

    protected JpaRepository jpaRepository;

    public AbstractController(JpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @GetMapping("/{entityId}")
    public ResponseEntity<D> readEntity(@PathVariable int entityId) {
        Optional<E> entity = jpaRepository.findById(entityId);
        if(entity.isEmpty())
            throw new EntityNotFoundException();
        D dto = entityToDTO(entity.get());
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity createEntity(@RequestBody D dto) {
        E entity = dtoToEntity(dto);
        entity.setId(null);
        entity = (E) jpaRepository.save(entity);
        dto = entityToDTO(entity);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
        return ResponseEntity.created(location).body(dto);
    }

    @PutMapping("/{entityId}")
    public ResponseEntity<D> updateEntity(@RequestBody D dto, @PathVariable int entityId) {
        E entity = dtoToEntity(dto);
        entity.setId(entityId);
        if (!jpaRepository.existsById(entityId)) {
            throw new EntityNotFoundException();
        }
        entity = (E) jpaRepository.save(entity);
        dto = entityToDTO(entity);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{entityId}")
    public ResponseEntity deleteEntity(@PathVariable int entityId) {
        jpaRepository.deleteById(entityId);
        return ResponseEntity.noContent().build();
    }

    protected abstract E dtoToEntity(D dto);

    protected abstract D entityToDTO(E entity);
}
