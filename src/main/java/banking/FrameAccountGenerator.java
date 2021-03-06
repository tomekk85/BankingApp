package banking;

import javax.swing.text.MaskFormatter;

/**
 *
 * @author tomas
 */
public class FrameAccountGenerator extends javax.swing.JFrame {

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify
    private javax.swing.JButton buttonBackToLogin;
    private javax.swing.JLabel lblCardNumber;
    private javax.swing.JLabel lblGeneralInfo;
    private javax.swing.JLabel lblPin;
    private javax.swing.JFormattedTextField textFieldCardNumber;
    private javax.swing.JTextField textFieldPin;
    private Account generatedAccount;
    // End of variables declaration

    /**
     * Creates new form AccountGeneratorFrame
     */
    public FrameAccountGenerator(Account generatedAccount) {
        this.generatedAccount =  generatedAccount;
        initComponents();
    }

    private void initComponents() {

        lblCardNumber = new javax.swing.JLabel();
        lblPin = new javax.swing.JLabel();
        try{
            textFieldCardNumber = new javax.swing.JFormattedTextField(new MaskFormatter("#### #### #### ####"));
            buttonBackToLogin = new javax.swing.JButton();
            lblGeneralInfo = new javax.swing.JLabel();
            textFieldPin = new javax.swing.JTextField();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setTitle("Generator konta");

            lblCardNumber.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            lblCardNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblCardNumber.setText("NR KARTY");

            lblPin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            lblPin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblPin.setText("PIN");

        } catch(Exception e){
            System.out.println(e);
        }
        textFieldCardNumber.setEditable(false);
        textFieldCardNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        //set Card number from generated account into text field
        textFieldCardNumber.setText(Long.toString(generatedAccount.getCardNumber()));
        textFieldCardNumber.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N

        buttonBackToLogin.setText("Wróć do opcji logowania");
        buttonBackToLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackToLoginActionPerformed(evt);
            }
        });

        lblGeneralInfo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblGeneralInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGeneralInfo.setText("WYGENEROWANO NOWE KONTO:");

        textFieldPin.setEditable(false);
        textFieldPin.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        textFieldPin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        //set Card number from generated account into text field
        textFieldPin.setText(generatedAccount.getPin());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(lblCardNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                                                .addComponent(textFieldCardNumber)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(68, 68, 68)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGap(10, 10, 10)
                                                                        .addComponent(textFieldPin, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(lblPin, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(45, 45, 45)
                                                .addComponent(buttonBackToLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(lblGeneralInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(lblGeneralInfo)
                                .addGap(18, 18, 18)
                                .addComponent(lblCardNumber)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(lblPin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldPin, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                                .addGap(41, 41, 41)
                                .addComponent(buttonBackToLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>

    private void buttonBackToLoginActionPerformed(java.awt.event.ActionEvent evt) {
        new FrameLogin().setVisible(true);
        this.dispose();

    }

}
