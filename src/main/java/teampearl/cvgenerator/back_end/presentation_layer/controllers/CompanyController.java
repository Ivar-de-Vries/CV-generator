package teampearl.cvgenerator.back_end.presentation_layer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Company;
import teampearl.cvgenerator.back_end.data_access_layer.repositories.CompanyRepository;
import teampearl.cvgenerator.back_end.presentation_layer.controllers.abstract_controllers.AbstractWithReadAllController;
import teampearl.cvgenerator.back_end.presentation_layer.dto.CompanyDTO;
import teampearl.cvgenerator.back_end.presentation_layer.mappers.CompanyMapper;

import java.util.List;
@RestController
@RequestMapping("/companies")
public class CompanyController extends AbstractWithReadAllController<Company, CompanyDTO> {
    CompanyMapper companyMapper;

    @Autowired
    public CompanyController(CompanyRepository companyRepository, CompanyMapper companyMapper) {
        super(companyRepository);
        this.companyMapper = companyMapper;
    }

    @Override
    protected Company dtoToEntity(CompanyDTO companyDTO) {
        return companyMapper.companyDTOToCompany(companyDTO);
    }

    @Override
    protected CompanyDTO entityToDTO(Company companyEntity) {
        return companyMapper.companyToCompanyDTO(companyEntity);
    }

    @Override
    protected List<Company> DTOsToEntities(List<CompanyDTO> companyDTOs) {
        return companyMapper.companyDTOsToCompanies(companyDTOs);
    }

    @Override
    protected List<CompanyDTO> entitiesToDTOs(List<Company> companies) {
        return companyMapper.companiesToCompanyDTOs(companies);
    }
}
