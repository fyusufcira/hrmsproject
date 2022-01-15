package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeLinkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeLinkDao;
import kodlamaio.hrms.entities.concretes.ResumeLink;

@Service

public class ResumeLinkManager implements ResumeLinkService{
	
	private ResumeLinkDao resumeLinkDao;
	@Autowired
	public ResumeLinkManager(ResumeLinkDao resumeLinkDao) {
		this.resumeLinkDao=resumeLinkDao;
	}
	@Override
	public DataResult<List<ResumeLink>> getAll() {
		
		return new SuccessDataResult<List<ResumeLink>>(this.resumeLinkDao.findAll());
	}

	@Override
	public Result add(ResumeLink resumeLink) {
		this.resumeLinkDao.save(resumeLink);
		return new SuccessResult("Link added");
	}

	@Override
	public Result update(ResumeLink resumeLink) {
		this.resumeLinkDao.saveAndFlush(resumeLink);
		return new SuccessResult("link updated.");
	}

	@Override
	public Result delete(ResumeLink resumeLink) {
		this.resumeLinkDao.delete(resumeLink);
		return new SuccessResult("link deleted.");
	}
	@Override
	public DataResult<ResumeLink> getByLinkId(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<ResumeLink>(this.resumeLinkDao.getByLinkId(id));
	}
	@Override
	public DataResult<List<ResumeLink>> getAllByCandidateId(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<ResumeLink>>(this.resumeLinkDao.getAllByCandidate_candidateId(id));
	}

}
