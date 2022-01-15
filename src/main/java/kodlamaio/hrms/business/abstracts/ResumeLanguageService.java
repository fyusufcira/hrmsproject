package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeLanguage;

public interface ResumeLanguageService{
	
	DataResult<List<ResumeLanguage>> getAll();
	
	Result add(ResumeLanguage resumeLanguage);
	
	Result update(ResumeLanguage resumeLanguage);
	
	Result delete(ResumeLanguage resumeLanguage);
	
	DataResult<ResumeLanguage> getByLanguageId(int id);
	
	DataResult<List<ResumeLanguage>> getAllByCandidate_id(int id);
}
