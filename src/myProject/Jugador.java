package myProject;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Miguel Angel Figueroa Solarte miguel.figueroa@correounivalle.edu.co
 * @version @version v.1.2.0 date: 12/02/2022
 */
public class Jugador {
    private FileManager fileManager;
    private ArrayList<String> listaDeJugadores;
    private String userName;
    private boolean existeUsuario;


    public Jugador (String playerName){

        fileManager = new FileManager();
        listaDeJugadores = new ArrayList<>();
        listaDeJugadores = fileManager.leerArchivos("ListaUsuarios");
        userName = playerName;
        existeUsuario = false;

    }
    public ArrayList<String> getListaDeJugadores() {
        return listaDeJugadores;
    }



    public boolean determinarExistenciaJugador() {
        if (buscarJugador()!=-1)
            existeUsuario = true;
        return existeUsuario;
    }


    private int buscarJugador(){
        int posicion = -1;
        int i = 0;
        while (i < listaDeJugadores.size() && !Objects.equals(listaDeJugadores.get(i), " ")) {
            String auxJugador = listaDeJugadores.get(i).substring(0, listaDeJugadores.get(i).lastIndexOf("="));
            if (auxJugador.equals(userName)){
                posicion=i;
                break;
            }

            i++;
        }
        return posicion;
    }


    public void registrarJugador()
    {
        fileManager.escribirTexto(userName + "=" + 0);
        listaDeJugadores.add(userName+ "="+ 0);
    }

    public int getNivelDelJugador(){
        String usuario= listaDeJugadores.get(buscarJugador());
        String nivelesEnString=usuario.substring(usuario.lastIndexOf("=")+1);
        return Integer.parseInt(nivelesEnString);
    }


    public int setNivelDelJugador(){
        if(getNivelDelJugador()<10){
            fileManager.actualizarNivel(buscarJugador(),getNivelDelJugador()+1);
        }else{
            fileManager.actualizarNivel(buscarJugador(),0);
        }
        return getNivelDelJugador();
    }


}
