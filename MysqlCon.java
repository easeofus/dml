import java.sql.*;
class MysqlCon{
public static void main(String args[]){
try{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection(
"jdbc:mysql://localhost:3306/emp","root","");
Statement stmt=con.createStatement();

stmt.execute("create table emp22(name varchar(20),id int,m1 int)");
System.out.println("table created successfully");
stmt.executeUpdate("insert into emp22 values('Viswa',22,90)");
stmt.executeUpdate("insert into emp22 values('Rahim',25,99)");
stmt.executeUpdate("insert into emp22 values('Jackie',29,96)");
System.out.println("insert successfully");
ResultSet rs1=stmt.executeQuery("select * from emp22");
while(rs1.next())
System.out.println(rs1.getString(1)+""+rs1.getInt(2)+""+rs1.getInt(3));
PreparedStatement pstmt = con.prepareStatement("update emp22 set m1=? where id=?");
pstmt.setInt(1,96);
pstmt.setInt(2,101);
pstmt.execute();
System.out.println("update successfully");
ResultSet rs2=stmt.executeQuery("select * from emp22");
while(rs2.next())
System.out.println(rs2.getString(1)+""+rs2.getInt(2)+""+rs2.getInt(3));
stmt.executeUpdate("DELETE FROM emp22 WHERE id=29");
System.out.println("delete successfully");
ResultSet rs3=stmt.executeQuery("select * from emp22");
while(rs3.next())
System.out.println(rs3.getString(1)+""+rs3.getString(2)+""+rs3.getInt(3));
con.close();
}
catch(Exception e){System.out.println(e);
}
}
}