package projects.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projects.hrms.business.abstacts.EmployerService;
import projects.hrms.business.abstacts.EmployerVerificationCodeService;
import projects.hrms.core.utilities.results.results.ErrorResult;
import projects.hrms.core.utilities.results.results.Result;
import projects.hrms.core.utilities.results.results.SuccessResult;
import projects.hrms.dataAccess.abstracts.EmployerDao;
import projects.hrms.dataAccess.abstracts.UserDao;
import projects.hrms.entities.concretes.Employer;

@Service
public class EmployerManager extends UserManager implements EmployerService {

	EmployerDao employerDao;
	EmployerVerificationCodeService employerVerificationCodeService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, EmployerVerificationCodeService employerVerificationCodeService, UserDao userDao) {
		super(userDao);
		this.employerDao = employerDao;
		this.employerVerificationCodeService = employerVerificationCodeService;
	}
	
	@Override
	public List<Employer> getAll() {
		return this.employerDao.findAll();
	}

	@Override
	public Result add(Employer employer) {
		
		List<Result> results = new ArrayList<Result>();
		boolean isFail = false;
		
		Result nullControl = nullControlForAdd(employer);
		Result emailControl = emailControl(employer);
//		Result passwordAgainControl= passwordAgainControl(employer);
		Result employerEmailControl = employerEmailControl(employer);
		
		results.add(nullControl);
		results.add(emailControl);
//		results.add(passwordAgainControl);
		results.add(employerEmailControl);
		
		for (var result : results) {
			if(!result.isSuccess())
			{
				isFail = true;
				return result;
			}
		}
		
		if(isFail == false)
		{
			this.employerDao.save(employer);
			Result isCodeSaved = employerVerificationCodeService.add(employer);
			if(!isCodeSaved.isSuccess()) {
				
			return new ErrorResult("Employer added. Verification mail can't send.");
			}else {
				return new SuccessResult("Employer added. Verification mail sent.");
			}
				
		}else {
			return new ErrorResult();
		}
		
	}

	private Result nullControlForAdd(Employer employer) {
        if (	employer.getCompanyName() == ""
                || employer.getWebAdress() == ""
                || employer.getPhoneNumber() == ""
                || employer.getEmail() == ""
                || employer.getPassword() == "" )
        {
            return new ErrorResult("Fill the all required fields.");
        }
        return new SuccessResult();
	}
	
	

	
	public Result employerEmailControl(Employer employer) {
		String[] emailSplit = employer.getEmail().split("@");
		if (!employer.getWebAdress().contains(emailSplit[1])) {
			return new ErrorResult("The e-mail address must be an extension of the web address. For example: name@YourDomainName.com");
		}
		else {
			return new SuccessResult();
		}
	}
}