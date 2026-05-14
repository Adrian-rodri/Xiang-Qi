package xiang.qi;

import java.util.ArrayList;

/**
 *
 * @author adria
 */
public class PlayerManager implements Gestionable{
    private ArrayList<Player> arrayPlayers= new ArrayList<>();
    @Override
    public void registrarPlayer(Player player) {
        if(!existePlayer(player.getUser())){
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
        if(arrayPlayers.get(size-1).getUser().equals(userName))
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
        if(player.getUser().equals(userName)&&player.getPassword().equals(password))
            return player;
        else
            return LogIn(userName, password,size-1);
    }
    @Override
    public void eliminarPlayer(String username) {
        for(int i=0; i<arrayPlayers.size();i++){
            if(arrayPlayers.get(i).getUser().equals(username)){
                arrayPlayers.remove(i);
                return;
            }
        }
    }

    @Override
    public ArrayList<Player> getRanking() {
        ArrayList<Player> rankedArray= new ArrayList<>(arrayPlayers);
        Player temp=null;
        for(int i=0;i<rankedArray.size()-1;i++){
            for(int j=0; j<rankedArray.size()-i-1;j++){
            if(rankedArray.get(j).getPuntos()>rankedArray.get(j+1).getPuntos()){
                temp=rankedArray.get(j);
                rankedArray.set(j, rankedArray.get(j+1));
                rankedArray.set(j+1, temp);
            }
            
            }
        }
        return rankedArray;
    }
    @Override
    public Player buscarPlayer(String userName){
        if(existePlayer(userName)){
            for(Player p: arrayPlayers){
                if(p.getUser().equals(userName))
                    return p;
            }
        }
        return null;
    }

    @Override
    public void agregarLog(Player p, Log log) {
       if(existePlayer(p.getUser()))
           p.agregarLog(log);
    }
    
    private ArrayList<Player> getPlayersActive(ArrayList<Player> array, int size, Player excluir){
        if(size>=0){
            if(arrayPlayers.get(size).isActivo() && !arrayPlayers.get(size).equals(excluir))
                array.add(arrayPlayers.get(size));
            return getPlayersActive(array,size-1,excluir);
        }
        return array;
    }

    @Override
    public ArrayList<Player> getPlayersActive(Player excluir) {
        return getPlayersActive(new ArrayList<>(),arrayPlayers.size()-1,excluir);
    }
    
}
