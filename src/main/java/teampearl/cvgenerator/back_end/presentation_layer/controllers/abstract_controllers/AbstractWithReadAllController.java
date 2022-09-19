package teampearl.cvgenerator.back_end.presentation_layer.controllers.abstract_controllers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import teampearl.cvgenerator.back_end.data_access_layer.entities.IEntity;

import java.util.List;

// Generic E: Entity & Generic D: Dto
public abstract class AbstractWithReadAllController <E extends IEntity, D> extends AbstractController<E, D> {

    public AbstractWithReadAllController(JpaRepository jpaRepository) {
        super(jpaRepository);
    }

    @GetMapping
    public ResponseEntity<List<D>> readEntities() {
        List<E> entities = jpaRepository.findAll();
        List<D> listOfDto = entitiesToDTOs(entities);
        return ResponseEntity.ok(listOfDto);
    }

    protected abstract List<E> DTOsToEntities(List<D> listOfDto);

    protected abstract List<D> entitiesToDTOs(List<E> entities);
}
