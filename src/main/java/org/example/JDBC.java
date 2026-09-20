package org.example;

import java.sql.*;

public class JDBC   {
    public static void main(String[] args) throws Exception {
        Connection conn= DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/demo",
                "postgres",
                "0000"
        );
        Statement st=conn.createStatement();

//        read operation
        ResultSet rs=st.executeQuery("SELECT * FROM STUDENT");
        while(rs.next()){
            System.out.print(rs.getString("name")+" - ");
            System.out.println(rs.getInt("marks"));
        }

//        create operation
//        int rowsEffected=st.executeUpdate("INSERT INTO STUDENT VALUES ('ramz',103,34)");
//        System.out.println(rowsEffected);

//        update operation
//        int rowsEffected=st.executeUpdate("UPDATE STUDENT SET name='ram' where id=103");
//        System.out.println(rowsEffected);

//        delete operation
//        int rowsEffected=st.executeUpdate("DELETE FROM STUDENT WHERE id=103");
//        System.out.println(rowsEffected);

//        ______________  prepared statements ____________
//        query passed at statement creation process not while execution
//        this adds extra features like cahcing and its also easy to inject data and safe to inject

        PreparedStatement pst= conn.prepareStatement("INSERT INTO STUDENT (id,name,marks) VALUES (?,?,?)");
        int id=120;
        String name="david";
        int marks=86;
        pst.setInt(1,id);
        pst.setString(2,name);
        pst.setInt(3,marks);
        int rowsEffected=pst.executeUpdate();
        System.out.println(rowsEffected);
    }
}
