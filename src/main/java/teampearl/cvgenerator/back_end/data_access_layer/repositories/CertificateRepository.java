package teampearl.cvgenerator.back_end.data_access_layer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Certificate;

import java.util.List;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Integer> {
    List<Certificate> findAllByEmployeeId(int employeeId);
}
