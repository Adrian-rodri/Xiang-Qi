package xiang.qi;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.ArrayList;

/**
 *
 * @author adria
 */
public class Board extends JPanel{
    private int bordeX,bordeY,clickX,clickY;
    private int tileSize=49;
    private int inicio=53;
    private Color borde=Color.BLACK;
    private Ficha fichita=null;
    private BufferedImage spriteSheet=null;
    private ArrayList<Integer[]> movimientosActuales= new ArrayList<>();
    private COLOR_FICHA turnoActual= COLOR_FICHA.Rojo;
    private Player player1,player2;
    private Player turnoPlayer;
    private ArrayList<Ficha> arrayCapturadosPlayer1= new ArrayList<>(),arrayCapturadosPlayer2= new ArrayList<>();
    
    Board(Player player1, Player player2, Gestionable pM){
        this.setLayout(null);
        this.setBackground(Color.white);
        this.player1=player1;
        this.player2=player2;
        
        JLabel lblTurno= new JLabel("");
        lblTurno.setBounds(520,260,200,30);
        lblTurno.setForeground(Color.black);
        lblTurno.setFont(new Font("Dialogue",Font.BOLD,15));
        
        
        try{
        spriteSheet= ImageIO.read(getClass().getResource("/recursos/fichas.png"));
        }catch(IOException e){
            System.err.println("Error con imagen: "+ e.getMessage());
        }
        turnoPlayer=turnoActual.equals(COLOR_FICHA.Rojo)?player1:player2;
        BoardLogico.inicializar();
        Timer timer= new Timer(60,e->{    
            repaint();
        });
        timer.start();
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(fichita!=null){
                    fichita.setBorde(fichita.getColor().getColor());
                    clickX =e.getX();
                    clickY =e.getY();

                    int col= Math.round((float)(clickX - inicio)/tileSize);
                    int fila= Math.round((float)(clickY - inicio)/tileSize);
                    
                    for(Integer[] mov:movimientosActuales){
                        if(mov[0]==col && mov[1]==fila){
                            //simulacion
                            Ficha fichaEnDestino= BoardLogico.getCasillas()[col][fila];
                            BoardLogico.setCasilla(fichita.getCol(),fichita.getFila(),null);
                            BoardLogico.setCasilla(col,fila, fichita);

                            if(BoardLogico.reyesEnfrentados()){
                                //reset
                                BoardLogico.setCasilla(fichita.getCol(),fichita.getFila(),fichita);
                                BoardLogico.setCasilla(col, fila, fichaEnDestino);
                                movimientosActuales.clear();
                                fichita.setBorde(fichita.getColor().getColor());
                                fichita =null;
                                GamePanel.lblFichas.setForeground(Color.black);
                                GamePanel.lblFichas.setText("Ilegal: Reyes Enfrentados");
                                break;
                                
                            }
                            //restTIO
                            BoardLogico.setCasilla(fichita.getCol(),fichita.getFila(),fichita);
                            BoardLogico.setCasilla(col, fila, fichaEnDestino);
                            boolean gano=BoardLogico.moverPieza(fichita, col, fila);
                            
                            if(gano){
                                Player ganador=turnoPlayer;
                                Player perdedor=(turnoPlayer.equals(player1)?player2:player1);
                                JOptionPane.showMessageDialog(new JFrame(),  ganador.getUser() +" VENCIO A "+ perdedor.getUser()+", FELICIDADES HAS GANADO 3 PUNTOS");
                                pM.agregarLog(perdedor,perdedor.getUser()+" PERDIO, DEJANDO COMO GANADOR A "+ ganador.getUser());
                                pM.agregarLog(ganador,ganador.getUser()+" VENCIO A "+perdedor.getUser() +", FELICIDADES HAS GANADO 3 PUNTOS");
                                ganador.sumarPuntos();
                                
                                GameWindow.setMenuPrincipal(player1, pM);
                                GameWindow.cambiarPantalla(GameWindow.getMenuprincipal(),"");
                            }
                            if(BoardLogico.getUltimaCapturada()!=null){
                                if(turnoPlayer.equals(player1))
                                    arrayCapturadosPlayer1.add(BoardLogico.getUltimaCapturada());
                                else
                                     arrayCapturadosPlayer2.add(BoardLogico.getUltimaCapturada());
                                lblTurno.setForeground(BoardLogico.getUltimaCapturada().getColor().equals(COLOR_FICHA.Negro)?Color.red:Color.black);
                                lblTurno.setText(turnoActual.toString() +" capturó "+ BoardLogico.getUltimaCapturada().getTipoFicha().toString());
                            }else {
                                lblTurno.setText("");
                            }
                            turnoActual= fichita.getColor()==COLOR_FICHA.Rojo?COLOR_FICHA.Negro:COLOR_FICHA.Rojo;
                            turnoPlayer=turnoActual.equals(COLOR_FICHA.Rojo)?player1:player2;
                            GamePanel.lblTurno.setText("Turno de: "+  turnoPlayer.getUser() +" - "+ turnoActual.name());
                            
                            break;
                        }
                            
                    }
                    BoardLogico.setUltimaCapturada(null);
                    movimientosActuales.clear();
                    fichita=null;
                    return;
                    
                }
                clickX= e.getX();
                clickY= e.getY();

                int col= Math.round((float)(clickX - inicio) / tileSize);
                int fila= Math.round((float)(clickY - inicio) / tileSize);

                if (col>=0 && col<BoardLogico.getCasillas().length && fila>= 0 &&fila<BoardLogico.getCasillas()[0].length) {

                    int centroX =inicio +(col *tileSize);
                    int centroY =inicio +(fila *tileSize);

                    int dx= clickX - centroX;
                    int dy= clickY - centroY;
                    int radio =20; 

                    if ((dx*dx + dy*dy)<=(radio*radio)) {
                        if (BoardLogico.getCasillas()[col][fila] !=null &&BoardLogico.getCasillas()[col][fila].getColor()==turnoActual) {
                            fichita= BoardLogico.getCasillas()[col][fila];
                            movimientosActuales= fichita.movimientosValidos();
                            borde= Color.green;
                            BoardLogico.getCasillas()[col][fila].setBorde(borde);
                        }
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {   
            }

            @Override
            public void mouseReleased(MouseEvent e) {   
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        
        
        add(lblTurno);
        
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2= (Graphics2D) g;
        //borde grande
        g2.setColor(Color.black);
        g2.fillRect(0, 0,500,550);
        //Rectangulo exterior
        g2.setColor(new Color(0xCE5C00));
        g2.fillRect(4, 4,492,542);
        //rectangulo interior
        g2.setColor(new Color(0xFCAF3E));
        g2.fillRect(54, 54, 390, 441);
        //borde del interior
        g2.setStroke(new BasicStroke(2.0f));
        g2.setColor(Color.black);
        g2.drawRect(53, 53, 392, 442);
        //lineas cuadricula

        for(int i=53;i<500;i+=49){
            g2.drawLine(inicio, i, inicio+(tileSize*8), i);
        }
        for(int i=53;i<448;i+=49){
            g2.drawLine(i, inicio,i, inicio+(tileSize*4));
            g2.drawLine(i, inicio+(tileSize*5),i, inicio+(tileSize*9));
        }
        //lineas cruzadas
        g2.drawLine(inicio+(tileSize*3), inicio, inicio+(tileSize*5), inicio+(tileSize*2));
        g2.drawLine(inicio+(tileSize*5), inicio, inicio+(tileSize*3), inicio+(tileSize*2));
        g2.drawLine(inicio+(tileSize*3), inicio+(tileSize*9), inicio+(tileSize*5), inicio+(tileSize*7));
        g2.drawLine(inicio+(tileSize*5), inicio+(tileSize*9), inicio+(tileSize*3), inicio+(tileSize*7));
        g2.setStroke(new BasicStroke(1.0f));
        //Ficha

        if(spriteSheet!=null){
        for(int i=0; i<BoardLogico.getCasillas().length;i++){
            for(int j=0; j<BoardLogico.getCasillas()[i].length;j++){
                if(BoardLogico.getCasillas()[i][j]==null)
                    continue;
                Ficha fActual=BoardLogico.getCasillas()[i][j];
                //imagen de la ficha
                g2.drawImage(spriteSheet.getSubimage(fActual.getSpriteX(), fActual.getSpriteY(), 42, 42),inicio + (tileSize*fActual.getCol())-21,inicio+(tileSize*fActual.getFila())-20, null);
                //borde
                if(fActual.getBorde().equals(Color.green)){
                    g2.setColor(fActual.getBorde());
                    g2.setStroke(new BasicStroke(2.0f));
                    bordeX=inicio + (tileSize*fActual.getCol())-22;
                    bordeY=inicio+(tileSize*fActual.getFila())-21;
                    g2.drawOval(bordeX, bordeY, 43, 43);
                }
            }

        }
        }
        ArrayList<Integer[]> copia=new ArrayList(movimientosActuales);
        for(Integer[] mov:copia){
            int centroX= inicio+mov[0]*tileSize;
            int centroY= inicio+mov[1]*tileSize;
            g2.setColor(new Color(0,200,0,150));
            g2.fillOval(centroX-10, centroY-10, 20, 20);
        } 
        
        //Cajas de los lados
        //negro
        g2.setColor(new Color(0xCE5C00));
        g2.fillRect(503, 0, 200, 250);
        
        g2.setColor(Color.black);
        g2.fillRect(507, 4, 190, 242);
        g2.setColor(new Color(0xFCAF3E));
        g2.fillRect(527, 10, 150, 228);
        for(int i=0;i<arrayCapturadosPlayer2.size();i++){
            int col= i%3;
            int fila= i/3;
            g2.drawImage(spriteSheet.getSubimage(arrayCapturadosPlayer2.get(i).getSpriteX(), arrayCapturadosPlayer2.get(i).getSpriteY(), 42, 42), 530+(col*45), 10+(fila*50), null);            
        }
        
        //rojo
        g2.setColor(new Color(0xCE5C00));
        g2.setColor(Color.black);
        g2.fillRect(503, 300, 200, 250);
        
        g2.setColor(new Color(0xD10000));
        g2.fillRect(507, 304, 190, 242);
        g2.setColor(new Color(0xFCAF3E));
        g2.fillRect(527, 310, 150, 228);
        
        for(int i=0;i<arrayCapturadosPlayer1.size();i++){
            int col= i%3;
            int fila= i/3;
            g2.drawImage(spriteSheet.getSubimage(arrayCapturadosPlayer1.get(i).getSpriteX(), arrayCapturadosPlayer1.get(i).getSpriteY(), 42, 42) , 530+(col*45),310 +(fila*50), null);
        }
        }
    

    public COLOR_FICHA getTurnoActual() {
        return turnoActual;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Player getTurnoPlayer() {
        return turnoPlayer;
    }
    
}
