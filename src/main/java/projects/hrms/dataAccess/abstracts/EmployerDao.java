package projects.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import projects.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
	
}