package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ResumeLanguage;

public interface ResumeLanguageDao extends JpaRepository<ResumeLanguage, Integer>{
	
	ResumeLanguage getByResumeLanguageId(int id);
	
	List<ResumeLanguage> getAllByCandidate_candidateId(int id);
}
