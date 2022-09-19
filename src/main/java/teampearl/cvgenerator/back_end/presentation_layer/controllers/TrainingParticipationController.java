package teampearl.cvgenerator.back_end.presentation_layer.controllers;

import org.springframework.web.bind.annotation.*;
import teampearl.cvgenerator.back_end.data_access_layer.entities.TrainingParticipation;
import teampearl.cvgenerator.back_end.data_access_layer.repositories.TrainingParticipationRepository;
import teampearl.cvgenerator.back_end.presentation_layer.controllers.abstract_controllers.AbstractWithEmployeeController;
import teampearl.cvgenerator.back_end.presentation_layer.dto.TrainingParticipationDTO;
import teampearl.cvgenerator.back_end.presentation_layer.mappers.TrainingParticipationMapper;

import java.util.List;

@RestController
@RequestMapping("/cv/{employeeId}/training")
public class TrainingParticipationController extends AbstractWithEmployeeController<TrainingParticipation, TrainingParticipationDTO> {
    TrainingParticipationMapper trainingParticipationMapper;

    public TrainingParticipationController(TrainingParticipationRepository trainingParticipationRepository, TrainingParticipationMapper trainingParticipationMapper) {
        super(trainingParticipationRepository);
        this.trainingParticipationMapper = trainingParticipationMapper;
    }

    @Override
    protected TrainingParticipation dtoToEntity(TrainingParticipationDTO trainingParticipationDTO) {
        return trainingParticipationMapper.trainingParticipationDTOToTrainingParticipation(trainingParticipationDTO);
    }

    @Override
    protected TrainingParticipationDTO entityToDTO(TrainingParticipation educationParticipation) {
        return trainingParticipationMapper.trainingParticipationToTrainingParticipationDTO(educationParticipation);
    }

    @Override
    protected List<TrainingParticipation> DTOsToEntities(List<TrainingParticipationDTO> trainingParticipationDTOS) {
        return trainingParticipationMapper.trainingParticipationDTOsToTrainingParticipations(trainingParticipationDTOS);
    }

    @Override
    protected List<TrainingParticipationDTO> entitiesToDTOs(List<TrainingParticipation> trainingParticipations) {
        return trainingParticipationMapper.trainingParticipationsToTrainingParticipationDTOs(trainingParticipations);
    }

    @Override
    protected List<TrainingParticipation> readAllEmployee(int employeeId) {
        return ((TrainingParticipationRepository) jpaRepository).findAllByEmployeeId(employeeId);
    }
}
