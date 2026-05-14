package xiang.qi;

import java.util.ArrayList;

/**
 *
 * @author adria
 */
public interface Gestionable {
    public void registrarPlayer(Player player);
    public boolean existePlayer(String userName);
    public Player LogIn(String userName, String password);
    public void eliminarPlayer(String username);
    public ArrayList<Player> getRanking();
    public void agregarLog(Player p, Log log);
    public Player buscarPlayer(String userName);
    public ArrayList<Player> getPlayersActive(Player excluir);
}
