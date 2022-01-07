package in.sts.gradleproject.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;

import org.apache.log4j.Logger;

import in.sts.gradleproject.models.Employee;
import in.sts.gradleproject.models.Salary;
import in.sts.gradleproject.mysqlconnection.MysqlConnection;

public class SalaryDao {
	
	final Logger logger=Logger.getLogger("SalaryDao.class");
	Salary salarymodel=new Salary();

	public int salarydetailsInsert(HashSet<Employee> hashset) throws Exception
	{


		

		Connection con=MysqlConnection.connectivity();
		String query="insert into Salary values(SalaryId,?,?,?,?)";
		PreparedStatement pstmt=MysqlConnection.preparedstatement(query);
		int result=0;
		try
		{




			if(con!=null)
			{
				for(Employee e:hashset)
				{
					
					for(Salary s:e.getSalarymodel().getSalarylist()) {
						pstmt.setInt(1,e.getId() );
						pstmt.setString(2,s.getMonth());
						pstmt.setInt(3,s.getAmount());
						pstmt.setInt(4, s.getYear());
						result=pstmt.executeUpdate();		
					}
					

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
		catch(SQLException ex)
		{
			logger.error("Sql Exception please cheack the connectivity or the query");
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
