package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="resume_job_experiences")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeJobExperience {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="resume_job_experience_id")
	private int resumeJobExperienceId;
	
	@Column(name="workplace")
	@NotBlank
	@NotNull
	private String workplace;
	
	@Column(name="job_position")
	@NotBlank
	@NotNull
	private String jobPosition;
	
	@Column(name="entry_year")
	@NotBlank
	@NotNull
	private String entryYear;
	
	@Column(name="exit_year")
	private String exitYear;
	
	@Column(name="is_still_working")
	@NotBlank
	@NotNull
	private boolean isStillWorking;
	
//	@OneToMany(mappedBy = "resumeJobExperience")
//	private List<Candidate> candidates;
	
	@ManyToOne()
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
}
