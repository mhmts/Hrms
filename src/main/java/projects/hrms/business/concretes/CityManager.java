package projects.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projects.hrms.business.abstacts.CityService;
import projects.hrms.business.concretes.checkInfo.CityCheckManager;
import projects.hrms.core.utilities.results.results.DataResult;
import projects.hrms.core.utilities.results.results.ErrorDataResult;
import projects.hrms.core.utilities.results.results.Result;
import projects.hrms.core.utilities.results.results.SuccessDataResult;
import projects.hrms.dataAccess.abstracts.CityDao;
import projects.hrms.entities.concretes.City;


@Service
public class CityManager implements CityService {

    private CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }



    @Override
    public DataResult<List<City>> getAll(){
        return  new SuccessDataResult<List<City>>(this.cityDao.findAll(),"Cities retrieved");

    }

    @Override
    public Result add(City city) {

        CityCheckManager cityCheckManager = new CityCheckManager(city);
        if(!cityCheckManager.checkCitySaved(this.cityDao.findAll())){
            this.cityDao.save(city);
            return new SuccessDataResult("City added");
        }
        else{
            return  new ErrorDataResult(cityCheckManager.getMessage());
        }


    }
}