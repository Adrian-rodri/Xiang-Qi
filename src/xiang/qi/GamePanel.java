package xiang.qi;

/**
 *
 * @author adria
 */
import java.awt.*;
import javax.swing.*;
public class GamePanel extends JPanel {
    static JLabel lblFichas,lblTurno;
    GamePanel(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc= new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=0;
        lblTurno= new JLabel("Turno de: rojo");
        lblTurno.setFont(new Font("Dialogue",Font.BOLD,33));
        add(lblTurno,gbc);
        
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.anchor= GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);
        
        Board tablero=new Board();
        tablero.setPreferredSize(new Dimension(500,600));
        add(tablero,gbc);
        
        gbc.gridx=1;
        gbc.gridy=1;
        lblFichas= new JLabel("Captura una pieza");
        lblFichas.setForeground(Color.red);
        lblFichas.setFont(new Font("Dialogue",Font.BOLD,15));
        lblFichas.setPreferredSize(new Dimension(200,30));
        add(lblFichas,gbc);
        
    }
}
