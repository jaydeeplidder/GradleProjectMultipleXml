package in.sts.gradleproject.service;

import org.apache.log4j.Logger;

import in.sts.gradleproject.daos.UniqueEmployeeListDao;
import in.sts.gradleproject.models.Employee;

public class UniqueEmployeeService {

	
	public void uniqueEmployee(Employee employeemodel) throws Exception {
		
		UniqueEmployeeListDao uniqueDao=new UniqueEmployeeListDao();
		
		uniqueDao.employeeUnique(employeemodel);
		
		for(Employee e:employeemodel.getEmployeeHashset()) {
			
			
			System.out.println("FirstName:-"+e.getFirstname()+" LastName :-"+e.getLastname()+" "+e.getDesignation());
			
		}
		System.out.println(employeemodel.getEmployeeHashset().hashCode());
		
	}
	
}
