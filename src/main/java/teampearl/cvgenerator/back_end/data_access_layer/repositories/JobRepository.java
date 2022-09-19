package teampearl.cvgenerator.back_end.data_access_layer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import teampearl.cvgenerator.back_end.data_access_layer.entities.EducationParticipation;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Job;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Integer> {
    List<Job> findAllByEmployeeId(int employeeId);
}
