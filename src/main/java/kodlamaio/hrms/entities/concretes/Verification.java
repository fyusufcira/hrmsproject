package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="verifications")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Verification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="verification_id")
	private int verificationId;
	@Column(name="email_activation_code")
	private String emailActivationCode;
	@Column(name="is_confirmed")
	private boolean isConfirmed;
	@Column(name="confirmation_date")
	private LocalDate confirmationDate= LocalDate.now();

}
