package projects.hrms.business.abstacts;

import java.util.List;

import projects.hrms.core.utilities.results.results.Result;
import projects.hrms.entities.concretes.SystemEmployee;



public interface SystemEmployeeService {
	List<SystemEmployee> getAll();
	Result add(SystemEmployee systemEmployee);
}