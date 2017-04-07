package chitchatclient;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import javax.swing.table.DefaultTableModel;

public class ChitchatClient extends javax.swing.JFrame {

    private DefaultTableModel model;
    private WaitMessage waitMessage;

    private DatagramSocket ds;
    private DatagramPacket dpIn, dpOut;
    private byte[] buffer;
    private InetAddress client;
    int clientPort;
    private String msgIn, msgOut;

    public ChitchatClient() {
        initComponents();
        model = (DefaultTableModel) tbMessage.getModel();

        waitMessage = new WaitMessage();

        btDisconnect.setEnabled(false);

        btClear.setEnabled(false);

        //table
        tbMessage.setEnabled(false);

        //chat box
        tfMessage.setEnabled(false);
        btSend.setEnabled(false);

    }

    public void connect() {
        try {
            //step 1 connect to server
            ds = new DatagramSocket();  //ถ้ามีเลขในวงเล็บจะเป็น Server ไม่มีคือ client

            waitMessage.start();

//--------------------------------------------------------
            String ip = tfIp.getText().toString();
            int port = Integer.parseInt(tfPort.getText());
            try {
                //step 2 prepair packet for server
                msgOut = "login";
                dpOut = new DatagramPacket(msgOut.getBytes(), msgOut.length(), InetAddress.getByName(ip), port);

                //step 3 send packet
                ds.send(dpOut);

            } catch (IOException ioe) {
                System.out.println("IO error : " + ioe);
            }
//--------------------------------------------------------

            lbStatus.setText("Running");

        } catch (SocketException se) {
            System.out.println("Socket Error : " + se);
            lbStatus.setText("Socket Error : " + se);
            System.exit(-1);
        } catch (IOException ioe) {
            System.out.println("IO error : " + ioe);
            lbStatus.setText("IO error : " + ioe);
        }

    }

    public void disconnect() {
        String ip = tfIp.getText().toString();
        int port = Integer.parseInt(tfPort.getText());
        try {
            //step 2 prepair packet for server
            msgOut = "logout";
            dpOut = new DatagramPacket(msgOut.getBytes(), msgOut.length(), InetAddress.getByName(ip), port);

            //step 3 send packet
            ds.send(dpOut);

        } catch (IOException ioe) {
            System.out.println("IO error : " + ioe);
        }
    }

    public void sendMessage() {

        String ip = tfIp.getText().toString();
        int port = Integer.parseInt(tfPort.getText());

        try {
            //step 2 prepair packet for server
            msgOut = tfName.getText().toString() + " : " + tfMessage.getText().toString();
            dpOut = new DatagramPacket(msgOut.getBytes(), msgOut.length(), InetAddress.getByName(ip), port);

            //step 3 send packet
            ds.send(dpOut);

            tfName.setText("");

        } catch (IOException ioe) {
            System.out.println("IO error : " + ioe);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfIp = new javax.swing.JTextField();
        tfPort = new javax.swing.JTextField();
        tfName = new javax.swing.JTextField();
        btConnect = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMessage = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        luser = new javax.swing.JList<>();
        lbStatus = new javax.swing.JLabel();
        tfMessage = new javax.swing.JTextField();
        btSend = new javax.swing.JButton();
        btClear = new javax.swing.JButton();
        btDisconnect = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("IP");

        jLabel2.setText("Port");

        jLabel3.setText("Name");

        tfIp.setText("localhost");

        tfPort.setText("8888");
        tfPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPortActionPerformed(evt);
            }
        });

        btConnect.setText("Connect");
        btConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConnectActionPerformed(evt);
            }
        });

        tbMessage.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Message"
            }
        ));
        jScrollPane1.setViewportView(tbMessage);

        luser.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {  };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(luser);

        lbStatus.setText("Status");

        tfMessage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfMessageKeyPressed(evt);
            }
        });

        btSend.setText("Send");
        btSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSendActionPerformed(evt);
            }
        });

        btClear.setText("Clear");
        btClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClearActionPerformed(evt);
            }
        });

        btDisconnect.setText("Disconnect");
        btDisconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDisconnectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btConnect)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btDisconnect)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(tfName)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfPort)
                                    .addComponent(tfIp))))
                        .addGap(15, 15, 15)
                        .addComponent(lbStatus)
                        .addGap(67, 67, 67)
                        .addComponent(btClear))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(tfMessage)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btSend))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btConnect)
                    .addComponent(lbStatus)
                    .addComponent(btClear)
                    .addComponent(btDisconnect))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSend))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConnectActionPerformed
        connect();

        btConnect.setEnabled(false);

        //textfield
        tfIp.setEnabled(false);
        tfPort.setEnabled(false);
        tfName.setEnabled(false);

        btDisconnect.setEnabled(true);

        btClear.setEnabled(true);

        //table
        tbMessage.setEnabled(true);

        //chat box
        tfMessage.setEnabled(true);
        btSend.setEnabled(true);

    }//GEN-LAST:event_btConnectActionPerformed

    private void btSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSendActionPerformed
        sendMessage();
    }//GEN-LAST:event_btSendActionPerformed

    private void btClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClearActionPerformed
        model.setRowCount(0);
    }//GEN-LAST:event_btClearActionPerformed

    private void btDisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDisconnectActionPerformed
        disconnect();
        waitMessage.interrupt();

        //textfield
        tfIp.setEnabled(true);
        tfPort.setEnabled(true);
        tfName.setEnabled(true);

        btDisconnect.setEnabled(false);

        btClear.setEnabled(false);

        //table
        tbMessage.setEnabled(false);

        //chat box
        tfMessage.setEnabled(false);
        btSend.setEnabled(false);

    }//GEN-LAST:event_btDisconnectActionPerformed

    private void tfPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPortActionPerformed

    private void tfMessageKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfMessageKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            System.out.println("1");
        }
//ทำต่อด้วย

    }//GEN-LAST:event_tfMessageKeyPressed

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
            java.util.logging.Logger.getLogger(ChitchatClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChitchatClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChitchatClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChitchatClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChitchatClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClear;
    private javax.swing.JButton btConnect;
    private javax.swing.JButton btDisconnect;
    private javax.swing.JButton btSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JList<String> luser;
    private javax.swing.JTable tbMessage;
    private javax.swing.JTextField tfIp;
    private javax.swing.JTextField tfMessage;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfPort;
    // End of variables declaration//GEN-END:variables

    class WaitMessage extends Thread {

        public void run() {
            while (true) {
                try {
                    sleep(1);
                    //step 4 create buffer
                    buffer = new byte[256];

                    //setp 5 create datagram packet (เพื่อรับข้อมูล)
                    dpIn = new DatagramPacket(buffer, buffer.length);

                    //step 6 receive packet
                    ds.receive(dpIn);

                    //step 7 extract message (แปลง byte เป็น String)
                    msgIn = new String(dpIn.getData(), 0, dpIn.getLength());
                    System.out.println(msgIn);

                    //shot TB
                    model.addRow(new Object[]{msgIn});

                } catch (IOException ioe) {
                    System.out.println("IO error : " + ioe);
                } catch (InterruptedException ie) {
                    System.out.println("interrupted");
                    lbStatus.setText("Stop");
                }
            }

        }
    }

}
