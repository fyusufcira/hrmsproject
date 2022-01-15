package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResumePhoto;

public interface ResumePhotoService {

	
    DataResult<List<ResumePhoto>> getAll();
	
	Result add(ResumePhoto resumePhoto);
	
	Result update(ResumePhoto resumePhoto);
	
	Result delete(ResumePhoto resumePhoto);
	
	DataResult<ResumePhoto> getByPhotoId(int id);
	
	DataResult<ResumePhoto> getByCandidateId(int id);

}
