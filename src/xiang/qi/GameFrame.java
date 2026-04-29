package xiang.qi;

/**
 *
 * @author adria
 */
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class GameFrame extends JFrame {
    public static JLabel lblFicha;
    private static JPanel paneles;
    private static CardLayout cardLayout;
    public static MenuInicial menuInicio= new MenuInicial();
    GameFrame(){
        this.setSize(1000,800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        cardLayout= new CardLayout();
        paneles= new JPanel(cardLayout);
        paneles.add(menuInicio,"Inicio");
        add(paneles);
        this.setVisible(true);
    }
    public static void cambiarPantalla(JPanel newPanel, String name){
        paneles.add(newPanel,name);
        cardLayout.show(paneles, name);
    }
}
