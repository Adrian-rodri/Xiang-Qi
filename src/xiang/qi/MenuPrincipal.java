package xiang.qi;

/**
 *
 * @author adria
 */

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Calendar;
import javax.imageio.ImageIO;
public class MenuPrincipal extends JPanel{
    private Gestionable playerManager= new PlayerManager();
    private Color txt= new Color(0x699BC9);
    private Color btn= Color.white;
    private Font fbtn= new Font("STXihei",Font.BOLD,17);
    private BufferedImage imgBgr;
    private int contador;
    private static CardLayout cardLayout= new CardLayout();
    
    MenuPrincipal(Player player, Gestionable playerManager){
        this.playerManager=playerManager;
        this.setBackground(new Color(0x82B1DB));
        setLayout(new BorderLayout());
        try{
            imgBgr= ImageIO.read(getClass().getResourceAsStream("/recursos/fondo.png"));
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        /* 
        Panel Central
        */
        JPanel panelCentro= new JPanel(cardLayout);
        /*
        Pnael Perfil
        */
        JPanel panelPerfil =new JPanel(new GridBagLayout());
        panelPerfil.setBackground(Color.white);
        GridBagConstraints gbc = new GridBagConstraints();
        //titulo
        gbc.gridx=1;
        gbc.gridy=0;
        gbc.anchor=GridBagConstraints.NORTH;
        gbc.gridwidth=1;
        gbc.insets= new Insets(40,0,1,0);
        JLabel lblMiCuenta= new JLabel("Mi Cuenta");
        lblMiCuenta.setFont(new Font("Candara", Font.BOLD,30));
        panelPerfil.add(lblMiCuenta, gbc);
        //Info del player
        gbc.anchor=GridBagConstraints.NORTHWEST;
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.insets= new Insets(15,10,15,10);
        JLabel lblNombre= new JLabel("Username: "+player.getUser());
        lblNombre.setFont(fbtn);
        panelPerfil.add(lblNombre,gbc);
        
        gbc.gridy=2;
        JLabel lblPuntos= new JLabel("Puntos: "+ player.getPuntos());
        lblPuntos.setFont(fbtn);
        panelPerfil.add(lblPuntos,gbc);
        
        gbc.gridy=3;
        JLabel lblPartidas= new JLabel("Partidas Jugadas: "+ player.getLogs().size());
        lblPartidas.setFont(fbtn);
        panelPerfil.add(lblPartidas,gbc);
        gbc.gridy=4;
        Calendar fechaTemp= player.getFechaIngreso();
        JLabel lblFecha= new JLabel("Ingreso en: "+ fechaTemp.get(Calendar.DAY_OF_MONTH)+"/"+(fechaTemp.get(Calendar.MONTH)+1)+"/"+fechaTemp.get(Calendar.YEAR));
        lblFecha.setFont(fbtn);
        panelPerfil.add(lblFecha,gbc);
        
        gbc.gridy=5;
        gbc.insets= new Insets(300,10,10,10);
        JButton btnActPass= new JButton("Cambiar Contraseña");
        btnActPass.setFont(fbtn);
        btnActPass.setForeground(Color.white);
        btnActPass.setBackground(new Color(0xD62828));
        btnActPass.setBorderPainted(false);
        panelPerfil.add(btnActPass,gbc);
        
        gbc.gridy=6;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.insets= new Insets(10,10,10,10);
        JButton btnDel= new JButton("Elminar Cuenta");
        btnDel.setForeground(Color.white);
        btnDel.setBorderPainted(false);
        btnDel.setFont(fbtn);
        btnDel.setBackground(new Color(0xD62828));
        panelPerfil.add(btnDel,gbc);
        
        gbc.gridheight=6;
        gbc.gridx=1;
        gbc.gridy=1;
        gbc.weightx=0.6;
        gbc.weighty=1;
        gbc.fill=GridBagConstraints.BOTH;
        JPanel panelActPass= new JPanel(new FlowLayout(FlowLayout.CENTER,100,10));
        panelActPass.setBackground(Color.white);
        panelPerfil.add(panelActPass,gbc);
        
        gbc.gridx=0;
        gbc.gridy=7;
        gbc.gridheight=1;
        gbc.weightx=0.0;
        gbc.weighty=1.0;
        gbc.fill=GridBagConstraints.VERTICAL;
        panelPerfil.add(new JLabel(""), gbc);
        
        JLabel lblConfirmPass= new JLabel("Ingrese su contraseña");
        lblConfirmPass.setFont(fbtn);
        lblConfirmPass.setVisible(false);
        
        JTextField txtConfirmPass= new JTextField();
        txtConfirmPass.setFont(new Font("Arial",Font.PLAIN,15));
        txtConfirmPass.setVisible(false);
        
        JLabel lblConfirm= new JLabel("Confirme que es usted");
        lblConfirm.setFont(fbtn);
        lblConfirm.setVisible(false);
        
        JButton btnConfirm= new JButton("Confirmar");
        btnConfirm.setFont(fbtn);
        btnConfirm.setBackground(Color.white);
        btnConfirm.setBorderPainted(false);
        btnConfirm.setFocusPainted(false);
        btnConfirm.setForeground(txt);
        btnConfirm.setVisible(false);
        btnConfirm.addActionListener(e->{
            String tempPass= txtConfirmPass.getText();
            if(tempPass.isEmpty())
                return;
            if(!tempPass.equals(player.getPassword())){
                JOptionPane.showMessageDialog(new JFrame(), "Contraseña Incorrecta");
                return;
            }
            playerManager.eliminarPlayer(player.getUser());
            JOptionPane.showMessageDialog(new JFrame(), "Se elimino su cuenta");
            GameWindow.cambiarPantalla(GameWindow.menuInicio, "");
            txtConfirmPass.setText("");
        });
        
        JButton btnCambiar= new JButton("Cambiar Contraseña");
        btnCambiar.setFont(fbtn);
        btnCambiar.setBackground(Color.white);
        btnCambiar.setBorderPainted(false);
        btnCambiar.setFocusPainted(false);
        btnCambiar.setForeground(txt);
        btnCambiar.setVisible(false);
        btnCambiar.addActionListener(e->{
            String newPassTxt=txtConfirmPass.getText();
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
            player.setPassword(newPassTxt);
            JOptionPane.showMessageDialog(new JFrame(), "Se cambio su contraseña");
            txtConfirmPass.setText("");
        });
        JLabel lblTemp= new JLabel("");
        lblTemp.setVisible(true);
        
        panelActPass.add(lblConfirm);
        panelActPass.add(lblTemp);
        panelActPass.add(lblConfirmPass);
        panelActPass.add(txtConfirmPass).setPreferredSize(new Dimension(200,20));
        panelActPass.add(btnConfirm).setPreferredSize(new Dimension(200,20));
        panelActPass.add(btnCambiar).setPreferredSize(new Dimension(300,20));
        
        btnActPass.addActionListener(e->{
            String passConfirm= JOptionPane.showInputDialog(new JFrame(),"Ingrese su Contraseña Actual","Confirme que es usted",JOptionPane.OK_OPTION);
           
            if(passConfirm!=null && passConfirm.equals(player.getPassword())){
                lblConfirm.setText("Cambiar Contraseña");
                lblConfirmPass.setText("Ingrese la nueva contraseña");
                lblTemp.setText("               ");
                lblConfirm.setVisible(true);
                lblConfirmPass.setVisible(true);
                txtConfirmPass.setText("");
                txtConfirmPass.setVisible(true);
                btnCambiar.setVisible(true);
                btnConfirm.setVisible(false);
            }
        });
        btnDel.addActionListener(e->{
            int opcion= JOptionPane.showConfirmDialog(new Frame(), "Seguro que quieres elimnar tu cuenta?");
            
            if(opcion==JOptionPane.YES_OPTION){
                btnCambiar.setVisible(false);
                lblConfirm.setText("Confirme que es Usted");
                lblConfirmPass.setText("Ingrese su contraseña");
                lblConfirmPass.setVisible(true);
                txtConfirmPass.setText("");
                txtConfirmPass.setVisible(true);
                lblConfirm.setVisible(true);
                btnConfirm.setVisible(true);
                repaint();
                revalidate();
            }
        });
        /*
        Panel Reporte
        */
        JPanel panelReport= new JPanel(new GridBagLayout());
        gbc= new GridBagConstraints();
        panelReport.setBackground(btn);
        gbc.anchor=GridBagConstraints.NORTHWEST;
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.insets= new Insets(40,10,10,10);
        JLabel lblReport= new JLabel("Reportes");
        lblReport.setFont(new Font("Candara", Font.BOLD,30));
        panelReport.add(lblReport,gbc);
        
        gbc.insets= new Insets(10,10,10,10);
        gbc.gridy=1;
        JLabel lblLog= new JLabel("Mis Ultimos Juegos");
        lblLog.setFont(fbtn);
        panelReport.add(lblLog,gbc);
        
        gbc.gridx=1;
        JLabel lblRank= new JLabel("Ranking de Jugadores");
        lblRank.setFont(fbtn);
        panelReport.add(lblRank,gbc);
        
        gbc.insets= new Insets(10,10,10,200);
        gbc.gridy=2;
        gbc.gridx=0;
        gbc.gridheight=4;
        gbc.weighty=0.8;
        gbc.weightx=0.1;
        gbc.fill=GridBagConstraints.BOTH;
        JTextArea txtLogs=  new JTextArea();
        txtLogs.setBackground(new Color(0xDFF1F1));
        txtLogs.setEditable(false);
        txtLogs.setFocusable(false);
        txtLogs.setLineWrap(true);
        txtLogs.setWrapStyleWord(true);
        txtLogs.setMargin(new Insets(10, 40, 10, 10));
        txtLogs.setFont(new Font("Monospaced", Font.PLAIN, 14));
        String txtActLog="";
        if(player.getLogs().isEmpty())
            txtActLog= "AUN NO HAS JUGADO";
        for(String l:player.getLogs()){
            txtActLog+=l+"\n";
        }
        txtLogs.setText(txtActLog);
        panelReport.add(txtLogs,gbc);
        
        gbc.gridx=1;
        gbc.weightx=0.5;
        gbc.insets= new Insets(10,10,10,10);
        JTextArea txtRank=  new JTextArea();
        txtRank.setEditable(false);
        txtRank.setFocusable(false);
        txtRank.setBackground(new Color(0xDFF1F1));
        txtRank.setFont(new Font("Monospaced", Font.PLAIN, 14));
        txtRank.setMargin(new Insets(2, 2, 2, 2));
        String txtRanks="";
        int index=1;
        for(int i =playerManager.getRanking().size()-1; i>=0;i--){
            txtRanks+=String.format(index+" - %-12s Pts: %d%n",playerManager.getRanking().get(i).getUser(),playerManager.getRanking().get(i).getPuntos());
            index++;
        }
        txtRank.setText(txtRanks);
        panelReport.add(txtRank,gbc);
        gbc.gridx=0;
        gbc.gridy=7;
        gbc.weighty=0.2;
        panelReport.add(new JLabel(""),gbc);
        
        gbc.gridx=1;
        
        
        panelCentro.add(panelReport,"Reporte");
        panelCentro.add(panelPerfil,"Perfil");
        
        //imagen
        Image imgD= imgBgr.getScaledInstance(1280,720,Image.SCALE_SMOOTH);
        ImageIcon icon= new ImageIcon(imgD);
        JLabel lblImagen= new JLabel(icon);
        panelCentro.add(lblImagen,"Imagen");
        cardLayout.show(panelCentro, "Imagen");
        /*
        Panel Izquierdo
        */
        JPanel menu= new JPanel(new FlowLayout(FlowLayout.CENTER,100,10));
        menu.setBackground(btn);
        menu.setBorder(BorderFactory.createEmptyBorder(220,0,0,0));
        menu.setPreferredSize(new Dimension(300, 0));

        JLabel lblTitulo= new JLabel("Xiang Qi Go!");
        lblTitulo.setFont(new Font("Bauhaus 93", Font.PLAIN,30));

        Dimension dBtn= new Dimension(200,40);

        JButton btnPlay= new JButton("Jugar Xiang Qi");
        btnPlay.setPreferredSize(dBtn);
        btnPlay.setBackground(btn);
        btnPlay.setForeground(txt);
        btnPlay.setBorderPainted(false);
        btnPlay.setFont(fbtn);
        btnPlay.setFocusPainted(false);


        JButton btnLog= new JButton("Reportes");
        btnLog.setBackground(btn);
        btnLog.setPreferredSize(dBtn);
        btnLog.setForeground(txt);
        btnLog.setBorderPainted(false);
        btnLog.setFont(fbtn);
        btnLog.setFocusPainted(false);

        JButton btnPerfil= new JButton("Mi cuenta");
        btnPerfil.setPreferredSize(dBtn);
        btnPerfil.setBackground(btn);
        btnPerfil.setForeground(txt);
        btnPerfil.setBorderPainted(false);
        btnPerfil.setFont(fbtn);
        btnPerfil.setFocusPainted(false);

        JButton btnClose= new JButton("Log Out");
        btnClose.setBackground(btn);
        btnClose.setPreferredSize(dBtn);
        btnClose.setForeground(txt);
        btnClose.setBorderPainted(false);
        btnClose.setFont(fbtn);
        btnClose.setFocusPainted(false);



        menu.add(lblTitulo);
        menu.add(btnPlay);
        menu.add(btnPerfil);
        menu.add(btnLog);
        menu.add(btnClose);
        contador =0;
        btnPlay.addActionListener(e->{
            cardLayout.show(panelCentro, "Imagen");
            ArrayList<Player> playersActivos= playerManager.getPlayersActive(player);
            if(playersActivos.isEmpty()){
                JOptionPane.showMessageDialog(new JFrame(), "No hay jugadores para luchar");
                return;
            }
            String[] usernames= new String[playersActivos.size()];
            String[] users= new String[playersActivos.size()];
            for(int i=0;i<playersActivos.size();i++){
                usernames[i]=playersActivos.get(i).getUser()+" - "+playersActivos.get(i).getPuntos() +" pts";
                users[i]=playersActivos.get(i).getUser();
            }
            
            JList<String> lista= new JList<>(usernames);
            JDialog dialog= new JDialog();
            dialog.setSize(new Dimension(300,playersActivos.size()*50));
            dialog.setLocationRelativeTo(null);
            dialog.setModal(true);
            dialog.setTitle("Seleccione un Oponente");
            
            lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            JScrollPane scroll= new JScrollPane(lista);
            JButton btnConfirmPlay= new JButton("Jugar");
            btnConfirmPlay.setBackground(Color.lightGray);
            btnConfirmPlay.addActionListener(ee->{
                int op=lista.getSelectedIndex();
                if(op<0)
                    return;
                GameWindow.cambiarPantalla(new GamePanel(player,playerManager.buscarPlayer(users[op]),playerManager), "");
                dialog.dispose();
            });
            dialog.add(scroll, BorderLayout.CENTER);
            dialog.add(btnConfirmPlay, BorderLayout.SOUTH);
            dialog.setVisible(true);
            
        });
        btnLog.addActionListener(e->{
            cardLayout.show(panelCentro, "Reporte");
        });
        btnClose.addActionListener(e->{
            int option =JOptionPane.showConfirmDialog(new JFrame(), "Seguro que quieres cerrar sesion");
            if(option == JOptionPane.YES_OPTION){
                GameWindow.cambiarPantalla(GameWindow.menuInicio, "");
                
            }
        });
        btnPerfil.addActionListener(e->{
            cardLayout.show(panelCentro,"Perfil");
        });
        add(panelCentro,BorderLayout.CENTER);
        add(menu,BorderLayout.WEST);
        }
    
}
