package xiang.qi;

/**
 *
 * @author adria
 */
public class BoardLogico {
    public static Ficha[][] casillas= new Ficha[9][10];
    
    public boolean moverPieza(Ficha f, int col, int fila){
        
    return false;
    }
    public static Ficha[][] getFichas(){
        return casillas;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static  void inicializar(){
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
        casillas[rojoTorre1.col][rojoTorre1.fila]=rojoTorre1;
        casillas[rojoTorre2.col][rojoTorre2.fila]=rojoTorre2;
        casillas[rojoCaballo1.col][rojoCaballo1.fila]=rojoCaballo1;
        casillas[rojoCaballo2.col][rojoCaballo2.fila]=rojoCaballo2;
        casillas[rojoElefante1.col][rojoElefante1.fila]=rojoElefante1;
        casillas[rojoElefante2.col][rojoElefante2.fila]=rojoElefante2;
        casillas[rojoConsejero1.col][rojoConsejero1.fila]=rojoConsejero1;
        casillas[rojoConsejero2.col][rojoConsejero2.fila]=rojoConsejero2;
        casillas[rojoRey.col][rojoRey.fila]=rojoRey;
        casillas[rojoCañon1.col][rojoCañon1.fila]=rojoCañon1;
        casillas[rojoCañon2.col][rojoCañon2.fila]=rojoCañon2;
        casillas[rojoSoldado1.col][rojoSoldado1.fila]=rojoSoldado1;
        casillas[rojoSoldado2.col][rojoSoldado2.fila]=rojoSoldado2;
        casillas[rojoSoldado3.col][rojoSoldado3.fila]=rojoSoldado3;
        casillas[rojoSoldado4.col][rojoSoldado4.fila]=rojoSoldado4;
        casillas[rojoSoldado5.col][rojoSoldado5.fila]=rojoSoldado5;    
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
        casillas[negroTorre1.col][negroTorre1.fila]=negroTorre1;
        casillas[negroTorre2.col][negroTorre2.fila]=negroTorre2;
        casillas[negroCaballo1.col][negroCaballo1.fila]=negroCaballo1;
        casillas[negroCaballo2.col][negroCaballo2.fila]=negroCaballo2;
        casillas[negroElefante1.col][negroElefante1.fila]=negroElefante1;
        casillas[negroElefante2.col][negroElefante2.fila]=negroElefante2;
        casillas[negroConsejero1.col][negroConsejero1.fila]=negroConsejero1;
        casillas[negroConsejero2.col][negroConsejero2.fila]=negroConsejero2;
        casillas[negroRey.col][negroRey.fila]=negroRey;
        casillas[negroCañon1.col][negroCañon1.fila]=negroCañon1;
        casillas[negroCañon2.col][negroCañon2.fila]=negroCañon2;
        casillas[negroSoldado1.col][negroSoldado1.fila]=negroSoldado1;
        casillas[negroSoldado2.col][negroSoldado2.fila]=negroSoldado2;
        casillas[negroSoldado3.col][negroSoldado3.fila]=negroSoldado3;
        casillas[negroSoldado4.col][negroSoldado4.fila]=negroSoldado4;
        casillas[negroSoldado5.col][negroSoldado5.fila]=negroSoldado5;   
    }
}
