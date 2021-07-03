package projects.hrms.business.abstacts;

import projects.hrms.core.utilities.results.results.Result;
import projects.hrms.entities.concretes.Candidate;

public interface CandidateVerificationCodeService extends VerificationCodeService{
	Result add(Candidate candidate);
}