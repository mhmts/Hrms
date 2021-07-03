package projects.hrms.business.abstacts;


import java.util.List;

import projects.hrms.core.utilities.results.results.Result;
import projects.hrms.entities.concretes.Candidate;



public interface CandidateService {
	List<Candidate> getAll(); 
	Result add(Candidate candidate);
}