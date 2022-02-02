package in.sts.gradleproject.threads;

import java.util.HashSet;

import org.apache.log4j.Logger;

import in.sts.gradleproject.daos.AddressDao;
import in.sts.gradleproject.daos.EmployeeDao;
import in.sts.gradleproject.daos.SalaryDao;
import in.sts.gradleproject.models.Employee;
import in.sts.gradleproject.xmlreader.EmployeeReader;

public class MultiThread extends Thread {


	EmployeeReader employeeRead=new EmployeeReader();
	final Logger logger=Logger.getLogger("EmployeeThread1.class");
	EmployeeDao employeedao=new EmployeeDao();
	SalaryDao salarydao=new SalaryDao();
	AddressDao addressdao=new AddressDao();

	@Override
	public void run() {
		

		try {

			//..................................................Emp1.....................................................
			if(this.currentThread().getName().equals("First Thread"))
			{
			HashSet<Employee> hashset=new HashSet<>();
			employeeRead.employeeRead("employee.xml",hashset);


			for(Employee e1:hashset)
			{
				logger.info("Reader id"+e1.getId()+" "+e1.getReportingto()+" "+e1.getAddressmodel().toString()+" "+e1.getSalarymodel().getSalarylist());
			}

			//			employeedao.employeedetailsInsert(hashset);
			//			addressdao.addressdetailsInsert(hashset);
			//			salarydao.salarydetailsInsert(hashset);

			}
			//..........................................................................................................................
			
			
			//..........................................Emp2.....................................................................
			else if(this.currentThread().getName().equals("Second Thread")) {
			HashSet<Employee> hashset2=new HashSet<>();


			employeeRead.employeeRead("employee2.xml",hashset2);


			for(Employee e2:hashset2)
			{
				logger.info("Reader id"+e2.getId()+" "+e2.getAddressmodel().toString()+" "+e2.getSalarymodel().getSalarylist());
			}

			//			employeedao.employeedetailsInsert(hashset2);
			//						addressdao.addressdetailsInsert(hashset2);
			//			salarydao.salarydetailsInsert(hashset2);
			}
			//...................................................................................................................

			
			
			//..........................................Emp3.....................................................................
			else if(this.currentThread().getName().equals("Third Thread")) {
			HashSet<Employee> hashset3=new HashSet<>();


			employeeRead.employeeRead("employee3.xml",hashset3);


			for(Employee e3:hashset3)
			{
				logger.info("Reader id"+e3.getId()+" "+e3.getAddressmodel().toString()+" "+e3.getSalarymodel().getSalarylist());
			}

			//			employeedao.employeedetailsInsert(hashset3);
			//			addressdao.addressdetailsInsert(hashset3);
			//			salarydao.salarydetailsInsert(hashset3);
			}
			//...................................................................................................................

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
