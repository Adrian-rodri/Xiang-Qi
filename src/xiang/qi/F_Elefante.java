package xiang.qi;

import java.util.ArrayList;

/**
 *
 * @author adria
 */
public class F_Elefante extends Ficha{

    public F_Elefante(int columna, int fila, COLOR_FICHA color) {
        super(columna, fila, color);
        setTipoFicha(TIPO_FICHA.Elefante);
        setSpriteX(47);
    }

    @Override
    public ArrayList<Integer[]> movimientosValidos() {
        ArrayList<Integer[]> arrayValidos= new ArrayList<>();
        if(enTablero(getCol()+1,getFila()+1) && BoardLogico.getCasillas()[getCol()+1][getFila()+1]==null){
            if(cruzaRio(getCol()+2,getFila()+2) && esValido(getCol()+2,getFila()+2))
                arrayValidos.add(new Integer[]{getCol()+2,getFila()+2});
        }
        if(enTablero(getCol()+1,getFila()-1) && BoardLogico.getCasillas()[getCol()+1][getFila()-1]==null){
            if(cruzaRio(getCol()+2,getFila()-2)&& esValido(getCol()+2,getFila()-2))
                arrayValidos.add(new Integer[]{getCol()+2,getFila()-2});
        }
        if(enTablero(getCol()-1,getFila()+1) && BoardLogico.getCasillas()[getCol()-1][getFila()+1]==null){
            if(cruzaRio(getCol()-2,getFila()+2)&& esValido(getCol()-2,getFila()+2))
                arrayValidos.add(new Integer[]{getCol()-2,getFila()+2});
        }
        if(enTablero(getCol()-1,getFila()-1) && BoardLogico.getCasillas()[getCol()-1][getFila()-1]==null){
            if(cruzaRio(getCol()-2,getFila()-2)&& esValido(getCol()-2,getFila()-2))
                arrayValidos.add(new Integer[]{getCol()-2,getFila()-2});   
        }
        return arrayValidos;
    }
    public boolean cruzaRio(int col,int fila){
        if(getColor().equals(COLOR_FICHA.Negro))
            return !(fila>4);
        else
            return !(fila<5);
    }
    
}
