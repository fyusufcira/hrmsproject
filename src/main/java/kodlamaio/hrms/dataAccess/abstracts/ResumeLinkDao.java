package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ResumeLink;

public interface ResumeLinkDao extends JpaRepository<ResumeLink, Integer>{
	
	ResumeLink getByLinkId(int id);
	
	List<ResumeLink> getAllByCandidate_candidateId(int id);

}
