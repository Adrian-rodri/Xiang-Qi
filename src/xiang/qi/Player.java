
package xiang.qi;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author adria
 */
public class Player {
    String user,password;
    ArrayList<String> logs= new ArrayList<>();
    int puntos;
    boolean activo;
    Calendar fechaIngreso;
    Player(String userName, String password){
        user=userName;
        this.password=password;
        puntos=0;
        activo=true;
        fechaIngreso=Calendar.getInstance();
    }
    public void agregarLog(String mensaje){
        logs.add(0,mensaje);
    }
    
    
    public void desActivar(){
        activo=false;
    }
    
}
