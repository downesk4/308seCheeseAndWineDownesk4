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
        
    }

    int pos = 0;
    
    public Connection getConnection()
    {
        Connection con = null;
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/cheese", "root", "");
           // JOptionPane.showMessageDialog(null, "connected");  //check its connected
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(ControlWindow.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(null, "Not connected");  //check its connected
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
    
    public ArrayList<cheesemain> getCheeseList()
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
    
    public void Show_cheeseList_in_JTable()
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
            
    public void ShowItem(int index) 
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
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
                                .addGap(200, 200, 200)
                                .addComponent(Btn_First)
                                .addGap(18, 18, 18)
                                .addComponent(Btn_Previous)
                                .addGap(18, 18, 18)
                                .addComponent(Btn_Next)
                                .addGap(18, 18, 18)
                                .addComponent(Btn_Last))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(14, 14, 14))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(394, Short.MAX_VALUE))
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
                .addContainerGap(130, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void Btn_PreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_PreviousActionPerformed
        // TODO add your handling code here:
        pos--;
        
        if(pos < 0)
        {
            pos = 0;
        }
        
        ShowItem(pos);
    }//GEN-LAST:event_Btn_PreviousActionPerformed

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

    private void JTable_cheeseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTable_cheeseMouseClicked
        // TODO add your handling code here:
        int index = JTable_cheese.getSelectedRow();
        ShowItem(index);
        
    }//GEN-LAST:event_JTable_cheeseMouseClicked

    private void Btn_FirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_FirstActionPerformed
        // TODO add your handling code here:
        pos = 0;
        ShowItem(pos);
        
    }//GEN-LAST:event_Btn_FirstActionPerformed

    private void Btn_LastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_LastActionPerformed
        // TODO add your handling code here:
        pos = getCheeseList().size()-1;
        ShowItem(pos);
    }//GEN-LAST:event_Btn_LastActionPerformed

    private void Btn_NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_NextActionPerformed
        // TODO add your handling code here:
       pos++;
       
       if(pos >= getCheeseList().size())
       {
            pos = getCheeseList().size()-1;
       }
       ShowItem(pos);      
    }//GEN-LAST:event_Btn_NextActionPerformed

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nameActionPerformed

    private void txt_originActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_originActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_originActionPerformed

    private void txt_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_priceActionPerformed

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
    private javax.swing.JButton Btn_Delete;
    private javax.swing.JButton Btn_First;
    private javax.swing.JButton Btn_Insert;
    private javax.swing.JButton Btn_Last;
    private javax.swing.JButton Btn_Next;
    private javax.swing.JButton Btn_Previous;
    private javax.swing.JButton Btn_Update;
    private javax.swing.JTable JTable_cheese;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_age;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_info;
    private javax.swing.JTextField txt_milk;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_origin;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_rating;
    private javax.swing.JTextField txt_stock;
    private javax.swing.JTextField txt_strength;
    private javax.swing.JTextField txt_style;
    private javax.swing.JTextField txt_supplier;
    // End of variables declaration//GEN-END:variables
}
