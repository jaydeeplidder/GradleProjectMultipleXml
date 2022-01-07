package in.sts.gradleproject.main;



import org.apache.log4j.BasicConfigurator;

import in.sts.gradleproject.mainthread.MainThread;
import in.sts.gradleproject.models.Employee;
import in.sts.gradleproject.service.EmployeeService;
import in.sts.gradleproject.service.TeamLeaderService;
import in.sts.gradleproject.service.UniqueEmployeeService;
import in.sts.gradleproject.xmlreader.EmployeeReader;

public class Main extends Thread {

	public static void main(String[] args)  throws Exception {
		EmployeeService es=new EmployeeService();
		BasicConfigurator.configure();
		// TODO Auto-generated method stub
		Employee employeemodel=new Employee();
		
		MainThread mainthread=new MainThread();
		mainthread.start();
		es.list();
		
//		UniqueEmployeeService uniqueemployeeservice=new UniqueEmployeeService();
//		uniqueemployeeservice.uniqueEmployee(employeemodel);
//		TeamLeaderService TL=new TeamLeaderService();
//		TL.tlservice();
	}

}
