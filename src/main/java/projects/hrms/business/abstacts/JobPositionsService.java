package projects.hrms.business.abstacts;

import java.util.List;

import projects.hrms.entities.concretes.JobPosition;



public interface JobPositionsService {
	List<JobPosition> getAll();

}