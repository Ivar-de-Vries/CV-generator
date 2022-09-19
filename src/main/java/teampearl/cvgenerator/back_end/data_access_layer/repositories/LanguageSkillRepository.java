package teampearl.cvgenerator.back_end.data_access_layer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import teampearl.cvgenerator.back_end.data_access_layer.entities.LanguageSkill;

public interface LanguageSkillRepository extends JpaRepository<LanguageSkill, Integer> {
}

