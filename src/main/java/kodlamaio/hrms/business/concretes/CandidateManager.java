package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.EmailValidator.EmailValidator;
import kodlamaio.hrms.EmailVerification.EmailVerification;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;
@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		this.candidateDao=candidateDao;
	}
	
	
	@Override
	public DataResult<List<Candidate>> getAll() {
		
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll());
	}

	@Override
	public Result register(Candidate candidate) throws Exception {
		
			/*KPSPublicSoapProxy kpsPublic= new KPSPublicSoapProxy();
			boolean mernisCheckResult= kpsPublic.TCKimlikNoDogrula(candidate.getNationalityId(),candidate.getFirstName(),
					candidate.getLastName(),candidate.getDateOfBirth().getYear());
			*/
			if(!candidate.getPassword().equals(candidate.getPasswordRepetition()))  {
				return new ErrorResult("ERROR!Passwords you entered arent same.");
			}
			/*if(mernisCheckResult==false) {
			return new ErrorResult("ERROR!You couldn't pass the mernis test.");
			}*/
			checkIfUserExistsBefore(candidateDao.findAll(), candidate);
			
			EmailValidator.isEmailValid(candidate.getEmail());
			EmailVerification.log(candidate);
		
	
		
		EmailVerification.log(candidate);
		this.candidateDao.save(candidate);
		
		return new SuccessResult("candidate added.");
	}

	@Override
	public Result delete(Candidate candidate) {
		this.candidateDao.delete(candidate);
		return new SuccessResult("candidate deleted.");
		
	}

	
	
	   private Result checkIfUserExistsBefore(List<Candidate> candidates, Candidate checkCandidate){
        for (Candidate candidate: candidates) {
            if (candidate.getEmail().equals(checkCandidate.getEmail())){
                return new ErrorResult("Bu email mevcut.");
            }
            if (candidate.getNationalityId()==checkCandidate.getNationalityId()){
                return new ErrorResult("Bu kimlik numarasÄ± zaten mevcut.");
            }
        }
        return new SuccessResult();
    }

}
