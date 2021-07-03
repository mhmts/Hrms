package projects.hrms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import projects.hrms.business.abstacts.SystemEmployeeConfirmEmployerService;
import projects.hrms.core.utilities.results.results.Result;
import projects.hrms.entities.concretes.SystemEmployeeConfirmEmployer;

public class SystemEmployeeConfirmController {
	
	private SystemEmployeeConfirmEmployerService systemEmployeeConfirmEmployerService;
	
	@Autowired
	public SystemEmployeeConfirmController(SystemEmployeeConfirmEmployerService systemEmployeeConfirmEmployerService) {		
		this.systemEmployeeConfirmEmployerService = systemEmployeeConfirmEmployerService;
	}
	
	@PostMapping("/confirmemployer")
	public Result confirm(@RequestBody SystemEmployeeConfirmEmployer systemEmployeeConfirmEmployer) {
		return this.systemEmployeeConfirmEmployerService.confirmEmployer(systemEmployeeConfirmEmployer);
	}

}
