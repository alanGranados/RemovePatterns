import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MetodosLimpieza {
  List<String> firstBlock = new ArrayList<>();
  List<String> secondBlock = new ArrayList<>();
  List<String> currentBlock = new ArrayList<>();
  // true first false second
  boolean firstOrSecond = true;

  public void encontrarBloquesRepetidos(String filePath) throws IOException {
    boolean newBlock = false;
    List<String> lines = Files.readAllLines(Paths.get(filePath));

    for (String line : lines) {
      if(newBlock){
        // Si esto es true quiere decir que la linea la debemos guardar en la list
        compararYLimpiar(line);
        newBlock = !newBlock;
      }else if (line.trim().isEmpty()) { // Revisamos si la linea esta en blanco
        //Si esto es true la linea siguiente la debemos guardar en la list
        newBlock = !newBlock;
      }
    }
  }

  private void compararYLimpiar(String line) {
    if(firstOrSecond){
      if(firstBlock.contains(line)){
        // Si esto es true debemos acomodar nuestra List
        int index = firstBlock.indexOf(line);
        firstBlock.subList(0,index).clear();
        secondBlock.add(line);
        firstOrSecond = !firstOrSecond;
      }else{
        firstBlock.add(line);
      }
    }else{
      if(firstBlock.size() == secondBlock.size()) {
        // Ya debe de tener el bloque de patrones
        depurarListas();
        listasIguales();
        firstOrSecond = !firstOrSecond;
        firstBlock.add(line);
      } else{
        secondBlock.add(line);
        depurarListas();
        if(firstOrSecond){
          listasIguales();
          firstBlock.add(line);
        }
      }
    }

  }
// EL INICIO SI ESTA BIEN, SOLO QUE AL FINAL LOS ULTIMOS VALORES NO SON IGUALES, ENTONCES DEBO COMPARARLOS UNO CON UNO HASTA DONDE SEA DIFERENTE Y AHI CORTAR E IMPRIMIR
  private void listasIguales() {
    if(firstBlock.equals(secondBlock)){
      System.out.println("Primer Lista===========================================================================");
      firstBlock.forEach(System.out::println);
      System.out.println("Segunda Lista ==========================================================================");
      secondBlock.forEach(System.out::println);
      firstBlock.clear();
      secondBlock.clear();
    }else{
      System.out.println("No son iguales");
    }
  }
  private void depurarListas(){
    //igualarTamanos();
    for(int i = 0; i< secondBlock.size(); i++ ){
      if(!firstBlock.get(i).equals(secondBlock.get(i))){
        firstBlock.subList(i, firstBlock.size()).clear();
        secondBlock.subList(i, secondBlock.size()).clear();
        firstOrSecond = true;
        break;
      }
    }
  }

  public void eliminarBloques(String filePath) throws IOException {
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
  public void eliminarLineasConPatron(String filePath, String patron) throws IOException {
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
  public void eliminarSaltosDeLineaMultiples(String filePath) throws IOException {
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
  public void quitarEspaciosAlInicio(String filePath) throws IOException {
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