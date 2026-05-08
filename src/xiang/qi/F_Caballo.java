package xiang.qi;


import java.util.ArrayList;

/**
 *
 * @author adria
 */
public class F_Caballo extends Ficha {

    public F_Caballo(int columna, int fila, COLOR_FICHA color){
        super(columna, fila, color);
        setTipoFicha(TIPO_FICHA.Caballo);
        setSpriteX(288);
    }

    @Override
    public ArrayList<Integer[]> movimientosValidos(){
        ArrayList<Integer[]> arrayValidos= new ArrayList<>();
        if(enTablero(getCol()+1,getFila()) && BoardLogico.getCasillas()[getCol()+1][getFila()]==null){
            if(esValido(getCol()+2,getFila()+1) && !BoardLogico.reyesEnfrentados())
                arrayValidos.add(new Integer[]{getCol()+2,getFila()+1});
        }
        if(enTablero(getCol()+1,getFila()) && BoardLogico.getCasillas()[getCol()+1][getFila()]==null){
            if(esValido(getCol()+2,getFila()-1))
                arrayValidos.add(new Integer[]{getCol()+2,getFila()-1});
        }
        if(enTablero(getCol()-1,getFila()) && BoardLogico.getCasillas()[getCol()-1][getFila()]==null){
            if(esValido(getCol()-2,getFila()+1))
                arrayValidos.add(new Integer[]{getCol()-2,getFila()+1});
        }
        if(enTablero(getCol()-1,getFila()) && BoardLogico.getCasillas()[getCol()-1][getFila()]==null){
            if(esValido(getCol()-2,getFila()-1))
                arrayValidos.add(new Integer[]{getCol()-2,getFila()-1});
        }
        if(enTablero(getCol(),getFila()+1) && BoardLogico.getCasillas()[getCol()][getFila()+1]==null){
            if(esValido(getCol()+1,getFila()+2))
                arrayValidos.add(new Integer[]{getCol()+1,getFila()+2});
        }
        if(enTablero(getCol(),getFila()+1) && BoardLogico.getCasillas()[getCol()][getFila()+1]==null){
            if(esValido(getCol()-1,getFila()+2))
                arrayValidos.add(new Integer[]{getCol()-1,getFila()+2});
        }
        if(enTablero(getCol(),getFila()-1) && BoardLogico.getCasillas()[getCol()][getFila()-1]==null){
            if(esValido(getCol()+1,getFila()-2))
                arrayValidos.add(new Integer[]{getCol()+1,getFila()-2});
        }
        if(enTablero(getCol(),getFila()-1) && BoardLogico.getCasillas()[getCol()][getFila()-1]==null){
            if(esValido(getCol()-1,getFila()-2))
                arrayValidos.add(new Integer[]{getCol()-1,getFila()-2});
        }
        return arrayValidos;   
    }
    
}
