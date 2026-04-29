package xiang.qi;

/**
 *
 * @author adria
 */
public class F_Rey extends Ficha {

    public F_Rey(int columna, int fila, COLOR_FICHA color) {
        super(columna, fila, color);
        tipoFicha=TIPO_FICHA.Rey;
        spriteX=0;
        this.spriteY=(color.equals(COLOR_FICHA.rojo))?0:39;
    }

    @Override
    public void movimientosValidos() {
    }
    
}
