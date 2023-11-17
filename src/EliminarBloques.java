import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class EliminarBloques  {
    public static void main(String[] args) {
        MetodosLimpieza metodosLimpieza = new MetodosLimpieza();
        //String filePath = "C:/Users/alan.granados/Documents/TrakcerDocuments/document.txt";
        //String filePath = "C:/Users/alan_/Documents/TrackerDocuments/document.txt";
        //Aqui va la direccion del archivo
        String filePath = "C:/Users/alan_/Documents/TrackerDocuments/document.txt";
        try {
            metodosLimpieza.eliminarBloques(filePath);
            metodosLimpieza.eliminarLineasConPatron(filePath, " ms,");
            metodosLimpieza.eliminarSaltosDeLineaMultiples(filePath);
            metodosLimpieza.quitarEspaciosAlInicio(filePath);
            metodosLimpieza.encontrarBloquesRepetidos(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}