package myProject;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author Miguel Angel Figueroa Solarte miguel.figueroa@correounivalle.edu.co
 * @version @version v.1.2.0 date: 12/02/2022
 */
public class Enciclopedia {

    private ArrayList<String> miDiccionario;
    private final ArrayList<String> palabrasCorrectas;
    private final ArrayList<String> palabrasIncorrectas;


    public Enciclopedia() {

        miDiccionario = new ArrayList<>();
        palabrasCorrectas = new ArrayList<>();
        palabrasIncorrectas = new ArrayList<>();

        FileManager fileManager = new FileManager();
        miDiccionario = fileManager.leerArchivos("ListaPalabras");

    }

    public ArrayList<String> generarPalabrasCorrectas(int nroPalabras) {
        IntStream.range(0, nroPalabras).mapToObj(i -> new Random()).mapToInt(random -> random.nextInt(miDiccionario.size())).forEachOrdered(auxIndex -> {
            palabrasCorrectas.add(miDiccionario.get(auxIndex));
            miDiccionario.remove(auxIndex);
        });

        return palabrasCorrectas;
    }

    public ArrayList<String> generarPalabrasIncorrectas(int nroPalabras) {

        IntStream.range(0, nroPalabras).mapToObj(i -> new Random()).mapToInt(random -> random.nextInt(miDiccionario.size())).forEach(auxIndex -> {
            palabrasIncorrectas.add(miDiccionario.get(auxIndex));
            miDiccionario.remove(auxIndex);
        });
        return palabrasIncorrectas;

    }
}
