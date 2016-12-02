package internship_work_test;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Function {

	public static void printData(int[] id,int[] amount,double[] price,String[] sc_fac,Date[] fh_date)
	{
		String str="";
		for(int i=0;i<id.length;i++)
		{
			str+=id[i]+"    "+amount[i]+"    "+price[i]+"      "+sc_fac[i]+"      "+fh_date[i]+"\n";
		}
		JOptionPane.showMessageDialog(null, str, "数据表", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void newprintData(int[] id,int[] amount,double[] price,String[] sc_fac,Date[] fh_date,String[] province)
	{
		String str="";
		for(int i=0;i<id.length;i++)
		{
			str+=id[i]+"    "+amount[i]+"    "+price[i]+"      "+sc_fac[i]+"      "+fh_date[i]+"      "+province[i]+"\n";
		}
		JOptionPane.showMessageDialog(null, str, "数据表", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static String[] cut_out(String[] sc_fac,String[] province)
	{
		for(int i=0;i<sc_fac.length;i++)
		{
			System.out.println(sc_fac[i]==null);
		}
		for(int i=0;i<sc_fac.length;i++)
		{
			if(sc_fac[i] !=null && !"".equals(sc_fac))
			{
			province[i]=sc_fac[i].substring(0,2);
			}
			else{
				continue;
			}
		}
		return province;
	}
	
	public static void addProvince(Analysis analysis) throws SQLException
	{
		String sql="select * from zone;";
		ResultSet result=analysis.connect.query(sql);
		int zone_length;
		result.last();
		zone_length=result.getRow();
		result.first();
		String[] zone=new String[zone_length];
		int in=0;
		do
		{
			zone[in]=result.getString(1);
			in++;
			
		}while(result.next()&&in<zone.length);
	
		for(int i=0;i<zone.length;i++)
		{
		    String sql2="update 新数据2 set province='"+zone[i]+"' where left(sc_fac,2)='"+zone[i]+"';";
		    analysis.connect.execute(sql2);
		}	
	}
	public static void addVar(String variable,String type,Analysis analysis)
	{
		String sql="alter table 新数据2 add "+variable+" "+type;
		analysis.connect.execute(sql);
	}
}