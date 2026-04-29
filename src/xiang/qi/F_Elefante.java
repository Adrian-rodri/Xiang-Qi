package xiang.qi;

/**
 *
 * @author adria
 */
public class F_Elefante extends Ficha{

    public F_Elefante(int columna, int fila, COLOR_FICHA color) {
        super(columna, fila, color);
        tipoFicha=TIPO_FICHA.Elefante;
        spriteX=40;
        this.spriteY=(color.equals(COLOR_FICHA.rojo))?0:39;
        
    }

    @Override
    public void movimientosValidos() {
    }
    
}
