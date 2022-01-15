package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeJobExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeJobExperienceDao;
import kodlamaio.hrms.entities.concretes.ResumeJobExperience;

@Service
public class ResumeJobExperienceManager implements ResumeJobExperienceService {

	private ResumeJobExperienceDao resumeDao;
	@Autowired
	public ResumeJobExperienceManager(ResumeJobExperienceDao resumeDao) {
		this.resumeDao=resumeDao;
	}
	
	
	@Override
	public DataResult<List<ResumeJobExperience>> getAll() {
		return new SuccessDataResult<List<ResumeJobExperience>>(this.resumeDao.findAll());
	}

	@Override
	public Result add(ResumeJobExperience resumeJobExperience) {
		this.resumeDao.save(resumeJobExperience);
		return new SuccessResult("job experience added.");
	}

	@Override
	public Result update(ResumeJobExperience resumeJobExperience) {
		this.resumeDao.saveAndFlush(resumeJobExperience);
		return new SuccessResult("job experience updated.");
	}

	@Override
	public Result delete(ResumeJobExperience resumeJobExperience) {
		this.resumeDao.delete(resumeJobExperience);
		return new SuccessResult("job experience deleted.");
	}


	@Override
	public DataResult<ResumeJobExperience> getByResumeJobExperienceId(int id) {
		return new SuccessDataResult<ResumeJobExperience>(this.resumeDao.getByResumeJobExperienceId(id));
	}


	@Override
	public DataResult<List<ResumeJobExperience>> getAllByCandidate_idOrderByEndYearDesc(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<ResumeJobExperience>>
		(this.resumeDao.getAllByCandidate_candidateIdOrderByExitYearDesc(id));
	}
	
	
	
}
