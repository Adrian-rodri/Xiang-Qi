package xiang.qi;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author adria
 */
public abstract class Ficha {
    private int col,fila;
    private TIPO_FICHA tipoFicha;
    private COLOR_FICHA color;
    private int spriteX,spriteY;
    private Color borde;
    
    Ficha(int columna, int fila, COLOR_FICHA color){
        col=columna;
        this.fila=fila;
        this.color=color;
        spriteY=(color.equals(COLOR_FICHA.rojo)?48:0);
        borde=color.getColor();
    }
    public abstract ArrayList<Integer[]> movimientosValidos();
    
    public boolean esValido(int col, int fila){
        if(col<0 || col >8 || fila<0 || fila>9)
            return false;
        else if(BoardLogico.getCasillas()[col][fila]!=null){
                if(this.color.equals(BoardLogico.getCasillas()[col][fila].color))
                    return false;
        }
        return true;
    }
    public boolean enPalacio(int col, int fila){
        if(color.equals(COLOR_FICHA.negro)){
            if(col<3 || col >5 || fila<0 || fila>2)
                return false;
        }else
            if(col<3|| col>5 || fila<7||fila>9)
                return false;
        return this.esValido(col, fila);
    }
    public boolean enTablero(int col, int fila){
        return !(col<0 || col >8 || fila<0 || fila>9);
    }
    //geters 
    public int getCol(){
        return col;
    }
    public int getFila(){
        return fila;
    }
    public TIPO_FICHA getTipoFicha(){
        return tipoFicha;
    }
    public COLOR_FICHA getColor() {
        return color;
    }
    public int getSpriteX() {
        return spriteX;
    }
    public int getSpriteY() {
        return spriteY;
    }
    public Color getBorde() {
        return borde;
    }
    //Setters
    
    public void setCol(int col){
        this.col=col;
    }
    public void setFila(int fila){
        this.fila=fila;
    }
    public void setTipoFicha(TIPO_FICHA tipoFicha){
        this.tipoFicha=tipoFicha;
    }
    public void setColor(COLOR_FICHA color) {
        this.color = color;
    }
    public void setSpriteX(int spriteX) {
        this.spriteX = spriteX;
    }
    public void setSpriteY(int spriteY) {
        this.spriteY = spriteY;
    }
    public void setBorde(Color borde) {
        this.borde = borde;
    }
    
    
}
