package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService{

	private CityDao cityDao;
	
	 public CityManager(CityDao cityDao) {
		this.cityDao=cityDao;
	}
	
	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>
		(this.cityDao.findAll());
	}

	@Override
	public Result add(City city) {
		
		return new SuccessDataResult<City>
		(this.cityDao.save(city),"City added.");
	}

	@Override
	public void update(City city) {
		
		this.cityDao.saveAndFlush(city);
		
	}

	@Override
	public void delete(City city) {
		this.cityDao.delete(city);
		
	}

}
