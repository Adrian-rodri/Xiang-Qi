package xiang.qi;

/**
 *
 * @author adria
 */
import javax.swing.*;
import java.awt.*;
public class MenuInicial extends JPanel{
    private Player player;
    private Gestionable playerManager= new PlayerManager();
    private Color bg= Color.white;
    private Color btn= bg;
    private Color txt= new Color(0x699BC9);
    private Font fTxt= new Font("STXihei",Font.BOLD,20);
    private Font fBtn= new Font("STXihei",Font.BOLD,15);
    private JPanel panelBtn,panelLogin;
    private JPanel panelCrear;
    private JButton btnCreate;
    private JButton btnBackCrear;
    private JTextField txtUserNuevo;
    private JTextField txtContraNueva;
    
    MenuInicial(){
        this.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        setLayout(new BorderLayout());
        setBackground(bg);
        JLabel titulo= new JLabel("Xing Qi Go!",SwingConstants.CENTER);
        titulo.setForeground(Color.black);
        titulo.setFont(new Font("Bauhaus 93",Font.BOLD,34));
        
        playerManager.registrarPlayer(new Player("1","1"));
        initPlayers();
        /*
        Botones
        */
        panelBtn= new JPanel();
        panelBtn.setLayout(new BoxLayout(panelBtn,BoxLayout.Y_AXIS));
        panelBtn.setBackground(bg);
        Dimension d= new Dimension(300,50);
        
        JButton btnLogin = new JButton("Log In");
        btnLogin.setBackground(btn);
        btnLogin.setFont(fTxt);
        btnLogin.setForeground(txt);
        btnLogin.setBorderPainted(false);
        btnLogin.setFocusPainted(false);
        
        JButton btnNew = new JButton("Crear Player");
        btnNew.setFont(fTxt);
        btnNew.setBackground(btn);
        btnNew.setForeground(txt);
        btnNew.setBorderPainted(false);
        btnNew.setFocusPainted(false);
        
        JButton btnClose= new JButton("Salir");
        btnClose.setFont(fTxt);
        btnClose.setBackground(btn);
        btnClose.setForeground(new Color(0xD62828));
        btnClose.setBorderPainted(false);
        btnClose.setFocusPainted(false);
        
        JButton[] botones={btnLogin, btnNew, btnClose};
        for (JButton b: botones){
            b.setAlignmentX(Component.CENTER_ALIGNMENT);
            b.setMaximumSize(d);
            panelBtn.add(b);
            panelBtn.add(Box.createVerticalStrut(5));
        }
        
        /*
        Panel Login
        */
        panelLogin= new JPanel(new GridBagLayout());
        panelLogin.setBorder(BorderFactory.createEmptyBorder(0, 0, 400,0));
        GridBagConstraints gbc= new GridBagConstraints();
        gbc.insets= new Insets(10,10,10,10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelLogin.setBackground(bg);
        
        JLabel lblLogin= new JLabel("Log In");
        lblLogin.setFont(fTxt);
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth= 2;
        panelLogin.add(lblLogin,gbc);
        
        gbc.gridwidth=1;
        gbc.gridy=1;
        JLabel lblUser= new JLabel("Username");
        panelLogin.add(lblUser,gbc);
        
        gbc.gridx=1;
        JTextField txtUsername= new JTextField(15);
        panelLogin.add(txtUsername,gbc);
        
        gbc.gridy=2;
        gbc.gridx=0;
        JLabel lblContra= new JLabel("Contraseña");
        panelLogin.add(lblContra,gbc);
        
        gbc.gridx=1;
        JPasswordField txtContra= new JPasswordField(15);
        panelLogin.add(txtContra,gbc);
        
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.gridwidth=2;
        gbc.insets= new Insets(2,10,2,10);
        JButton btnLog= new JButton("Continuar");
        btnLog.setBackground(btn);
        btnLog.setForeground(txt);
        btnLog.setBorderPainted(false);
        btnLog.setFocusPainted(false);
        panelLogin.add(btnLog,gbc);
        
        gbc.gridy=4;
        JButton btnBackLog= crearBtnRegresar(panelLogin);
        btnBackLog.setBackground(btn);
        panelLogin.add(btnBackLog,gbc);
        
        //Accion boton continuar
        btnLog.addActionListener(e->{
            String userTxt= txtUsername.getText();
            String passTxt= txtContra.getText();
            if(userTxt.isEmpty() || passTxt.isEmpty()){
                JOptionPane.showMessageDialog(this,"Llene todos los campos");
                return;
            }
            player= playerManager.LogIn(userTxt, passTxt);
            if(player!=null){
                GameWindow.setMenuPrincipal(player, playerManager);
                GameWindow.cambiarPantalla(GameWindow.getMenuprincipal(), "Principal");
                btnBackLog.doClick();
                repaint();
                revalidate();
            }else{
                JOptionPane.showMessageDialog(this,"Credenciales Incorrectas");
            }
            
            txtUsername.setText("");
            txtContra.setText("");
            
        });
        /*
        Panel new player
        */
        panelCrear= new JPanel(new GridBagLayout());
        panelCrear.setBorder(BorderFactory.createEmptyBorder(0, 0, 400,0));
        panelCrear.setBackground(bg);
        gbc.insets= new Insets(10,10,10,10);
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=2;
        JLabel lblCrear= new JLabel("Crear Nuevo Player");
        lblCrear.setFont(fTxt);
        panelCrear.add(lblCrear,gbc);
        
        gbc.gridy=1;
        gbc.gridwidth=1;
        panelCrear.add(new JLabel("Username"),gbc);
        
        gbc.gridy=1;
        gbc.gridx=1;
        txtUserNuevo= new JTextField(15);
        panelCrear.add(txtUserNuevo,gbc);
        
        gbc.gridy=2;
        gbc.gridx=0;
        panelCrear.add(new JLabel("Contraseña"),gbc);
        
        gbc.gridx=1;
        txtContraNueva= new JTextField(15);
        panelCrear.add(txtContraNueva,gbc);
        
        gbc.gridy=3;
        gbc.gridx=0;
        gbc.gridwidth=2;
        gbc.insets= new Insets(2,10,2,10);
        btnCreate= new JButton("Crear Player");
        btnCreate.setBackground(btn);
        btnCreate.setForeground(txt);
        btnCreate.setBorderPainted(false);
        btnCreate.setFocusPainted(false);
        panelCrear.add(btnCreate,gbc);
        
        gbc.gridy=4;
        btnBackCrear= crearBtnRegresar(panelCrear);
        btnBackCrear.setBackground(btn);
        panelCrear.add(btnBackCrear,gbc);
        //Accion boton registar
        
        btnCreate.addActionListener(e->{
            
            String newUserTxt= txtUserNuevo.getText();
            String newPassTxt= txtContraNueva.getText();
            
            if(newUserTxt.isEmpty() || newPassTxt.isEmpty()){
                JOptionPane.showMessageDialog(this,"Llene todos los campos");
                return;
            
            }
            if(playerManager.existePlayer(newUserTxt)){
                JOptionPane.showMessageDialog(this,"El username ya esta en uso");
                return;
            }
            if(newPassTxt.length() !=5){
                JOptionPane.showMessageDialog(this,"La contraseña tiene que ser de 5 characteres");
                return;
            }
            if(!newPassTxt.matches(".*[0-9].*")){
                JOptionPane.showMessageDialog(this,"La contraseña debe contener almenos 1 numero");
                return;
            }
            if(!newPassTxt.matches(".*[A-Z].*")){
                JOptionPane.showMessageDialog(this,"La contraseña debe tener una letra mayuscula");
                return;
            }
            if(!newPassTxt.matches(".*[a-z].*")){
                JOptionPane.showMessageDialog(this,"La contraseña debe tener una letra miniscula");
                return;
            }
            Player nuevo=new Player(newUserTxt,newPassTxt);
            playerManager.registrarPlayer(nuevo);
            JOptionPane.showMessageDialog(this,"Se creo el player: "+newUserTxt+" exitosamente");
            GameWindow.setMenuPrincipal(nuevo, playerManager);
            GameWindow.cambiarPantalla(GameWindow.getMenuprincipal(), "Principal");
            txtUserNuevo.setText("");
            txtContraNueva.setText("");
            btnBackCrear.doClick();
            repaint();
            revalidate();
            
        });
        /*
        Acciones
        */
        btnLogin.addActionListener(e->{
            panelBtn.setVisible(false);
            add(panelLogin,BorderLayout.CENTER);
            repaint();
            revalidate();
        });
        btnNew.addActionListener(e->{
            panelBtn.setVisible(false);
            add(panelCrear,BorderLayout.CENTER);
            repaint();
            revalidate();
        });
        btnClose.addActionListener(e->{
            int opcion= JOptionPane.showConfirmDialog(this, "Seguro que quieres salir?","Confirmar Salir",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(opcion== JOptionPane.YES_OPTION)
            System.exit(0);
            
        });
        
        add(titulo, BorderLayout.NORTH);
        add(panelBtn,BorderLayout.CENTER);
    }
    private JButton crearBtnRegresar(JPanel panelActual){
        JButton btnRegresar= new JButton("Back");
        btnRegresar.setForeground(new Color(0xD62828));
        btnRegresar.setBorderPainted(false);
        btnRegresar.setFocusPainted(false);
        btnRegresar.addActionListener(e->{
            remove(panelActual);
            add(panelBtn, BorderLayout.CENTER);
            panelBtn.setVisible(true);
            repaint();
            revalidate();
            
        });
        return btnRegresar;
    }
    private void initPlayers(){
        Player maestro1=new Player("Maestro Huan","12345");
        Player maestro2=new Player("Maestro Gín","12345");
        Player maestro3=new Player("Maestro Shan","12345");
        playerManager.registrarPlayer(maestro1);
        playerManager.registrarPlayer(maestro2);
        playerManager.registrarPlayer(maestro3);
        maestro1.sumarPuntos();
        maestro1.sumarPuntos();
        maestro1.sumarPuntos();
        maestro2.sumarPuntos();
        maestro2.sumarPuntos();
        maestro3.sumarPuntos();
        maestro3.sumarPuntos();
        maestro3.sumarPuntos();
    }
}

