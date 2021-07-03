package projects.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import projects.hrms.business.abstacts.UserService;
import projects.hrms.core.utilities.results.results.ErrorResult;
import projects.hrms.core.utilities.results.results.Result;
import projects.hrms.core.utilities.results.results.SuccessResult;
import projects.hrms.dataAccess.abstracts.UserDao;
import projects.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService{
	
	UserDao userDao;
	
	public UserManager(UserDao userDao) {
		this.userDao=userDao;
	}
	
	@Override
	public Result emailControl(User user) {
		List<User> users = this.userDao.findByEmail(user.getEmail()); 
		if(!(users.isEmpty()))
		{
			return new ErrorResult("This e-mail is already registered.");
		}
		return new SuccessResult();
	}

}