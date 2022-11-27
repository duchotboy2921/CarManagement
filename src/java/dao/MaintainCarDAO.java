/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Component;
import model.MaintainCar;
import model.PurchasedComponent;
import model.PurchasedService;
import model.Service;

/**
 *
 * @author ducke
 */
public class MaintainCarDAO extends DAO{
    private UserDAO userDAO;
    private CarDAO carDAO;
    private SlotDAO slotDAO;
    private CustomerDAO customerDAO;
    private ServiceDAO serviceDAO;
    private ComponentDAO componentDAO;
    public MaintainCarDAO() {
        super();
        userDAO = new UserDAO();
        carDAO = new CarDAO();
        slotDAO = new SlotDAO();
        customerDAO = new CustomerDAO();
        serviceDAO = new ServiceDAO();
        componentDAO = new ComponentDAO();
    }
    public MaintainCar getMainTainCarByID(String id){
        MaintainCar maintainCar = new MaintainCar();
        String sql = "SELECT * FROM public.tblmaintaincar WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                maintainCar.setId(id);
                maintainCar.setCar(carDAO.getCarByID(rs.getString("carid")));
                maintainCar.setSlot(slotDAO.getSlotByID(rs.getString("slotid")));
                maintainCar.setTechnician(userDAO.getUserByID(rs.getString("technician")));
                maintainCar.setNote(rs.getString("note"));
            }
            //get list purchasedService
            List<PurchasedService> listPurchasedServices = new ArrayList<>();
            String sqlService = "SELECT * FROM public.tblpurchasedservice WHERE maintaincarid = ?";
            ps = con.prepareStatement(sqlService);
            ps.setString(1, id);
            ResultSet rsService = ps.executeQuery();
            while(rsService.next()){
                int amount = rsService.getInt("amount");
                float price = rsService.getFloat("price");               
                Service service = serviceDAO.getServiceByID(rsService.getString("serviceid"));
                listPurchasedServices.add(new PurchasedService(service, amount, price));
            }
            maintainCar.setListPurchasedServices(listPurchasedServices);
            //get list purchasedCOmponent
            List<PurchasedComponent> listPurchasedComponents = new ArrayList<>();
            String sqlComponent = "SELECT * FROM public.tblpurchasedcomponent WHERE maintaincarid = ?";
            ps = con.prepareStatement(sqlComponent);
            ps.setString(1, id);
            ResultSet rsComponent = ps.executeQuery();
            while(rsComponent.next()){
                int amount = rsComponent.getInt("amount");
                float price = rsComponent.getFloat("price");
                Component component = componentDAO.getComponentByID(rsComponent.getString("componentid"));
                listPurchasedComponents.add(new PurchasedComponent(component, amount, price));
            }
            maintainCar.setListPurchasedComponents(listPurchasedComponents);
        } catch (Exception e) {
            System.out.println(e);
        }
        return maintainCar;
    }
    
}
