package in.sts.gradleproject.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;

import org.apache.log4j.Logger;

import in.sts.gradleproject.models.Employee;
import in.sts.gradleproject.mysqlconnection.MysqlConnection;

public class AddressDao {
	final Logger logger=Logger.getLogger("AddressDao.class");
	public int addressdetailsInsert(HashSet<Employee> hashset) throws Exception
	{




		Connection con=MysqlConnection.connectivity();
		String query="insert into Address values(AddressId,?,?,?,?)";

		PreparedStatement pstmt=MysqlConnection.preparedstatement(query);;
		int result=0;
		try
		{



			if(con!=null)
			{

				for(Employee e:hashset)
				{
					pstmt.setInt(1,e.getId() );
					pstmt.setString(2, e.getAddressmodel().getCity());
					pstmt.setString(3,e.getAddressmodel().getCountry());
					pstmt.setInt(4,e.getAddressmodel().getPincode());

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
