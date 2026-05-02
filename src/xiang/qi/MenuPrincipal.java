package xiang.qi;

/**
 *
 * @author adria
 */

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.imageio.ImageIO;
public class MenuPrincipal extends JPanel{
    private Gestionable playerManager= new PlayerManager();
    private Color txt= new Color(0x699BC9);
    private Color btn= Color.white;
    private Font fbtn= new Font("STXihei",Font.BOLD,17);
    private BufferedImage imgBgr;
    private int contador;
    
    MenuPrincipal(Player player, Gestionable playerManager){
        this.playerManager=playerManager;
        this.setBackground(new Color(0x82B1DB));
        setLayout(new BorderLayout());
        try{
        imgBgr= ImageIO.read(getClass().getResourceAsStream("/recursos/fondo.png"));
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        Image imgD= imgBgr.getScaledInstance(1280,720,Image.SCALE_SMOOTH);
        ImageIcon icon= new ImageIcon(imgD);
        JLabel lblImagen= new JLabel(icon);
        add(lblImagen,BorderLayout.CENTER);
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
            System.out.println("Ultimos Juegos");
            for(String l:player.getLogs()){  
                System.out.println(l);
            }
        });
        btnClose.addActionListener(e->{
            int option =JOptionPane.showConfirmDialog(new JFrame(), "Seguro que quieres cerrar sesion");
            if(option == JOptionPane.YES_OPTION){
                GameWindow.cambiarPantalla(GameWindow.menuInicio, "");
                
            }
        });
        
        add(menu,BorderLayout.WEST);
        }
}
