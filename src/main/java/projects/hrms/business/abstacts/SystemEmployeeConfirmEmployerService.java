package projects.hrms.business.abstacts;

import projects.hrms.core.utilities.results.results.Result;
import projects.hrms.entities.concretes.SystemEmployeeConfirmEmployer;

public interface SystemEmployeeConfirmEmployerService {
	Result confirmEmployer(SystemEmployeeConfirmEmployer systemEmployeeConfirm);
	
}