package org.example;

public class InformeSistemaprueba {
    static void Main(String[] args){
        Runtime runtime = Runtime.getRuntime();
        long[] reservado = new long[8 * 1024 * 1024];

        int procesadores = runtime.availableProcessors();
        long mReservada = runtime.totalMemory()/ (1024 * 1024);
        long mLibre = runtime.freeMemory()/ (1024 * 1024);
        long mUso = (mReservada - mLibre) / (1024 * 1024);
        long porcentajeUso = mUso * 100 / mReservada;

        System.out.println("PROCESADORES");
        System.out.println("============================================================");
        System.out.println("  Disponibles JVM: "+procesadores);
        System.out.println("  (son hilos lógicos: con SMT no coinciden con los núcleos físicos)");
        System.out.println();

        System.out.println("MEMORIA · ANTES");
        System.out.println("============================================================");
        System.out.println("  Total reservada: "+ mReservada +" MiB");
        System.out.println("  Libre:           "+mLibre+" MiB");
        System.out.println("  En uso:          "+mUso+" MiB (5 % de la total)");
        System.out.println("  Máxima (-Xmx):   "+porcentajeUso+" MiB");
        System.out.println();

        reservado[0]= 0;

        long mReservada2 = runtime.totalMemory()/ (1024 * 1024);
        long mLibre2 = runtime.freeMemory()/ (1024 * 1024);
        long mUso2 = (mReservada - mLibre) / (1024 * 1024);
        long porcentajeUso2 = mUso * 100 / mReservada;
        long incrementoUso = mUso2 - mUso;

        System.out.println("MEMORIA · DESPUÉS DE RESERVAR 64 MiB");
        System.out.println("============================================================");
        System.out.println("  Total reservada: "+ mReservada2 +" MiB");
        System.out.println("  Libre:           "+mLibre2+" MiB");
        System.out.println("  En uso:          "+mUso2+" MiB (5 % de la total)");
        System.out.println("  Máxima (-Xmx):   "+porcentajeUso2+" MiB");
        System.out.println("  Incremento en uso: " +incrementoUso+ " MiB");
        System.out.println("  (el array sigue en memoria: reservado[0] = 0)");
        System.out.println();

        String soNombre = System.getProperty("os.name");
        String separador = System.getProperty("file.separator");

        String javaVersion = System.getProperty("java.version");
        String javaVersionFecha = System.getProperty("java.version.date");

        String arquitectura = System.getProperty("os.arch");
        String soVersion = System.getProperty("os.version");

        String paisUsuario = System.getProperty("user.country");
        String directorioUsuario = System.getProperty("user.dir");
        String homeUsuario = System.getProperty("user.home");
        String lenguajeUsuario = System.getProperty("user.language");
        String nombreUsuario = System.getProperty("user.name");

        // File creado con propiedades
        String rutaArchivo = homeUsuario + separador + "pruebaPSP" + separador + "archivo.txt";

        System.out.println("SISTEMA");
        System.out.println("============================================================");
        System.out.println("  os.name:         "+soNombre);
        System.out.println("  file.separator:  "+separador);
        System.out.println("  Ruta construida con las propiedades:");
        System.out.println("    "+rutaArchivo);
        System.out.println();

        System.out.println("PROPIEDADES QUE EMPIEZAN POR os., user., java.version");
        System.out.println("============================================================");
        System.out.println("  java.version = "+javaVersion);
        System.out.println("  java.version.date = "+javaVersionFecha);
        System.out.println("  os.arch = "+arquitectura);
        System.out.println("  os.name = "+soNombre);
        System.out.println("  os.version = "+soVersion);
        System.out.println("  user.country = " + paisUsuario);
        System.out.println("  user.dir = " + directorioUsuario);
        System.out.println("  user.home = " + homeUsuario);
        System.out.println("  user.language = "+lenguajeUsuario);
        System.out.println("  user.name = "+nombreUsuario);
        System.out.println();

        System.out.println("PROCESO EN ESPERA");
        System.out.println("============================================================");
        System.out.println("  Búscame desde otra terminal con:");
        System.out.println("    ps -ef | grep InformeSistema");
        System.out.println();
        System.out.println("  Pulsa INTRO para terminar...");
        System.out.println("  Fin del programa.");
    }
}
