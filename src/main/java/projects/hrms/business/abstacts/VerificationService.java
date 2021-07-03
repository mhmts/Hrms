package projects.hrms.business.abstacts;

import projects.hrms.core.utilities.results.results.Result;

public interface VerificationService {
	Result send(String email,String code);
}