package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	public static Connection con;
	
	public DAO(){
		if(con == null){
                    String host="localhost";
                    String port="5432";
                    String dbname="GarageManagement";
                    String user="postgres";
                    String pass="";
                    String dburl = "jdbc:postgresql://"+host+":"+port+"/"+dbname+"?currentSchema=SCHEMA";
                    try {
                        Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection (dburl, user, pass);
                    }catch(Exception e) {
			e.printStackTrace();
                    }
		}
	}
}
