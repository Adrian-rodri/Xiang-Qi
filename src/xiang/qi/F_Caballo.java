package xiang.qi;

/**
 *
 * @author adria
 */
public class F_Caballo extends Ficha {

    public F_Caballo(int columna, int fila, COLOR_FICHA color){
        super(columna, fila, color);
        tipoFicha=TIPO_FICHA.Caballo;
        spriteX=240;
        spriteY=(color.equals(COLOR_FICHA.rojo)?0:39);
//        signo=(color.equals(COLOR_FICHA.rojo)?"🐎":"🐎");
    }

    @Override
    public void movimientosValidos(){
        
    }
    
}
