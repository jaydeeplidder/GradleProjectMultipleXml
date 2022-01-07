package in.sts.gradleproject.mainthread;

import java.util.HashSet;

import in.sts.gradleproject.models.Employee;
import in.sts.gradleproject.threads.Employee1Thread;
import in.sts.gradleproject.threads.Employee2Thread;
import in.sts.gradleproject.threads.Employee3Thread;

public class MainThread extends Thread {

	public MainThread() throws InterruptedException
	{

		Employee employee=new Employee();
		Employee1Thread thread1 = new Employee1Thread();
		Employee2Thread thread2 = new Employee2Thread();
		Employee3Thread thread3 = new Employee3Thread();
		thread1.start();

		thread1.join();

		thread2.start();
		thread2.join();
		
		thread3.start();
		thread3.join();


	}

}
