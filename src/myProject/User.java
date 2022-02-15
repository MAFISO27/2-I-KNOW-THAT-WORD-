package myProject;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Miguel Angel Figueroa Solarte miguel.figueroa@correounivalle.edu.co
 * @version @version v.1.2.0 date: 12/02/2022
 */
public class User {
    FileManager fileManager= new FileManager();
    private String nombre;
    private int nivel;

    /**
     * constructor of User class
     */
    public User (String nombre,int nivel){
        this.nombre=nombre;
        this.nivel=nivel;

    }
//    public User(){
//
//    }

    public String getNombre(){ return nombre; }

    public int getNivelDelJugador(){ return nivel; }

    public void setNivelDelJugador(int nivelJugador){

        nivel=nivelJugador;
    }

    /**
     * Este método registra los datos del usuario en el archivo .txt
     */

    public void guardar(){
        fileManager.escribirTexto(nombre);
        fileManager.escribirTexto(String.valueOf(nivel));
    }

}
