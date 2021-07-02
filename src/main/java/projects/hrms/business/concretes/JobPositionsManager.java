package projects.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projects.hrms.business.abstacts.JobPositionsService;
import projects.hrms.dataAccess.abstracts.JobPositionsDao;
import projects.hrms.entities.concretes.JobPosition;



@Service
public class JobPositionsManager implements JobPositionsService{
	
	private JobPositionsDao jobPositionsDao;
	
	@Autowired
	public JobPositionsManager(JobPositionsDao jobPositionsDao) {
		super();
		this.jobPositionsDao = jobPositionsDao;
	}

	@Override
	public List<JobPosition> getAll() {
		
		return this.jobPositionsDao.findAll();
	}

}