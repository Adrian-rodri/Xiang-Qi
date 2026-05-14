package xiang.qi;

/**
 *
 * @author adria
 */
public class LogRetiro extends Log {
    private String ganador;
    private String retirado;
    
    LogRetiro(String ganador,String retirado){
        super(retirado+" TE RETIRASTE DEJANDO COMO GANADOR A "+ganador);
        this.ganador=ganador;
        this.retirado=retirado;
    }
    public LogGanador getGanadorLog(){
        return new LogGanador(ganador,retirado,true);
    }
}
