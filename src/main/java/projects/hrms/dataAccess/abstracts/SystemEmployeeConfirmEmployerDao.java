package projects.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import projects.hrms.entities.concretes.SystemEmployeeConfirmEmployer;

public interface SystemEmployeeConfirmEmployerDao extends JpaRepository<SystemEmployeeConfirmEmployer, Integer>  {

}