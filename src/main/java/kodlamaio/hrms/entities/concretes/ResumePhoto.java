package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name="resume_photos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumePhoto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="resume_photo_id")
	private int photoId;
	
	@Column(name="photo_url")
	@NotNull
	@NotBlank
	private String photoUrl;

	
	@OneToOne(mappedBy = "resumePhoto")
	private Candidate candidate;
	
	
}
