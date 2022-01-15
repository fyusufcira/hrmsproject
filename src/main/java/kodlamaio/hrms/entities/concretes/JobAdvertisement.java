package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_advertisements")
public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_advertisement_id")
	private int jobAdvertisementId;
	@Column(name="job_name")
	@NotBlank
	@NotNull
	private String jobName;
	@Column(name="job_description")
	private String jobDescription;
	@Column(name="max_salary")
	private int maxSalary;
	@Column(name="min_salary")
	private int minSalary;
	@Column(name="open_position_amount")
	@NotBlank
	@NotNull
	private int openPositionAmount;
	@Column(name="application_deadline_date")
	@NotBlank
	@NotNull
	private LocalDate applicationDeadline;
	@Column(name="is_active")
	private boolean isActive=true;
	@Column(name="release_date")
	@NotBlank
	@NotNull
	private Date releaseDate;
	@Column(name="application_date")
	private LocalDate applicationDate;
	
	@ManyToOne()
	@JoinColumn(name="position_id")
	private JobPosition jobPosition;
	
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
	
}
