package internship_work_test;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import internship_work_test.Function;

public class Analysis {
	
	public static int data_length;
	public Connect_Sql connect;
	public static int[] id; 
	public static int[] amount;
	public static double[] price;
	public static  String[] sc_fac;
	public static  Date[] fh_date;
	public static  String[] province;
	
	public Analysis()
	{
		
	}
	public void connect()
	{
		connect=new Connect_Sql();
		System.out.println("the database connection is successful! ");
	    
	}
	
	public void disconnect()
	{
		try {
			connect.statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void getData(Analysis analysis) throws SQLException
	{
		   analysis.connect();
		   String sql="select * from 新数据2 ";// select 10 data in the table 数据
		   ResultSet result=analysis.connect.query(sql);
		   result.last();// cursor on the last of line
		   data_length=result.getRow();
		   result.first(); // cursor back on the head of line
		   id=new int[data_length];
		   amount=new int[data_length];
		   price=new double[data_length];
		   sc_fac=new String[data_length];
		   fh_date=new Date[data_length];
		   province=new String[data_length];
		   int in=0;
		   do{
			   id[in]=result.getInt(1);
			   amount[in]=result.getInt(2);
			   price[in]=result.getDouble(3);
			   sc_fac[in]=result.getString(5);
			   fh_date[in]=result.getDate(6);
			   in++;
		   }while(result.next()&&in<data_length);
	}
	public static void main(String[] args) throws SQLException
	{
	   Analysis analysis=new Analysis();
	   analysis.getData(analysis);
	   Function.cut_out(sc_fac, province);
	  // Function.addVar("province", "varchar(6)", analysis);
	   Function.addProvince(analysis);
	   //System.out.println("insert successful");
	   }

}