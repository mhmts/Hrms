package projects.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projects.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {

   
    List<JobAdvertisement> findByStatueTrue();
    List<JobAdvertisement> findByStatueTrueOrderByReleaseDate();
    List<JobAdvertisement> findByEmployer_CompanyName(String employerName);


}
