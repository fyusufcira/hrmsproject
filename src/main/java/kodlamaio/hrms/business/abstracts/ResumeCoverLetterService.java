package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeCoverLetter;

public interface ResumeCoverLetterService {
	DataResult<List<ResumeCoverLetter>> getAll();
	
	Result add(ResumeCoverLetter resumeCoverLetter);
	
	Result update(ResumeCoverLetter resumeCoverLetter);
	
	Result delete(ResumeCoverLetter resumeCoverLetter);
	
    DataResult<ResumeCoverLetter> getByResumeCoverLetterId(int id);
	
	DataResult<List<ResumeCoverLetter>> getAllByCandidate_id(int id);
	
	

}
