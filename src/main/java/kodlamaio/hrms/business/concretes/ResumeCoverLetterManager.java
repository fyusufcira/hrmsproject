package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeCoverLetterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeCoverLetterDao;
import kodlamaio.hrms.entities.concretes.ResumeCoverLetter;

@Service
public class ResumeCoverLetterManager implements ResumeCoverLetterService{

	private ResumeCoverLetterDao resumeCoverLetterDao;
	@Autowired
	public ResumeCoverLetterManager(ResumeCoverLetterDao resumeCoverLetterDao) {
		this.resumeCoverLetterDao=resumeCoverLetterDao;
	}
	
	
	@Override
	public DataResult<List<ResumeCoverLetter>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<ResumeCoverLetter>>(this.resumeCoverLetterDao.findAll());
	}
	


	@Override
	public Result add(ResumeCoverLetter resumeCoverLetter) {
		this.resumeCoverLetterDao.save(resumeCoverLetter);		
		return new SuccessResult("cv cover letter is saved.");
	}

	@Override
	public Result update(ResumeCoverLetter resumeCoverLetter) {
		this.resumeCoverLetterDao.saveAndFlush(resumeCoverLetter);		
		return new SuccessResult("cv cover letter is updated.");
	}

	@Override
	public Result delete(ResumeCoverLetter resumeCoverLetter) {
		this.resumeCoverLetterDao.delete(resumeCoverLetter);		
		return new SuccessResult("cv cover letter is deleted.");
	}


	


	@Override
	public DataResult<List<ResumeCoverLetter>> getAllByCandidate_id(int id) {
		return new SuccessDataResult<List<ResumeCoverLetter>>
		(this.resumeCoverLetterDao.getAllByCandidate_candidateId(id));
		
	}


	@Override
	public DataResult<ResumeCoverLetter> getByResumeCoverLetterId(int id) {
		
		return new SuccessDataResult<ResumeCoverLetter>
		(this.resumeCoverLetterDao.getByResumeCoverLetterId(id));
	}





}
