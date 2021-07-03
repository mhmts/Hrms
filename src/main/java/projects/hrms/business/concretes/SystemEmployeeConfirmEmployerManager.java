package projects.hrms.business.concretes;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projects.hrms.business.abstacts.SystemEmployeeConfirmEmployerService;
import projects.hrms.core.utilities.results.results.Result;
import projects.hrms.core.utilities.results.results.SuccessResult;
import projects.hrms.dataAccess.abstracts.SystemEmployeeConfirmEmployerDao;
import projects.hrms.entities.concretes.SystemEmployeeConfirmEmployer;

@Service
public class SystemEmployeeConfirmEmployerManager implements SystemEmployeeConfirmEmployerService {
	
	SystemEmployeeConfirmEmployerDao systemEmployeeConfirmEmployerDao;
	
	@Autowired
	public SystemEmployeeConfirmEmployerManager(SystemEmployeeConfirmEmployerDao systemEmployeeConfirmEmployerDao) {
		this.systemEmployeeConfirmEmployerDao = systemEmployeeConfirmEmployerDao;
	}

	
	@Override
	public Result confirmEmployer(SystemEmployeeConfirmEmployer systemEmployeeConfirmEmployer) {
		systemEmployeeConfirmEmployer.setConfirmDate(Date.valueOf(LocalDate.now()));
		systemEmployeeConfirmEmployer.setConfirmed(true);
		systemEmployeeConfirmEmployerDao.save(systemEmployeeConfirmEmployer);
		
		return new SuccessResult("Employer is confirmed.");
	}
}