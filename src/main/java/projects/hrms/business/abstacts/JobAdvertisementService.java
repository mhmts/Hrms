package projects.hrms.business.abstacts;

import java.util.List;

import projects.hrms.core.utilities.results.results.DataResult;
import projects.hrms.core.utilities.results.results.Result;
import projects.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

    DataResult<List<JobAdvertisement>> getAll();
    DataResult<List<JobAdvertisement>> getActive();
    DataResult<List<JobAdvertisement>> getActiveSorted();
    DataResult<List<JobAdvertisement>> getByEmployerName(String companyName);
    Result add(JobAdvertisement jobAdvertisement);

}