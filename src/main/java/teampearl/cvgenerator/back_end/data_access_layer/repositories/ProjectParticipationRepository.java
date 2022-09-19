package teampearl.cvgenerator.back_end.data_access_layer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teampearl.cvgenerator.back_end.data_access_layer.entities.ProjectParticipation;

import java.util.List;

@Repository
public interface ProjectParticipationRepository extends JpaRepository<ProjectParticipation, Integer> {
    List<ProjectParticipation> findAllByEmployeeId(int employeeId);
}
