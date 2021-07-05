package projects.hrms.business.abstacts;

import java.util.List;

import projects.hrms.core.utilities.results.results.DataResult;
import projects.hrms.core.utilities.results.results.Result;
import projects.hrms.entities.concretes.City;

public interface CityService {

    DataResult<List<City>> getAll();
    Result add(City city);

}