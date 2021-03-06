package projects.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projects.hrms.business.abstacts.JobService;
import projects.hrms.core.utilities.results.results.ErrorResult;
import projects.hrms.core.utilities.results.results.Result;
import projects.hrms.core.utilities.results.results.SuccessResult;
import projects.hrms.dataAccess.abstracts.JobDao;
import projects.hrms.entities.concretes.Job;

@Service
public class JobManager implements JobService{

	JobDao jobDao;
	
	@Autowired
	public JobManager(JobDao jobDao) {
		this.jobDao = jobDao;
	}
	
	@Override
	public List<Job> getAll() {
		return this.jobDao.findAll();
	}

	@Override
	public Result add(Job job) {
		
		List<Result> results = new ArrayList<Result>();
		boolean isFail = false;
		
		Result nullControl = nullControlForAdd(job);
		Result jobControl = jobControl(job);
		
		results.add(nullControl);
		results.add(jobControl);
		
		for (var result : results) {
			if(!result.isSuccess())
			{
				isFail = true;
				return result;
			}
		}
		
		if(isFail == false)
		{
			this.jobDao.save(job);
			return new SuccessResult("Job added.");		
		}else {
			return new ErrorResult();
		}
		
	}
	
	public Result nullControlForAdd(Job job) {
        if (job.getTitle() == "")
        {
            return new ErrorResult("Fill the all required fields.");
        }
        return new SuccessResult();
	}
	
	public Result jobControl(Job job) {
		List<Job> titles = this.jobDao.findByTitle(job.getTitle()); 
		if(!(titles.isEmpty()))
		{
			return new ErrorResult("This title has already exists.");
		}
		return new SuccessResult();
	}
	
}