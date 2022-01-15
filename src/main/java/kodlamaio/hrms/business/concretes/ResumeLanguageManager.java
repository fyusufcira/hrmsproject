package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeLanguageDao;
import kodlamaio.hrms.entities.concretes.ResumeLanguage;

@Service
public class ResumeLanguageManager implements ResumeLanguageService{

	private ResumeLanguageDao resumeLanguageDao;
	@Autowired
	public ResumeLanguageManager(ResumeLanguageDao resumeLanguageDao) {
		this.resumeLanguageDao=resumeLanguageDao;
	}
	
	
	@Override
	public DataResult<List<ResumeLanguage>> getAll() {
		
		return new SuccessDataResult<List<ResumeLanguage>>(this.resumeLanguageDao.findAll());
	}

	@Override
	public Result add(ResumeLanguage resumeLanguage) {
		this.resumeLanguageDao.save(resumeLanguage);
		return new SuccessResult("language addded.");
	}

	@Override
	public Result update(ResumeLanguage resumeLanguage) {
		this.resumeLanguageDao.saveAndFlush(resumeLanguage);
		return new SuccessResult("language updated.");
	}

	@Override
	public Result delete(ResumeLanguage resumeLanguage) {
		this.resumeLanguageDao.delete(resumeLanguage);
		return new SuccessResult("language deleted");
	}


	@Override
	public DataResult<ResumeLanguage> getByLanguageId(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<ResumeLanguage>(this.resumeLanguageDao.getByResumeLanguageId(id));
	}


	@Override
	public DataResult<List<ResumeLanguage>> getAllByCandidate_id(int id) {
		return new SuccessDataResult<List<ResumeLanguage>>(this.resumeLanguageDao.getAllByCandidate_candidateId(id));
	}

}
