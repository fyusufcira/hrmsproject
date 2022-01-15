package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeJobExperience;

public interface ResumeJobExperienceService {
	
DataResult<List<ResumeJobExperience>> getAll();
	
	Result add(ResumeJobExperience resumeJobExperience);
	
	Result update(ResumeJobExperience resumeJobExperience);
	
	Result delete(ResumeJobExperience resumeJobExperience);
	
    DataResult<ResumeJobExperience> getByResumeJobExperienceId(int id);
	
	DataResult<List<ResumeJobExperience>> getAllByCandidate_idOrderByEndYearDesc(int id);
	
	
	
}
