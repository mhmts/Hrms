package projects.hrms.core.utilities.results.adapters;

import org.springframework.stereotype.Service;

import projects.hrms.MernisTest.MernisVerification;
import projects.hrms.entities.concretes.User;

@Service
public class MernisServiceAdapter {
	public boolean verify(User user)
	{
		MernisVerification adapter = new MernisVerification();
		return adapter.verify(user);
	}

}