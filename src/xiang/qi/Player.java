
package xiang.qi;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author adria
 */
public final class Player {
    private String user,password;
    private ArrayList<Log> logs= new ArrayList<>();
    private int puntos;
    private boolean activo;
    private Calendar fechaIngreso;
    Player(String userName, String password){
        user=userName;
        this.password=password;
        puntos=0;
        activo=true;
        fechaIngreso=Calendar.getInstance();
    }
    public final void agregarLog(Log log){
        logs.add(0,log);
        if(log instanceof LogGanador){
            sumarPuntos(((LogGanador) log).getpuntosGanados());
        }
    }
    public final void desActivar(){
        activo=false;
    }
    public final void sumarPuntos(int puntos){
        this.puntos+=puntos;
    }
    //Getters
    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Log> getLogs() {
        return logs;
    }

    public int getPuntos() {
        return puntos;
    }

    public boolean isActivo() {
        return activo;
    }

    public Calendar getFechaIngreso() {
        return fechaIngreso;
    }
    //settters
    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLogs(ArrayList<Log> logs) {
        this.logs = logs;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setFechaIngreso(Calendar fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
    
}
