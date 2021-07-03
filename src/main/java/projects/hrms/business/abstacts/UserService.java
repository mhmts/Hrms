package projects.hrms.business.abstacts;



import projects.hrms.core.utilities.results.results.Result;
import projects.hrms.entities.concretes.User;

public interface UserService {
	Result emailControl(User user);
}