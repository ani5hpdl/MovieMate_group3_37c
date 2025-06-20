/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Doa.UsermngmtDao;
import Model.UserMngmt;
import java.awt.event.MouseAdapter;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import java.awt.event.MouseEvent;

import view.AdminUserr;

/**
 *
 * @author anish
 */
public final class UserMngmtController {
    private final UsermngmtDao userDao;
    private AdminUserr view;
    
    public UserMngmtController(AdminUserr view){
    this.userDao = new UsermngmtDao();
    this.view = view;
    loadUsersTotable();
    }
    
    public void open(){
        this.view.setVisible(true);
    }
    
    public void close(){
        this.view.dispose();
    }
    
    public void loadUsersTotable(){
        List<UserMngmt> users = userDao.getAllusers();
        
        Object[][] data = new Object[users.size()][8];
        
        for(int i =0; i<users.size() ; i++){
            UserMngmt u = users.get(i);
            data[i][0]=i+1;
            data[i][1]=u.getName();
            data[i][2] = u.getDate();
            data[i][3]=u.getRole();
            data[i][4]=u.getEmail();
            data[i][5]=u.getAddress();
            data[i][6]=u.getContactNumber();
            data[i][7]="Delete";
        }
        
        view.setUserTableData(data);
        addDeleteAction(users);
    }


    private void addDeleteAction(List<UserMngmt> users) {
        
    JTable table = view.getUserTable(); // Get table from view

    table.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent evt) {
            int row = table.rowAtPoint(evt.getPoint());
            int col = table.columnAtPoint(evt.getPoint());

            if (col == 7) { // Action column (Delete)
                int confirm = JOptionPane.showConfirmDialog(null,
                        "Do you want to delete this user?",
                        "Confirm Delete", JOptionPane.OK_CANCEL_OPTION);

                if (confirm == JOptionPane.OK_OPTION) {
                    UserMngmt userToDelete = users.get(row);
                    userDao.deleteUser(userToDelete.getId()); // Make sure this method exists
                    loadUsersTotable(); // Refresh table
                }
            }
        }
    });
}

    
    
    
}
