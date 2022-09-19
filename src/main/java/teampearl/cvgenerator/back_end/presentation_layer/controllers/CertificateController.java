package teampearl.cvgenerator.back_end.presentation_layer.controllers;

import org.springframework.web.bind.annotation.*;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Certificate;
import teampearl.cvgenerator.back_end.data_access_layer.repositories.CertificateRepository;
import teampearl.cvgenerator.back_end.presentation_layer.controllers.abstract_controllers.AbstractWithEmployeeController;
import teampearl.cvgenerator.back_end.presentation_layer.dto.CertificateDTO;
import teampearl.cvgenerator.back_end.presentation_layer.mappers.CertificateMapper;

import java.util.List;

@RestController
@RequestMapping("cv/{employeeId}/certificate")
public class CertificateController extends AbstractWithEmployeeController<Certificate, CertificateDTO> {
    CertificateMapper certificateMapper;

    public CertificateController(CertificateRepository certificateRepository, CertificateMapper certificateMapper) {
        super(certificateRepository);
        this.certificateMapper = certificateMapper;
    }

    @Override
    public Certificate dtoToEntity(CertificateDTO certificateDTO) {
        return certificateMapper.certificateDTOtoCertificate(certificateDTO);
    }

    @Override
    public CertificateDTO entityToDTO(Certificate certificate) {
        return certificateMapper.certificateToCertificateDTO(certificate);
    }

    @Override
    public List<Certificate> DTOsToEntities(List<CertificateDTO> certificateDTOS) {
        return certificateMapper.certificateDTOsToCertificates(certificateDTOS);
    }

    @Override
    public List<CertificateDTO> entitiesToDTOs(List<Certificate> certificates) {
        return certificateMapper.certificatesToCertificateDTOs(certificates);
    }

    @Override
    public List<Certificate> readAllEmployee(int employeeId) {
        return ((CertificateRepository) jpaRepository).findAllByEmployeeId(employeeId);
    }
}
