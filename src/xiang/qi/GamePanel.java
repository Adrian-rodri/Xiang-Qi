package xiang.qi;

/**
 *
 * @author adria
 */
import java.awt.*;
import javax.swing.*;
public class GamePanel extends JPanel {
    protected static JLabel lblFichas,lblTurno;
    private Board tablero;
    GamePanel(Player player1, Player player2, Gestionable pM){
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.white);
        GridBagConstraints gbc= new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=1;
        JLabel lblTemp= new JLabel("");
        lblTemp.setPreferredSize(new Dimension(200,3));
        add(lblTemp,gbc);
        
        gbc.gridx=1;
        gbc.gridy=0;
        lblTurno= new JLabel("Turno de: "+player1.getUser()+" - rojo");
        lblTurno.setFont(new Font("Dialogue",Font.BOLD,33));
        add(lblTurno,gbc);
        
        gbc.gridx=1;
        gbc.gridy=1;
        gbc.anchor= GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);
        tablero=new Board(player1,player2,pM);
        tablero.setPreferredSize(new Dimension(700,600));
        add(tablero,gbc);
        
        gbc.gridx=2;
        gbc.gridy=1;
        lblFichas= new JLabel("");
        lblFichas.setForeground(Color.black);
        lblFichas.setFont(new Font("Dialogue",Font.BOLD,15));
        lblFichas.setPreferredSize(new Dimension(200,30));
        add(lblFichas,gbc);
        
        gbc.gridx=2;
        gbc.gridy=0;
        JButton btnRendirse= new JButton("Rendirse");
        btnRendirse.setForeground(Color.red);
        btnRendirse.setFocusPainted(false);
        btnRendirse.setBackground(Color.white);
        btnRendirse.setBorderPainted(false);
        btnRendirse.setPreferredSize(new Dimension(210,30));
        btnRendirse.setFont(new Font("Dialog",Font.BOLD,17));
        add(btnRendirse,gbc);
        btnRendirse.addActionListener(e->{
            int option = JOptionPane.showConfirmDialog(new JFrame(), tablero.getTurnoPlayer().getUser()+" Seguro que quieres rendirte");
            if(option==JOptionPane.YES_OPTION){
                Player retirado=tablero.getTurnoPlayer();
                Player ganador= tablero.getTurnoPlayer().equals(tablero.getPlayer1())?tablero.getPlayer2():tablero.getPlayer1();
                LogRetiro logRetiro= new LogRetiro(ganador.getUser(),retirado.getUser());
                JOptionPane.showMessageDialog(new JFrame(), logRetiro.getGanadorLog().getMensaje());
                retirado.agregarLog(logRetiro);
                ganador.agregarLog(logRetiro.getGanadorLog());
                GameWindow.setMenuPrincipal(player1, pM);
                GameWindow.cambiarPantalla(GameWindow.getMenuprincipal(),"");
            }
        });
    }
   
}
