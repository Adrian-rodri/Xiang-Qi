package xiang.qi;

import java.util.ArrayList;

/**
 *
 * @author adria
 */
public class F_Soldado extends Ficha{
    
    public F_Soldado(int columna, int fila , COLOR_FICHA color){
        super(columna, fila, color);
        tipoFicha= TIPO_FICHA.Soldado;
        spriteX=191;
        this.spriteY=(color.equals(COLOR_FICHA.rojo))?50:1;
        borde=color.color;
    }

    @Override
    public ArrayList<Integer[]> movimientosValidos(){
        ArrayList<Integer[]> arrayValidos= new ArrayList<>();
        if(color.equals(COLOR_FICHA.negro)){
            if(fila<=4){
                if(this.esValido(col, fila+1))
                    arrayValidos.add(new Integer[]{col,fila+1});
            }else if(fila>4){
                if(this.esValido(col, fila+1))
                    arrayValidos.add(new Integer[]{col,fila+1});
                if(this.esValido(col+1, fila))
                    arrayValidos.add(new Integer[]{col+1,fila});
                if(this.esValido(col-1, fila))
                    arrayValidos.add(new Integer[]{col-1,fila});
            }
        }else{
            if(fila>=5){
                if(this.esValido(col, fila-1))
                    arrayValidos.add(new Integer[]{col,fila-1});
            }else if(fila<5){
                if(this.esValido(col, fila-1))
                    arrayValidos.add(new Integer[]{col,fila-1});
                if(this.esValido(col+1, fila))
                    arrayValidos.add(new Integer[]{col+1,fila});
                if(this.esValido(col-1, fila))
                    arrayValidos.add(new Integer[]{col-1,fila});
            }
        }
        return arrayValidos;
        
    }
    
}
