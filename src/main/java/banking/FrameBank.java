package banking;

import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author tomas
 */
public class FrameBank extends javax.swing.JFrame {
    // Variables declaration - do not modify
    private javax.swing.JButton buttonConfirm;
    private javax.swing.JButton buttonDeposit;
    private javax.swing.JButton buttonLogout;
    private javax.swing.JButton buttonPayOut;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblBalance;
    private javax.swing.JLabel lblCardNumber;
    private javax.swing.JPanel panelOperations;
    private javax.swing.JTextField textFieldAmount;
    private javax.swing.JTextField textFieldBalance;
    private javax.swing.JFormattedTextField textFieldCardNumber;
    private Account account;
    private String operation;
    // End of variables declaration


    /**
     * Creates new form BankFrame
     */
    public FrameBank(Account account) {
        this.account = account;
        initComponents();
        panelOperations.setVisible(false);

    }

    private void initComponents() {

        buttonDeposit = new javax.swing.JButton();
        buttonPayOut = new javax.swing.JButton();
        lblBalance = new javax.swing.JLabel();
        buttonLogout = new javax.swing.JButton();
        textFieldBalance = new javax.swing.JTextField();
        try{
            textFieldCardNumber = new javax.swing.JFormattedTextField(new MaskFormatter("#### #### #### ####"));
            lblCardNumber = new javax.swing.JLabel();
            panelOperations = new javax.swing.JPanel();
            textFieldAmount = new javax.swing.JTextField();
            buttonConfirm = new javax.swing.JButton();
            lblAmount = new javax.swing.JLabel();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setTitle("Konto");

            buttonDeposit.setText("Wpłata");
            buttonDeposit.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonDepositActionPerformed(evt);
                }
            });

            buttonPayOut.setText("Wypłata");
            buttonPayOut.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonPayOutActionPerformed(evt);
                }
            });

            lblBalance.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
            lblBalance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblBalance.setText("SALDO");

            buttonLogout.setText("WYLOGUJ");
            buttonLogout.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonLogoutActionPerformed(evt);
                }
            });

            textFieldBalance.setEditable(false);
            textFieldBalance.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
            textFieldBalance.setHorizontalAlignment(javax.swing.JTextField.CENTER);

            //pobranie tekstu z obiekty klasy Account
            textFieldBalance.setText(
                    String.format(
                                    "%,.2f",//sposób formatowania
                                    account.getBalance()//saldo
                                    ));

        } catch(Exception e){
            System.out.println(e);
        }
        textFieldCardNumber.setEditable(false);
        textFieldCardNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        textFieldCardNumber.setText(String.valueOf(account.getCardNumber()));
        textFieldCardNumber.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N

        lblCardNumber.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCardNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCardNumber.setText("NR KARTY");

        textFieldAmount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        textFieldAmount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldAmount.setText("");
        textFieldAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textFieldAmountKeyTyped(evt);
            }
        });

        buttonConfirm.setText("Zatwierdź");
        buttonConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConfirmActionPerformed(evt);
            }
        });

        lblAmount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblAmount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAmount.setText("Podaj kwotę");

        javax.swing.GroupLayout panelOperationsLayout = new javax.swing.GroupLayout(panelOperations);
        panelOperations.setLayout(panelOperationsLayout);
        panelOperationsLayout.setHorizontalGroup(
                panelOperationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(textFieldAmount)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOperationsLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(106, 106, 106))
                        .addComponent(lblAmount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelOperationsLayout.setVerticalGroup(
                panelOperationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelOperationsLayout.createSequentialGroup()
                                .addComponent(lblAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(buttonLogout))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(lblCardNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                                                .addGap(48, 48, 48))))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(textFieldCardNumber)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(buttonDeposit, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                                                .addComponent(buttonPayOut, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(lblBalance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textFieldBalance)
                                        .addComponent(panelOperations, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonLogout)
                                .addGap(18, 18, 18)
                                .addComponent(lblCardNumber)
                                .addGap(18, 18, 18)
                                .addComponent(textFieldCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttonDeposit, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonPayOut, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(panelOperations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(textFieldBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void buttonLogoutActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        new FrameLogin(account).setVisible(true);
        this.dispose();
    }

    private void buttonDepositActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        operation = "deposit";
        lblAmount.setText("Podaj kwotę wpłaty");
        panelOperations.setVisible(true);
    }

    private void buttonPayOutActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        operation = "payout";
        lblAmount.setText("Podaj kwotę wypłaty");
        panelOperations.setVisible(true);
    }

    private void buttonConfirmActionPerformed(java.awt.event.ActionEvent evt) {
        Double inputAmount = Double.parseDouble(textFieldAmount.getText());
        if(inputAmount > 0){
            if("deposit".equals(operation)){
                account.deposit(inputAmount);
            } else if("payout".equals(operation)){
                account.payOut(inputAmount);

            }
            //uaktualnienie wyswietlanego salda
            textFieldBalance.setText(
                    String.format(
                            "%,.2f",//sposób formatowania
                            account.getBalance()//saldo
                    ));
            panelOperations.setVisible(false);
        }else {
            JOptionPane.showMessageDialog(null, "Musisz podać wartość większą od zera");}
    }
    //funkcja pilnuje by można było wpisywać tylko cyfry i kropkę
    // (i ze podana liczba jest z dokladnoscia do 2-och miejsc po przecinku)
    private void textFieldAmountKeyTyped(java.awt.event.KeyEvent evt) {

        String input = textFieldAmount.getText();
        if (!input.matches("\\d*(\\.\\d{0,1})?")) {
            evt.consume();
        }
    }

}
