package my_swing;

import function.Method;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
;

public class Get_File_New extends javax.swing.JPanel {
String path;
    public int getFileID() {
        return fileID;
    }

    public void setFileID(int fileID) {
        this.fileID = fileID;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public Get_File_New() {
        initComponents();
    }
    private int fileID;
    private String fileName;
    private String fileSize;

    public void set(int ID, String fileName, ImageIcon icon) {
        this.fileID = Integer.valueOf(fileName.split("!")[0]);
        this.fileName = fileName.split("!")[1];
        this.fileSize = fileName.split("!")[2];
        lbFileName.setIcon(icon);
        lbFileName.setText(this.fileName);
        if (Method.getFriends().get(ID).getImage() != null) {
            profile.setIcon(Method.getFriends().get(ID).getImage());
        }
        lbName.setText(Method.getFriends().get(ID).getfName());
        lbFileName.setToolTipText(fileSize);
    }
        public void setold(String name, String fileName) {
        
        lbFileName.setText(fileName);
        lbName.setText(name);
            System.out.println(fileName);
            System.out.println(name);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        border = new javax.swing.JLabel();
        profile = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        lbFileName = new javax.swing.JButton(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(new java.awt.Color(195, 191, 191));
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
                g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
            }
        };

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(600, 72));

        jLayeredPane1.setLayout(new javax.swing.OverlayLayout(jLayeredPane1));

        border.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        border.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/border_small.png"))); // NOI18N
        jLayeredPane1.add(border);

        profile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/profile_small.png"))); // NOI18N
        jLayeredPane1.add(profile);

        lbName.setFont(new java.awt.Font("Khmer SBBIC Serif", 1, 15)); // NOI18N
        lbName.setForeground(new java.awt.Color(29, 118, 206));
        lbName.setText("Name");

        lbFileName.setFont(new java.awt.Font("Khmer SBBIC Serif", 0, 15)); // NOI18N
        lbFileName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/file_1.png"))); // NOI18N
        lbFileName.setText("File name.rar");
        lbFileName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 20));
        lbFileName.setContentAreaFilled(false);
        lbFileName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbFileName.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        lbFileName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbFileNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbFileName)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbName)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbFileName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

     public static Connection MySqlConnection(){
        Connection conn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/chatapp",
                    "root", "root");
          //JOptionPane.showMessageDialog(null, "Mysql DB Connection Successful...");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Mysql Connection Failed....");
            return null;
        }    
    }   
    public void click()
    {
    try  
{  
//constructor of file class having file as argument  
    String f=lbFileName.getText();
    String n=lbName.getText();
    
    Connection conn=MySqlConnection();
    PreparedStatement ps=conn.prepareStatement("select filepath from chattingapp where name =? AND filename=?");
    //PreparedStatement ps=conn.prepareStatement("select file from chatfile where name =? AND filename=?");
    
    if(n.equals("You"))
    {
        ps.setString(1, Method.getMyName());
        System.out.println("Method.getMyName();"+Method.getMyName());
        ps.setString(2, f);
    }
    else
    {
        ps.setString(1, n);
        ps.setString(2, f);
        System.out.println("n"+n);
    }
    
    //System.out.println("Method.getMyName();"+Method.getMyName());
    ResultSet r =ps.executeQuery();
    
    while(r.next())
    {      path = r.getString("filepath");
    System.out.println("path :"+path);
    }
    //System.out.println("n"+n);
    System.out.println("f"+f);
    System.out.println(path);
    File file = new File(path);   
    if(!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not  
    {  
        System.out.println("not supported");  
        return;  
    }  
    Desktop desktop = Desktop.getDesktop();  
    if(file.exists())         //checks file exists or not  
    desktop.open(file);              //opens the specified file  
}  
catch(Exception e)  
{  
e.printStackTrace();  
}       
        
}
    private void lbFileNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbFileNameActionPerformed
        //Method.downloadFile(fileID, fileName);
        click();
    }//GEN-LAST:event_lbFileNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel border;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JButton lbFileName;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel profile;
    // End of variables declaration//GEN-END:variables
}
