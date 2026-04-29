package xiang.qi;

import java.awt.Color;

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
        borde=Color.black;
    }
    @Override
    public abstract void movimientosValidos();
}
