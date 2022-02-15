package myProject;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Miguel Angel Figueroa Solarte miguel.figueroa@correounivalle.edu.co
 * @version @version v.1.2.0 date: 12/02/2022
 */
public class Palabra {

    private ArrayList <String> palabras = new ArrayList<String>();


    /**
     * Constructor of Words class
     */

    public Palabra(){
        FileManager fileManager= new FileManager();
        palabras = fileManager.lecturaWordFile();

    }

    /**
     * Método que elige una palabra random dentro del arrayList 'palabras'.
     * el arrayList 'palabras' es creado a partir del archivo bancoDePalabras
     * @return String, retorna la palabra elegida
     */

    public String palabraAleatoria(){
        Random random = new Random();
        return palabras.get(random.nextInt(palabras.size()));

    }

}
