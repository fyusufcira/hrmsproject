package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Employee  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employee_id")
	private int employeeId;
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
	
}
