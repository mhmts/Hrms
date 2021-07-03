package projects.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projects.hrms.business.abstacts.CandidateVerificationCodeService;
import projects.hrms.business.abstacts.VerificationService;
import projects.hrms.core.utilities.results.results.ErrorResult;
import projects.hrms.core.utilities.results.results.Result;
import projects.hrms.core.utilities.results.results.SuccessResult;
import projects.hrms.dataAccess.abstracts.CandidateVerificationCodeDao;
import projects.hrms.entities.concretes.Candidate;
import projects.hrms.entities.concretes.CandidateVerificationCode;

@Service
public class CandidateVerificationCodeManager implements CandidateVerificationCodeService{
	
	
	CandidateVerificationCodeDao candidateVerificationCodeDao;
	VerificationService verificationService;
	
	@Autowired
	public CandidateVerificationCodeManager(CandidateVerificationCodeDao candidateVerificationCodeDao,VerificationService verificationService) {
		this.candidateVerificationCodeDao = candidateVerificationCodeDao;
		this.verificationService = verificationService;
	}
		
	@Override
	public String createCode() {
		return "X52FB2KL";
	}
		
	@Override
	public Result add(Candidate candidate)
	{
		String code = createCode();
		CandidateVerificationCode candidateVerificationCode = new CandidateVerificationCode();
		
		candidateVerificationCode.setCode(code);
		candidateVerificationCode.setCandidateId(candidate.getId());
		candidateVerificationCodeDao.save(candidateVerificationCode);
		
		return verificationService.send(candidate.getEmail(), code);	
	}
	
	public Result verifyEmail(String code, int candidateId) {
		List<CandidateVerificationCode> codes = candidateVerificationCodeDao.findByCode(code);
		if(!codes.isEmpty())
		{
			for (CandidateVerificationCode candidateVerificationCode : codes) {
				if(candidateVerificationCode.getCandidateId()==candidateId) {
					if(candidateVerificationCode.isVerified()==true) return new ErrorResult("This account has already been verified.");
					candidateVerificationCode.setVerified(true);
					candidateVerificationCode.setVerificationDate(LocalDate.now());
					return new SuccessResult("Account is verified.");		
				}
			}
					
		}
		return new ErrorResult("This verification code is invalid.");
	}
	
} 
