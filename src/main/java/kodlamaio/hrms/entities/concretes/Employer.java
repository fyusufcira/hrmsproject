package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="employers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})

public class Employer  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employer_id")
	private int employerId;
	
	@Column(name="company_name")
	@NotBlank
	@NotNull
	private String companyName;
	@Column(name="web_address")
	@NotBlank
	@NotNull
	private String webAddress;
	@Column(name="phone_number")
	@NotBlank
	@NotNull
	private String phoneNumber;
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

	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisements;
}
