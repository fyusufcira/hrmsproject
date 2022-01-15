package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ResumePhoto;

public interface ResumePhotoDao extends JpaRepository<ResumePhoto, Integer>{
	
	ResumePhoto getByPhotoId(int id);
	
	ResumePhoto getByCandidate_candidateId(int id);

}
