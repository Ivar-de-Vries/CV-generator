package teampearl.cvgenerator.back_end.data_access_layer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
}
