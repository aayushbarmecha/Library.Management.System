package library.management.system;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.JTableHeader;
import net.proteanit.sql.DbUtils;
public class ModifyLibrarianInfo extends javax.swing.JFrame {
    int mousePositionX;
    int mousePositionY;
    boolean isConfirmed;
    public ModifyLibrarianInfo() {
        UIManager UI = new UIManager();
        UI.put("OptionPane.background",new java.awt.Color(8,32,50));
        UI.put("Panel.background",new java.awt.Color(44,57,75));
        UI.put("OptionPane.messageForeground", new java.awt.Color(255,255,255));
        
        this.getContentPane().setBackground(new java.awt.Color(8,32,50));
        initComponents();
        librarian();
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
        back = new javax.swing.JButton();
        search = new javax.swing.JButton();
        searchTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        librarianInfoTable = new javax.swing.JTable();
        modify = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Alpha Library System");
        setIconImage(Toolkit.getDefaultToolkit().createImage((System.getProperty("user.dir")+"//icon.png")));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(44, 57, 75));

        back.setBackground(new java.awt.Color(51, 71, 86));
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("Back");
        back.setMaximumSize(new java.awt.Dimension(73, 23));
        back.setMinimumSize(new java.awt.Dimension(73, 23));
        back.setPreferredSize(new java.awt.Dimension(73, 23));
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        search.setBackground(new java.awt.Color(51, 71, 86));
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setText("Search");
        search.setMaximumSize(new java.awt.Dimension(73, 23));
        search.setMinimumSize(new java.awt.Dimension(73, 23));
        search.setPreferredSize(new java.awt.Dimension(73, 23));
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        searchTF.setBackground(new java.awt.Color(51, 71, 86));
        searchTF.setForeground(new java.awt.Color(255, 255, 255));
        searchTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchTFKeyPressed(evt);
            }
        });

        librarianInfoTable.setAutoCreateRowSorter(true);
        librarianInfoTable.setBackground(new java.awt.Color(51, 71, 86));
        librarianInfoTable.setForeground(new java.awt.Color(255, 255, 255));
        librarianInfoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Name", "Password", "Security Question", "Security Answer"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        librarianInfoTable.setGridColor(new java.awt.Color(51, 71, 86));
        jScrollPane1.setViewportView(librarianInfoTable);
        JTableHeader Theader = librarianInfoTable.getTableHeader();
        Theader.setBackground(new java.awt.Color(57,76,99));
        Theader.setForeground(new java.awt.Color(255,255,255));

        jScrollPane1.getViewport().setBackground(new java.awt.Color(51,71,86));

        modify.setBackground(new java.awt.Color(51, 71, 86));
        modify.setForeground(new java.awt.Color(255, 255, 255));
        modify.setText("Modify");
        modify.setMaximumSize(new java.awt.Dimension(73, 23));
        modify.setMinimumSize(new java.awt.Dimension(73, 23));
        modify.setPreferredSize(new java.awt.Dimension(73, 23));
        modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(51, 71, 86));
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("Delete");
        delete.setMaximumSize(new java.awt.Dimension(73, 23));
        delete.setMinimumSize(new java.awt.Dimension(73, 23));
        delete.setPreferredSize(new java.awt.Dimension(73, 23));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchTF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modify, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/library/management/system/icons/close.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/library/management/system/icons/minimize.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel6MouseDragged(evt);
            }
        });
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(44, 57, 75));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Administrator - Modify Librarian Information");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.setVisible(false);
        main menu = new main();
        menu.setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        try {
            conn con = new conn();
            String sql = "select username as 'Username', name as 'Name', password as 'Password', sec_q as 'Security Question', sec_ans as 'Security Answer' from account where username||name like ?";
            PreparedStatement st = con.c.prepareStatement(sql);
            st.setString(1, "%" + searchTF.getText() + "%");
            ResultSet rs = st.executeQuery();

            librarianInfoTable.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            con.closeConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_searchActionPerformed

    private void searchTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTFKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            searchActionPerformed(null);
        }
    }//GEN-LAST:event_searchTFKeyPressed

    private void modifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyActionPerformed
        int row = librarianInfoTable.getSelectedRow();
        String value = librarianInfoTable.getModel().getValueAt(row, 0).toString();
        this.setVisible(false);
        ModifyLibrarianInformation modify = new ModifyLibrarianInformation();
        modify.passInfo(value);
    }//GEN-LAST:event_modifyActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        confirm();
        copyInfo();
        delete();
    }//GEN-LAST:event_deleteActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        this.setVisible(false);
        main menu = new main();
        menu.setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        this.setExtendedState(Login_user.ICONIFIED);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseDragged
        int coordinateX = evt.getXOnScreen();
        int coordinateY = evt.getYOnScreen();

        this.setLocation(coordinateX-mousePositionX, coordinateY-mousePositionY);
    }//GEN-LAST:event_jLabel6MouseDragged

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
        mousePositionX = evt.getX();
        mousePositionY = evt.getY();
    }//GEN-LAST:event_jLabel6MousePressed

    private void librarian(){
        try {
            conn con = new conn();
            String sql = "SELECT username as 'Username', name as 'Name', password as 'Password', sec_q as 'Security Question', sec_ans as 'Security Answer' FROM account";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            librarianInfoTable.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            con.closeConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void confirm(){
        String confirmation = JOptionPane.showInputDialog(null,"Type CONFIRM to delete librarian information", "Confirm", JOptionPane.PLAIN_MESSAGE).toUpperCase();
        System.out.println(confirmation);
        if (confirmation.equals("CONFIRM")){
            isConfirmed = true;
        }
    }

    private void copyInfo(){
        if (isConfirmed == true){
            int row = librarianInfoTable.getSelectedRow();
            String value = librarianInfoTable.getModel().getValueAt(row, 0).toString();
            try {
                conn con = new conn();
                String sql = "select * from account where username=?";
                PreparedStatement st = con.c.prepareStatement(sql);
                
                String user = value;
                st.setString(1, user);
                ResultSet rs = st.executeQuery();
            
                if (rs.next()){
                    String usernameInfo = rs.getString("username");
                    String nameInfo = rs.getString("name");
                    String passwordInfo = rs.getString("password");
                    String sec_qInfo = rs.getString("sec_q");
                    String sec_ansInfo = rs.getString("sec_ans");
                    
                    con.closeConnection();
                    trash(usernameInfo, nameInfo, passwordInfo, sec_qInfo, sec_ansInfo);
                }
            } catch (Exception e) {
            
            }
        }
    }

    private void trash(String usernameInfo, String nameInfo, String passwordInfo, String sec_qInfo, String sec_ansInfo){
        try {
                conn con = new conn();
                String sql = "insert into deleted_account(username, name, password, sec_q, sec_ans) values(?, ?, ?, ?, ?)";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, usernameInfo);
                st.setString(2, nameInfo);
                st.setString(3, passwordInfo);
                st.setString(4, sec_qInfo);
                st.setString(5, sec_ansInfo);
                
                int i = st.executeUpdate();
                con.closeConnection();
            }catch (Exception e){
                System.out.println(e);
            }
    }

    private void delete(){
        if (isConfirmed == true){
            int row = librarianInfoTable.getSelectedRow();
            String value = librarianInfoTable.getModel().getValueAt(row, 0).toString();
            try {
                conn con = new conn();
                String sql = "DELETE FROM account WHERE username = ?";
                PreparedStatement st = con.c.prepareStatement(sql);
                
                String id = value;
                
                st.setString(1, id);
                st.executeUpdate();
                JOptionPane.showMessageDialog(null,"Librarian information successfully deleted from the database", "Success!", JOptionPane.PLAIN_MESSAGE);
                Logs write = new Logs();
                write.log("Administrator removed Librarian "+id+"'s information from the database");
                con.closeConnection();
            }catch (Exception e){
                System.out.println(e);
            }
            isConfirmed = false;
            searchTF.setText("");
            searchActionPerformed(null);
        }
    }

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
            java.util.logging.Logger.getLogger(ModifyLibrarianInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifyLibrarianInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifyLibrarianInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifyLibrarianInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifyLibrarianInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable librarianInfoTable;
    private javax.swing.JButton modify;
    private javax.swing.JButton search;
    private javax.swing.JTextField searchTF;
    // End of variables declaration//GEN-END:variables
}
