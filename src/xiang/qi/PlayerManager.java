package xiang.qi;

import java.util.ArrayList;

/**
 *
 * @author adria
 */
public class PlayerManager implements Gestionable{
    ArrayList<Player> arrayPlayers= new ArrayList<>();
    @Override
    public void registrarPlayer(Player player) {
        if(!existePlayer(player.user)){
            arrayPlayers.add(player);
        }
    }

    @Override
    public boolean existePlayer(String userName) {
        return existePlayer(userName, arrayPlayers.size());
    }
    
    private boolean existePlayer(String userName, int size) {
        if(size==0)
            return false;
        if(arrayPlayers.get(size-1).user.equals(userName))
            return true;
        else
        return existePlayer(userName, size-1);
    }

    @Override
    public Player LogIn(String userName, String password) {
        return LogIn(userName,password, arrayPlayers.size());
    }
    private Player LogIn(String userName, String password,int size) {
        if(size==0)
            return null;
        Player player=arrayPlayers.get(size-1);
        if(player.user.equals(userName)&&player.password.equals(password))
            return player;
        else
            return LogIn(userName, password,size-1);
    }
    @Override
    public void eliminarPlayer(String username) {
        for(int i=0; i<arrayPlayers.size();i++){
            if(arrayPlayers.get(i).user.equals(username))
                arrayPlayers.get(i).desActivar();
        }
    }

    @Override
    public ArrayList<Player> getRanking() {
        ArrayList<Player> rankedArray= new ArrayList<>(arrayPlayers);
        Player temp=null;
        for(int i=0;i<rankedArray.size()-1;i++){
            for(int j=0; j<rankedArray.size()-i-1;j++){
            if(rankedArray.get(j).puntos>rankedArray.get(j+1).puntos){
                temp=rankedArray.get(j);
                rankedArray.set(j, rankedArray.get(j+1));
                rankedArray.set(j+1, temp);
            }
            
            }
        }
        return rankedArray;
    }

    @Override
    public void agregarLog(Player p, String log) {
       if(existePlayer(p.user))
           p.agregarLog(log);
    }
    
}
