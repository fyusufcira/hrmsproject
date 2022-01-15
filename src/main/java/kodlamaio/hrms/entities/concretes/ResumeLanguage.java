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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="resume_languages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeLanguage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="resume_language_id")
	@NotBlank
	@NotNull
	private int resumeLanguageId;

	@Column(name="language_name")
	@NotBlank
	@NotNull
	private String languageName;
	
	@Column(name="language_level")
	@Max(value = 5)
	@Min(value = 1)
	@NotBlank
	@NotNull
	private int languageLevel;
//	
//	@OneToMany(mappedBy = "resumeLanguage")
//	private List<Candidate> candidates;
	
	@ManyToOne()
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
}
