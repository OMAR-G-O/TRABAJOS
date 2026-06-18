package org.example;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;

public abstract class Main {
    static Contenido contenido;
    static ArrayList<Contenido> contenidos = new ArrayList<Contenido>();
    static void nuevaPelicula() {
        contenido = new Pelicula("Interestelar",1.30,"Ciencia Ficcion","Christopher Nolan");
        contenidos.add(contenido);
    }
    static void nuevaSerie(){
        contenido = new Serie("Peaky bad",5.00,"Accion",5);
        contenidos.add(contenido);
    }
    static void nuevoPodcast(){
        contenido = new Podcast("Terror en el 3",2.30,"Terror","Chepito gonza");
        contenidos.add(contenido);
    }
    static void imprimircontenido(){
        for (Contenido c : contenidos){
            System.out.println(c);
        }
    }
    static void reproducirContenido(){
        if(contenidos.isEmpty()){
            System.out.println("No hay contenido");
            return;
        }
        for (Contenido c : contenidos){
            System.out.println(c.reproducir() + c.getTitulo());
        }
    }
    // Filtrar por tipo específico (Pelicula, Serie, Podcast)
    static void mostrarPorTipo(String tipo) {
        boolean encontrado = false;
        for (Contenido c : contenidos) {
            if (c.obtenerTipoContenido().equalsIgnoreCase(tipo)) {
                System.out.println(c);
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("No hay contenidos del tipo: " + tipo);
    }

    // Mostrar el tiempo total acumulado o individual por formato
    static void mostrarTiemposTotales() {
        if(contenidos.isEmpty()){ System.out.println("No hay contenido."); return; }
        for (Contenido c : contenidos) {
            System.out.println(c.getTitulo() + " (" + c.obtenerTipoContenido() + ") - Tiempo Total: " + c.obtenerTiempoTotal() + " horas.");
        }
    }

    // Mostrar número de episodios de las series
    static void mostrarEpisodiosSeries() {
        boolean haySeries = false;
        for (Contenido c : contenidos) {
            if (c instanceof Serie) {
                Serie s = (Serie) c; // Cast de Contenido a Serie
                System.out.println("Serie: " + s.getTitulo() + " -> Episodios Totales: " + s.numeroDeEpisodios());
                haySeries = true;
            }
        }
        if (!haySeries) System.out.println("No se han ingresado series.");
    }

    // Mostrar datos generales (Clase Padre)
    static void mostrarDatosGenerales() {
        if(contenidos.isEmpty()){ System.out.println("No hay contenido."); return; }
        for (Contenido c : contenidos) {
            System.out.println("- " + c.obtenerDatosGenerales());
        }
    }

    // Mostrar datos particulares (Clases Hijas)
    static void mostrarDatosParticulares() {
        if (contenidos.isEmpty()) {
            System.out.println("No hay contenido.");
            return;
        }
        for (Contenido c : contenidos) {
            System.out.println(c.getTitulo() + " (" + c.obtenerTipoContenido() + ") -> 4" + c.obtenerDatosParticulares());
        }
    }


    static void main() throws  Exception{
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        int opc = 0;
        while(opc!=11){

            System.out.println("---------MENU-------");
            System.out.println("1. Crear pelicula");
            System.out.println("2. Crear serie");
            System.out.println("3. Crear podcast");
            System.out.println("4. Mostrar todo el contenido");
            System.out.println("5. Reproducir contenido");
            System.out.println("6. Filtrar solo películas");
            System.out.println("7. Filtrar solo series");
            System.out.println("8. Filtrar solo podcasts");
            System.out.println("9. Ver tiempos totales de reproducción");
            System.out.println("10. Ver número de Episodios (Solo Series)");
            System.out.println("11. ver datos generales vs particulares");
            System.out.println("12. Salir");
            System.out.print("Selecciona una opción: ");
            opc = Integer.parseInt(leer.readLine());
            switch(opc){
                case 1:
                    System.out.println("Pelicula creada");nuevaPelicula();break;

                case 2:
                    System.out.println("Serie");nuevaSerie();break;

                case 3:
                    System.out.println("Podcast");nuevoPodcast();break;

                case 4: imprimircontenido();break;

                case 5: reproducirContenido();break;

                case 6: mostrarPorTipo("Película"); break;

                case 7: mostrarPorTipo("Serie"); break;

                case 8: mostrarPorTipo("Podcast"); break;

                case 9: mostrarTiemposTotales(); break;

                case 10: mostrarEpisodiosSeries(); break;

                case 11:
                    System.out.println("\n--- DATOS GENERALES ---");
                    mostrarDatosGenerales();
                    System.out.println("\n--- DATOS PARTICULARES ---");
                    mostrarDatosParticulares();
                    break;
                case 12: System.out.println("¡Adiós!"); break;

                default: System.out.println("Opción incorrecta."); break;

            }
        }
    }
}

