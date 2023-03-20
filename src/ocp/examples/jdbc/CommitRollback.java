package ocp.examples.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CommitRollback {


	public static void main(String... data) throws SQLException {
		String url = "jdbc:derby:clowns";
		try (Connection conn = DriverManager.getConnection(url);
				Statement stmt = conn.createStatement()) {
			conn.setAutoCommit(false);
			stmt.executeUpdate("insert into colors values ('red')");
			stmt.executeUpdate("insert into colors values ('blue')");
			conn.rollback();
			conn.setAutoCommit(true);
			stmt.executeUpdate("insert into colors values ('green')");
			conn.rollback(); //la commit viene eseguita in ogni caso perchè automatica
		}
	}
}