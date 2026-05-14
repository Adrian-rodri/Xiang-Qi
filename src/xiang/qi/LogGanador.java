package xiang.qi;

/**
 *
 * @author adria
 */
public class LogGanador extends Log{
    private final int puntosGanados=3;
    public LogGanador(String ganador, String perdedor) {
        super(ganador+ " VENCIO A "+ perdedor+", FELCIDADES HAS GANADO 3 PUNTOS");
    }
    public LogGanador(String ganador, String retirado,boolean esRetiro) {
        super(retirado+" SE HA RETIRADO, FELCIDADES "+ganador+" HAS GANADO 3 PUNTOS");
    }
    public int getpuntosGanados(){
        return puntosGanados;
    }
    
}
