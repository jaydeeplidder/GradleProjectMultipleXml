package in.sts.gradleproject.daos;






import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.HashSet;

import org.apache.log4j.Logger;

import in.sts.gradleproject.models.Employee;
import in.sts.gradleproject.mysqlconnection.MysqlConnection;


public class UniqueEmployeeListDao {

	final Logger logger=Logger.getLogger("UniqueEmployeeListDao.class");

	public int employeeUnique(Employee employeemodel) throws Exception
	{

		int id;
		String firstname;
		String lastname;
		String designation;
		int reportingto;


		HashSet<Employee> employeeList=new HashSet<>();




		Connection con=MysqlConnection.connectivity();
		String query="Select * from Employee";
		PreparedStatement pstmt=MysqlConnection.preparedstatement(query);
		ResultSet rs=pstmt.executeQuery();
		int result=0;
		try
		{

			while(rs.next()) {
				
				employeemodel.setId(rs.getInt("EmployeeID"));
				employeemodel.setFirstname(rs.getString("FirstName"));
				employeemodel.setLastname(rs.getString("LastName"));
				employeemodel.setDesignation(rs.getString("Designation"));
				employeemodel.setReportingto(rs.getInt("reportingto"));
				id=employeemodel.getId();
				firstname=employeemodel.getFirstname();
				lastname=employeemodel.getLastname();
				designation=employeemodel.getDesignation();
				reportingto=employeemodel.getReportingto();
				Employee employeemodel1=new Employee(firstname,lastname,designation);
				employeeList.add(employeemodel1);
				

				
		
			}
			employeemodel.setEmployeeHashset(employeeList);

			if(con!=null)
			{

				System.out.println("Connection established");
			}
			if(pstmt!=null)
			{
				System.out.println("You Successfully Signed In");
			}
			
			
			System.out.println("details are not inserted");

		}
		catch(SQLException ex)
		{
			System.out.println("Sql Exception please cheack the connectivity or the query");
		}
		catch(Exception e)
		{
			System.out.println(" Exception please cheack the code");
		}
		finally
		{

			MysqlConnection.closeMysqlconnection();


		}
		return result;


	}
}

