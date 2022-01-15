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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="resume_skills")
public class ResumeSkill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="resume_skill_id")
	private int skillId;
	
	@Column(name="skill_name")
	@NotBlank
	@NotNull
	private String skillName;
	
	@Column(name="skill_description")
	private String skillDescription;
	
//	@OneToMany(mappedBy = "resumeSkill")
//	private List<Candidate> candidates;
	
	@ManyToOne()
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
}
