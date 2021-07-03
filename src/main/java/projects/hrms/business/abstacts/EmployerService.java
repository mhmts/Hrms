package projects.hrms.business.abstacts;

import java.util.List;

import projects.hrms.core.utilities.results.results.Result;
import projects.hrms.entities.concretes.Employer;

public interface EmployerService {
	List<Employer> getAll();
	Result add(Employer employer);
}