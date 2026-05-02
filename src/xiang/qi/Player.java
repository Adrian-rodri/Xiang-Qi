
package xiang.qi;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author adria
 */
public final class Player {
    private String user,password;
    private ArrayList<String> logs= new ArrayList<>();
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
    public final void agregarLog(String mensaje){
        logs.add(0,mensaje);
    }
    public final void desActivar(){
        activo=false;
    }
    public final void sumarPuntos(){
        puntos+=3;
    }
    //Getters
    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<String> getLogs() {
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

    public void setLogs(ArrayList<String> logs) {
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
