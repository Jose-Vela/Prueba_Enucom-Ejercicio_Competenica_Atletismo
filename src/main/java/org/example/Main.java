package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner teclado = new Scanner(System.in);
    static ArrayList<Atleta> atletas = new ArrayList<>();

    public static void main(String[] args) {
        String opcion;

        do {
            System.out.println("\n\n1 - Agregar atleta");
            System.out.println("2 - Mostrar información del atleta ganador de la carrera");
            System.out.println("3 - Mostrar todos los atletas participantes de la carrera");
            System.out.println("4 - Salir");
            System.out.println("\nElija una de las opciones anteriores...");

            opcion=teclado.nextLine();

            switch (opcion){
                case "1": agregarAtleta(); break;
                case "2": mostrarAtletaGanador(); break;
                case "3": mostrarTodosLosAtletas(); break;
            }
        } while (!opcion.equals("4"));
        System.exit(0);
    }

    private static void mostrarTodosLosAtletas() {
        if(!atletas.isEmpty()){
            int numero;
            String nombre;
            float tiempoDeCarrera;

            for(int i = 0; i< atletas.size(); i++) {
                numero = atletas.get(i).getNumero();
                nombre = atletas.get(i).getNombre();
                tiempoDeCarrera = atletas.get(i).getTiempoDeCarrera();

                System.out.println(i+1 + " - Numero: " + numero + ", Nombre: " + nombre + ", Tiempo obtenido en la carrera: " + tiempoDeCarrera);
            }
            teclado.nextLine();
        }
    }

    private static void mostrarAtletaGanador() {
        if(!atletas.isEmpty()){
            int indiceMasBarato = calcularAtletaGanador();
            int numero = atletas.get(indiceMasBarato).getNumero();
            String nombre = atletas.get(indiceMasBarato).getNombre();
            float tiempoDeCarrera = atletas.get(indiceMasBarato).getTiempoDeCarrera();

            System.out.println("Numero: " + numero + ", Nombre: " + nombre + ", Tiempo obtenido en la carrera: " + tiempoDeCarrera);
            teclado.nextLine();
        }
    }

    private static void agregarAtleta() {
        int numero;
        String nombre;
        float tiempoDeCarrera;

        System.out.print("\nNumero del atleta: ");
        numero = teclado.nextInt();
        teclado.nextLine();
        System.out.print("Nombre del atleta: ");
        nombre = teclado.nextLine();
        System.out.print("Tiempo obtenido en la carrera: ");
        tiempoDeCarrera = teclado.nextFloat();
        teclado.nextLine();

        atletas.add(new Atleta(numero, nombre, tiempoDeCarrera));
    }

    private static int calcularAtletaGanador() {
        int indice = 0;
        float mejorTiempo = atletas.get(0).getTiempoDeCarrera();
        for(int i = 1; i < atletas.size(); i++) {
            if (atletas.get(i).getTiempoDeCarrera() < mejorTiempo) {
                mejorTiempo = atletas.get(i).getTiempoDeCarrera();
                indice = i;
            }
        }
        return indice;
    }
}