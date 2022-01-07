package in.sts.gradleproject.daos;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;

import org.apache.log4j.Logger;

import in.sts.gradleproject.models.Employee;
import in.sts.gradleproject.mysqlconnection.MysqlConnection;


public class EmployeeDao   {

	final Logger logger=Logger.getLogger("EmployeeDao.class");

	public int employeedetailsInsert(HashSet<Employee> hashset) throws Exception
	{
		int result=0;
		logger.info("EmployeeDao");
		
		
		

		Connection con=MysqlConnection.connectivity();
		String query="insert into Employee values(?,?,?,?,?)";
		PreparedStatement pstmt=MysqlConnection.preparedstatement(query);
		
		try
		{

			


			if(con!=null)
			{

				
				for(Employee e:hashset)
				{
					
				
					pstmt.setInt(1,e.getId() );
					pstmt.setString(2, e.getFirstname());
					pstmt.setString(3,e.getLastname());
					pstmt.setString(4,e.getDesignation());
					pstmt.setInt(5,e.getReportingto());
					result=pstmt.executeUpdate();
				
				}


				
			}
			if(pstmt!=null)
			{
				logger.error("You Successfully Signed In");
			}
			else
			{
				logger.error("details are not inserted");
			}
		}
		catch(Exception e)
		{
			logger.error(" Exception please cheack the code");
		}
		finally
		{

			MysqlConnection.closeMysqlconnection();


		}
		return result;


	}
}