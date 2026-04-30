package xiang.qi;

import java.util.ArrayList;

/**
 *
 * @author adria
 */
public class F_Torre extends Ficha{

    public F_Torre(int columna, int fila, COLOR_FICHA color){
        super(columna, fila, color);
        tipoFicha=TIPO_FICHA.Torre;
        spriteX=239;
        spriteY=(color.equals(COLOR_FICHA.rojo)?50:1);
        borde=color.color;
    }

    @Override
    public ArrayList<Integer[]> movimientosValidos(){
        ArrayList<Integer[]> arrayValidos= new ArrayList<>();
        buscarEnDireccion(arrayValidos,col+1,fila,1,0);
        buscarEnDireccion(arrayValidos,col-1,fila,-1,0);
        buscarEnDireccion(arrayValidos,col,fila+1,0,+1);
        buscarEnDireccion(arrayValidos,col,fila-1,0,-1);
        return arrayValidos;
    }
    private void buscarEnDireccion(ArrayList<Integer[]> array, int col, int fila, int dcol, int dfila){
        if(!enTablero(col,fila))
            return;
        if(BoardLogico.casillas[col][fila]==null){
            array.add(new Integer[]{col,fila});
            buscarEnDireccion(array,col+dcol,fila+dfila,dcol,dfila);
        }else if(color.equals(BoardLogico.casillas[col][fila].color))
            return;
        else{
            array.add(new Integer[]{col,fila});
            return;
        }
    }
    
}
