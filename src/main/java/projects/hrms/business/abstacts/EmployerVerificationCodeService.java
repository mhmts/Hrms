package projects.hrms.business.abstacts;

import projects.hrms.core.utilities.results.results.Result;
import projects.hrms.entities.concretes.Employer;

public interface EmployerVerificationCodeService extends VerificationCodeService {
	Result add(Employer employer);
}