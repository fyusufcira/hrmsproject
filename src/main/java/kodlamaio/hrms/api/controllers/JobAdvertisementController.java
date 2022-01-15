package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/job_advertisement")
public class JobAdvertisementController {
	
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService=jobAdvertisementService;
	}

	@GetMapping("/getallactive")
	public DataResult<List<JobAdvertisement>> getAllActive(){
		return this.jobAdvertisementService.getAllActive();
		
	}
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
		
	}
	@GetMapping("/getallclosed")
	public DataResult<List<JobAdvertisement>> getAllClosed(){
		return this.jobAdvertisementService.getAllClosed();
	
}
	@GetMapping("/getallsortedbydateasc")
	public DataResult<List<JobAdvertisement>> getAllSortedByDateAsc(){
	
		return this.jobAdvertisementService.getAllSortedByDateAsc();
	
}
	
	@GetMapping("/getallsortedbydatedesc")
	public DataResult<List<JobAdvertisement>> getAllSortedByDateDesc(){
	
		return this.jobAdvertisementService.getAllSortedByDateDesc();
	
}
	
	
	@GetMapping("/getbycompanyname")
	public DataResult<List<JobAdvertisement>> getByCompanyName(@RequestParam String companyName){
	
		return this.jobAdvertisementService.getByCompanyName(companyName);
	
}
	@GetMapping("/getbynameandcompanyname")
	public DataResult<List<JobAdvertisement>> getByNameAndEmployer_CompanyName
	(@RequestParam(value="jobName",required=false) String jobName, @RequestParam(value="employerId") int employerId){
		
		return this.jobAdvertisementService.getByNameAndEmployer_EmployerId(jobName, employerId);
}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	
	@PostMapping("/closeadvertisement")
	public DataResult<JobAdvertisement> closeAdvertisement(@RequestBody JobAdvertisement jobAdvertisement){
		return this.jobAdvertisementService.closeAdvertisement(jobAdvertisement);
		
	}
	
	
	
}
