package projects.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projects.hrms.business.abstacts.SystemEmployeeService;
import projects.hrms.core.utilities.results.results.Result;
import projects.hrms.entities.concretes.SystemEmployee;

@RestController
@RequestMapping("api/systememployee")
public class SystemEmployeeController {
	
	private SystemEmployeeService systemEmployeeService;
	
	@Autowired
	public SystemEmployeeController(SystemEmployeeService systemEmployeeService) {
		this.systemEmployeeService = systemEmployeeService;
	}
	
	@GetMapping("/getall")
	public List<SystemEmployee> getAll() {
		return this.systemEmployeeService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody SystemEmployee systemEmployee, @RequestBody String passwordAgain) {
		return this.systemEmployeeService.add(systemEmployee);
	}
	
}