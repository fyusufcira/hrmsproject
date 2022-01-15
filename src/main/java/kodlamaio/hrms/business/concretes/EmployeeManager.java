package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.EmailValidator.EmailValidator;
import kodlamaio.hrms.EmailVerification.EmailVerification;
import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.concretes.Employee;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;
@Service
public class EmployeeManager implements EmployeeService{
	private EmployeeDao employeeDao;
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		this.employeeDao=employeeDao;
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll());
		
	}
	
	@Override
	public Result register(Employee employee) throws Exception{
		
		
		/*	KPSPublicSoapProxy kpsPublic= new KPSPublicSoapProxy();
			boolean mernisCheckResult= kpsPublic.TCKimlikNoDogrula(employee.getNationalityId(),employee.getFirstName(),
					employee.getLastName(),employee.getDateOfBirth().getYear());
			*/
			if(!employee.getPassword().equals(employee.getPasswordRepetition())) {
				return new ErrorResult("ERROR!Passwords you entered arent same.");
				
			}
			/*if(mernisCheckResult==false) {
			return new ErrorResult("ERROR!You couldn't pass the mernis test.");
			}*/
			checkIfUserExistsBefore(employeeDao.findAll(), employee);
			
			EmailValidator.isEmailValid(employee.getEmail());
			EmailVerification.log(employee);
		
		this.employeeDao.save(employee);
		return new SuccessResult("Employee added.");
	}

	@Override
	public Result delete(Employee employee) {
		this.employeeDao.delete(employee);
		return new SuccessResult("employee deleted.");
	}

	private Result checkIfUserExistsBefore(List<Employee> employees, Employee checkEmployee){
        for (Employee employee: employees) {
            if (employee.getEmail().equals(checkEmployee.getEmail())){
                return new ErrorResult("Bu email mevcut.");
            }
            if (employee.getNationalityId()==checkEmployee.getNationalityId()){
                return new ErrorResult("Bu kimlik numarasÄ± zaten mevcut.");
            }
        }
        return new SuccessResult();
    }

}
