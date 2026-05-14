package xiang.qi;

/**
 *
 * @author adria
 */
public class LogPerdedor extends Log{
    LogPerdedor(String ganador, String perdedor){
        super(perdedor+" PERDIO, DEJANDO COMO GANADOR A "+ganador);
    }
    
}
