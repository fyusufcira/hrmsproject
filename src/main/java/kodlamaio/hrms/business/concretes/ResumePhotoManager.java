package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumePhotoService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumePhotoDao;
import kodlamaio.hrms.entities.concretes.ResumePhoto;


@Service
public class ResumePhotoManager implements ResumePhotoService{

	ResumePhotoDao resumePhotoDao;
	@Autowired
	public ResumePhotoManager(ResumePhotoDao resumePhotoDao) {
		this.resumePhotoDao=resumePhotoDao;
	}
	@Override
	public DataResult<List<ResumePhoto>> getAll() {
		
		return new SuccessDataResult<List<ResumePhoto>>(this.resumePhotoDao.findAll());
	}

	@Override
	public Result add(ResumePhoto resumePhoto) {
		this.resumePhotoDao.save(resumePhoto);
		return new SuccessResult("photo added.");
	}

	@Override
	public Result update(ResumePhoto resumePhoto) {
		this.resumePhotoDao.saveAndFlush(resumePhoto);
		return new SuccessResult("photo updated");
	}

	@Override
	public Result delete(ResumePhoto resumePhoto) {
		this.resumePhotoDao.delete(resumePhoto);
		
		return new SuccessResult("resume deleted.");
	}
	@Override
	public DataResult<ResumePhoto> getByPhotoId(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<ResumePhoto>(this.resumePhotoDao.getByPhotoId(id));
	}
	@Override
	public DataResult<ResumePhoto> getByCandidateId(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<ResumePhoto>(this.resumePhotoDao.getByCandidate_candidateId(id));
	}

}
