package xiang.qi;

/**
 *
 * @author adria
 */
public class F_Soldado extends Ficha{

    public F_Soldado(int columna, int fila , COLOR_FICHA color){
        super(columna, fila, color);
        tipoFicha= TIPO_FICHA.Soldado;
        spriteX=160;
        this.spriteY=(color.equals(COLOR_FICHA.rojo))?0:39;
    }

    public void movimientosValidos(){
        
    }
    
}
