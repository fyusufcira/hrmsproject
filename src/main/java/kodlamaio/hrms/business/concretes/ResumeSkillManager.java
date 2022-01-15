package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeSkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeSkillDao;
import kodlamaio.hrms.entities.concretes.ResumeSkill;

@Service
public class ResumeSkillManager implements ResumeSkillService{
	
	ResumeSkillDao resumeSkillDao;
	@Autowired
	public ResumeSkillManager(ResumeSkillDao resumeSkillDao) {
		this.resumeSkillDao=resumeSkillDao;
	}
	
	@Override
	public DataResult<List<ResumeSkill>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<ResumeSkill>>(this.resumeSkillDao.findAll());
	}

	@Override
	public Result add(ResumeSkill resumeSkill) {
		this.resumeSkillDao.save(resumeSkill);
		return new SuccessResult("skill added.");
	}

	@Override
	public Result update(ResumeSkill resumeSkill) {
		this.resumeSkillDao.saveAndFlush(resumeSkill);
		return new SuccessResult("skill updated.");
	}

	@Override
	public Result delete(ResumeSkill resumeSkill) {
		this.resumeSkillDao.delete(resumeSkill);
		
		return new SuccessResult("skill deleted.");
	}

	@Override
	public DataResult<ResumeSkill> getBySkillId(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<ResumeSkill>(this.resumeSkillDao.getBySkillId(id));
	}

	@Override
	public DataResult<List<ResumeSkill>> getAllByCandidateId(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<ResumeSkill>>(this.resumeSkillDao.getAllByCandidate_candidateId(id));
	}

}
