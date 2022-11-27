/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unittest;

import dao.UserDAO;
import junit.framework.Assert;
import model.User;
import org.junit.Test;
/**
 *
 * @author ducke
 */
public class TestUserDAO {
    UserDAO userDAO;
    public TestUserDAO() {
        userDAO = new UserDAO();
    } 
    
    @Test
    public void checkLogin_testChuan1(){
        String username = "minhduc";
        String password = "minhduc";
        User user = new User(username, password);
        boolean isSuccess = userDAO.checkLogin(user);
        Assert.assertNotNull(isSuccess);
        Assert.assertEquals(isSuccess, true);      
    }
    @Test
    public void checkLogin_testNgoaiLe1(){
        String username = "minhduc1";
        String password = "minhduc";
        User user = new User(username, password);
        boolean isSuccess = userDAO.checkLogin(user);
        Assert.assertNotNull(isSuccess);
        Assert.assertEquals(isSuccess, false);
    }
    @Test
    public void checkLogin_testNgoaiLe2(){
        String username = "minhduc";
        String password = "minhduc1";
        User user = new User(username, password);
        boolean isSuccess = userDAO.checkLogin(user);
        Assert.assertNotNull(isSuccess);
        Assert.assertEquals(isSuccess, false);
    }
    @Test
    public void checkLogin_testNgoaiLe3(){
        String username = "minhduc1";
        String password = "minhduc1";
        User user = new User(username, password);
        boolean isSuccess = userDAO.checkLogin(user);
        Assert.assertNotNull(isSuccess);
        Assert.assertEquals(isSuccess, false);
    }
    
}
