package teampearl.cvgenerator.back_end.presentation_layer.mappers;


import org.mapstruct.Mapper;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Company;
import teampearl.cvgenerator.back_end.presentation_layer.dto.CompanyDTO;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface CompanyMapper {
    CompanyDTO companyToCompanyDTO(Company company);

    Company companyDTOToCompany(CompanyDTO companyDTO);

    List<CompanyDTO> companiesToCompanyDTOs (List<Company> companies);

    List<Company> companyDTOsToCompanies (List<CompanyDTO> companyDTOs);
}
