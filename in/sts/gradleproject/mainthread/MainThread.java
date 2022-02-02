package in.sts.gradleproject.mainthread;

import java.util.HashSet;

import in.sts.gradleproject.models.Employee;
import in.sts.gradleproject.threads.Employee1Thread;
import in.sts.gradleproject.threads.Employee2Thread;
import in.sts.gradleproject.threads.Employee3Thread;
import in.sts.gradleproject.threads.MultiThread;

public class MainThread extends Thread {

	public MainThread() throws InterruptedException
	{

//		Employee employee=new Employee();
//		Employee1Thread thread1 = new Employee1Thread();
//		Employee2Thread thread2 = new Employee2Thread();
//		Employee3Thread thread3 = new Employee3Thread();
//		thread1.start();
//
//		thread1.join();
//
//		thread2.start();
//		thread2.join();
//		
//		thread3.start();
//		thread3.join();

		MultiThread thread1=new MultiThread();
		thread1.setName("First Thread");
		thread1.setPriority(10);
		MultiThread thread2=new MultiThread();
		thread2.setName("Second Thread");
		thread2.setPriority(5);
		MultiThread thread3=new MultiThread();
		thread3.setName("Third Thread");
		thread3.setPriority(1);
		
		thread1.start();
		thread1.join();
		thread2.start();
		thread2.join();
		thread3.start();
	}

}
