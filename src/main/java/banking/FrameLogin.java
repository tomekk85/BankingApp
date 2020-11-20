package banking;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author tomas
 */
public class FrameLogin extends javax.swing.JFrame {

    /**
     * @param args the command line arguments
     */

    private javax.swing.JButton buttonNewAccount;
    private javax.swing.JButton buttonLogin;
    private javax.swing.JLabel lblCardNumber;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblPin;
    private javax.swing.JPasswordField passwordFieldPin;
    private javax.swing.JFormattedTextField textFieldCardNumber;
    private AccountCollection accounts;
    private Logger logger;
    // End of variables declaration

    /**
     * Creates new form LoginFrame
     */
    public FrameLogin() {
        //creates new object AccountCollection and loads data from given filepath
        accounts = new AccountCollection("accounts.data");
        initComponents();


    }

    //Constructor with update of AccountCollection field
    public FrameLogin(Account account) {
        //creates new object AccountCollection and loads data from given filepath
        accounts = new AccountCollection("accounts.data");
        //updates specified account in AccountColletion
        accounts.updateAccount(account);
        //saves update to file
        accounts.save();
        initComponents();
    }


    private void initComponents() {

        lblLogin = new javax.swing.JLabel();
        lblCardNumber = new javax.swing.JLabel();
        lblPin = new javax.swing.JLabel();
        buttonLogin = new javax.swing.JButton();
        try{
            textFieldCardNumber = new javax.swing.JFormattedTextField(new MaskFormatter("#### #### #### ####"));
            passwordFieldPin = new javax.swing.JPasswordField();
            buttonNewAccount = new javax.swing.JButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setTitle("Logowanie");

            lblLogin.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
            lblLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblLogin.setText("LOGOWANIE");

            lblCardNumber.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            lblCardNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblCardNumber.setText("PODAJ NR KARTY");

            lblPin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            lblPin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblPin.setText("PODAJ PIN");

            buttonLogin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            buttonLogin.setText("ZALOGUJ");
            buttonLogin.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonLoginActionPerformed(evt);
                }
            });

        } catch(Exception e){
            System.out.println(e);
        }
        textFieldCardNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldCardNumber.setText("4000 0000 0000 0000");
        textFieldCardNumber.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N

        passwordFieldPin.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        passwordFieldPin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordFieldPin.setText("");
        passwordFieldPin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordFieldPinKeyTyped(evt);
            }
        });

        buttonNewAccount.setText("Utwórz nowe konto");
        buttonNewAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNewAccountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(lblCardNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                                                        .addComponent(lblLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(textFieldCardNumber)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(68, 68, 68)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lblPin, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(10, 10, 10)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(passwordFieldPin)
                                                                                        .addComponent(buttonLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)))))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(78, 78, 78)
                                                .addComponent(buttonNewAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblCardNumber)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(lblPin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(passwordFieldPin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addComponent(buttonNewAccount))
        );

        pack();
    }// </editor-fold>

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {
        String pin = passwordFieldPin.getText().toString();
        Long cardNumber = Long.parseLong(textFieldCardNumber.getText().replace(" ", ""));

        logger = new Logger(accounts, cardNumber, pin);
        logger.logIn();

        if(logger.isAccessGranted()){
            //przekazujemy konstruktorowi klasy FrameBank jako paratmer obiekt Account
            new FrameBank(accounts.getAccountByNumber(cardNumber)).setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null,"Niewłaściwy numer konta lub błędny PIN!");
        }
    }

    private void passwordFieldPinKeyTyped(java.awt.event.KeyEvent evt) {

        // do PINu można wpisać same cyfry i tylko 4 znaki
        if(!Character.isDigit(evt.getKeyChar()) ||
                passwordFieldPin.getPassword().length >= 4){
            evt.consume();
        }
    }

    private void buttonNewAccountActionPerformed(java.awt.event.ActionEvent evt) {
        Account account = new Account();
        while (accounts.containsAccount(account)) {
            account = new Account();
        }
        accounts.addAccount(account);
        accounts.save();
        new FrameAccountGenerator(account).setVisible(true);
        this.dispose();
    }

}
