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
        setTipoFicha(TIPO_FICHA.Cañon);
        setSpriteX(144);
    }

    @Override
    public ArrayList<Integer[]> movimientosValidos(){
        ArrayList<Integer[]> arrayValidos= new ArrayList<>();
        mover(arrayValidos, getCol()+1,getFila(),1,0);
        buscarCaptura(arrayValidos,1,0);
        mover(arrayValidos, getCol()-1,getFila(),-1,0);
        buscarCaptura(arrayValidos,-1,0);
        mover(arrayValidos, getCol(),getFila()+1,0,1);
        buscarCaptura(arrayValidos,0,1);
        mover(arrayValidos, getCol(),getFila()-1,0,-1);
        buscarCaptura(arrayValidos,0,-1);
        return arrayValidos;
    }
    public void mover(ArrayList<Integer[]> lista,int col, int fila, int dcol,int dFila){
        primeraFicha=null;
        while(enTablero(col,fila)){
            if(BoardLogico.getCasillas()[col][fila]==null)
                lista.add(new Integer[] {col,fila});
            else{
                primeraFicha=BoardLogico.getCasillas()[col][fila];
                return;
            }
            col+=dcol;
            fila+=dFila;
        }
        
    }
    public void buscarCaptura(ArrayList<Integer[]> lista,int dcol,int dFila){
        if(primeraFicha!=null){
        int colFicha= primeraFicha.getCol()+dcol;
        int filaFicha= primeraFicha.getFila()+dFila;
        while(enTablero(colFicha,filaFicha)){
            if(BoardLogico.getCasillas()[colFicha][filaFicha]!=null && !BoardLogico.getCasillas()[colFicha][filaFicha].equals(primeraFicha) && !getColor().equals(BoardLogico.getCasillas()[colFicha][filaFicha].getColor())){
                lista.add(new Integer[]{colFicha,filaFicha});
                return;
            }else if(BoardLogico.getCasillas()[colFicha][filaFicha]!=null && getColor().equals(BoardLogico.getCasillas()[colFicha][filaFicha].getColor()))
                return;
            colFicha+=dcol;
            filaFicha+=dFila;
        }
        }
    }
    
}
