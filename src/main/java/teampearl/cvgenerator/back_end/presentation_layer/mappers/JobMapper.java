package teampearl.cvgenerator.back_end.presentation_layer.mappers;

import org.mapstruct.Mapper;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Job;
import teampearl.cvgenerator.back_end.presentation_layer.dto.JobDTO;

import java.util.List;


@Mapper(
        componentModel = "spring"
)
public interface JobMapper {
    JobDTO jobToJobDTO(Job job);

    List<JobDTO> jobsToJobsDTOs (List<Job> job);

    Job jobDTOtoJob(JobDTO jobDTO);

    List<Job> jobDTOsToJobs(List<JobDTO> jobDTOs);
}
