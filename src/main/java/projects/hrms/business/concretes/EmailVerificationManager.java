package projects.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projects.hrms.business.abstacts.VerificationService;
import projects.hrms.core.utilities.results.results.ErrorResult;
import projects.hrms.core.utilities.results.results.Result;
import projects.hrms.core.utilities.results.results.SuccessResult;
import projects.hrms.core.utilities.results.senders.email.EmailSender;

@Service
public class EmailVerificationManager implements VerificationService{
	
	EmailSender emailSender = new EmailSender();
	
	@Autowired
	public EmailVerificationManager() {
		
	}
	
	public Result send(String email,String code)
	{		
		boolean sendEmail = emailSender.sendVerificationCode(email, code);
		if(sendEmail == false)
		{
			return new ErrorResult();

		}else {
			return new SuccessResult();
		}
	}
	

	
}