package projects.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import projects.hrms.entities.concretes.SystemEmployee;

public interface SystemEmployeeDao extends JpaRepository<SystemEmployee, Integer> {
	
}