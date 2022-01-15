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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="resume_links")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeLink {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="resume_link_id")
	private int linkId;
	
	@Column(name="link_name")
	private String linkName;
	
	@Column(name="link_url")
	private String linkUrl;
	
//	@OneToMany(mappedBy = "resumeLink")
//	private List<Candidate> candidates;
	
	
	@ManyToOne()
	@JsonIgnore
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
}
