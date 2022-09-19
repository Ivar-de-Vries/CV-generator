package teampearl.cvgenerator.back_end.presentation_layer.controllers;

import org.springframework.web.bind.annotation.*;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Training;
import teampearl.cvgenerator.back_end.data_access_layer.repositories.TrainingRepository;
import teampearl.cvgenerator.back_end.presentation_layer.controllers.abstract_controllers.AbstractWithReadAllController;
import teampearl.cvgenerator.back_end.presentation_layer.dto.TrainingDTO;
import teampearl.cvgenerator.back_end.presentation_layer.mappers.TrainingMapper;

import java.util.List;

@RestController
@RequestMapping("/training")
public class TrainingController extends AbstractWithReadAllController<Training, TrainingDTO> {
    TrainingMapper trainingMapper;

    public TrainingController(TrainingRepository trainingRepository, TrainingMapper trainingMapper) {
        super(trainingRepository);
        this.trainingMapper = trainingMapper;
    }

    @Override
    public Training dtoToEntity(TrainingDTO trainingDTO) {
        return trainingMapper.trainingDTOToTraining(trainingDTO);
    }

    @Override
    public TrainingDTO entityToDTO(Training training) {
        return trainingMapper.trainingToTrainingDTO(training);
    }

    @Override
    public List<Training> DTOsToEntities(List<TrainingDTO> trainingDTOS) {
        return trainingMapper.trainingDTOsToTrainings(trainingDTOS);
    }

    @Override
    public List<TrainingDTO> entitiesToDTOs(List<Training> trainings) {
        return trainingMapper.trainingsToTrainingDTOs(trainings);
    }
}
