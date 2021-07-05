package projects.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import projects.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City,Integer> {
}