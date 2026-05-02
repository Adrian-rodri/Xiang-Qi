package xiang.qi;

import java.util.ArrayList;

/**
 *
 * @author adria
 */
public class F_Torre extends Ficha{

    public F_Torre(int columna, int fila, COLOR_FICHA color){
        super(columna, fila, color);
        setTipoFicha(TIPO_FICHA.Torre);
        setSpriteX(239);
    }

    @Override
    public ArrayList<Integer[]> movimientosValidos(){
        ArrayList<Integer[]> arrayValidos= new ArrayList<>();
        buscarEnDireccion(arrayValidos,getCol()+1,getFila(),1,0);
        buscarEnDireccion(arrayValidos,getCol()-1,getFila(),-1,0);
        buscarEnDireccion(arrayValidos,getCol(),getFila()+1,0,+1);
        buscarEnDireccion(arrayValidos,getCol(),getFila()-1,0,-1);
        return arrayValidos;
    }
    private void buscarEnDireccion(ArrayList<Integer[]> array, int col, int fila, int dcol, int dfila){
        if(!enTablero(col,fila))
            return;
        if(BoardLogico.getCasillas()[col][fila]==null){
            array.add(new Integer[]{col,fila});
            buscarEnDireccion(array,col+dcol,fila+dfila,dcol,dfila);
        }else if(getColor().equals(BoardLogico.getCasillas()[col][fila].getColor()))
            return;
        else{
            array.add(new Integer[]{col,fila});
            return;
        }
    }
    
}
