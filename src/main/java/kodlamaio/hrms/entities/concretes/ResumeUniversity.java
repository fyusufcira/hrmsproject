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
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="resume_universities")
@Data

@AllArgsConstructor
@NoArgsConstructor
public class ResumeUniversity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="resume_university_id")
	@NotBlank
	@NotNull
	private int universityId;
	
	@Column(name="university_name")
	@NotBlank
	@NotNull
	private String universityName;
	
	@Column(name="department")
	@NotBlank
	@NotNull
	private String department;
	
	@Column(name="entry_year")
	@NotBlank
	@NotNull
	private String entryYear;
	
	@Column(name="graduation_year")
	private String graduationYear;
	
	@Column(name="is_graduated")
	@NotBlank
	@NotNull
	private boolean isGraduated;
	
//	@OneToMany(mappedBy = "resumeUniversity")
//	private List<Candidate> candidates;
	
	@ManyToOne()
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	
	
}
