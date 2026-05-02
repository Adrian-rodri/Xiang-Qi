package xiang.qi;

import java.util.ArrayList;

/**
 *
 * @author adria
 */
public class F_Rey extends Ficha {

    public F_Rey(int columna, int fila, COLOR_FICHA color) {
        super(columna, fila, color);
        setTipoFicha(TIPO_FICHA.Rey);
        setSpriteX(0);
    }

    @Override
    public ArrayList<Integer[]> movimientosValidos() {
        ArrayList<Integer[]> arrayValidos= new ArrayList<>();
        if(enPalacio(getCol(),getFila()+1))
            arrayValidos.add(new Integer[]{getCol(),getFila()+1});
        if(enPalacio(getCol(),getFila()-1))
            arrayValidos.add(new Integer[]{getCol(),getFila()-1});
        if(enPalacio(getCol()+1,getFila()))
            arrayValidos.add(new Integer[]{getCol()+1,getFila()});
        if(enPalacio(getCol()-1,getFila()))
            arrayValidos.add(new Integer[]{getCol()-1,getFila()});
        return arrayValidos;
    }
    
}
