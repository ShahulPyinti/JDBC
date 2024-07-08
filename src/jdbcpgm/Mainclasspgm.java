package jdbcpgm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Mainclasspgm {
	Jdbc reg=new Jdbc();
	Scanner s=new Scanner(System.in);

	void getData()
	{
	System.out.println("Enter your Registeration Number ");
	reg.setRegistrationnumber(s.nextInt());
	System.out.println("Enter the Name ");
	reg.setName(s.next());
	System.out.println("Enter your Department ");
	reg.setDept(s.next());
	System.out.println("Enter your Mobile Number ");
	reg.setMobileno(s.nextLong());
	}
	
	void insertData()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Lucky@SQL2024");
			PreparedStatement pr=con.prepareStatement("insert into Registration (regis_no,name,dept,mobileNo) values(?,?,?,?)");
			pr.setInt(1,reg.getRegistrationnumber());
			pr.setString(2,reg.getName());
			pr.setString(3,reg.getDept());
			pr.setLong(4,reg.getMobileno());
			int i=pr.executeUpdate();
			if(i>0) {
				System.out.println("Insertion successfull!!");
			}
			else {
				System.out.println("Error insertion");
			}
		}
		catch(ClassNotFoundException cnfe) {
			System.out.println(cnfe);
		}
		catch(SQLException sqle) {
			System.out.println(sqle);
		}

    }
	void reteriveData()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Lucky@SQL2024");
			PreparedStatement preparedStatement=con.prepareStatement("select * from registeration" );
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getInt(2));
				System.out.println(resultSet.getString(3));
				System.out.println(resultSet.getString(4));
				System.out.println(resultSet.getLong(5));
			}
			
		}
		catch(ClassNotFoundException cnfe)
		{
			System.out.println(cnfe);
		}
		catch(SQLException sqle)
		{
			System.out.println(sqle);
		}
		
		
		
	}
	void updateData()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Lucky@SQL2024");
			System.out.println("Enter the Mobile No u want to update");
			reg.setMobileno(s.nextLong());
			System.out.println("Enter the Register Number ");
			reg.setRegistrationnumber(s.nextInt());
			
			PreparedStatement preparedStatement=con.prepareStatement("update registeration set mobileNo=? where regis_no=? ");
			preparedStatement.setLong(1, reg.getMobileno());
			preparedStatement.setInt(2, reg.getRegistrationnumber());
			int i=preparedStatement.executeUpdate();
			if(i>0)
			{
				System.out.println("Update Operation Done Successfully");
			}
			else
			{
				System.out.println("Error in Updation ");
			}
			
			
		}
		catch(ClassNotFoundException cnfe)
		{
			System.out.println(cnfe);
		}
		catch(SQLException sqle)
		{
			System.out.println(sqle);
		}
		
		
	}

	public static void main(String[] args) {
		Mainclasspgm mc=new Mainclasspgm();
		mc.getData();
		mc.insertData();
}
}