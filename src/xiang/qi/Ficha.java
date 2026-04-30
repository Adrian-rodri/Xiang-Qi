package xiang.qi;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author adria
 */
public abstract class Ficha implements Movible{
    int col,fila;
    TIPO_FICHA tipoFicha;
    COLOR_FICHA color;
    int spriteX,spriteY;
    Color borde;
    Ficha(int columna, int fila, COLOR_FICHA color){
        col=columna;
        this.fila=fila;
        this.color=color;
    }
    @Override
    public abstract ArrayList<Integer[]> movimientosValidos();
    public boolean esValido(int col, int fila){
        if(col<0 || col >8 || fila<0 || fila>9)
            return false;
        else if(BoardLogico.casillas[col][fila]!=null){
                if(this.color.equals(BoardLogico.casillas[col][fila].color))
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
}
