package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ResumeSkill;

public interface ResumeSkillDao extends JpaRepository<ResumeSkill, Integer>{
	
	ResumeSkill getBySkillId(int id);
	
	List<ResumeSkill> getAllByCandidate_candidateId(int id);

}
