package students;

import java.sql.*;

public class DBUtilities {

    /* add new entry */
    public boolean addStudent(int id_number, String first_name, String middle_name, String last_name, String gender, String civil_status)
    {
        String hostname = "jdbc:mysql://localhost/students";
        String username = "root";
        String password = "";

        try {
           Class.forName("com.mysql.jdbc.Driver");
        }

        catch(java.lang.ClassNotFoundException e) {
           System.err.print("ClassNotFoundException: " + e.getMessage());
        }

        try
        {
            Connection con = DriverManager.getConnection(hostname, username, password);
            Statement stmt;
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);

            String tableName = "students";
            String columns = "(id_number, first_name, middle_name, last_name, gender, civil_status)";
            String values = "'"+id_number+"','"+first_name+"','"+middle_name+"','"+last_name+"','"+gender+"','"+civil_status+"'";
            
            stmt.executeUpdate("Insert into "+tableName+" "+columns+" values("+values+")");
            
            stmt.close();
            con.close();
        }

        catch(SQLException ex)
        {
           System.err.println("SQLException: " + ex.getMessage());
           return false;
        }

       return true;
    }
    
    public String[] searchStudent(int id_number)
    {
        String hostname = "jdbc:mysql://localhost/students";
        String username = "root";
        String password = "";
        
        String results[] = new String[5];

        try {
           Class.forName("com.mysql.jdbc.Driver");
        }

        catch(java.lang.ClassNotFoundException e) {
           System.err.print("ClassNotFoundException: " + e.getMessage());
        }
        
        try
        {
            Connection con = DriverManager.getConnection(hostname, username, password);
            Statement stmt;
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("Select * from students where id_number = "+id_number);

            if(rs.next()){
                results[0] = rs.getString("first_name");
                results[1] = rs.getString("middle_name");
                results[2] = rs.getString("last_name");
                results[3] = rs.getString("gender");
                results[4] = rs.getString("civil_status");
            }
           
            stmt.close();
            con.close();
        }

        catch(SQLException ex)
        {
           System.err.println("SQLException: " + ex.getMessage());
        }

        return results;
    }
    
    /* update entry */
    public boolean updateStudent(int id_number, String first_name, String middle_name, String last_name, String gender, String civil_status)
    {
        String hostname = "jdbc:mysql://localhost/students";
        String username = "root";
        String password = "";

        try {
           Class.forName("com.mysql.jdbc.Driver");
        }

        catch(java.lang.ClassNotFoundException e) {
           System.err.print("ClassNotFoundException: " + e.getMessage());
        }

        try
        {
            Connection con = DriverManager.getConnection(hostname, username, password);
            Statement stmt;
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);

            String tableName = "students";
            String newValues = "first_name='"+first_name+"', middle_name='"+middle_name+"', last_name='"+last_name+"', gender='"+gender+"', civil_status='"+civil_status+"'";
            
            stmt.executeUpdate("Update "+tableName+" set "+newValues+" where id_number = "+id_number);
            
            stmt.close();
            con.close();
        }

        catch(SQLException ex)
        {
           System.err.println("SQLException: " + ex.getMessage());
           return false;
        }

       return true;
    }
    
    /* delete entry */
    public boolean deleteStudent(int id_number)
    {
        String hostname = "jdbc:mysql://localhost/students";
        String username = "root";
        String password = "";

        try {
           Class.forName("com.mysql.jdbc.Driver");
        }

        catch(java.lang.ClassNotFoundException e) {
           System.err.print("ClassNotFoundException: " + e.getMessage());
        }

        try
        {
            Connection con = DriverManager.getConnection(hostname, username, password);
            Statement stmt;
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);

            String tableName = "students";
            
            stmt.executeUpdate("Delete from "+tableName+" where id_number = "+id_number);
            
            stmt.close();
            con.close();
        }

        catch(SQLException ex)
        {
           System.err.println("SQLException: " + ex.getMessage());
           return false;
        }

       return true;
    }
}
