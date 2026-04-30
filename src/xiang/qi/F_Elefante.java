package xiang.qi;

import java.util.ArrayList;

/**
 *
 * @author adria
 */
public class F_Elefante extends Ficha{

    public F_Elefante(int columna, int fila, COLOR_FICHA color) {
        super(columna, fila, color);
        tipoFicha=TIPO_FICHA.Elefante;
        spriteX=47;
        this.spriteY=(color.equals(COLOR_FICHA.rojo))?50:1;
        borde=color.color;
        
    }

    @Override
    public ArrayList<Integer[]> movimientosValidos() {
        ArrayList<Integer[]> arrayValidos= new ArrayList<>();
        if(enTablero(col+1,fila+1) && BoardLogico.casillas[col+1][fila+1]==null){
            if(cruzaRio(col+2,fila+2) && esValido(col+2,fila+2))
                arrayValidos.add(new Integer[]{col+2,fila+2});
        }
        if(enTablero(col+1,fila-1) && BoardLogico.casillas[col+1][fila-1]==null){
            if(cruzaRio(col+2,fila-2)&& esValido(col+2,fila-2))
                arrayValidos.add(new Integer[]{col+2,fila-2});
        }
        if(enTablero(col-1,fila+1) && BoardLogico.casillas[col-1][fila+1]==null){
            if(cruzaRio(col-2,fila+2)&& esValido(col-2,fila+2))
                arrayValidos.add(new Integer[]{col-2,fila+2});
        }
        if(enTablero(col-1,fila-1) && BoardLogico.casillas[col-1][fila-1]==null){
            if(cruzaRio(col-2,fila-2)&& esValido(col-2,fila-2))
                arrayValidos.add(new Integer[]{col-2,fila-2});   
        }
        return arrayValidos;
    }
    public boolean cruzaRio(int col,int fila){
        if(color.equals(COLOR_FICHA.negro))
            return !(fila>4);
        else
            return !(fila<5);
    }
    
}
