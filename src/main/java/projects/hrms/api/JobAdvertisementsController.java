package projects.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projects.hrms.business.abstacts.JobAdvertisementService;
import projects.hrms.core.utilities.results.results.DataResult;
import projects.hrms.core.utilities.results.results.Result;
import projects.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {

    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
        super();
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobAdvertisement>> getAll(){
        return this.jobAdvertisementService.getAll();
    }

    @GetMapping("/getactive")
    public DataResult<List<JobAdvertisement>> getActive(){
        return this.jobAdvertisementService.getActive();
    }
    @GetMapping("/getactivesorted")
    public DataResult<List<JobAdvertisement>> getActiveSorted(){
        return this.jobAdvertisementService.getActiveSorted();
    }
    @GetMapping("/getbyemployer")
    public DataResult<List<JobAdvertisement>> getByEmployer(String companyName){
        return this.jobAdvertisementService.getByEmployerName(companyName);
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement){
        return this.jobAdvertisementService.add(jobAdvertisement);
    }


}