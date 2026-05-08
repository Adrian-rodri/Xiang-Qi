package xiang.qi;

import java.util.ArrayList;

/**
 *
 * @author adria
 */
public class F_Soldado extends Ficha{
    
    public F_Soldado(int columna, int fila , COLOR_FICHA color){
        super(columna, fila, color);
        setTipoFicha(TIPO_FICHA.Soldado);
        setSpriteX(192);
    }

    @Override
    public ArrayList<Integer[]> movimientosValidos(){
        ArrayList<Integer[]> arrayValidos= new ArrayList<>();
        if(getColor().equals(COLOR_FICHA.Negro)){
            if(getFila()<=4){
                if(this.esValido(getCol(), getFila()+1))
                    arrayValidos.add(new Integer[]{getCol(),getFila()+1});
            }else if(getFila()>4){
                if(this.esValido(getCol(), getFila()+1))
                    arrayValidos.add(new Integer[]{getCol(),getFila()+1});
                if(this.esValido(getCol()+1, getFila()))
                    arrayValidos.add(new Integer[]{getCol()+1,getFila()});
                if(this.esValido(getCol()-1, getFila()))
                    arrayValidos.add(new Integer[]{getCol()-1,getFila()});
            }
        }else{
            if(getFila()>=5){
                if(this.esValido(getCol(), getFila()-1))
                    arrayValidos.add(new Integer[]{getCol(),getFila()-1});
            }else if(getFila()<5){
                if(this.esValido(getCol(), getFila()-1))
                    arrayValidos.add(new Integer[]{getCol(),getFila()-1});
                if(this.esValido(getCol()+1, getFila()))
                    arrayValidos.add(new Integer[]{getCol()+1,getFila()});
                if(this.esValido(getCol()-1, getFila()))
                    arrayValidos.add(new Integer[]{getCol()-1,getFila()});
            }
        }
        return arrayValidos;
        
    }
    
}
