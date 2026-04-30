package xiang.qi;


import java.util.ArrayList;

/**
 *
 * @author adria
 */
public class F_Caballo extends Ficha {

    public F_Caballo(int columna, int fila, COLOR_FICHA color){
        super(columna, fila, color);
        tipoFicha=TIPO_FICHA.Caballo;
        spriteX=288;
        spriteY=(color.equals(COLOR_FICHA.rojo)?50:1);
        borde=color.color;

    }

    @Override
    public ArrayList<Integer[]> movimientosValidos(){
        ArrayList<Integer[]> arrayValidos= new ArrayList<>();
        if(enTablero(col+1,fila) && BoardLogico.casillas[col+1][fila]==null){
            if(esValido(col+2,fila+1))
                arrayValidos.add(new Integer[]{col+2,fila+1});
        }
        if(enTablero(col+1,fila) && BoardLogico.casillas[col+1][fila]==null){
            if(esValido(col+2,fila-1))
                arrayValidos.add(new Integer[]{col+2,fila-1});
        }
        if(enTablero(col-1,fila) && BoardLogico.casillas[col-1][fila]==null){
            if(esValido(col-2,fila+1))
                arrayValidos.add(new Integer[]{col-2,fila+1});
        }
        if(enTablero(col-1,fila) && BoardLogico.casillas[col-1][fila]==null){
            if(esValido(col-2,fila-1))
                arrayValidos.add(new Integer[]{col-2,fila-1});
        }
        if(enTablero(col,fila+1) && BoardLogico.casillas[col][fila+1]==null){
            if(esValido(col+1,fila+2))
                arrayValidos.add(new Integer[]{col+1,fila+2});
        }
        if(enTablero(col,fila+1) && BoardLogico.casillas[col][fila+1]==null){
            if(esValido(col-1,fila+2))
                arrayValidos.add(new Integer[]{col-1,fila+2});
        }
        if(enTablero(col,fila-1) && BoardLogico.casillas[col][fila-1]==null){
            if(esValido(col+1,fila-2))
                arrayValidos.add(new Integer[]{col+1,fila-2});
        }
        if(enTablero(col,fila-1) && BoardLogico.casillas[col][fila-1]==null){
            if(esValido(col-1,fila-2))
                arrayValidos.add(new Integer[]{col-1,fila-2});
        }
        return arrayValidos;
        
    }
    
}
