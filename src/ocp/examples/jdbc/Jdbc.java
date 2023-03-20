package ocp.examples.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String url = "jdbc:derby:clowns";
		Class.forName("java.lang.Thread"); //esempio
		try (Connection conn = DriverManager.getConnection(url);
				Statement stmt = conn.createStatement(ResultSet.FETCH_REVERSE,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery("select title from clowns")) {
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO STUDENT VALUES (?, ?)"); //This is created only once 
			//Once created, the PREPAREDSTATEMENT is compiled automatically.    
			ps.setInt(1, 111);
			ps.setString(2, "Bob");
			ps.executeUpdate();
			//Now change the parameter values and execute again.   
			ps.setInt(1, 112);
			ps.setString(2, "Cathy");
			ps.executeUpdate();
			rs.next();
			
			//computeMatrixForSales is a STORED PROCEDURE that has already been created in the database.   
			CallableStatement cs = conn.prepareCall("{call computeMatrixForSales(?)}");
			cs.setInt(1, 1000);
			cs.executeUpdate();
			
			rs.absolute(0); //valori assoluti delle righe, con i - si parte dalla fine
			rs.relative(5); //non posso mettere il cursore più dietro di 0
			if (rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString("title"));
			}
			ResultSet rs2 = stmt.executeQuery("select * from pens");
			rs2.afterLast();
			rs2.previous();
			rs2.updateInt(2, 10);
			rs2.updateRow();
			rs2 = stmt.executeQuery("select * from pens where color = 'red'");
			while (rs.next())
			System.out.println(rs.getInt(2));
		}
	}

}