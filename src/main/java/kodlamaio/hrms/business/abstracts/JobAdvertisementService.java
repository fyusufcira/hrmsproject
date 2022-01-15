package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	
	Result add(JobAdvertisement jobAdvertisement);
	
	
	DataResult<List<JobAdvertisement>> getAllActive(); 
	
	DataResult<List<JobAdvertisement>> getAll();
	
	DataResult<List<JobAdvertisement>> getAllClosed();

	
	DataResult<List<JobAdvertisement>> getAllSortedByDateAsc();
	
	DataResult<List<JobAdvertisement>> getAllSortedByDateDesc();
	
	DataResult<List<JobAdvertisement>> getByCompanyName(String companyName);
	
	
	DataResult<JobAdvertisement> closeAdvertisement(JobAdvertisement jobAdvertisement );
	
	DataResult<List<JobAdvertisement>> getByNameAndEmployer_EmployerId(String jobName, int employerId);


}
