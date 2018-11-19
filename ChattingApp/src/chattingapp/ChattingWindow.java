package chattingapp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ChattingWindow extends javax.swing.JFrame implements Runnable {

    private int portNo;
    private String yourIP;
    private Thread t;

    public ChattingWindow() {
        initComponents();
        try {
            InetAddress inet = InetAddress.getLocalHost();
            yourIP = inet.getHostAddress();
            yourIpTextField.setText(yourIP);

            portNo = Integer.parseInt(JOptionPane.showInputDialog("Enter Server Port No"));
            yourPortNoTextField.setText(portNo + "");

            t = new Thread(this);
            t.start();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex, "Chatting Window", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        yourIpTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        yourPortNoTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        chattingTextArea = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        clientIpTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        clientPortNoTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        messageTextField = new javax.swing.JTextField();
        sendButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chatting Window 345");

        jPanel1.setLayout(new java.awt.GridLayout(2, 2, 10, 10));

        jLabel2.setText("Your IP");
        jPanel1.add(jLabel2);

        yourIpTextField.setEditable(false);
        jPanel1.add(yourIpTextField);

        jLabel1.setText("Your Port No");
        jPanel1.add(jLabel1);
        jPanel1.add(yourPortNoTextField);

        chattingTextArea.setColumns(20);
        chattingTextArea.setRows(5);
        jScrollPane1.setViewportView(chattingTextArea);

        jPanel2.setLayout(new java.awt.GridLayout(3, 2, 10, 10));

        jLabel3.setText("Enter Client IP Address");
        jPanel2.add(jLabel3);
        jPanel2.add(clientIpTextField);

        jLabel4.setText("Client Port No");
        jPanel2.add(jLabel4);
        jPanel2.add(clientPortNoTextField);

        jLabel5.setText("Enter Message");
        jPanel2.add(jLabel5);
        jPanel2.add(messageTextField);

        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(471, 459));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        String msg=messageTextField.getText();
        chattingTextArea.append("You: "+msg+"\n");
        try 
        {
             
             int portNo=Integer.parseInt(clientPortNoTextField.getText());
             String clientIp=clientIpTextField.getText();
            Socket s = new Socket(clientIp, portNo);
            OutputStream out = s.getOutputStream();
           
            byte[] b=msg.getBytes();
            out.write(b);
            Thread.sleep(1000);
            out.close();
            s.close();
        }
        catch (Exception ex) 
        {
            System.out.println(ex);
        }
        
        messageTextField.setText("");
    }//GEN-LAST:event_sendButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea chattingTextArea;
    private javax.swing.JTextField clientIpTextField;
    private javax.swing.JTextField clientPortNoTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField messageTextField;
    private javax.swing.JButton sendButton;
    private javax.swing.JTextField yourIpTextField;
    private javax.swing.JTextField yourPortNoTextField;
    // End of variables declaration//GEN-END:variables

    public void run() {
        try 
        {
            ServerSocket ss=null; 
            while (true) 
            {
                ss= new ServerSocket(portNo);
                System.out.println("Server Waiting");
                Socket s = ss.accept();
                String clientIp=s.getInetAddress().getHostAddress();
                InputStream in = s.getInputStream();
                int size = in.available();
                byte[] b = new byte[size];
                in.read(b);
                String msg = new String(b);
                
                chattingTextArea.append(clientIp+": "+msg+"\n");
                in.close();
                s.close();
              ss.close();  
            }
            
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

}
