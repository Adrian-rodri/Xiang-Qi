package xiang.qi;

import java.util.Calendar;

/**
 *
 * @author adria
 */
public class Log {
    private String mensaje;
    private Calendar fecha;
    
    Log(String mensaje){
        this.mensaje=mensaje;
        this.fecha=Calendar.getInstance();
    }
    public String getMensaje(){
        return mensaje;
    }
    public Calendar getFecha(){
        return fecha;
    }
    @Override
    public String toString(){
        return fecha.get(Calendar.DAY_OF_MONTH)+"/"+(fecha.get(Calendar.MONTH)+1)+ "/"+fecha.get(Calendar.YEAR)+ " - "+ mensaje;
    }
}
