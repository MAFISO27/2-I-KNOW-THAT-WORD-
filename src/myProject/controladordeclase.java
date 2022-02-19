package myProject;

import java.util.ArrayList;
import java.util.Random;


/**
 * @author Miguel Angel Figueroa Solarte miguel.figueroa@correounivalle.edu.co
 * @version @version v.1.2.0 date: 12/02/2022
 */
public class controladordeclase {

    private Enciclopedia diccionario;

    private ArrayList<String> palabrasAMostrar = new ArrayList<>();
    private boolean contadorNiveles;
    private Jugador miUsuario;

    String nombreUsuario;
    int nivelesAprobados, nivelActual, cantPalabrasDelNivel, aciertos, contadorPalabrasCorrectas, contadorPalabrasAleatorias;
    double porcentajeAciertos;
    private ArrayList<String> arraListPalabrasCorrectas = new ArrayList<>();
    private ArrayList<String> arraListPalabrasIncorrectas = new ArrayList<>();
    private ArrayList<String> arrayDePalabrasAleatorias = new ArrayList<>();
    boolean nuevoUsuario;


    /**
     * Constructor of class
     */
    public controladordeclase() {

    }

    public void buscarJugador(String nombreJugador) {
        diccionario = new Enciclopedia();
        nuevoUsuario = false;
        nombreUsuario = nombreJugador;
        miUsuario = new Jugador(nombreUsuario);
        if (miUsuario.determinarExistenciaJugador()) {
            nivelesAprobados = miUsuario.getNivelDelJugador();
        } else {
            miUsuario.registrarJugador();
            nuevoUsuario = true;
            nivelesAprobados = 0;
        }

        contadorPalabrasCorrectas = 0;
        contadorNiveles = false;
        if (nivelesAprobados < 8) {
            nivelActual = nivelesAprobados + 1;
        } else {
            nivelActual = nivelesAprobados;
        }
        setNivelActual();

    }

    private void setNivelActual() {
        aciertos = 0;
        if (getApruebaNivel()) {
            nivelActual++;
        }
        asignarCantidadPalabrasPorNivel();
        PorcentajesNivel();
        arraListPalabrasCorrectas = diccionario.generarPalabrasCorrectas(cantPalabrasDelNivel / 2);
        arraListPalabrasIncorrectas = diccionario.generarPalabrasIncorrectas(cantPalabrasDelNivel / 2);
        miArraydePalabrasAleatorias();
    }

    private void asignarCantidadPalabrasPorNivel() {
        switch (nivelActual) {
            case 1-> cantPalabrasDelNivel =20;
            case 2-> cantPalabrasDelNivel =40;
            case 3-> cantPalabrasDelNivel =50;
            case 4-> cantPalabrasDelNivel =60;
            case 5-> cantPalabrasDelNivel =70;
            case 6-> cantPalabrasDelNivel =80;
            case 7-> cantPalabrasDelNivel =100;
            case 8-> cantPalabrasDelNivel =120;
            case 9-> cantPalabrasDelNivel =140;
            case 10-> cantPalabrasDelNivel =200;
        }

    }

    private void miArraydePalabrasAleatorias() {

        palabrasAMostrar.addAll(arraListPalabrasCorrectas);
        palabrasAMostrar.addAll(arraListPalabrasIncorrectas);
        ArrayList<String> auxPalabrasAMostrar = palabrasAMostrar;

        while (auxPalabrasAMostrar.size() > 0) {
            Random random = new Random();
            String palabra = auxPalabrasAMostrar.get(random.nextInt(auxPalabrasAMostrar.size()));
            int auxIndice = auxPalabrasAMostrar.indexOf(palabra);
            arrayDePalabrasAleatorias.add(palabra);
            auxPalabrasAMostrar.remove(auxIndice);
        }
    }

    private void PorcentajesNivel() {
        switch (nivelActual) {
            case 1, 2 -> porcentajeAciertos = 0.7;
            case 3 -> porcentajeAciertos = 0.75;
            case 4, 5 -> porcentajeAciertos = 0.8;
            case 6 -> porcentajeAciertos = 0.85;
            case 7, 8 -> porcentajeAciertos = 0.9;
            case 9 -> porcentajeAciertos = 0.95;

        }
    }

    public void validarPalabraCorrecta(String palabra) {

        int i = 0;
        while (i < arraListPalabrasCorrectas.size()) {
            String elementoListCorrecta = arraListPalabrasCorrectas.get(i);
            if (elementoListCorrecta.equals(palabra)) {
                aciertos++;
                break;
            }
            i++;
        }
    }

    public void validarPalabraIncorrecta(String palabra) {
        int i = 0, arraListPalabrasIncorrectasSize = arraListPalabrasIncorrectas.size();
        while (i < arraListPalabrasIncorrectasSize) {
            String elementoListIncorrecta = arraListPalabrasIncorrectas.get(i);
            if (elementoListIncorrecta.equals(palabra)) {
                aciertos++;
                break;
            }
            i++;
        }
    }

    public String getPalabrasMemorizar() {
        String palabraMemorizar = "";
        if (contadorPalabrasCorrectas < arraListPalabrasCorrectas.size()) {
            palabraMemorizar = arraListPalabrasCorrectas.get(contadorPalabrasCorrectas);
            contadorPalabrasCorrectas++;
        }

        return palabraMemorizar;
    }

    public String getPalabrasAleatorias() {
        String palabraAleatoria = "";
        if (contadorPalabrasAleatorias < arrayDePalabrasAleatorias.size()) {
            palabraAleatoria = arrayDePalabrasAleatorias.get(contadorPalabrasAleatorias);
            int auxIndice = arrayDePalabrasAleatorias.indexOf(palabraAleatoria);
            arrayDePalabrasAleatorias.remove(auxIndice);
        }
        return palabraAleatoria;
    }

    public int getAciertos() {
        return aciertos;
    }

    public boolean getApruebaNivel() {
        return contadorNiveles;
    }

    public int porcentajeAciertos() {
        return ((aciertos * 100) / cantPalabrasDelNivel);
    }

    public int getNivelActual() {
        return nivelActual;
    }

    public void setNivelesAprobados() {

        if (aciertos >= cantPalabrasDelNivel * porcentajeAciertos) {
            nivelesAprobados = miUsuario.setNivelDelJugador();
            contadorNiveles = true;
            setNivelActual();
            contadorPalabrasCorrectas = 0;
        } else {
            contadorNiveles = false;
            contadorPalabrasCorrectas = 0;
            setNivelActual();
        }

    }

}
