package xiang.qi;

import java.util.ArrayList;

/**
 *
 * @author adria
 */
public class F_Consejero extends Ficha {

    public F_Consejero(int columna, int fila,  COLOR_FICHA color) {
        super(columna, fila, color);
        this.tipoFicha=TIPO_FICHA.Consejero;
        spriteX=96;
        this.spriteY=(color.equals(COLOR_FICHA.rojo))?50:2;
        borde=color.color;
    }

    @Override
    public ArrayList<Integer[]> movimientosValidos() {
        ArrayList<Integer[]> arrayValidos= new ArrayList<>();
            if(enPalacio(col+1,fila+1))
                arrayValidos.add(new Integer[]{col+1,fila+1});
            if(enPalacio(col+1,fila-1))
                arrayValidos.add(new Integer[]{col+1,fila-1});
            if(enPalacio(col-1,fila+1))
                arrayValidos.add(new Integer[]{col-1,fila+1});
            if(enPalacio(col-1,fila-1))
                arrayValidos.add(new Integer[]{col-1,fila-1});
        
        return arrayValidos;
    }
    
    
}
