package unittest;

import dao.BillDAO;
import junit.framework.Assert;
import model.Bill;
import org.junit.Test;

/**
 *
 * @author ducke
 */
public class TestBillDAO {
     BillDAO billDAO;
    public TestBillDAO() {
        billDAO = new BillDAO();
    }
    
    
    @Test
    public void searchBillById_testChuan1(){
        String billId = "111";
        Bill bill = billDAO.searchBillByID(billId);
        Assert.assertNotNull(bill);
        Assert.assertNotNull(bill.getCustomer());
        Assert.assertEquals(bill.getId(), billId);
    }
    
    @Test
    public void searchBillById_testNgoaiLe1(){
        String billId = "1111";
        Bill bill = billDAO.searchBillByID(billId);
        Assert.assertNotNull(bill);
        Assert.assertNull(bill.getCustomer());
        Assert.assertNull(bill.getId());
    }
}
