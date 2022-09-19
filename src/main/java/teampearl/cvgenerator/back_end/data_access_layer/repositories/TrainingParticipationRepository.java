package teampearl.cvgenerator.back_end.data_access_layer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teampearl.cvgenerator.back_end.data_access_layer.entities.TrainingParticipation;

import java.util.List;

@Repository
public interface TrainingParticipationRepository extends JpaRepository<TrainingParticipation, Integer> {
    List<TrainingParticipation> findAllByEmployeeId(int employeeId);
}
