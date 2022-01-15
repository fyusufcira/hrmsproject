package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.VerificationService;
import kodlamaio.hrms.dataAccess.abstracts.VerificationDao;

@Service
public class VerificationManager implements VerificationService{

	VerificationDao verificationDao;
	@Autowired
	
	 public VerificationManager(VerificationDao verificationDao) {
		
		 this.verificationDao=verificationDao;
	}
	@Override
	public boolean verificate( ) {
		System.out.println( "verificated by admin.");
		return true;
		
		
	}
}
