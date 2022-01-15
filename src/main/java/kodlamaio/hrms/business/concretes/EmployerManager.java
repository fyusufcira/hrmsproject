package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.EmailValidator.EmailValidator;
import kodlamaio.hrms.EmailVerification.EmailVerification;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.VerificationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.VerificationDao;
import kodlamaio.hrms.entities.concretes.Employer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;
@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private VerificationService verificationService;
	@Autowired
	public EmployerManager(EmployerDao employerDao,VerificationDao verificationDao) {
		this.employerDao=employerDao;
		this.verificationService=verificationService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
		
	}
	

	@Override
	public Result delete(Employer employer) {
		this.employerDao.delete(employer);
		return new SuccessResult("User deleted.");
	}

	private Result checkIfEmailExistsBefore(List<Employer> employers, Employer checkEmployer){
        for (Employer employer: employers) {
            if (employer.getEmail().equals(checkEmployer.getEmail())){
                return new ErrorResult("Bu email mevcut.");
            }
        }
        return new SuccessResult();
    }

	@Override
	public Result register(Employer employer) {
		
		checkIfEmailExistsBefore(employerDao.findAll(), employer);
		if(!employer.getPassword().equals(employer.getPasswordRepetition()))
		{
			return new ErrorResult("Passwords doesnt match");
		}
		
		this.employerDao.save(employer);
		//verificationService.verificate(employer);
		return new SuccessResult("Employer registered.");
	}

}
