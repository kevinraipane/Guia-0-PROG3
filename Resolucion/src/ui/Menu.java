package ui;

import models.Juego;
import models.JuegoBase;
import repositorios.IRepositorio;
import repositorios.Repositorio;

import java.util.Scanner;

public class Menu {
    private IRepositorio<JuegoBase> repositorio = new Repositorio<>();
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu(){
        int opcion;
        do{
            System.out.println("""
                    --- Menu Principal ---
                    1. Agregar juego.
                    2. Agregar expansion.
                    3. Eliminar por ID.
                    4. Mostrar todo ordenado por titulo.
                    5. Filtrar por genero.
                    6. Salir.
                    Elija una opcion:""");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                //case 1 -> agregarJuego();
                //case 2 -> agregarExpansion();
                case 3 -> eliminarJuego();
                case 4 -> mostrarTodos();
                case 5 -> filtrarPorGenero();
                case 6 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opcion invalida.");
            }
        }while (opcion != 6);
    }

    //HACER QUE EL ID SEA AUTOINCREMENTAL, NO TIPEADO POR EL USER
//    private void agregarJuego(){
//        try{
//            System.out.print("Ingrese el Título: ");
//            String titulo = scanner.nextLine();
//            System.out.print("Ingrese el Creador: ");
//            String creador = scanner.nextLine();
//            System.out.print("Ingrese el Genero: ");
//            String genero = scanner.nextLine();
//            System.out.print("Ingrese el ID: ");
//            String id = scanner.nextLine();
//            System.out.print("Ingrese el Versión: ");
//            int version = scanner.nextInt();
//            scanner.nextLine();
//
//            Juego juego = new Juego()
//        }
//    }

    private void eliminarJuego(){
        System.out.println("Ingrese el ID a eliminar: ");
        String id = scanner.nextLine();
        repositorio.eliminar(id);
        //Deberia dar un mensaje si elimino o no, si encontro el obj??
        System.out.println("Eliminado correctamente");
    }

    private void mostrarTodos(){
        System.out.println("--- Coleccion ordenada por titulo ---");
        System.out.println(repositorio.obtenerTodosOrdenador());
    }

    private void filtrarPorGenero(){
        System.out.println("Ingrese el genero con lo que filtrar: ");
        String genero = scanner.nextLine();
        System.out.println("--- Coleccion filtrada por genero ---");
        System.out.println(repositorio.filtrarPorGenero(genero));
    }
}
