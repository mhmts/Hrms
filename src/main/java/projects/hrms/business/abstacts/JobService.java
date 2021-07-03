package projects.hrms.business.abstacts;

import java.util.List;

import projects.hrms.core.utilities.results.results.Result;
import projects.hrms.entities.concretes.Job;

public interface JobService {
	List<Job> getAll();
	Result add(Job job);
}