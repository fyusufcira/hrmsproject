package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{
	
	private JobAdvertisementDao jobAdvertisementDao;
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		this.jobAdvertisementDao=jobAdvertisementDao;
	}
	
	

	@Override
	public DataResult<List<JobAdvertisement>> getAllActive() {
		
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.getAllActive());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllSortedByDateAsc() {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.getAllActiveSortedAsc());
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getAllSortedByDateDesc() {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.getAllActiveSortedDesc());
	}

	

	@Override
	public DataResult<JobAdvertisement> closeAdvertisement(JobAdvertisement jobAdvertisement) {
		jobAdvertisement.setActive(false);
		return new SuccessDataResult<JobAdvertisement>("Advertisement for this job is closed.");
	}



	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findAll());
	}



	@Override
	public DataResult<List<JobAdvertisement>> getAllClosed() {
		
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.getAllClosed());
	}



	@Override
	public DataResult<List<JobAdvertisement>> getByNameAndEmployer_EmployerId
	(String jobName, int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.getByNameAndEmployer_Id(jobName,employerId));
	}



	@Override
	public Result add(JobAdvertisement jobAdvertisement) {

		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("job advertisement added.");
	
	}



	@Override
	public DataResult<List<JobAdvertisement>> getByCompanyName(String companyName) {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.getByEmployer_CompanyName(companyName));
	}

}
