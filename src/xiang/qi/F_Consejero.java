package xiang.qi;

/**
 *
 * @author adria
 */
public class F_Consejero extends Ficha {

    public F_Consejero(int columna, int fila,  COLOR_FICHA color) {
        super(columna, fila, color);
        this.tipoFicha=TIPO_FICHA.Consejero;
        spriteX=80;
        this.spriteY=(color.equals(COLOR_FICHA.rojo))?0:39;
    }

    @Override
    public void movimientosValidos() {
    }
    
}
