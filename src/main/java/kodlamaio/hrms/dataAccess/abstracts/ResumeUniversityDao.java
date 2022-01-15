package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ResumeUniversity;

public interface ResumeUniversityDao extends JpaRepository<ResumeUniversity, Integer>{

	ResumeUniversity getByUniversityId(int id);
	List<ResumeUniversity> getAllByCandidate_candidateIdOrderByGraduationYearDesc(int id);
	
	List<ResumeUniversity> getAllByCandidate_candidateIdOrderByGraduationYearAsc(int id);
	
}
