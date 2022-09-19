package teampearl.cvgenerator.back_end.presentation_layer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Job;
import teampearl.cvgenerator.back_end.data_access_layer.repositories.JobRepository;
import teampearl.cvgenerator.back_end.presentation_layer.controllers.abstract_controllers.AbstractWithEmployeeController;
import teampearl.cvgenerator.back_end.presentation_layer.dto.JobDTO;
import teampearl.cvgenerator.back_end.presentation_layer.mappers.JobMapper;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/cv/{employeeId}/jobs")
public class JobController extends AbstractWithEmployeeController <Job, JobDTO> {
    JobRepository jobRepository;
    JobMapper jobMapper;

    @Autowired
    public JobController(JobRepository jobRepository, JobMapper jobMapper){
        super(jobRepository);
        this.jobMapper = jobMapper;
        this.jobRepository = jobRepository;
    }

    @Override
    protected Job dtoToEntity(JobDTO jobDTO) {
        return jobMapper.jobDTOtoJob(jobDTO);
    }

    @Override
    protected JobDTO entityToDTO(Job job) {
        return jobMapper.jobToJobDTO(job);
    }

    @Override
    protected List<Job> DTOsToEntities(List<JobDTO> jobDTOs) {
        return jobMapper.jobDTOsToJobs(jobDTOs);
    }

    @Override
    protected List<JobDTO> entitiesToDTOs(List<Job> jobs) {
        return jobMapper.jobsToJobsDTOs(jobs);
    }

    @Override
    protected List<Job> readAllEmployee(int employeeId) {
        return jobRepository.findAllByEmployeeId(employeeId);
    }
}
