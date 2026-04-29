package xiang.qi;

/**
 *
 * @author adria
 */
public class F_Cañon extends Ficha {

    public F_Cañon(int columna, int fila,COLOR_FICHA color){
        super(columna, fila, color);
        tipoFicha= TIPO_FICHA.Cañon;
        spriteX=120;
        this.spriteY=(color.equals(COLOR_FICHA.rojo))?0:39;
        
    }

    @Override
    public void movimientosValidos(){
    }
    
}
