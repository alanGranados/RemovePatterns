import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class EliminarBloques  {
    public static void main(String[] args) {
        //String path = "C:/Users/alan_/Documents/TrackerDocuments/document.txt";
        if (args.length != 1) {
            System.out.println("Uso: java EliminarBloques <ruta_del_archivo>");
            System.exit(1);
        }

        String filePath = args[0];

        try {
            eliminarBloques(filePath);
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
        String searchString = "2023-11-13T";

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

}