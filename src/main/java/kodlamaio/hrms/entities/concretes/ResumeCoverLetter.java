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

import lombok.NoArgsConstructor;

import lombok.Data;

import lombok.AllArgsConstructor;

@Table(name="resume_cover_letters")
@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ResumeCoverLetter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="resume_cover_letter_id")
	private int resumeCoverLetterId;

	@Column(name="letter")
	@NotBlank
	@NotNull
	private String letter;

//	@OneToMany(mappedBy = "resumeCoverLetter")
//	private List<Candidate> candidates;
	
	@ManyToOne()
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
}
