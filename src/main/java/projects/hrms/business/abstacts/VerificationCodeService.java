package projects.hrms.business.abstacts;

import projects.hrms.core.utilities.results.results.Result;

public interface VerificationCodeService {
	String createCode();
	Result verifyEmail(String code , int userId);
}