package teampearl.cvgenerator.back_end.presentation_layer.mappers;

import org.mapstruct.Mapper;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Training;
import teampearl.cvgenerator.back_end.presentation_layer.dto.TrainingDTO;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface TrainingMapper {
    Training trainingDTOToTraining(TrainingDTO trainingDTO);

    List<Training> trainingDTOsToTrainings(List<TrainingDTO> trainingDTOs);

    TrainingDTO trainingToTrainingDTO(Training training);

    List<TrainingDTO> trainingsToTrainingDTOs(List<Training> training);
}
