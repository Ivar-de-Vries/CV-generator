package teampearl.cvgenerator.back_end.data_access_layer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teampearl.cvgenerator.back_end.data_access_layer.entities.EducationParticipation;

import java.util.List;

@Repository
public interface EducationParticipationRepository extends JpaRepository<EducationParticipation, Integer> {
    List<EducationParticipation> findAllByEmployeeId(int employeeId);

}
