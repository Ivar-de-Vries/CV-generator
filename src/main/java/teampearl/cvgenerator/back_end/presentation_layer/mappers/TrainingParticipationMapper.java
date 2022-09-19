package teampearl.cvgenerator.back_end.presentation_layer.mappers;

import org.mapstruct.Mapper;
import teampearl.cvgenerator.back_end.data_access_layer.entities.TrainingParticipation;
import teampearl.cvgenerator.back_end.presentation_layer.dto.TrainingParticipationDTO;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface TrainingParticipationMapper {
    TrainingParticipationDTO trainingParticipationToTrainingParticipationDTO(TrainingParticipation trainingParticipation);

    TrainingParticipation trainingParticipationDTOToTrainingParticipation(TrainingParticipationDTO trainingDTO);

    List<TrainingParticipationDTO> trainingParticipationsToTrainingParticipationDTOs(List<TrainingParticipation> educationParticipations);

    List<TrainingParticipation> trainingParticipationDTOsToTrainingParticipations(List<TrainingParticipationDTO> educationParticipationDTOs);
}
