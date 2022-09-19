package teampearl.cvgenerator.back_end.data_access_layer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import teampearl.cvgenerator.back_end.data_access_layer.entities.SkillLevel;

import java.util.List;

public interface SkillLevelRepository extends JpaRepository<SkillLevel, Integer> {
    List<SkillLevel> findAllByEmployeeId(int employeeId);
}
