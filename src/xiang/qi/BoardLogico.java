package xiang.qi;

/**
 *
 * @author adria
 */

public class BoardLogico {
    private static Ficha[][] casillas= new Ficha[9][10];
    private  static Ficha ultimaCapturada= null;
    
    public static Ficha[][] getCasillas(){
        return casillas;
    }

    public static Ficha getUltimaCapturada() {
        return ultimaCapturada;
    }

    public static void setCasilla(int col, int fila, Ficha ficha) {
        BoardLogico.casillas[col][fila]=ficha;
    }

    public static void setUltimaCapturada(Ficha ultimaCapturada) {
        BoardLogico.ultimaCapturada = ultimaCapturada;
    }
    
    public static boolean moverPieza(Ficha f, int col, int fila){
        ultimaCapturada=casillas[col][fila];
        casillas[f.getCol()][f.getFila()]=null;
        casillas[col][fila]=f;
        f.setCol(col);
        f.setFila(fila);
    return ultimaCapturada instanceof F_Rey;
    }
    public static boolean reyesEnfrentados(){
    int colReyRojo=-1, filaReyRojo=-1,colReyNegro=-1, filaReyNegro=-1;
    
    for(int i=0; i<casillas.length; i++){
        for(int j=0; j<casillas[i].length; j++){
            if(casillas[i][j] instanceof F_Rey){
                if(casillas[i][j].getColor()==COLOR_FICHA.rojo){
                    colReyRojo=i; filaReyRojo=j;
                }else{
                    colReyNegro=i; filaReyNegro=j;
                }
            }
        }
    }
    
    if(colReyRojo != colReyNegro)
        return false;
    
    int filaMin= Math.min(filaReyRojo, filaReyNegro)+1;
    int filaMax= Math.max(filaReyRojo, filaReyNegro);
    
    for(int f=filaMin; f<filaMax; f++){
        if(casillas[colReyRojo][f]!=null)
            return false; 
    }
    
    return true; 
}
    public static  void inicializar(){
        casillas=new Ficha[9][10];
        //Rojo
        COLOR_FICHA rojo= COLOR_FICHA.rojo;
        F_Torre rojoTorre1= new F_Torre(0,9,rojo);
        F_Torre rojoTorre2= new F_Torre(8,9,rojo);
        F_Caballo rojoCaballo1= new F_Caballo(1,9,rojo);
        F_Caballo rojoCaballo2= new F_Caballo(7,9,rojo);
        F_Elefante rojoElefante1= new F_Elefante(2,9,rojo);
        F_Elefante rojoElefante2= new F_Elefante(6,9,rojo);
        F_Consejero rojoConsejero1= new F_Consejero(3,9,rojo);
        F_Consejero rojoConsejero2= new F_Consejero(5,9,rojo);
        F_Rey rojoRey= new F_Rey(4,9,rojo);
        F_Cañon rojoCañon1= new F_Cañon(1,7,rojo);
        F_Cañon rojoCañon2= new F_Cañon(7,7,rojo);
        F_Soldado rojoSoldado1= new F_Soldado(0,6,rojo);
        F_Soldado rojoSoldado2= new F_Soldado(2,6,rojo);
        F_Soldado rojoSoldado3= new F_Soldado(4,6,rojo);
        F_Soldado rojoSoldado4= new F_Soldado(6,6,rojo);
        F_Soldado rojoSoldado5= new F_Soldado(8,6,rojo);
        
        /*
        Agregarlas 
        */
        casillas[rojoTorre1.getCol()][rojoTorre1.getFila()]=rojoTorre1;
        casillas[rojoTorre2.getCol()][rojoTorre2.getFila()]=rojoTorre2;
        casillas[rojoCaballo1.getCol()][rojoCaballo1.getFila()]=rojoCaballo1;
        casillas[rojoCaballo2.getCol()][rojoCaballo2.getFila()]=rojoCaballo2;
        casillas[rojoElefante1.getCol()][rojoElefante1.getFila()]=rojoElefante1;
        casillas[rojoElefante2.getCol()][rojoElefante2.getFila()]=rojoElefante2;
        casillas[rojoConsejero1.getCol()][rojoConsejero1.getFila()]=rojoConsejero1;
        casillas[rojoConsejero2.getCol()][rojoConsejero2.getFila()]=rojoConsejero2;
        casillas[rojoRey.getCol()][rojoRey.getFila()]=rojoRey;
        casillas[rojoCañon1.getCol()][rojoCañon1.getFila()]=rojoCañon1;
        casillas[rojoCañon2.getCol()][rojoCañon2.getFila()]=rojoCañon2;
        casillas[rojoSoldado1.getCol()][rojoSoldado1.getFila()]=rojoSoldado1;
        casillas[rojoSoldado2.getCol()][rojoSoldado2.getFila()]=rojoSoldado2;
        casillas[rojoSoldado3.getCol()][rojoSoldado3.getFila()]=rojoSoldado3;
        casillas[rojoSoldado4.getCol()][rojoSoldado4.getFila()]=rojoSoldado4;
        casillas[rojoSoldado5.getCol()][rojoSoldado5.getFila()]=rojoSoldado5;    
        //Negro
        COLOR_FICHA negro= COLOR_FICHA.negro;
        F_Torre negroTorre1= new F_Torre(0,0,negro);
        F_Torre negroTorre2= new F_Torre(8,0,negro);
        F_Caballo negroCaballo1= new F_Caballo(1,0,negro);
        F_Caballo negroCaballo2= new F_Caballo(7,0,negro);
        F_Elefante negroElefante1= new F_Elefante(2,0,negro);
        F_Elefante negroElefante2= new F_Elefante(6,0,negro);
        F_Consejero negroConsejero1= new F_Consejero(3,0,negro);
        F_Consejero negroConsejero2= new F_Consejero(5,0,negro);
        F_Rey negroRey= new F_Rey(4,0,negro);
        F_Cañon negroCañon1= new F_Cañon(1,2,negro);
        F_Cañon negroCañon2= new F_Cañon(7,2,negro);
        F_Soldado negroSoldado1= new F_Soldado(0,3,negro);
        F_Soldado negroSoldado2= new F_Soldado(2,3,negro);
        F_Soldado negroSoldado3= new F_Soldado(4,3,negro);
        F_Soldado negroSoldado4= new F_Soldado(6,3,negro);
        F_Soldado negroSoldado5= new F_Soldado(8,3,negro);
        
        /*
        Agregarlas 
        */
        casillas[negroTorre1.getCol()][negroTorre1.getFila()]=negroTorre1;
        casillas[negroTorre2.getCol()][negroTorre2.getFila()]=negroTorre2;
        casillas[negroCaballo1.getCol()][negroCaballo1.getFila()]=negroCaballo1;
        casillas[negroCaballo2.getCol()][negroCaballo2.getFila()]=negroCaballo2;
        casillas[negroElefante1.getCol()][negroElefante1.getFila()]=negroElefante1;
        casillas[negroElefante2.getCol()][negroElefante2.getFila()]=negroElefante2;
        casillas[negroConsejero1.getCol()][negroConsejero1.getFila()]=negroConsejero1;
        casillas[negroConsejero2.getCol()][negroConsejero2.getFila()]=negroConsejero2;
        casillas[negroRey.getCol()][negroRey.getFila()]=negroRey;
        casillas[negroCañon1.getCol()][negroCañon1.getFila()]=negroCañon1;
        casillas[negroCañon2.getCol()][negroCañon2.getFila()]=negroCañon2;
        casillas[negroSoldado1.getCol()][negroSoldado1.getFila()]=negroSoldado1;
        casillas[negroSoldado2.getCol()][negroSoldado2.getFila()]=negroSoldado2;
        casillas[negroSoldado3.getCol()][negroSoldado3.getFila()]=negroSoldado3;
        casillas[negroSoldado4.getCol()][negroSoldado4.getFila()]=negroSoldado4;
        casillas[negroSoldado5.getCol()][negroSoldado5.getFila()]=negroSoldado5;   
    }
}
