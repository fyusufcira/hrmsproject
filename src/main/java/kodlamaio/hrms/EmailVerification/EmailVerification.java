package kodlamaio.hrms.EmailVerification;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.Employer;

public class EmailVerification {

public static void log(Candidate candidate) {
		
		System.out.println("Sended email for verification to: "+candidate.getEmail());
		
	}

public static void log(Employer employer) {
	
	System.out.println("Sended email for verification to: "+employer.getEmail());
	
}public static void log(Employee employee) {
	
	System.out.println("Sended email for verification to: "+employee.getEmail());
	
}
}