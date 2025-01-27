package banking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Database {
	String user="root",password="2024",url="jdbc:mysql://localhost:3306/Test",logQuery,regQuery;
	private Database() {
	}
	private static volatile Database instance;
	
	public static Database getInstance() {
		if(instance==null) {
			synchronized(Database.class) {
				if(instance==null) {
					instance=new Database();
				}
			}
		}
		return instance;
	}
	private void initiate(String name,String pass,String option) {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,user,password);
			if(option=="register") {
			regQuery="INSERT INTO register(name,password) VALUES(?,SHA2(?,256))";
			String checkUser="SELECT name FROM register where name=?";
			PreparedStatement check= con.prepareStatement(checkUser);
			check.setString(1,name);
			ResultSet r = check.executeQuery();
			if(r.next()) {
				System.out.println("User already exists");
			}
			PreparedStatement reg = con.prepareStatement(regQuery);
			reg.setString(1,name);
			reg.setString(2,pass);
			if(reg.executeUpdate()>0) {
			System.out.println("Register successful!");
			}
			else {
				System.out.println("Register unsuccessful!");
			}}
			
			else {
				logQuery="SELECT password FROM register WHERE name=? AND password=SHA2(?,256)";
				PreparedStatement log =con.prepareStatement(logQuery);
				log.setString(1, name);
				log.setString(2, pass);
				ResultSet result=log.executeQuery();
				if(result.next()) {
					System.out.println("Welcome back "+name);
				}
				else {
					System.out.println("Invalid name or password");
				}
				
			}
	}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
	public void getInitiation(String name,String pass,String option) {
		initiate(name,pass,option);
	}
}
