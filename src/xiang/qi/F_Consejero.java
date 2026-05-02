package xiang.qi;

import java.util.ArrayList;

/**
 *
 * @author adria
 */
public class F_Consejero extends Ficha {

    public F_Consejero(int columna, int fila,  COLOR_FICHA color) {
        super(columna, fila, color);
        setTipoFicha(TIPO_FICHA.Consejero);
        setSpriteX(96);
    }

    @Override
    public ArrayList<Integer[]> movimientosValidos() {
        ArrayList<Integer[]> arrayValidos= new ArrayList<>();
            if(enPalacio(getCol()+1,getFila()+1))
                arrayValidos.add(new Integer[]{getCol()+1,getFila()+1});
            if(enPalacio(getCol()+1,getFila()-1))
                arrayValidos.add(new Integer[]{getCol()+1,getFila()-1});
            if(enPalacio(getCol()-1,getFila()+1))
                arrayValidos.add(new Integer[]{getCol()-1,getFila()+1});
            if(enPalacio(getCol()-1,getFila()-1))
                arrayValidos.add(new Integer[]{getCol()-1,getFila()-1});
        
        return arrayValidos;
    }
    
    
}
