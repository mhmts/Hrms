package projects.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import projects.hrms.entities.concretes.SystemEmployeeConfirm;

public interface SystemEmployeeConfirmDao extends JpaRepository<SystemEmployeeConfirm, Integer> {

}
