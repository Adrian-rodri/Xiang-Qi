package xiang.qi;

import java.util.ArrayList;

/**
 *
 * @author adria
 */
public class F_Rey extends Ficha {

    public F_Rey(int columna, int fila, COLOR_FICHA color) {
        super(columna, fila, color);
        tipoFicha=TIPO_FICHA.Rey;
        spriteX=0;
        this.spriteY=(color.equals(COLOR_FICHA.rojo))?50:1;
        borde=color.color;
    }

    @Override
    public ArrayList<Integer[]> movimientosValidos() {
        ArrayList<Integer[]> arrayValidos= new ArrayList<>();
        if(enPalacio(col,fila+1))
            arrayValidos.add(new Integer[]{col,fila+1});
        if(enPalacio(col,fila-1))
            arrayValidos.add(new Integer[]{col,fila-1});
        if(enPalacio(col+1,fila))
            arrayValidos.add(new Integer[]{col+1,fila});
        if(enPalacio(col-1,fila))
            arrayValidos.add(new Integer[]{col-1,fila});
        return arrayValidos;
    }
    
}
