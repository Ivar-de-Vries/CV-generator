package teampearl.cvgenerator.back_end.data_access_layer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import teampearl.cvgenerator.back_end.data_access_layer.entities.LanguageLevel;

import java.util.List;

public interface LanguageLevelRepository extends JpaRepository<LanguageLevel, Integer> {
    List<LanguageLevel> findAllByEmployeeId(int employeeId);
}
