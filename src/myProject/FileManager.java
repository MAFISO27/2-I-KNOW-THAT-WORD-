package myProject;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Miguel Angel Figueroa Solarte miguel.figueroa@correounivalle.edu.co
 * @version @version v.1.2.0 date: 12/02/2022
 */

public class FileManager
{
    private FileReader fileReader;
    private BufferedReader input;
    private FileWriter fileWriter;
    private BufferedWriter output;
    public static final String bancoDePalabras = "src/myProject/files/bancoDePalabras.txt";
    public static final String usuariosListados = "src/myProject/files/usuariosListados.txt";


    public ArrayList<String> leerArchivos(String _file)
    {

        ArrayList<String> texto = new ArrayList<>();

        String elArchivoLeido = "";
        if (Objects.equals(_file, "ListaPalabras")) {
            elArchivoLeido = bancoDePalabras;
        } else if (Objects.equals(_file, "ListaUsuarios")) {
            elArchivoLeido = usuariosListados;
        }

        try {
            fileReader = new FileReader(elArchivoLeido);
            input = new BufferedReader(fileReader);
            String line = input.readLine();
            while (line != null) {
                texto.add(line);
                line = input.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return texto;
    }


    public void escribirTexto(String linea)
    {
        try {
            fileWriter = new FileWriter(usuariosListados, true);
            output = new BufferedWriter(fileWriter);
            output.write(linea);
            output.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void actualizarNivel(int posicion, int nivelNuevo)
    {
        try {
            ArrayList<String> usuariosActualizados = leerArchivos("ListaUsuarios");
            String usuarioAntiguo = usuariosActualizados.get(posicion);
            String usuarioActualizado = usuarioAntiguo.substring(0, usuarioAntiguo.lastIndexOf("=") + 1) + nivelNuevo;
            usuariosActualizados.remove(posicion);
            usuariosActualizados.add(posicion, usuarioActualizado);
            fileWriter = new FileWriter(usuariosListados, false);
            output = new BufferedWriter(fileWriter);
            for (String usuariosActualizado : usuariosActualizados) {
                output.write(usuariosActualizado);
                output.newLine();

            }
            output.close();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}