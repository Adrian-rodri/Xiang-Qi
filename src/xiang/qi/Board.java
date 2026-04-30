/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    int txtX, txtY,fichaX,fichaY,bordeX,bordeY,clickX,clickY;
    int tileSize=49;
    int inicio=53;
    Color borde=Color.BLACK;
    Ficha fichita=null;
    
    Board(){
        
        BoardLogico.inicializar();
        Timer timer= new Timer(32,e->{    
            repaint();
        });
        timer.start();
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(fichita!=null)
                    fichita.borde=fichita.color.color;
                clickX =e.getX();
                clickY =e.getY();

                int col =Math.round((float)(clickX - inicio) / tileSize);
                int fila =Math.round((float)(clickY - inicio) / tileSize);

                if (col>=0 && col<BoardLogico.casillas.length && fila>= 0 &&fila<BoardLogico.casillas[0].length) {

                    int centroX =inicio +(col *tileSize);
                    int centroY =inicio +(fila *tileSize);

                    int dx =clickX - centroX;
                    int dy =clickY - centroY;
                    int radio =20; 

                    if ((dx*dx + dy*dy)<=(radio*radio)) {
                        if (BoardLogico.casillas[col][fila] !=null) {
                            fichita= BoardLogico.casillas[col][fila];
                            borde= Color.green;
                            BoardLogico.casillas[col][fila].borde= borde;
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
        try{
        BufferedImage spreedSheet= ImageIO.read(getClass().getResource("/recursos/fichas.png"));
        for(int i=0; i<BoardLogico.casillas.length;i++){
            for(int j=0; j<BoardLogico.casillas[i].length;j++){
                if(BoardLogico.casillas[i][j]==null)
                    continue;
                Ficha fActual=BoardLogico.casillas[i][j];
                
                g2.drawImage(spreedSheet.getSubimage(fActual.spriteX, fActual.spriteY, 42, 42),inicio + (tileSize*fActual.col)-21,inicio+(tileSize*fActual.fila)-20, null);



                //borde
                g2.setColor(fActual.borde);
                g2.setStroke(new BasicStroke(2.0f));
                bordeX=inicio + (tileSize*fActual.col)-21;
                bordeY=inicio+(tileSize*fActual.fila)-21;
                
                g2.drawOval(bordeX, bordeY, 42, 42);



    //            g2.setStroke(new BasicStroke(1.0f));
    //            
    //            g2.setColor(new Color(0xFEDAA4));
    //            fichaX=inicio + (tileSize*fActual.col)-20;
    //            fichaY=inicio+(tileSize*fActual.fila)-20;
    //            g2.fillOval(fichaX, fichaY, 40, 40);
    //            
    //            g2.setColor(fActual.color.color);
    //            g2.setFont(new Font("Dialog",Font.BOLD,30));
    //            String txt=fActual.signo;
    //            txtX= inicio + (tileSize*fActual.col)-15;
    //            txtY= inicio+(tileSize*fActual.fila)+10;
    //            
    //            g2.drawString(txt, txtX,txtY);



            }

        }
        }catch(IOException e){}

    //    for(int i=0; i<=800;i++){
    //        for(int j=0;j<=800;j++){
    //            g2.setColor(Color.red);
    //            g2.drawRect(i, j, 1, 1);
    //            g2.setColor(Color.green);
    //        }
    ////    }
    //    g2.setColor(Color.black);
    //    g2.drawLine(100, 0, 100, 500);
    
        }
}
