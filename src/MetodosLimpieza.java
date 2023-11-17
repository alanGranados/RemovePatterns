import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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
        firstOrSecond = !firstOrSecond;
      }else{
        firstBlock.add(line);
      }
    }else{
      if(secondBlock.contains(line)){
        // Quiere decir que aqui probablemente ya se esta repitiendo el bloque
        listasIguales();
      }else{
        secondBlock.add(line);
      }
    }

  }
// EL INICIO SI ESTA BIEN, SOLO QUE AL FINAL LOS ULTIMOS VALORES NO SON IGUALES, ENTONCES DEBO COMPARARLOS UNO CONM UNO HASTA DONDE SEA DIFERENTE Y AHI CORTAR E IMPRIMIR
  private void listasIguales() {
    if(firstBlock.equals(secondBlock)){
      System.out.println("Primer bloque");
      firstBlock.forEach(System.out::println);
      System.out.println("Segundo bloque");
      secondBlock.forEach(System.out::println);
      firstBlock.clear();
      secondBlock.clear();
    }else{
      firstBlock.clear();
      secondBlock.clear();
      System.out.println("No son iguales");

    }
  }
}
/*
EJEMPLO DE DOC
Procedure EXIS_SERIES_DOCTO:
param0 = integer, "38248"
param1 = integer, "0"

Procedure CUADRA_DISCRETOS_IN:
param0 = integer, "38248"

DOCTOS_IN_BEFINSUPD_RI FOR DOCTOS_IN (BEFORE UPDATE)

DOCTOS_IN_BEFUPD_0 FOR DOCTOS_IN (BEFORE UPDATE)

DOCTOS_IN_BEFINSUPD_1 FOR DOCTOS_IN (BEFORE UPDATE)

DOCTOS_IN_AFTUPD_0 FOR DOCTOS_IN (AFTER UPDATE)

Procedure COMPARA_ENTEROS:
param0 = integer, "<NULL>"
param1 = integer, "<NULL>"

Procedure GET_SIGFOL_CONCEPTO:
param0 = char(2), "IN"
param1 = integer, "26"
param2 = varchar(3), "@"
param3 = integer, "0"

DOCTOS_IN_BEFINSUPD_RI FOR DOCTOS_IN (BEFORE UPDATE)

DOCTOS_IN_BEFUPD_0 FOR DOCTOS_IN (BEFORE UPDATE)

Procedure GET_SN:
param0 = char(1), "S"
param1 = integer, "38248"
param2 = integer, "4"

Procedure CALC_TOTALES:
param0 = char(1), "0"
param1 = integer, "4"

Procedure GET_ELEM_REGISTRY:
param0 = integer, "0"
param1 = varchar(50), "PreferenciasEmpresa"

Procedure GET_ELEM_REGISTRY:
param0 = integer, "208"
param1 = varchar(50), "TOTAL_DOCTOS_4"

DOCTOS_IN_BEFINSUPD_1 FOR DOCTOS_IN (BEFORE UPDATE)

DOCTOS_IN_AFTUPD_0 FOR DOCTOS_IN (AFTER UPDATE)

DOCTOS_IN_DET_BEFUPD_0 FOR DOCTOS_IN_DET

Procedure COMPARA_ENTEROS:
param0 = integer, "<NULL>"
param1 = integer, "<NULL>"

DOCTOS_IN_DET_BEFUPD_0 FOR DOCTOS_IN_DET (BEFORE UPDATE)

Procedure COMPARA_ENTEROS:
param0 = integer, "<NULL>"
param1 = integer, "<NULL>"

DOCTOS_IN_DET_BEFUPD_0 FOR DOCTOS_IN_DET (BEFORE UPDATE)

Procedure COMPARA_ENTEROS:
param0 = integer, "<NULL>"
param1 = integer, "<NULL>"

Procedure APLICA_DOCTO_IN:
param0 = integer, "38248"

Procedure AJUSTA_FECHA_MOVTO_IN_MENOR:
param0 = char(1), "C"
param1 = date, "2023-11-09"

Procedure AJUSTA_FECHA_MOVTO_IN_MENOR:
param0 = char(1), "P"
param1 = date, "2023-11-09"

Procedure APLICA_ENTRADA_IN:
param0 = integer, "38249"

Procedure COSTEA_MOVTO_ENTRADA:
param0 = integer, "38249"

Procedure COSTEA_ENTRADA_IN:
param0 = integer, "38249"
param1 = char(1), "-"

Procedure GET_COSTO_ENTRADA:
param0 = integer, "7234"
param1 = integer, "220"
param2 = char(1), "C"
param3 = integer, "38249"

Procedure GET_CAPAS_COSTEO:
param0 = integer, "7234"
param1 = integer, "220"
param2 = char(1), "C"
param3 = char(1), "S"

Procedure GET_ULTCOM_ART:
param0 = integer, "7234"

Procedure ROUND_PROD:
param0 = double precision, "9999"
param1 = double precision, "0"
param2 = double precision, "0.01"

Procedure ROUND_MIN:
param0 = double precision, "0"
param1 = double precision, "0.01"

DOCTOS_IN_DET_BEFUPD_0 FOR DOCTOS_IN_DET (BEFORE UPDATE)

Procedure COMPARA_ENTEROS:
param0 = integer, "<NULL>"
param1 = integer, "<NULL>"

Procedure AFECTA_CAPA_PROMEDIO:
param0 = integer, "7234"
param1 = integer, "220"
param2 = bigint(*, -5), "9999.00000"
param3 = bigint(*, -2), "0"
param4 = integer, "1"

CAPAS_COSTOS_BEFINS FOR CAPAS_COSTOS (BEFORE INSERT)

CAPAS_COSTOS_BEFINS_0 FOR CAPAS_COSTOS (BEFORE INSERT)

CAPAS_COSTOS_BEFINSUPD_RI FOR CAPAS_COSTOS

Procedure AFECTA_SALDOS_IN:
param0 = integer, "7234"
param1 = integer, "220"
param2 = date, "2023-11-09"
param3 = char(1), "E"
param4 = bigint(*, -5), "9999.00000"
param5 = bigint(*, -2), "0"
param6 = integer, "1"

Procedure DECODIF_FECHA:
param0 = date, "2023-11-09"

Procedure APLICA_ENTRADA_IN:
param0 = integer, "38250"

Procedure COSTEA_MOVTO_ENTRADA:
param0 = integer, "38250"

Procedure COSTEA_ENTRADA_IN:
param0 = integer, "38250"
param1 = char(1), "-"

Procedure GET_COSTO_ENTRADA:
param0 = integer, "7236"
param1 = integer, "220"
param2 = char(1), "C"
param3 = integer, "38250"

Procedure GET_CAPAS_COSTEO:
param0 = integer, "7236"
param1 = integer, "220"
param2 = char(1), "C"
param3 = char(1), "S"

Procedure GET_ULTCOM_ART:
param0 = integer, "7236"

Procedure ROUND_PROD:
param0 = double precision, "9999"
param1 = double precision, "0"
param2 = double precision, "0.01"

DOCTOS_IN_DET_BEFUPD_0 FOR DOCTOS_IN_DET (BEFORE UPDATE)

Procedure COMPARA_ENTEROS:
param0 = integer, "<NULL>"
param1 = integer, "<NULL>"

Procedure AFECTA_CAPA_PROMEDIO:
param0 = integer, "7236"
param1 = integer, "220"
param2 = bigint(*, -5), "9999.00000"
param3 = bigint(*, -2), "0"
param4 = integer, "1"

CAPAS_COSTOS_BEFINS FOR CAPAS_COSTOS (BEFORE INSERT)

CAPAS_COSTOS_BEFINS_0 FOR CAPAS_COSTOS (BEFORE INSERT)

CAPAS_COSTOS_BEFINSUPD_RI FOR CAPAS_COSTOS (BEFORE INSERT)

Procedure AFECTA_SALDOS_IN:
param0 = integer, "7236"
param1 = integer, "220"
param2 = date, "2023-11-09"
param3 = char(1), "E"
param4 = bigint(*, -5), "9999.00000"
param5 = bigint(*, -2), "0"
param6 = integer, "1"

Procedure DECODIF_FECHA:
param0 = date, "2023-11-09"

Procedure APLICA_ENTRADA_IN:
param0 = integer, "38251"

Procedure COSTEA_MOVTO_ENTRADA:
param0 = integer, "38251"

Procedure COSTEA_ENTRADA_IN:
param0 = integer, "38251"
param1 = char(1), "-"

Procedure GET_COSTO_ENTRADA:
param0 = integer, "7238"
param1 = integer, "220"
param2 = char(1), "C"
param3 = integer, "38251"

Procedure GET_CAPAS_COSTEO:
param0 = integer, "7238"
param1 = integer, "220"
param2 = char(1), "C"
param3 = char(1), "S"

Procedure GET_ULTCOM_ART:
param0 = integer, "7238"

Procedure ROUND_PROD:
param0 = double precision, "9999"
param1 = double precision, "0"
param2 = double precision, "0.01"

Procedure ROUND_MIN:
param0 = double precision, "0"
param1 = double precision, "0.01"

DOCTOS_IN_DET_BEFUPD_0 FOR DOCTOS_IN_DET (BEFORE UPDATE)

Procedure COMPARA_ENTEROS:
param0 = integer, "<NULL>"
param1 = integer, "<NULL>"

Procedure AFECTA_CAPA_PROMEDIO:
param0 = integer, "7238"
param1 = integer, "220"
param2 = bigint(*, -5), "9999.00000"
param3 = bigint(*, -2), "0"
param4 = integer, "1"

CAPAS_COSTOS_BEFINS FOR CAPAS_COSTOS (BEFORE INSERT)

CAPAS_COSTOS_BEFINS_0 FOR CAPAS_COSTOS (BEFORE INSERT)

CAPAS_COSTOS_BEFINSUPD_RI FOR CAPAS_COSTOS (BEFORE INSERT)

Procedure AFECTA_SALDOS_IN:
param0 = integer, "7238"
param1 = integer, "220"
param2 = date, "2023-11-09"
param3 = char(1), "E"
param4 = bigint(*, -5), "9999.00000"
param5 = bigint(*, -2), "0"
param6 = integer, "1"

Procedure DECODIF_FECHA:
param0 = date, "2023-11-09"

DOCTOS_IN_BEFINSUPD_RI FOR DOCTOS_IN (BEFORE UPDATE)

DOCTOS_IN_BEFUPD_0 FOR DOCTOS_IN (BEFORE UPDATE)

DOCTOS_IN_BEFINSUPD_1 FOR DOCTOS_IN (BEFORE UPDATE)

DOCTOS_IN_AFTUPD_0 FOR DOCTOS_IN (AFTER UPDATE)

Procedure COMPARA_ENTEROS:
param0 = integer, "<NULL>"
param1 = integer, "<NULL>"

Procedure GET_SIGFOL_CONCEPTO:
param0 = char(2), "IN"
param1 = integer, "26"
param2 = varchar(3), "@"
param3 = integer, "3"

FOLIOS_CONCEPTOS_BEFINSUPD_RI FOR FOLIOS_CONCEPTOS (BEFORE UPDATE)

REGISTRY_BEFUPD FOR REGISTRY (BEFORE UPDATE)

Procedure DOCTOS_IN_SKIP:
param0 = smallint, "2"
param1 = char(1), "E"
param2 = integer, "26"
param3 = char(9), "_00001649"

Procedure DOCTOS_IN_SKIP:
param0 = smallint, "2"
param1 = char(1), "E"
param2 = integer, "26"
param3 = char(9), "000000002"

* */
/*
RESUELTO
Procedure EXIS_SERIES_DOCTO:
param0 = integer, "38248"
param1 = integer, "0"

Procedure CUADRA_DISCRETOS_IN:
param0 = integer, "38248"

DOCTOS_IN_BEFINSUPD_RI FOR DOCTOS_IN (BEFORE UPDATE)

DOCTOS_IN_BEFUPD_0 FOR DOCTOS_IN (BEFORE UPDATE)

DOCTOS_IN_BEFINSUPD_1 FOR DOCTOS_IN (BEFORE UPDATE)

DOCTOS_IN_AFTUPD_0 FOR DOCTOS_IN (AFTER UPDATE)

Procedure COMPARA_ENTEROS:
param0 = integer, "<NULL>"
param1 = integer, "<NULL>"

Procedure GET_SIGFOL_CONCEPTO:
param0 = char(2), "IN"
param1 = integer, "26"
param2 = varchar(3), "@"
param3 = integer, "0"

DOCTOS_IN_BEFINSUPD_RI FOR DOCTOS_IN (BEFORE UPDATE)

DOCTOS_IN_BEFUPD_0 FOR DOCTOS_IN (BEFORE UPDATE)

Procedure GET_SN:
param0 = char(1), "S"
param1 = integer, "38248"
param2 = integer, "4"

Procedure CALC_TOTALES:
param0 = char(1), "0"
param1 = integer, "4"

Procedure GET_ELEM_REGISTRY:
param0 = integer, "0"
param1 = varchar(50), "PreferenciasEmpresa"

Procedure GET_ELEM_REGISTRY:
param0 = integer, "208"
param1 = varchar(50), "TOTAL_DOCTOS_4"

DOCTOS_IN_BEFINSUPD_1 FOR DOCTOS_IN (BEFORE UPDATE)

DOCTOS_IN_AFTUPD_0 FOR DOCTOS_IN (AFTER UPDATE)

DOCTOS_IN_DET_BEFUPD_0 FOR DOCTOS_IN_DET

Procedure COMPARA_ENTEROS:
param0 = integer, "<NULL>"
param1 = integer, "<NULL>"

DOCTOS_IN_DET_BEFUPD_0 FOR DOCTOS_IN_DET (BEFORE UPDATE)

Procedure COMPARA_ENTEROS:
param0 = integer, "<NULL>"
param1 = integer, "<NULL>"

DOCTOS_IN_DET_BEFUPD_0 FOR DOCTOS_IN_DET (BEFORE UPDATE)

Procedure COMPARA_ENTEROS:
param0 = integer, "<NULL>"
param1 = integer, "<NULL>"

Procedure APLICA_DOCTO_IN:
param0 = integer, "38248"

Procedure AJUSTA_FECHA_MOVTO_IN_MENOR:
param0 = char(1), "C"
param1 = date, "2023-11-09"

Procedure AJUSTA_FECHA_MOVTO_IN_MENOR:
param0 = char(1), "P"
param1 = date, "2023-11-09"
================================================
PRIMER BLOQUE DE 3
Procedure APLICA_ENTRADA_IN:
param0 = integer, "38249"

Procedure COSTEA_MOVTO_ENTRADA:
param0 = integer, "38249"

Procedure COSTEA_ENTRADA_IN:
param0 = integer, "38249"
param1 = char(1), "-"

Procedure GET_COSTO_ENTRADA:
param0 = integer, "7234"
param1 = integer, "220"
param2 = char(1), "C"
param3 = integer, "38249"

Procedure GET_CAPAS_COSTEO:
param0 = integer, "7234"
param1 = integer, "220"
param2 = char(1), "C"
param3 = char(1), "S"

Procedure GET_ULTCOM_ART:
param0 = integer, "7234"

Procedure ROUND_PROD:
param0 = double precision, "9999"
param1 = double precision, "0"
param2 = double precision, "0.01"

Procedure ROUND_MIN:
param0 = double precision, "0"
param1 = double precision, "0.01"

DOCTOS_IN_DET_BEFUPD_0 FOR DOCTOS_IN_DET (BEFORE UPDATE)

Procedure COMPARA_ENTEROS:
param0 = integer, "<NULL>"
param1 = integer, "<NULL>"

Procedure AFECTA_CAPA_PROMEDIO:
param0 = integer, "7234"
param1 = integer, "220"
param2 = bigint(*, -5), "9999.00000"
param3 = bigint(*, -2), "0"
param4 = integer, "1"

CAPAS_COSTOS_BEFINS FOR CAPAS_COSTOS (BEFORE INSERT)

CAPAS_COSTOS_BEFINS_0 FOR CAPAS_COSTOS (BEFORE INSERT)

CAPAS_COSTOS_BEFINSUPD_RI FOR CAPAS_COSTOS

Procedure AFECTA_SALDOS_IN:
param0 = integer, "7234"
param1 = integer, "220"
param2 = date, "2023-11-09"
param3 = char(1), "E"
param4 = bigint(*, -5), "9999.00000"
param5 = bigint(*, -2), "0"
param6 = integer, "1"

Procedure DECODIF_FECHA:
param0 = date, "2023-11-09"
================================================
SEGUNDO BLOQUE DE 3
Procedure APLICA_ENTRADA_IN:
param0 = integer, "38250"

Procedure COSTEA_MOVTO_ENTRADA:
param0 = integer, "38250"

Procedure COSTEA_ENTRADA_IN:
param0 = integer, "38250"
param1 = char(1), "-"

Procedure GET_COSTO_ENTRADA:
param0 = integer, "7236"
param1 = integer, "220"
param2 = char(1), "C"
param3 = integer, "38250"

Procedure GET_CAPAS_COSTEO:
param0 = integer, "7236"
param1 = integer, "220"
param2 = char(1), "C"
param3 = char(1), "S"

Procedure GET_ULTCOM_ART:
param0 = integer, "7236"

Procedure ROUND_PROD:
param0 = double precision, "9999"
param1 = double precision, "0"
param2 = double precision, "0.01"

DOCTOS_IN_DET_BEFUPD_0 FOR DOCTOS_IN_DET (BEFORE UPDATE)

Procedure COMPARA_ENTEROS:
param0 = integer, "<NULL>"
param1 = integer, "<NULL>"

Procedure AFECTA_CAPA_PROMEDIO:
param0 = integer, "7236"
param1 = integer, "220"
param2 = bigint(*, -5), "9999.00000"
param3 = bigint(*, -2), "0"
param4 = integer, "1"

CAPAS_COSTOS_BEFINS FOR CAPAS_COSTOS (BEFORE INSERT)

CAPAS_COSTOS_BEFINS_0 FOR CAPAS_COSTOS (BEFORE INSERT)

CAPAS_COSTOS_BEFINSUPD_RI FOR CAPAS_COSTOS (BEFORE INSERT)

Procedure AFECTA_SALDOS_IN:
param0 = integer, "7236"
param1 = integer, "220"
param2 = date, "2023-11-09"
param3 = char(1), "E"
param4 = bigint(*, -5), "9999.00000"
param5 = bigint(*, -2), "0"
param6 = integer, "1"

Procedure DECODIF_FECHA:
param0 = date, "2023-11-09"
================================================
TERCER BLOQUE DE 3
Procedure APLICA_ENTRADA_IN:
param0 = integer, "38251"

Procedure COSTEA_MOVTO_ENTRADA:
param0 = integer, "38251"

Procedure COSTEA_ENTRADA_IN:
param0 = integer, "38251"
param1 = char(1), "-"

Procedure GET_COSTO_ENTRADA:
param0 = integer, "7238"
param1 = integer, "220"
param2 = char(1), "C"
param3 = integer, "38251"

Procedure GET_CAPAS_COSTEO:
param0 = integer, "7238"
param1 = integer, "220"
param2 = char(1), "C"
param3 = char(1), "S"

Procedure GET_ULTCOM_ART:
param0 = integer, "7238"

Procedure ROUND_PROD:
param0 = double precision, "9999"
param1 = double precision, "0"
param2 = double precision, "0.01"

Procedure ROUND_MIN:
param0 = double precision, "0"
param1 = double precision, "0.01"

DOCTOS_IN_DET_BEFUPD_0 FOR DOCTOS_IN_DET (BEFORE UPDATE)

Procedure COMPARA_ENTEROS:
param0 = integer, "<NULL>"
param1 = integer, "<NULL>"

Procedure AFECTA_CAPA_PROMEDIO:
param0 = integer, "7238"
param1 = integer, "220"
param2 = bigint(*, -5), "9999.00000"
param3 = bigint(*, -2), "0"
param4 = integer, "1"

CAPAS_COSTOS_BEFINS FOR CAPAS_COSTOS (BEFORE INSERT)

CAPAS_COSTOS_BEFINS_0 FOR CAPAS_COSTOS (BEFORE INSERT)

CAPAS_COSTOS_BEFINSUPD_RI FOR CAPAS_COSTOS (BEFORE INSERT)

Procedure AFECTA_SALDOS_IN:
param0 = integer, "7238"
param1 = integer, "220"
param2 = date, "2023-11-09"
param3 = char(1), "E"
param4 = bigint(*, -5), "9999.00000"
param5 = bigint(*, -2), "0"
param6 = integer, "1"

Procedure DECODIF_FECHA:
param0 = date, "2023-11-09"
================================================
DOCTOS_IN_BEFINSUPD_RI FOR DOCTOS_IN (BEFORE UPDATE)

DOCTOS_IN_BEFUPD_0 FOR DOCTOS_IN (BEFORE UPDATE)

DOCTOS_IN_BEFINSUPD_1 FOR DOCTOS_IN (BEFORE UPDATE)

DOCTOS_IN_AFTUPD_0 FOR DOCTOS_IN (AFTER UPDATE)

Procedure COMPARA_ENTEROS:
param0 = integer, "<NULL>"
param1 = integer, "<NULL>"

Procedure GET_SIGFOL_CONCEPTO:
param0 = char(2), "IN"
param1 = integer, "26"
param2 = varchar(3), "@"
param3 = integer, "3"

FOLIOS_CONCEPTOS_BEFINSUPD_RI FOR FOLIOS_CONCEPTOS (BEFORE UPDATE)

REGISTRY_BEFUPD FOR REGISTRY (BEFORE UPDATE)

Procedure DOCTOS_IN_SKIP:
param0 = smallint, "2"
param1 = char(1), "E"
param2 = integer, "26"
param3 = char(9), "_00001649"

Procedure DOCTOS_IN_SKIP:
param0 = smallint, "2"
param1 = char(1), "E"
param2 = integer, "26"
param3 = char(9), "000000002"


* */
