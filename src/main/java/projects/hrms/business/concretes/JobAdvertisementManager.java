package projects.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projects.hrms.business.abstacts.JobAdvertisementService;
import projects.hrms.business.concretes.checkInfo.JobAdvertisementCheckManager;
import projects.hrms.core.utilities.results.results.DataResult;
import projects.hrms.core.utilities.results.results.ErrorDataResult;
import projects.hrms.core.utilities.results.results.Result;
import projects.hrms.core.utilities.results.results.SuccessDataResult;
import projects.hrms.dataAccess.abstracts.JobAdvertisementDao;
import projects.hrms.entities.concretes.JobAdvertisement;


@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;
    }


    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return  new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),"JobAdvertisements retrieved");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getActive() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByStatueTrue(),"Active job advertisements listed");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getActiveSorted() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByStatueTrueOrderByReleaseDate(),"Active job advertisements sorted listed");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByEmployerName(String companyName) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByEmployer_CompanyName(companyName),companyName+" advertisements retrieved");
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        JobAdvertisementCheckManager jobAdvertisementCheckManager=new JobAdvertisementCheckManager(jobAdvertisement);
        if(!jobAdvertisementCheckManager.checkJobAdvertisementInfo()){
            this.jobAdvertisementDao.save(jobAdvertisement);
            return new SuccessDataResult("Job advertisement added");
        }
        else{
            return  new ErrorDataResult(jobAdvertisementCheckManager.getMessage());
        }
    }



}