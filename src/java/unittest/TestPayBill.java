/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unittest;

import dao.BillDAO;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author ducke
 */
public class TestPayBill {
    BillDAO billDAO;

    public TestPayBill() {
        billDAO = new BillDAO();
    }
    @Test
    public void testThanhToan_testCHuan1(){
        String billID = "111";
        boolean isSuccess = billDAO.changePaidStatus(billID, true);
        Assert.assertNotNull(isSuccess);
        Assert.assertEquals(isSuccess,true);
    }
    @Test
    public void testThanhToan_testNgoaiLe1(){
        String billID = "1111";
        boolean isSuccess = billDAO.changePaidStatus(billID, true);
        Assert.assertNotNull(isSuccess);
        Assert.assertEquals(isSuccess,false);
    }
    
}
