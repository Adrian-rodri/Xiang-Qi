package xiang.qi;

import java.util.ArrayList;

/**
 *
 * @author adria
 */
public class F_Cañon extends Ficha {
    private Ficha primeraFicha=null;
    public F_Cañon(int columna, int fila,COLOR_FICHA color){
        super(columna, fila, color);
        tipoFicha= TIPO_FICHA.Cañon;
        spriteX=144;
        this.spriteY=(color.equals(COLOR_FICHA.rojo))?50:1;
        borde=color.color;
        
    }

    @Override
    public ArrayList<Integer[]> movimientosValidos(){
        ArrayList<Integer[]> arrayValidos= new ArrayList<>();
        mover(arrayValidos, col+1,fila,1,0);
        buscarCaptura(arrayValidos,1,0);
        mover(arrayValidos, col-1,fila,-1,0);
        buscarCaptura(arrayValidos,-1,0);
        mover(arrayValidos, col,fila+1,0,1);
        buscarCaptura(arrayValidos,0,1);
        mover(arrayValidos, col,fila-1,0,-1);
        buscarCaptura(arrayValidos,0,-1);
        return arrayValidos;
    }
    public void mover(ArrayList<Integer[]> lista,int col, int fila, int dcol,int dFila){
        primeraFicha=null;
        while(enTablero(col,fila)){
            if(BoardLogico.casillas[col][fila]==null)
                lista.add(new Integer[] {col,fila});
            else{
                primeraFicha=BoardLogico.casillas[col][fila];
                return;
            }
            col+=dcol;
            fila+=dFila;
        }
        
    }
    public void buscarCaptura(ArrayList<Integer[]> lista,int dcol,int dFila){
        if(primeraFicha!=null){
        int colFicha= primeraFicha.col+dcol;
        int filaFicha= primeraFicha.fila+dFila;
        while(enTablero(colFicha,filaFicha)){
            if(BoardLogico.casillas[colFicha][filaFicha]!=null && !BoardLogico.casillas[colFicha][filaFicha].equals(primeraFicha) && !color.equals(BoardLogico.casillas[colFicha][filaFicha].color)){
                lista.add(new Integer[]{colFicha,filaFicha});
                return;
            }else if(BoardLogico.casillas[colFicha][filaFicha]!=null && color.equals(BoardLogico.casillas[colFicha][filaFicha].color))
                return;
            colFicha+=dcol;
            filaFicha+=dFila;
        }
        }
    }
    
}
