package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{

	
	 @Query("From JobAdvertisement j where j.isActive=true order by j.releaseDate ASC")
	    List<JobAdvertisement> getAllActiveSortedAsc();

	    @Query("From JobAdvertisement j where j.isActive=true order by j.releaseDate DESC")
	    List<JobAdvertisement> getAllActiveSortedDesc ();
	
	
	@Query("From JobAdvertisement where isActive=true")
	List<JobAdvertisement> getAllActive();
	
	
	@Query("From JobAdvertisement where isActive=false")
	List<JobAdvertisement> getAllClosed();
	
	
	
	@Query("From JobAdvertisement Where isActive=true and jobName=jobName and employer.employerId=employerId")
	List<JobAdvertisement> getByNameAndEmployer_Id(String jobName, int employerId);
	
	
	List<JobAdvertisement> getByEmployer_CompanyName(String companyName);
	
	
	
}
