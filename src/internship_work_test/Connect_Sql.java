package internship_work_test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import internship_work_test.Information_log_in;
public class Connect_Sql {
	
	public Statement statement;

	
	public Connect_Sql()
	{
		try {
			Class.forName(internship_work_test.Information_log_in.DRIVER_MYSQL);
			System.out.println("DRIVER LOAD SUCCESS");
			try {
				Connection connection=DriverManager.getConnection(Information_log_in.URL, Information_log_in.USER, Information_log_in.Pwd);
				statement=connection.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet query(String sql)
	{
		ResultSet result=null;
     	try {
			result=statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public void execute(String sql)
	{
		try {
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}