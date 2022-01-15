package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeLink;

public interface ResumeLinkService {
	
	DataResult<List<ResumeLink>> getAll();
	
	Result add(ResumeLink resumeLink);
	
	Result update(ResumeLink resumeLink);
	
	Result delete(ResumeLink resumeLink);
	
	DataResult<ResumeLink> getByLinkId(int id);
	
	DataResult<List<ResumeLink>> getAllByCandidateId(int id);
	
	
}
