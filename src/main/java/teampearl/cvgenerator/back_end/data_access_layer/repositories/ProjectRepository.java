package teampearl.cvgenerator.back_end.data_access_layer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
