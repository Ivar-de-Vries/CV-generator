package teampearl.cvgenerator.back_end.presentation_layer.mappers;

import org.mapstruct.Mapper;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Certificate;
import teampearl.cvgenerator.back_end.presentation_layer.dto.CertificateDTO;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface CertificateMapper {
    CertificateDTO certificateToCertificateDTO(Certificate certificate);

    Certificate certificateDTOtoCertificate (CertificateDTO certificateDTO);

    List<CertificateDTO> certificatesToCertificateDTOs(List<Certificate> certificateList);

    List<Certificate> certificateDTOsToCertificates(List<CertificateDTO> certificateDTOS);
}
