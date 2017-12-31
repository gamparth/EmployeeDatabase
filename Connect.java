import java.sql.*;
class Connect
{
	Connection co;
	PreparedStatement ps;
	ResultSet rs;
	Connect()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			co=DriverManager.getConnection("jdbc:odbc:tips");
		}catch(Exception ee){
		System.out.println(ee);
		}
	}
public boolean insertEmployee(String code,String name,String age,String address,String gender,String phone,String mobile,String email,String department,String designation)
{
	try
	{
		ps=co.prepareStatement("insert into employees(employeecode,name,age,address,gender,phone,mobile,emailaddress,department,designation) values(?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1,code);
		ps.setString(2,name);
		ps.setInt(3,Integer.parseInt(age));
		ps.setString(5,gender);
		ps.setString(4,address);
		ps.setString(6,phone);
		ps.setString(7,mobile);
		ps.setString(8,email);
		ps.setString(9,department);
		ps.setString(10,designation);
		ps.executeUpdate();
		return true;
	}catch(Exception ee)
	{
		System.out.println(ee);
		return false;
	}
}

public boolean editEmployee(String code,String name,String age,String address,String gender,String phone,String mobile,String email,String department,String designation,int employeeid)
{
	try
	{
		ps=co.prepareStatement("update Employees set employeecode=?,name=?,age=?,address=?,gender=?,phone=?,mobile=?,emailaddress=?,department=?,designation=? where EmployeeID=?");
		ps.setString(1,code);
		ps.setString(2,name);
		ps.setInt(3,Integer.parseInt(age));
		ps.setString(5,gender);
		ps.setString(4,address);
		ps.setString(6,phone);
		ps.setString(7,mobile);
		ps.setString(8,email);
		ps.setString(9,department);
		ps.setString(10,designation);
		ps.setInt(11,employeeid);
		ps.executeUpdate();
		return true;
	}catch(Exception ee)
	{
		System.out.println(ee);
		return false;
	}
	
}

public void searchEmployee(String code)
{
	try
	{
		ps=co.prepareStatement("select * from Employees where EmployeeCode=?");
		ps.setString(1,code);
		rs=ps.executeQuery();
	}catch(Exception e)
	{
		System.out.println(e);
	}
}
public boolean deleteEmployee(int employeeid)
{
	try
	{
		ps=co.prepareStatement("delete from employees where employeeid=?");
		ps.setInt(1,employeeid);
		ps.executeUpdate();
		return true;
	}catch(Exception e)
	{
		return false;
	}
}
}
