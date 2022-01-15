package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeUniversityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeUniversityDao;
import kodlamaio.hrms.entities.concretes.ResumeUniversity;

@Service
public class ResumeUniversityManager implements ResumeUniversityService{

	ResumeUniversityDao resumeUniversityDao;
	@Autowired
	public ResumeUniversityManager(ResumeUniversityDao resumeUniversityDao) {
		this.resumeUniversityDao=resumeUniversityDao;
	}
	@Override
	public DataResult<List<ResumeUniversity>> getAll() {
		
		return new SuccessDataResult<List<ResumeUniversity>>(this.resumeUniversityDao.findAll());
	}

	@Override
	public Result add(ResumeUniversity resumeUniversity) {
		this.resumeUniversityDao.save(resumeUniversity);
		return new SuccessResult("university added.");
	}

	@Override
	public Result update(ResumeUniversity resumeUniversity) {
		this.resumeUniversityDao.saveAndFlush(resumeUniversity);
		return new SuccessResult("university updated.");
	}

	@Override
	public Result delete(ResumeUniversity resumeUniversity) {
		this.resumeUniversityDao.delete(resumeUniversity);
		
		return new SuccessResult("university deleted.");
	}
	@Override
	public DataResult<ResumeUniversity> getByUniversityId(int id) {
		return new SuccessDataResult<ResumeUniversity>(this.resumeUniversityDao.getByUniversityId(id));
	}
	@Override
	public DataResult<List<ResumeUniversity>> getAllByCandidate_idOrderByGraduationYearDesc(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<ResumeUniversity>>
		(this.resumeUniversityDao.getAllByCandidate_candidateIdOrderByGraduationYearDesc(id));
	}
	@Override
	public DataResult<List<ResumeUniversity>> getAllByCandidate_idOrderByGraduationYearAsc(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<ResumeUniversity>>
		(this.resumeUniversityDao.getAllByCandidate_candidateIdOrderByGraduationYearAsc(id));
	}

}
