package in.sts.gradleproject.service;



import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;



import in.sts.gradleproject.daos.EmployeeDao;

import in.sts.gradleproject.models.Employee;



//..............................READING AND STORING XML SIMULTANEOUSLY TO DATBASE.......................................................


public class EmployeeService 
{  
	final Logger logger=Logger.getLogger("EmployeeServiceClass.class");
	Set<Employee> hashset=new HashSet<>();
	Employee empmodel=new Employee();
	public int Employeeservice(int id, int reportingto, String designation, String firstname, String lastname) throws Exception

	{
		
		int result=0;
		
		
		
		
		EmployeeDao empdao=new EmployeeDao();
		empmodel.setId(id);
		empmodel.setReportingto(reportingto);
		empmodel.setDesignation(designation);
		empmodel.setFirstname(firstname);

		empmodel.setLastname(lastname);
		
		int eid=empmodel.getId();
		int report=empmodel.getReportingto();
		String edesignation=empmodel.getDesignation();
		String efname=empmodel.getFirstname();
		String elname=empmodel.getLastname();
		logger.info("Student id: "+ empmodel.getId());
		logger.info("First Name: "+ empmodel.getFirstname());  
		logger.info("Last Name: "+ empmodel.getLastname());
		logger.info("Designation: "+ empmodel.getDesignation());
		logger.info("Reportingto"+ empmodel.getReportingto());

		Employee empmodel2=new Employee(eid, report,edesignation,  efname, elname);
		hashset.add(empmodel2);
		
		
		empmodel.setEmployeeHashset(hashset);
		for(Employee e:empmodel.getEmployeeHashset())
		{
			logger.info("this id "+e.getId()+" "+e.getFirstname()+" "+e.getLastname()+" "+e.getDesignation()+" "+e.getReportingto());
		}
		
		
	
		
		
//		
		
//		empdao.employeedetailsInsert(empmodel);
		return result;



	}
	public void list()
	{
		logger.info("list is running");
		empmodel.setEmployeeHashset(hashset);
		for(Employee e:empmodel.getEmployeeHashset()) {
			logger.info(e.getId());
		}
	}
	
}
