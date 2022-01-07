package in.sts.gradleproject.models;

import java.util.ArrayList;

public class Salary {

	private String month;
	private int amount;
	private int year;
	ArrayList<Salary> salarylist=new ArrayList<>();
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}


	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}



	public Salary() {
		super();
	}

	public Salary(String month, int amount, int year) {
		super();
		this.month = month;
		this.amount = amount;
		this.year = year;
	}

	public ArrayList<Salary> getSalarylist() {
		return salarylist;
	}

	public void setSalarylist(ArrayList<Salary> salarylist) {
		this.salarylist = salarylist;
	}

	@Override
	public String toString() {
		return "Salary [month=" + month + ", amount=" + amount + ", year=" + year + "]";
	}

}
