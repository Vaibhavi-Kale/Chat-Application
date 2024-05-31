package main;

import function.Client;
import function.Method;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdStart = new javax.swing.JButton();
        cmdStop = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt = new javax.swing.JTextArea();
        lbStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        cmdStart.setBackground(new java.awt.Color(102, 255, 102));
        cmdStart.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cmdStart.setText("Start Server");
        cmdStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdStartActionPerformed(evt);
            }
        });

        cmdStop.setBackground(new java.awt.Color(255, 153, 153));
        cmdStop.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cmdStop.setText("Stop Server");
        cmdStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdStopActionPerformed(evt);
            }
        });

        txt.setEditable(false);
        txt.setColumns(20);
        txt.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txt.setRows(5);
        txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(txt);

        lbStatus.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmdStart)
                        .addGap(6, 6, 6)
                        .addComponent(cmdStop)
                        .addGap(4, 4, 4)
                        .addComponent(lbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdStart)
                    .addComponent(cmdStop)
                    .addComponent(lbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private ServerSocket server;
    private Thread run;

    private void startServer() throws Exception {
        Method.setClients(new ArrayList<>());
      //  File f = new File("data");
    //    for (File fs : f.listFiles()) {
         //   fs.delete();
      //  }
        run = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    server = new ServerSocket(5000);
                    lbStatus.setForeground(Color.GREEN);
                    Method.setTxt(txt);
                    txt.setText("Server Started\n");
                    while (true) {
                        new Client(server.accept());
                    }
                } catch (Exception e) {
                   // JOptionPane.showMessageDialog(Main.this, e, "Error", JOptionPane.ERROR_MESSAGE);
                    //e.printStackTrace();
                }
            }
        });
        run.start();
    }

    private void stopServer()throws Exception {
        //int c = JOptionPane.showConfirmDialog(this, "Are you sure to stop server now", "Sotop Server", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        //if (c == JOptionPane.YES_OPTION) {
            lbStatus.setForeground(new Color(255, 51, 51));
            txt.setText("Server Stoped");
            run.interrupt();
        
            server.close();
            //}
         
    }
    private void cmdStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdStartActionPerformed
        try {
            //int c = JOptionPane.showConfirmDialog(this, "File in data will be delete when server is start", "Start Server", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            //if (c == JOptionPane.YES_OPTION) {
                startServer();
            //}
        } catch (Exception e) {
           JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cmdStartActionPerformed

    private void cmdStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdStopActionPerformed
        try {
            stopServer();
        } catch (Exception e) {
           JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cmdStopActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdStart;
    private javax.swing.JButton cmdStop;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JTextArea txt;
    // End of variables declaration//GEN-END:variables
}
