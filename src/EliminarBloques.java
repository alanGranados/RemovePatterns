import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class EliminarBloques  {
    public static void main(String[] args) {
        MetodosLimpieza metodosLimpieza = new MetodosLimpieza();
        String filePath = "C:/Users/alan.granados/Documents/TrakcerDocuments/document.txt";

        try {
            eliminarBloques(filePath);
            eliminarLineasConPatron(filePath, " ms,");
            eliminarSaltosDeLineaMultiples(filePath);
            quitarEspaciosAlInicio(filePath);
            metodosLimpieza.encontrarBloquesRepetidos(filePath);
            //encontrarBloquesRepetidos(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void eliminarBloques(String filePath) throws IOException {
        // Lee todas las líneas del archivo
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        /*
        // Obtiene la fecha actual y la formatea
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'");
        String formattedDate = currentDate.format(formatter);*/

        // Construye la cadena de búsqueda
        String searchString = "2023-11-15T";

        // Itera sobre las líneas y elimina las coincidencias junto con las siguientes tres líneas
        Iterator<String> iterator = lines.iterator();
        while (iterator.hasNext()) {
            String line = iterator.next();
            if (line.contains(searchString)) {
                iterator.remove();
                // Elimina las siguientes tres líneas si hay suficientes
                for (int i = 0; i < 3 && iterator.hasNext(); i++) {
                    iterator.next();
                    iterator.remove();
                }
            }
        }

        // Guarda las líneas filtradas en el archivo
        Files.write(Paths.get(filePath), lines);

        System.out.println("Bloques eliminados con éxito.");
    }
    public static void eliminarLineasConPatron(String filePath, String patron) throws IOException {
        // Lee todas las líneas del archivo
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        // Itera sobre las líneas y elimina las que contienen el patrón
        Iterator<String> iterator = lines.iterator();
        while (iterator.hasNext()) {
            String line = iterator.next();
            if (line.contains(patron)) {
                iterator.remove();
            }
        }

        // Guarda las líneas filtradas en el archivo
        Files.write(Paths.get(filePath), lines);

        System.out.println("Líneas con el patrón '" + patron + "' eliminadas con éxito.");
    }
    public static void eliminarSaltosDeLineaMultiples(String filePath) throws IOException {
        // Lee todas las líneas del archivo
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        // Itera sobre las líneas y elimina saltos de línea múltiples
        Iterator<String> iterator = lines.iterator();
        while (iterator.hasNext()) {
            String line = iterator.next();
            if (line.trim().isEmpty()) {
                // Si es una línea vacía, revisa las siguientes líneas
                while (iterator.hasNext() && iterator.next().trim().isEmpty()) {
                    iterator.remove();
                }
            }
        }

        // Guarda las líneas filtradas en el archivo
        Files.write(Paths.get(filePath), lines);

        System.out.println("Saltos de línea múltiples eliminados con éxito.");
    }

    public static void quitarEspaciosAlInicio(String filePath) throws IOException {
        // Lee todas las líneas del archivo
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        // Itera sobre las líneas y quita espacios y tabulaciones al inicio
        for (int i = 0; i < lines.size(); i++) {
            lines.set(i, lines.get(i).replaceAll("^\\s+", ""));
        }

        // Guarda las líneas sin espacios al inicio en el archivo
        Files.write(Paths.get(filePath), lines);

        System.out.println("Espacios y tabulaciones al inicio eliminados con éxito.");
    }
}