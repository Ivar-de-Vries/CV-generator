package teampearl.cvgenerator.back_end.data_access_layer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Company;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
