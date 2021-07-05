package projects.hrms.business.concretes.checkInfo;

import java.util.List;

import lombok.Data;
import projects.hrms.entities.concretes.City;

@Data
public class CityCheckManager {

    private City city;
    private String message="";

    public CityCheckManager(City city){
        this.city=city;
    }

    public boolean checkCitySaved(List<City> allCities){

        for(City city : allCities){
            if(city.getName().equals(this.city.getName())){
                message="Job is already added";
                return true;
            }
        }

        return false;

    }

}