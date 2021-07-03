package projects.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projects.hrms.business.abstacts.SystemEmployeeService;
import projects.hrms.core.utilities.results.results.ErrorResult;
import projects.hrms.core.utilities.results.results.Result;
import projects.hrms.core.utilities.results.results.SuccessResult;
import projects.hrms.dataAccess.abstracts.SystemEmployeeDao;
import projects.hrms.entities.concretes.SystemEmployee;

@Service
public class SystemEmployeeManager implements SystemEmployeeService {
	 
	SystemEmployeeDao systemEmployeeDao;
    
    @Autowired
    public SystemEmployeeManager(SystemEmployeeDao systemEmployeeDao) {
    	this.systemEmployeeDao=systemEmployeeDao;
    }
    
    @Override
    public List<SystemEmployee> getAll() {
        return this.systemEmployeeDao.findAll();
    }

    @Override
    public Result add(SystemEmployee systemEmployee) {
        List<Result> results = new ArrayList<Result>();
        boolean isFail = false;
        Result nullControl = nullControlForAdd(systemEmployee);
//        Result passwordAgainControl= passwordAgainControl(systemEmployee);
        
        results.add(nullControl);
//        results.add(passwordAgainControl);
        
        for (var result : results) {
            if(!result.isSuccess())
            {
                isFail = true;
                return result;
            }
        }
        
        if(isFail == false)
        {
            this.systemEmployeeDao.save(systemEmployee);
            return new SuccessResult("System Employee added.");
        }
        
        return new ErrorResult();    
    }
    
    public Result nullControlForAdd(SystemEmployee systemEmployee) {
        if (    systemEmployee.getFirstName() == ""
                || systemEmployee.getLastName() == ""
                || systemEmployee.getEmail() == ""
                || systemEmployee.getPassword() == "" )
        {
            return new ErrorResult("Fill the all required fields.");
        }
        return new SuccessResult();
    }
    

    
}