package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ResumeJobExperience;

public interface ResumeJobExperienceDao extends JpaRepository<ResumeJobExperience, Integer>{
	
	ResumeJobExperience getByResumeJobExperienceId(int id);
	
	List<ResumeJobExperience> getAllByCandidate_candidateIdOrderByExitYearDesc(int id);
}
