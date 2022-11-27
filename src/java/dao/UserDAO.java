package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.User;

public class UserDAO extends DAO{
	
	public UserDAO() {
		super();
	}
	
	public boolean checkLogin(User user) {
		boolean result = false;
		String sql = "SELECT name, role FROM public.tbluser WHERE username = ? AND password = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
				result = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}              
		return result;
	}
        public User getUserByID(String id){
            User user = new User();
            String sql = "SELECT * FROM public.tbluser WHERE id = ?";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, id);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    user.setId(id);
                    user.setAddress(rs.getString("address"));
                    user.setRole(rs.getString("role"));
                    user.setName(rs.getString("name"));
                }
            } catch (Exception e) {
            }
            return user;
        }
}
