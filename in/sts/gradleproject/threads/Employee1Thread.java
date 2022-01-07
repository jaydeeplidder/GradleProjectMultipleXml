package in.sts.gradleproject.threads;

import java.util.HashSet;

import org.apache.log4j.Logger;

import in.sts.gradleproject.daos.AddressDao;
import in.sts.gradleproject.daos.EmployeeDao;
import in.sts.gradleproject.daos.SalaryDao;
import in.sts.gradleproject.models.Employee;
import in.sts.gradleproject.xmlreader.EmployeeReader;

public class Employee1Thread extends Thread {
	EmployeeReader employeeRead=new EmployeeReader();
	final Logger logger=Logger.getLogger("EmployeeThread1.class");
	EmployeeDao employeedao=new EmployeeDao();
	SalaryDao salarydao=new SalaryDao();
	AddressDao addressdao=new AddressDao();
	
	@Override
	public void run() {
		HashSet<Employee> hashset=new HashSet<>();
		Employee employee=new Employee();
		try {
			employeeRead.employeeRead("employee.xml",hashset);
			
			
			for(Employee e:hashset)
			{
				logger.info("Reader id"+e.getId()+" "+e.getAddressmodel().getCity()+" "+e.getSalarymodel().getSalarylist());
			}
			
//			employeedao.employeedetailsInsert(hashset);
//			addressdao.addressdetailsInsert(hashset);
//			salarydao.salarydetailsInsert(hashset);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
