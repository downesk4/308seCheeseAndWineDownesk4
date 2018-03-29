//Kieran downes 6406875

package guisql;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FiercePC
 */
public class ControlWindow extends javax.swing.JFrame {

    /**
     * Creates new form ControlWindow
     */
    public ControlWindow() {
        initComponents();
        Show_cheeseList_in_JTable();
        Show_boardList_in_JTable();
        Show_linkList_in_JTable();
    }

    int pos = 0;  //cheese
    int pos1 = 0; //cheeseboard
    int pos2 = 0; //linktable
    
    
     
    public Connection getConnection()  //cheese is the database not the table - put in class
    {
        Connection con = null;
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/cheese", "root", "");
           //JOptionPane.showMessageDialog(null, "connected");  //check its connected
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(ControlWindow.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "cheese Not connected");  //check its connected
            return null;
        }
    }
    // Check input Fields
    
    public boolean checkInputs()     //just trying to make sure that we get at least 1 input like a name to a new record
    {
        if(        
                   txt_name.getText() == null 
                || txt_price.getText() == null)
        {
        return false;    
        }
        else
        {
            try
            {
                Float.parseFloat(txt_price.getText());
                return true;
            }
            catch(Exception ex)
            {
                return false;
            }
            
        }
    }
    
    
    
    //fill array with data
    public ArrayList<linktablemain> getTableList() //linktable
    {
            ArrayList<linktablemain> linkList = new ArrayList<linktablemain>();
            Connection con = getConnection();
            String query = "SELECT * FROM cheeseboardrow";
            
            Statement state;
            ResultSet result;
        try {
            
            state = con.createStatement();
            result = state.executeQuery(query);
            linktablemain cheeseboardrow; 
            
            while(result.next())
               {
                cheeseboardrow = new linktablemain(result.getInt("rowid"),result.getInt("boardid"),result.getInt("cheeseid"),result.getInt("quantity"),Float.parseFloat(result.getString("cost")));                
                linkList.add(cheeseboardrow);                
               }
            
            } 
        catch (SQLException ex) 
            {
            Logger.getLogger(ControlWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return linkList;
    }
    
    public void Show_linkList_in_JTable()  //linktable
    {
        
        ArrayList<linktablemain> list = getTableList();
        DefaultTableModel model = (DefaultTableModel)JTable_linktable.getModel();
        
        
        model.setRowCount(0);  //clear JTable
        Object[] row = new Object[5];
        for(int i = 0; i < list.size(); i++)
        {
           row[0] = list.get(i).getRowid(); 
           row[1] = list.get(i).getRowboardid(); 
           row[2] = list.get(i).getRowcheeseid();  
           row[3] = list.get(i).getRowquantitys();  
           row[4] = list.get(i).getRowcost();
           model.addRow(row);
        }
    }
    
    
    public ArrayList<cheeseboardmain> getcheeseBoardList() //cheesesboad
    {
            ArrayList<cheeseboardmain> boardList = new ArrayList<cheeseboardmain>();
            Connection con = getConnection();
            String query = "SELECT * FROM cheeseboard";
            
            Statement state;
            ResultSet result;
        try {
            
            state = con.createStatement();
            result = state.executeQuery(query);
            cheeseboardmain cheeseboard; 
            
            while(result.next())
               {
                cheeseboard = new cheeseboardmain(result.getInt("id"),result.getString("name"),Float.parseFloat(result.getString("cost")),result.getString("status"),result.getString("cheeses"));                
                boardList.add(cheeseboard);                
               }
            
            } 
        catch (SQLException ex) 
            {
            Logger.getLogger(ControlWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return boardList;
    }
    
    
    
    //show in table
    public void Show_boardList_in_JTable()  //cheeseboard
    {
        
        ArrayList<cheeseboardmain> list = getcheeseBoardList();
        DefaultTableModel model = (DefaultTableModel)JTable_cheeseboard.getModel();
        
        
        model.setRowCount(0);  //clear JTable
        Object[] row = new Object[5];
        for(int i = 0; i < list.size(); i++)
        {
           row[0] = list.get(i).getBoardid(); 
           row[1] = list.get(i).getBoardname(); 
           row[2] = list.get(i).getBoardcost();  
           row[3] = list.get(i).getBoardstatus();  
           row[4] = list.get(i).getBoardcheeses();
           model.addRow(row);
        }
    }
    
    //fill array with data
    
    public ArrayList<cheesemain> getCheeseList() //cheeses
    {
            ArrayList<cheesemain> cheeseList = new ArrayList<cheesemain>();
            Connection con = getConnection();
            String query = "SELECT * FROM cheese";
            
            Statement state;
            ResultSet result;
        try {
            
            state = con.createStatement();
            result = state.executeQuery(query);
            cheesemain cheese; 
            
            while(result.next())
               {
                cheese = new cheesemain(result.getInt("id"),result.getString("name"),Float.parseFloat(result.getString("price")),result.getString("style"),result.getString("supplier"),result.getString("origin"),result.getString("milk"),result.getInt("age"),result.getInt("strength"),result.getString("rating"),Float.parseFloat(result.getString("stock")),result.getString("info"));                
                cheeseList.add(cheese);                
               }
            
            } 
        catch (SQLException ex) 
            {
            Logger.getLogger(ControlWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return cheeseList;
    }
    
    //fill the table
    
    public void Show_cheeseList_in_JTable()  //cheeses
    {
        
        ArrayList<cheesemain> list = getCheeseList();
        DefaultTableModel model = (DefaultTableModel)JTable_cheese.getModel();
        
        
        model.setRowCount(0);  //clear JTable
        Object[] row = new Object[12];
        for(int i = 0; i < list.size(); i++)
        {
           row[0] = list.get(i).getid(); 
           row[1] = list.get(i).getName(); 
           row[2] = list.get(i).getPrice();   
           row[3] = list.get(i).getStyle();
           row[4] = list.get(i).getSupplier();
           row[5] = list.get(i).getOrigin();
           row[6] = list.get(i).getMilk();
           row[7] = list.get(i).getAge();
           row[8] = list.get(i).getStrength();
           row[9] = list.get(i).getRating();
           row[10] = list.get(i).getStock();
           row[11] = list.get(i).getInfo();
           
           model.addRow(row);
        }
    }
            
    public void ShowItem(int index) //cheese-to show in textfilds to prevent re typing
    {
        
         txt_id.setText(Integer.toString(getCheeseList().get(index).getid()));
         txt_name.setText(getCheeseList().get(index).getName());
         txt_price.setText(Float.toString(getCheeseList().get(index).getPrice()));
         txt_style.setText(getCheeseList().get(index).getStyle());
         txt_supplier.setText(getCheeseList().get(index).getSupplier());
         txt_origin.setText(getCheeseList().get(index).getOrigin());
         txt_milk.setText(getCheeseList().get(index).getMilk());
         txt_age.setText(Integer.toString(getCheeseList().get(index).getAge()));
         txt_strength.setText(Integer.toString(getCheeseList().get(index).getStrength()));
         txt_rating.setText(getCheeseList().get(index).getRating());
         txt_stock.setText(Float.toString(getCheeseList().get(index).getStock()));
         txt_info.setText(getCheeseList().get(index).getInfo());  
    }
    
    public void ShowBoardItem(int index) //cheeseboard -- need to put in a class
    {
        txt_idboard.setText(Integer.toString(getcheeseBoardList().get(index).getBoardid()));
        txt_nameboard.setText(getcheeseBoardList().get(index).getBoardname());
        txt_costboard.setText(Float.toString(getcheeseBoardList().get(index).getBoardcost()));
        txt_statusboard.setText(getcheeseBoardList().get(index).getBoardstatus());
        txt_cheesesboard.setText(getcheeseBoardList().get(index).getBoardcheeses());
    }
    
    public void ShowLinkItem(int index) //linktable -- need to put in a class
    {
        txt_rowid.setText(Integer.toString(getTableList().get(index).getRowid()));
        txt_boardid.setText(Integer.toString(getTableList().get(index).getRowboardid()));
        txt_cheeseid.setText(Integer.toString(getTableList().get(index).getRowcheeseid()));
        txt_quantity.setText(Integer.toString(getTableList().get(index).getRowquantitys()));
        txt_rowcost.setText(Float.toString(getTableList().get(index).getRowcost()));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        txt_price = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable_cheese = new javax.swing.JTable();
        Btn_Insert = new javax.swing.JButton();
        Btn_Update = new javax.swing.JButton();
        Btn_Delete = new javax.swing.JButton();
        Btn_First = new javax.swing.JButton();
        Btn_Next = new javax.swing.JButton();
        Btn_Previous = new javax.swing.JButton();
        Btn_Last = new javax.swing.JButton();
        txt_style = new javax.swing.JTextField();
        txt_supplier = new javax.swing.JTextField();
        txt_origin = new javax.swing.JTextField();
        txt_milk = new javax.swing.JTextField();
        txt_age = new javax.swing.JTextField();
        txt_strength = new javax.swing.JTextField();
        txt_rating = new javax.swing.JTextField();
        txt_stock = new javax.swing.JTextField();
        txt_info = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_statusboard = new javax.swing.JTextField();
        txt_costboard = new javax.swing.JTextField();
        txt_nameboard = new javax.swing.JTextField();
        txt_idboard = new javax.swing.JTextField();
        Btn_Add = new javax.swing.JButton();
        Btn_Update1 = new javax.swing.JButton();
        Btn_Delete1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTable_cheeseboard = new javax.swing.JTable();
        Btn_First1 = new javax.swing.JButton();
        Btn_Previous1 = new javax.swing.JButton();
        Btn_Next1 = new javax.swing.JButton();
        Btn_Last1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txt_cheesesboard = new javax.swing.JTextField();
        txt_rowcost = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_quantity = new javax.swing.JTextField();
        txt_cheeseid = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_boardid = new javax.swing.JTextField();
        txt_rowid = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTable_linktable = new javax.swing.JTable();
        Btn_Add1 = new javax.swing.JButton();
        Btn_Update2 = new javax.swing.JButton();
        Btn_Delete2 = new javax.swing.JButton();
        Btn_First2 = new javax.swing.JButton();
        Btn_Previous2 = new javax.swing.JButton();
        Btn_Next2 = new javax.swing.JButton();
        Btn_Last2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setText("ID:");

        jLabel2.setText("Name:");

        jLabel3.setText("Price:");

        txt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameActionPerformed(evt);
            }
        });

        txt_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_priceActionPerformed(evt);
            }
        });

        JTable_cheese.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price(PKG)", "Style", "Supplier", "Origin", "Milk Tpe", "Age", "Strength", "Rating", "Stock (KG)", "Info"
            }
        ));
        JTable_cheese.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTable_cheeseMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTable_cheese);

        Btn_Insert.setText("Add");
        Btn_Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_InsertActionPerformed(evt);
            }
        });

        Btn_Update.setText("Update");
        Btn_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_UpdateActionPerformed(evt);
            }
        });

        Btn_Delete.setText("Delete");
        Btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_DeleteActionPerformed(evt);
            }
        });

        Btn_First.setText("First");
        Btn_First.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_FirstActionPerformed(evt);
            }
        });

        Btn_Next.setText("Next");
        Btn_Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_NextActionPerformed(evt);
            }
        });

        Btn_Previous.setText("Previous");
        Btn_Previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_PreviousActionPerformed(evt);
            }
        });

        Btn_Last.setText("Last");
        Btn_Last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_LastActionPerformed(evt);
            }
        });

        txt_origin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_originActionPerformed(evt);
            }
        });

        jLabel4.setText("Style:");

        jLabel5.setText("Supplier:");

        jLabel6.setText("Origin:");

        jLabel7.setText("Milk:");

        jLabel8.setText("Age:");

        jLabel9.setText("Strength:");

        jLabel10.setText("Rating:");

        jLabel11.setText("Stock:");

        jLabel12.setText("Info:");

        jLabel13.setText("ID:");

        jLabel14.setText("Name:");

        jLabel15.setText("Cost:");

        jLabel16.setText("Status:");

        txt_costboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_costboardActionPerformed(evt);
            }
        });

        txt_nameboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameboardActionPerformed(evt);
            }
        });

        Btn_Add.setText("Add");
        Btn_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AddActionPerformed(evt);
            }
        });

        Btn_Update1.setText("Update");
        Btn_Update1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Update1ActionPerformed(evt);
            }
        });

        Btn_Delete1.setText("Delete");
        Btn_Delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Delete1ActionPerformed(evt);
            }
        });

        JTable_cheeseboard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Cost", "Status", "Cheeses"
            }
        ));
        JTable_cheeseboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTable_cheeseboardMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JTable_cheeseboard);

        Btn_First1.setText("First");
        Btn_First1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_First1ActionPerformed(evt);
            }
        });

        Btn_Previous1.setText("Previous");
        Btn_Previous1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Previous1ActionPerformed(evt);
            }
        });

        Btn_Next1.setText("Next");
        Btn_Next1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Next1ActionPerformed(evt);
            }
        });

        Btn_Last1.setText("Last");
        Btn_Last1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Last1ActionPerformed(evt);
            }
        });

        jLabel17.setText("Cheeses:");

        jLabel18.setText("Cost:");

        jLabel19.setText("Quantity:");

        txt_cheeseid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cheeseidActionPerformed(evt);
            }
        });

        jLabel20.setText("CheeseID:");

        jLabel21.setText("BoardID:");

        txt_boardid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_boardidActionPerformed(evt);
            }
        });

        jLabel22.setText("RowID:");

        JTable_linktable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RowID", "BoardID", "CheeseID", "Quantity(KG)", "Cost(£)"
            }
        ));
        JTable_linktable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTable_linktableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(JTable_linktable);

        Btn_Add1.setText("Add");
        Btn_Add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Add1ActionPerformed(evt);
            }
        });

        Btn_Update2.setText("Update");
        Btn_Update2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Update2ActionPerformed(evt);
            }
        });

        Btn_Delete2.setText("Delete");
        Btn_Delete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Delete2ActionPerformed(evt);
            }
        });

        Btn_First2.setText("First");
        Btn_First2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_First2ActionPerformed(evt);
            }
        });

        Btn_Previous2.setText("Previous");
        Btn_Previous2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Previous2ActionPerformed(evt);
            }
        });

        Btn_Next2.setText("Next");
        Btn_Next2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Next2ActionPerformed(evt);
            }
        });

        Btn_Last2.setText("Last");
        Btn_Last2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Last2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))
                                        .addGap(6, 6, 6))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)))
                                .addComponent(txt_info, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_stock, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_supplier, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                    .addComponent(txt_origin)
                                    .addComponent(txt_milk)
                                    .addComponent(txt_strength)
                                    .addComponent(txt_rating)
                                    .addComponent(txt_age))))
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(65, 65, 65)
                                                .addComponent(Btn_Update1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Btn_Delete1))
                                            .addComponent(Btn_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(29, 29, 29))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel16)
                                                    .addComponent(jLabel14)
                                                    .addComponent(jLabel13)
                                                    .addComponent(jLabel15))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txt_nameboard, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txt_idboard, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txt_costboard, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txt_statusboard, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel17)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txt_cheesesboard, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                            .addGap(77, 77, 77)
                                                            .addComponent(jLabel22))
                                                        .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addGap(61, 61, 61)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txt_boardid, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txt_rowid, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txt_cheeseid, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txt_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txt_rowcost, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(31, 31, 31)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(92, 92, 92)
                                        .addComponent(Btn_First1)
                                        .addGap(18, 18, 18)
                                        .addComponent(Btn_Previous1)
                                        .addGap(18, 18, 18)
                                        .addComponent(Btn_Next1)
                                        .addGap(18, 18, 18)
                                        .addComponent(Btn_Last1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(65, 65, 65)
                                                .addComponent(Btn_Update2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Btn_Delete2))
                                            .addComponent(Btn_Add1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(72, 72, 72)
                                        .addComponent(Btn_First2)
                                        .addGap(18, 18, 18)
                                        .addComponent(Btn_Previous2)
                                        .addGap(18, 18, 18)
                                        .addComponent(Btn_Next2)
                                        .addGap(18, 18, 18)
                                        .addComponent(Btn_Last2)
                                        .addGap(49, 49, 49))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addComponent(jLabel1))
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_style, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Btn_Insert, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Btn_Update)
                                        .addGap(18, 18, 18)
                                        .addComponent(Btn_Delete)
                                        .addGap(441, 441, 441)
                                        .addComponent(Btn_First)
                                        .addGap(18, 18, 18)
                                        .addComponent(Btn_Previous)
                                        .addGap(18, 18, 18)
                                        .addComponent(Btn_Next)
                                        .addGap(18, 18, 18)
                                        .addComponent(Btn_Last)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_style, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_origin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_milk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_strength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_rating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_info, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_Insert)
                    .addComponent(Btn_Update)
                    .addComponent(Btn_Delete)
                    .addComponent(Btn_Next)
                    .addComponent(Btn_First)
                    .addComponent(Btn_Previous)
                    .addComponent(Btn_Last))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_idboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_nameboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_costboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_statusboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_cheesesboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_rowid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_boardid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cheeseid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_rowcost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Btn_Add1)
                        .addComponent(Btn_Update2)
                        .addComponent(Btn_Delete2)
                        .addComponent(Btn_Next2)
                        .addComponent(Btn_First2)
                        .addComponent(Btn_Previous2)
                        .addComponent(Btn_Last2))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Btn_Add)
                        .addComponent(Btn_Update1)
                        .addComponent(Btn_Delete1)
                        .addComponent(Btn_Next1)
                        .addComponent(Btn_First1)
                        .addComponent(Btn_Previous1)
                        .addComponent(Btn_Last1)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_boardidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_boardidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_boardidActionPerformed

    private void txt_cheeseidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cheeseidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cheeseidActionPerformed

    private void Btn_Last1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Last1ActionPerformed
        // TODO add your handling code here:
        //cheeseboard
        pos1 = getcheeseBoardList().size()-1;
        ShowBoardItem(pos1);
    }//GEN-LAST:event_Btn_Last1ActionPerformed

    private void Btn_Next1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Next1ActionPerformed
        // TODO add your handling code here:
        //cheeseboard
        pos1++;

        if(pos1 >= getcheeseBoardList().size())
        {
            pos1 = getcheeseBoardList().size()-1;
        }
        ShowBoardItem(pos1);
    }//GEN-LAST:event_Btn_Next1ActionPerformed

    private void Btn_Previous1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Previous1ActionPerformed
        // TODO add your handling code here:
        //cheseeboard
        pos1--;

        if(pos1 < 0)
        {
            pos1 = 0;
        }
        ShowBoardItem(pos1);
    }//GEN-LAST:event_Btn_Previous1ActionPerformed

    private void Btn_First1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_First1ActionPerformed
        // TODO add your handling code here:
        //cheeseboard
        pos1 = 0;
        ShowBoardItem(pos1);
    }//GEN-LAST:event_Btn_First1ActionPerformed

    private void JTable_cheeseboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTable_cheeseboardMouseClicked
        // TODO add your handling code here:
        //cheeseboard
        int index = JTable_cheeseboard.getSelectedRow();
        ShowBoardItem(index);
    }//GEN-LAST:event_JTable_cheeseboardMouseClicked

    private void Btn_Delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Delete1ActionPerformed
        //cheeseboard    // TODO add your handling code here:
        if(!txt_idboard.getText().equals(""))
        {
            try {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("DELETE FROM cheeseboard WHERE id = ?");
                int id = Integer.parseInt(txt_idboard.getText());
                ps.setInt(1, id);
                ps.executeUpdate();
                Show_boardList_in_JTable(); //refresh the jtable
                JOptionPane.showMessageDialog(null, "Cheeseboard Deleted");
            }

            catch (SQLException ex)
            {
                Logger.getLogger(ControlWindow.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Cheeseboard Could Not Be Deleted");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Enter Cheeseboard ID to Delete the Cheeseboard"); //cant delete somthing that doesnt have an id
        }

    }//GEN-LAST:event_Btn_Delete1ActionPerformed

    private void Btn_Update1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Update1ActionPerformed
        //cheeseboard  // TODO add your handling code here:
        String UpdateQuery = null;
        PreparedStatement ps = null;
        Connection con = getConnection();

        try
        {
            UpdateQuery = "UPDATE cheeseboard SET name = ?, cost = ?, status = ?, cheeses = ? WHERE id = ?";
            ps = con.prepareStatement(UpdateQuery);

            ps.setString(1, txt_nameboard.getText());
            ps.setString(2, txt_costboard.getText());
            ps.setString(3, txt_statusboard.getText());
            ps.setString(4, txt_cheesesboard.getText());
            ps.setInt(5, Integer.parseInt(txt_idboard.getText()));

            ps.executeUpdate();
            Show_boardList_in_JTable();
            JOptionPane.showMessageDialog(null, "cheeseboard Updated");
        }
        catch (SQLException ex)
        {
            Logger.getLogger(ControlWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Btn_Update1ActionPerformed

    private void Btn_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AddActionPerformed
        //cheaseboard
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO cheeseboard(name,cost,status,cheeses)"  //"cheeseboard in this instance is the table name
                + "values(?,?,?,?)");
            ps.setString(1, txt_nameboard.getText());
            ps.setString(2, txt_costboard.getText());
            ps.setString(3, txt_statusboard.getText());
            ps.setString(4, txt_cheesesboard.getText());

            ps.executeUpdate();
            Show_boardList_in_JTable();

        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_AddActionPerformed

    private void txt_nameboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameboardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nameboardActionPerformed

    private void txt_costboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_costboardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_costboardActionPerformed

    private void txt_originActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_originActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_originActionPerformed

    private void Btn_LastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_LastActionPerformed
        // TODO add your handling code here:
        pos = getCheeseList().size()-1;
        ShowItem(pos);
    }//GEN-LAST:event_Btn_LastActionPerformed

    private void Btn_PreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_PreviousActionPerformed
        // TODO add your handling code here:
        pos--;

        if(pos < 0)
        {
            pos = 0;
        }

        ShowItem(pos);
    }//GEN-LAST:event_Btn_PreviousActionPerformed

    private void Btn_NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_NextActionPerformed
        // TODO add your handling code here:
        pos++;

        if(pos >= getCheeseList().size())
        {
            pos = getCheeseList().size()-1;
        }
        ShowItem(pos);
    }//GEN-LAST:event_Btn_NextActionPerformed

    private void Btn_FirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_FirstActionPerformed
        // TODO add your handling code here:
        pos = 0;
        ShowItem(pos);

    }//GEN-LAST:event_Btn_FirstActionPerformed

    private void Btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_DeleteActionPerformed
        // TODO add your handling code here:
        if(!txt_id.getText().equals(""))
        {
            try {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("DELETE FROM cheese WHERE id = ?");
                int id = Integer.parseInt(txt_id.getText());
                ps.setInt(1, id);
                ps.executeUpdate();
                Show_cheeseList_in_JTable(); //refresh the jtable
                JOptionPane.showMessageDialog(null, "Cheese Deleted");
            }

            catch (SQLException ex)
            {
                Logger.getLogger(ControlWindow.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Cheese Could Not Be Deleted");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Enter Cheese ID to Delete the Cheese"); //cant delete somthing that doesnt have an id
        }
    }//GEN-LAST:event_Btn_DeleteActionPerformed

    private void Btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_UpdateActionPerformed
        // TODO add your handling code here:
        if(checkInputs() && txt_id.getText() != null )
        {
            System.out.println("name = " + txt_name.getText()); //debug
            System.out.println("price = " + txt_price.getText()); //debug
            System.out.println("id = " + txt_id.getText()); //debug

            String UpdateQuery = null;
            PreparedStatement ps = null;
            Connection con = getConnection();

            try
            {
                UpdateQuery = "UPDATE cheese SET name = ?, price = ?, style = ?, supplier = ?, origin = ?, milk = ?, age = ?, strength = ?, rating = ?, stock = ?, info = ? WHERE id = ?";
                ps = con.prepareStatement(UpdateQuery);

                ps.setString(1, txt_name.getText());
                ps.setString(2, txt_price.getText());
                ps.setString(3, txt_style.getText());
                ps.setString(4, txt_supplier.getText());
                ps.setString(5, txt_origin.getText());
                ps.setString(6, txt_milk.getText());
                ps.setString(7, txt_age.getText());
                ps.setString(8, txt_strength.getText());
                ps.setString(9, txt_rating.getText());
                ps.setString(10,txt_stock.getText());
                ps.setString(11,txt_info.getText());

                ps.setInt(12, Integer.parseInt(txt_id.getText()));

                ps.executeUpdate();
                Show_cheeseList_in_JTable();
                JOptionPane.showMessageDialog(null, "cheese Updated");
            }
            catch (SQLException ex)
            {
                Logger.getLogger(ControlWindow.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        else
        {
            JOptionPane.showMessageDialog(null, "field empty or wrong!");
        }

        System.out.println("name = " + txt_name.getText()); //debug
        System.out.println("price = " + txt_price.getText()); //debug
        System.out.println("id = " + txt_id.getText()); //debug
    }//GEN-LAST:event_Btn_UpdateActionPerformed

    private void Btn_InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_InsertActionPerformed
        // TODO add your handling code here:
        if(checkInputs() != false)
        {
            try {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO cheese(name,price,style,supplier,origin,milk,age,strength,rating,stock,info)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1, txt_name.getText());
                ps.setString(2, txt_price.getText());
                ps.setString(3, txt_style.getText());
                ps.setString(4, txt_supplier.getText());
                ps.setString(5, txt_origin.getText());
                ps.setString(6, txt_milk.getText());
                ps.setString(7, txt_age.getText());
                ps.setString(8, txt_strength.getText());
                ps.setString(9, txt_rating.getText());
                ps.setString(10, txt_stock.getText());
                ps.setString(11, txt_info.getText());

                ps.executeUpdate();
                Show_cheeseList_in_JTable();

            }
            catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "one or more fields empty!");
        }
        System.out.println("name = " + txt_name.getText());
        System.out.println("price = " + txt_price.getText());
    }//GEN-LAST:event_Btn_InsertActionPerformed

    private void JTable_cheeseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTable_cheeseMouseClicked
        // TODO add your handling code here:
        int index = JTable_cheese.getSelectedRow();
        ShowItem(index);

    }//GEN-LAST:event_JTable_cheeseMouseClicked

    private void txt_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_priceActionPerformed

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nameActionPerformed

    private void JTable_linktableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTable_linktableMouseClicked
        // TODO add your handling code here:
        //linktable
        int index = JTable_linktable.getSelectedRow();
        ShowLinkItem(index);
    }//GEN-LAST:event_JTable_linktableMouseClicked

    private void Btn_Add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Add1ActionPerformed
        // TODO add your handling code here:
        //linkttable
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO cheeseboardrow(boardid,cheeseid,quantity,cost)"  //"cheeseboard in this instance is the table name
                + "values(?,?,?,?)");
            ps.setString(1, txt_boardid.getText());
            ps.setString(2, txt_cheeseid.getText());
            ps.setString(3, txt_quantity.getText());
            ps.setString(4, txt_rowcost.getText());

            ps.executeUpdate();
            Show_linkList_in_JTable();

        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_Btn_Add1ActionPerformed

    private void Btn_Update2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Update2ActionPerformed
        // TODO add your handling code here:
        //linktable
        String UpdateQuery = null;
        PreparedStatement ps = null;
        Connection con = getConnection();

        try
        {
            UpdateQuery = "UPDATE cheeseboardrow SET boardid = ?, cheeseid = ?, quantity = ?, cost = ? WHERE rowid = ?";
            ps = con.prepareStatement(UpdateQuery);

            ps.setString(1, txt_boardid.getText());
            ps.setString(2, txt_cheeseid.getText());
            ps.setString(3, txt_quantity.getText());
            ps.setString(4, txt_rowcost.getText());
            ps.setInt(5, Integer.parseInt(txt_rowid.getText()));

            ps.executeUpdate();
            Show_linkList_in_JTable();
            JOptionPane.showMessageDialog(null, "cheeseboardrow Updated");
        }
        catch (SQLException ex)
        {
            Logger.getLogger(ControlWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Btn_Update2ActionPerformed

    private void Btn_Delete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Delete2ActionPerformed
        // TODO add your handling code here:
        //linktable
        if(!txt_rowid.getText().equals(""))
        {
            try {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("DELETE FROM cheeseboardrow WHERE rowid = ?");
                int id = Integer.parseInt(txt_rowid.getText());
                ps.setInt(1, id);
                ps.executeUpdate();
                Show_linkList_in_JTable(); //refresh the jtable
                JOptionPane.showMessageDialog(null, "cheseeboard/cheese Link Deleted");
            }

            catch (SQLException ex)
            {
                Logger.getLogger(ControlWindow.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "cheseeboard/cheese Link Could Not Be Deleted");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Enter Row ID to Delete the cheseeboard/cheese Link"); //cant delete somthing that doesnt have an id
        }
    }//GEN-LAST:event_Btn_Delete2ActionPerformed

    private void Btn_First2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_First2ActionPerformed
        // TODO add your handling code here:
        //linktable
        pos2 = 0;
        ShowLinkItem(pos1);
    }//GEN-LAST:event_Btn_First2ActionPerformed

    private void Btn_Previous2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Previous2ActionPerformed
        // TODO add your handling code here:
        //linktable
        pos2--;

        if(pos2 < 0)
        {
            pos2 = 0;
        }

        ShowLinkItem(pos2);
    }//GEN-LAST:event_Btn_Previous2ActionPerformed

    private void Btn_Next2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Next2ActionPerformed
        // TODO add your handling code here:
        //linktable
        pos2++;

        if(pos2 >= getTableList().size())
        {
            pos2 = getTableList().size()-1;
        }
        ShowLinkItem(pos2);
    }//GEN-LAST:event_Btn_Next2ActionPerformed

    private void Btn_Last2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Last2ActionPerformed
        // TODO add your handling code here:
        //linktable
        pos2 = getTableList().size()-1;
        ShowLinkItem(pos2);
    }//GEN-LAST:event_Btn_Last2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ControlWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControlWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControlWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControlWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControlWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Add;
    private javax.swing.JButton Btn_Add1;
    private javax.swing.JButton Btn_Delete;
    private javax.swing.JButton Btn_Delete1;
    private javax.swing.JButton Btn_Delete2;
    private javax.swing.JButton Btn_First;
    private javax.swing.JButton Btn_First1;
    private javax.swing.JButton Btn_First2;
    private javax.swing.JButton Btn_Insert;
    private javax.swing.JButton Btn_Last;
    private javax.swing.JButton Btn_Last1;
    private javax.swing.JButton Btn_Last2;
    private javax.swing.JButton Btn_Next;
    private javax.swing.JButton Btn_Next1;
    private javax.swing.JButton Btn_Next2;
    private javax.swing.JButton Btn_Previous;
    private javax.swing.JButton Btn_Previous1;
    private javax.swing.JButton Btn_Previous2;
    private javax.swing.JButton Btn_Update;
    private javax.swing.JButton Btn_Update1;
    private javax.swing.JButton Btn_Update2;
    private javax.swing.JTable JTable_cheese;
    private javax.swing.JTable JTable_cheeseboard;
    private javax.swing.JTable JTable_linktable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField txt_age;
    private javax.swing.JTextField txt_boardid;
    private javax.swing.JTextField txt_cheeseid;
    private javax.swing.JTextField txt_cheesesboard;
    private javax.swing.JTextField txt_costboard;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_idboard;
    private javax.swing.JTextField txt_info;
    private javax.swing.JTextField txt_milk;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_nameboard;
    private javax.swing.JTextField txt_origin;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_quantity;
    private javax.swing.JTextField txt_rating;
    private javax.swing.JTextField txt_rowcost;
    private javax.swing.JTextField txt_rowid;
    private javax.swing.JTextField txt_statusboard;
    private javax.swing.JTextField txt_stock;
    private javax.swing.JTextField txt_strength;
    private javax.swing.JTextField txt_style;
    private javax.swing.JTextField txt_supplier;
    // End of variables declaration//GEN-END:variables
}
