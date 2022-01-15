package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeUniversity;

public interface ResumeUniversityService {

	
DataResult<List<ResumeUniversity>> getAll();
	
	Result add(ResumeUniversity resumeUniversity);
	
	Result update(ResumeUniversity resumeUniversity);
	
	Result delete(ResumeUniversity resumeUniversity);
	
	DataResult<ResumeUniversity> getByUniversityId(int id);
	
	DataResult<List<ResumeUniversity>> getAllByCandidate_idOrderByGraduationYearDesc(int id);
	
	DataResult<List<ResumeUniversity>> getAllByCandidate_idOrderByGraduationYearAsc(int id);

	
}