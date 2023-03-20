package ocp.examples.jdbc;

public class Info {

}

/*
JDBC 3.0 
* java.sql.Driver : ALLOWED
* Class.forName() : REQUIRED
JDBC 4.0 
* java.sql.Driver : REQUIRED
* Class.forName() : ALLOWED
*
*
INTERFACE STATEMENT
boolean execute(String sql)
* Executes the given SQL statement, which may return multiple results.
ResultSet executeQuery(String sql)
* Executes the given SQL statement, which returns a single ResultSet object.
int executeUpdate(String sql)
* Executes the given SQL statement, which may be an INSERT, UPDATE, or DELETE statement
* or an SQL statement that returns nothing, such as an SQL DDL statement.
* 
* 
* When running a query on a Statement, Java closes any already open ResultSet objects.
* 
* STATEMENTS for queries
* PREPAREDSTATEMENT for queries executed multiple times
* CALLABLESTATEMENT for stored procedure
*
*
*To update an existing row:  
* 1. First, go to the row you want to update.
* You can either iterate through a ResultSet to reach a particular row or just call rs.absolute(int rowNumber). 
* 2. Now update the columns of the ResultSet with required values using rs.updateXXX(columnNumber, value) or rs.updateXXX(columnName, value) methods. 
* 3. Call rs.updateRow(); If you call rs.refreshRow() without calling updateRow(), the updates will be lost.  
* 
* To insert a new Row: 
* 1. Call rs.moveToInsertRow(); first. You can't insert a row without calling this method first. 
* 2. Use rs.updateXXX methods to update all column values. You must set values for all the columns. 
* 3. Call rs.insertRow();  
* 4. Call rs.moveToCurrentRow(); to go back to the row where you were before calling moveToInsertRow.
*/
