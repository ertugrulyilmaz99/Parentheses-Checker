package g;
import java.sql.*;

import g.GetCon;
public class RegisterUser {
static int status=0;
/** Ertuğrul Yılmaz, ID: 041701030, 16 November 2019 
 * A class with correct parentheses.*/
public static int register(String username,String password,String repassword,double amount,String adderess,double phone){
	

	Connection con=GetCon.getCon();
	PreparedStatement ps;
	try {
		ps = con.prepareStatement("Insert into NEWACCOUNT values(?,?,?,?,?,?,?)");
		int	nextvalue1=GetCon.getPrimaryKey();
		ps.setInt(1,nextvalue1);
		ps.setString(2,username);
		ps.setString(3,password);
		ps.setString(4,repassword);
		ps.setDouble(5,amount);
		ps.setString(6,adderess);
		ps.setDouble(7,phone);
		
		status=ps.executeUpdate();
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return status;
	
}
}
