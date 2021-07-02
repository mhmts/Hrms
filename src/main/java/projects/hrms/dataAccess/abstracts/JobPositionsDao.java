package projects.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import projects.hrms.entities.concretes.JobPosition;

public interface JobPositionsDao extends JpaRepository<JobPosition,Integer>{
	

}