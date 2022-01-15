package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="candidates")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Candidate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="candidate_id")
	private int candidateId;
	@Column(name="first_name")
	@NotBlank
	@NotNull
	private String firstName;
	@Column(name="last_name")
	@NotBlank
	@NotNull
	private String lastName;
	@Column(name="nationality_id")
	@NotBlank
	@NotNull
	private long nationalityId;
	@Column(name="date_of_birth")
	@NotBlank
	@NotNull
	private LocalDate dateOfBirth;
	@Column(name="email")
	@NotBlank
	@NotNull
	private String email;
	@Column(name="password")
	@NotBlank
	@NotNull
	private String password;
	@Column(name="password_repetition")
	@NotBlank
	@NotNull
	private String passwordRepetition;
	@Column(name="created_at")
	private Date createdAt;
	
	
	
	
	
//	@ManyToOne()
//	@JoinColumn(name="university_id")
//	private ResumeUniversity resumeUniversity;
//	
	@OneToMany(mappedBy = "candidate")
    private List<ResumeUniversity> resumeUniversity;
      
//	@ManyToOne()
//	@JoinColumn(name="resume_job_experience_id")
//	private ResumeJobExperience resumeJobExperience;
	
	
    @OneToMany(mappedBy = "candidate")
    private List<ResumeJobExperience> resumeJobExperience;
//    
//	@ManyToOne
//	@JoinColumn(name="resume_language_id")
//	private ResumeLanguage resumeLanguage;
    
    
    @OneToMany(mappedBy = "candidate")
    private List<ResumeLanguage> resumeLanguage;
	
	
//	@ManyToOne
//	@JoinColumn(name="resume_link_id")
//	private ResumeLink resumeLink;
    
    @OneToMany(mappedBy = "candidate")
    private List<ResumeLink> resumeLink;
    
    
//	@ManyToOne
//	@JoinColumn(name="resume_skill_id")
//	private ResumeSkill resumeSkill;
    
    
    @OneToMany(mappedBy = "candidate")
    private List<ResumeSkill> resumeSkill;

//	@ManyToOne
//	@JoinColumn(name="resume_cover_letter_id")
//	private ResumeCoverLetter resumeCoverLetter;
    
    
    @OneToMany(mappedBy = "candidate")
    private List<ResumeCoverLetter> resumeCoverLetter;

    @OneToOne()
    @JoinColumn(name="resume_photo_id")
    private ResumePhoto resumePhoto;
	
	
	
	
	
	
	

}