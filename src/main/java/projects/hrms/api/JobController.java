package projects.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projects.hrms.business.abstacts.JobService;
import projects.hrms.core.utilities.results.results.Result;
import projects.hrms.entities.concretes.Job;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
	
	private JobService jobService;
	
	@Autowired
	public JobController(JobService jobService) {
		this.jobService = jobService;
	}
	
	@GetMapping("/getall")
	public List<Job> getAll() {
		return this.jobService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Job job) {
		return this.jobService.add(job);
	}
	
	
}