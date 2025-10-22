package Herencia; // Paquete principal de la aplicacion

//========================================================================================================
//IMPORACION DE LIBRERIAS
//========================================================================================================
import java.util.ArrayList; // Import para usar ArrayList
import java.util.List; // Import para la interfaz List
import java.util.Scanner; // Import para leer desde la consola

//========================================================================================================
// Clase principal con el metodo main
//========================================================================================================
public class AppInsert { // Definicion de la clase App

    //========================================================================================================
    // Metodo de entrada de la aplicacion
    //========================================================================================================
    public static void main(String[] args) { // Punto de entrada main
        Scanner sc = new Scanner(System.in); // Crea un lector de consola
        List<Vehiculo> inventario = new ArrayList<>(); // Crea el ArrayList que almacenara objetos de subclases
        boolean salir = false; // Bandera para controlar la salida del menu
        
        //========================================================================================================
        // Bucle principal del menu
        //========================================================================================================
        while (!salir) { // Mientras no se elija salir
            System.out.println("==================================================");
            System.out.println("\n***** Menu Vehiculos *****"); // Muestra el encabezado del menu
            System.out.println("==================================================");
            System.out.println("1) Agregar Automovil"); // Opcion para crear Automovil
            System.out.println("2) Agregar Tren"); // Opcion para crear Tren
            System.out.println("3) Agregar Avion"); // Opcion para crear Avion
            System.out.println("4) Agregar Barco"); // Opcion para crear Barco
            System.out.println("5) Agregar Scooter Electrico"); // Opcion para crear ScooterElectrico
            System.out.println("6) Listar inventario"); // Opcion para listar todos los objetos
            System.out.println("0) Salir"); // Opcion para salir

            int opcion = leerEntero(sc, "Seleccione una opcion (0-6): ", 0, 6); // Lee la opcion con validacion y rango
            
            //========================================================================================================
            // Seleccion segun la opcion elegida
            //========================================================================================================
            switch (opcion) { // Estructura de control para cada caso
                case 1: { // Caso de Automovil
                    Automovil obj = crearAutomovil(sc); // Llama a la funcion que construye un Automovil con validaciones
                    inventario.add(obj); // Agrega el objeto al ArrayList tipado como Vehiculo
                    System.out.println("Automovil agregado correctamente."); // Confirma la operacion
                    break; // Sale del caso
                }
                case 2: { // Caso de Tren
                    Tren obj = crearTren(sc); // Construye un Tren solicitando datos
                    inventario.add(obj); // Agrega al inventario
                    System.out.println("Tren agregado correctamente."); // Mensaje de confirmacion
                    break; // Fin del caso
                }
                case 3: { // Caso de Avion
                    Avion obj = crearAvion(sc); // Construye un Avion
                    inventario.add(obj); // Agrega al inventario
                    System.out.println("Avion agregado correctamente."); // Mensaje de confirmacion
                    break; // Fin del caso
                }
                case 4: { // Caso de Barco
                    Barco obj = crearBarco(sc); // Construye un Barco
                    inventario.add(obj); // Agrega al inventario
                    System.out.println("Barco agregado correctamente."); // Mensaje de confirmacion
                    break; // Fin del caso
                }
                case 5: { // Caso de Scooter Electrico
                    ScooterElectrico obj = crearScooter(sc); // Construye un ScooterElectrico
                    inventario.add(obj); // Agrega al inventario
                    System.out.println("Scooter Electrico agregado correctamente."); // Mensaje de confirmacion
                    break; // Fin del caso
                }
                case 6: { // Caso de listar
                    if (inventario.isEmpty()) { // Verifica si la lista esta vacia
                        System.out.println("Inventario vacio."); // Mensaje si no hay elementos
                    } else { // Si hay elementos
                        System.out.println("\n--- Inventario ---"); // Encabezado de listado
                        for (Vehiculo v : inventario) { // Recorre todos los vehiculos
                            System.out.println(v); // Imprime la representacion textual de cada objeto
                        } // Fin del for-each
                    } // Fin del else
                    break; // Fin del caso
                }
                case 0: { // Opcion de salir
                    salir = true; // Cambia la bandera para salir del bucle
                    System.out.println("Saliendo..."); // Mensaje de salida
                    break; // Fin del caso
                }
                default: { // Caso por defecto (no deberia ocurrir por validacion)
                    System.out.println("Opcion no valida."); // Mensaje de opcion invalida
                }
            } // Fin del switch
        } // Fin del while principal

        sc.close(); // Cierra el Scanner para liberar recursos
    } // Fin de main

    //========================================================================================================
    // Metodos de creacion por tipo
    //========================================================================================================

    //========================================================================================================
    // Crea un Automovil pidiendo datos comunes y especificos con validacion
    //========================================================================================================
    private static Automovil crearAutomovil(Scanner sc) { // Metodo auxiliar para crear Automovil
        int id = leerEntero(sc, "ID (entero positivo): ", 1, Integer.MAX_VALUE); // Lee id con rango
        String marca = leerTextoNoVacio(sc, "Marca: "); // Lee marca no vacia
        String modelo = leerTextoNoVacio(sc, "Modelo: "); // Lee modelo no vacio
        int anio = leerEntero(sc, "Ano (1900-2100): ", 1900, 2100); // Lee ano con rango
        int cap = leerEntero(sc, "Capacidad de pasajeros (1-1000): ", 1, 1000); // Lee capacidad valida
        int puertas = leerEntero(sc, "Puertas (2-6): ", 2, 6); // Lee cantidad de puertas
        String combustible = leerTextoNoVacio(sc, "Tipo de combustible (gasolina/diesel/hibrido/electrico): "); // Lee tipo de combustible
        return new Automovil(id, marca, modelo, anio, cap, puertas, combustible); // Retorna el objeto construido
    } // Fin de crearAutomovil
    
    //========================================================================================================
    // Crea un Tren con validacion
    //========================================================================================================
    private static Tren crearTren(Scanner sc) { // Metodo auxiliar para crear Tren
        int id = leerEntero(sc, "ID (entero positivo): ", 1, Integer.MAX_VALUE); // Lee id
        String marca = leerTextoNoVacio(sc, "Marca: "); // Lee marca
        String modelo = leerTextoNoVacio(sc, "Modelo: "); // Lee modelo
        int anio = leerEntero(sc, "Ano (1900-2100): ", 1900, 2100); // Lee ano
        int cap = leerEntero(sc, "Capacidad de pasajeros (1-2000): ", 1, 2000); // Lee capacidad
        int vagones = leerEntero(sc, "Numero de vagones (1-200): ", 1, 200); // Lee vagones
        boolean electrico = leerSiNo(sc, "¿Es electrico? (s/n): "); // Lee si es electrico
        return new Tren(id, marca, modelo, anio, cap, vagones, electrico); // Retorna el objeto
    } // Fin de crearTren
    
    //========================================================================================================
    // Crea un Avion con validacion
    //========================================================================================================
    private static Avion crearAvion(Scanner sc) { // Metodo auxiliar para crear Avion
        int id = leerEntero(sc, "ID (entero positivo): ", 1, Integer.MAX_VALUE); // Lee id
        String marca = leerTextoNoVacio(sc, "Marca: "); // Lee marca
        String modelo = leerTextoNoVacio(sc, "Modelo: "); // Lee modelo
        int anio = leerEntero(sc, "Ano (1900-2100): ", 1900, 2100); // Lee ano
        int cap = leerEntero(sc, "Capacidad de pasajeros (1-1000): ", 1, 1000); // Lee capacidad
        int motores = leerEntero(sc, "Motores (1-8): ", 1, 8); // Lee cantidad de motores
        String aerolinea = leerTextoNoVacio(sc, "Aerolinea: "); // Lee aerolinea
        return new Avion(id, marca, modelo, anio, cap, motores, aerolinea); // Retorna el objeto
    } // Fin de crearAvion
    
    //========================================================================================================
    // Crea un Barco con validacion
    //========================================================================================================
    private static Barco crearBarco(Scanner sc) { // Metodo auxiliar para crear Barco
        int id = leerEntero(sc, "ID (entero positivo): ", 1, Integer.MAX_VALUE); // Lee id
        String marca = leerTextoNoVacio(sc, "Marca: "); // Lee marca
        String modelo = leerTextoNoVacio(sc, "Modelo: "); // Lee modelo
        int anio = leerEntero(sc, "Ano (1900-2100): ", 1900, 2100); // Lee ano
        int cap = leerEntero(sc, "Capacidad de pasajeros (0-10000): ", 0, 10000); // Lee capacidad permitiendo 0
        double tonelaje = leerDouble(sc, "Tonelaje (0.1 - 500000.0): ", 0.1, 500000.0); // Lee tonelaje dentro de rango
        String tipo = leerTextoNoVacio(sc, "Tipo de barco (carga/pasajeros/velero/pesquero/...): "); // Lee tipo
        return new Barco(id, marca, modelo, anio, cap, tonelaje, tipo); // Retorna el objeto
    } // Fin de crearBarco

    //========================================================================================================
    // Crea un ScooterElectrico con validacion
    //========================================================================================================
    private static ScooterElectrico crearScooter(Scanner sc) { // Metodo auxiliar para crear ScooterElectrico
        int id = leerEntero(sc, "ID (entero positivo): ", 1, Integer.MAX_VALUE); // Lee id
        String marca = leerTextoNoVacio(sc, "Marca: "); // Lee marca
        String modelo = leerTextoNoVacio(sc, "Modelo: "); // Lee modelo
        int anio = leerEntero(sc, "Ano (1900-2100): ", 1900, 2100); // Lee ano
        int cap = leerEntero(sc, "Capacidad de pasajeros (1-2): ", 1, 2); // Lee capacidad tipica de scooter
        int autonomia = leerEntero(sc, "Autonomia (km, 1-300): ", 1, 300); // Lee autonomia
        int potencia = leerEntero(sc, "Potencia (W, 100-10000): ", 100, 10000); // Lee potencia
        return new ScooterElectrico(id, marca, modelo, anio, cap, autonomia, potencia); // Retorna el objeto
    } // Fin de crearScooter

    //========================================================================================================
    // Lectura validada de entradas
    //========================================================================================================
    
    //========================================================================================================
    // Lee un entero con try-catch y validacion de rango
    //========================================================================================================
    private static int leerEntero(Scanner sc, String prompt, int min, int max) { // Metodo para leer enteros con rango
        while (true) { // Bucle hasta que la entrada sea valida
            try { // Intenta convertir la entrada
                System.out.print(prompt); // Muestra el mensaje de entrada
                String linea = sc.nextLine(); // Lee la linea completa del usuario
                int valor = Integer.parseInt(linea.trim()); // Convierte a entero luego de recortar espacios
                if (valor < min || valor > max) { // Verifica que este dentro del rango
                    System.out.println("Valor fuera de rango (" + min + " - " + max + ")."); // Mensaje de error de rango
                    continue; // Repite la lectura
                } // Fin de validacion de rango
                return valor; // Retorna el entero valido
            } catch (NumberFormatException e) { // Captura errores de conversion
                System.out.println("Entrada invalida. Ingrese un numero entero."); // Mensaje de error
            } // Fin del catch
        } // Fin del while
    } // Fin de leerEntero

    //========================================================================================================
    // Lee un double con try-catch y validacion de rango
    //========================================================================================================
    private static double leerDouble(Scanner sc, String prompt, double min, double max) { // Metodo para leer double con rango
        while (true) { // Bucle de validacion
            try { // Bloque de intento
                System.out.print(prompt); // Muestra el mensaje
                String linea = sc.nextLine(); // Lee la linea de entrada
                double valor = Double.parseDouble(linea.trim()); // Convierte a double
                if (valor < min || valor > max) { // Verifica rango
                    System.out.println("Valor fuera de rango (" + min + " - " + max + ")."); // Mensaje de rango invalido
                    continue; // Repite la lectura
                } // Fin de validacion de rango
                return valor; // Retorna el valor valido
            } catch (NumberFormatException e) { // Captura excepcion de formato
                System.out.println("Entrada invalida. Ingrese un numero (decimal permitido)."); // Mensaje de error
            } // Fin del catch
        } // Fin del while
    } // Fin de leerDouble

    //========================================================================================================
    // Lee un texto no vacio
    //========================================================================================================
    private static String leerTextoNoVacio(Scanner sc, String prompt) { // Metodo para leer cadenas no vacias
        while (true) { // Bucle de validacion
            System.out.print(prompt); // Muestra el mensaje
            String texto = sc.nextLine(); // Lee el texto ingresado
            if (texto != null && !texto.trim().isEmpty()) { // Verifica que no sea null ni vacio
                return texto.trim(); // Retorna el texto recortado
            } else { // Si es vacio
                System.out.println("El texto no puede estar vacio."); // Mensaje de validacion fallida
            } // Fin del else
        } // Fin del while
    } // Fin de leerTextoNoVacio
    
    //========================================================================================================
    // Lee una respuesta si/no y retorna boolean
    //========================================================================================================
    private static boolean leerSiNo(Scanner sc, String prompt) { // Metodo para leer valores booleanos como s/n
        while (true) { // Bucle de validacion
            System.out.print(prompt); // Muestra el mensaje
            String resp = sc.nextLine(); // Lee la respuesta
            if (resp == null) { // Si es null
                System.out.println("Ingrese 's' o 'n'."); // Pide un valor valido
                continue; // Repite
            } // Fin de control de null
            resp = resp.trim().toLowerCase(); // Normaliza la respuesta
            if (resp.equals("s") || resp.equals("si") || resp.equals("si")) { // Si es afirmativo
                return true; // Retorna verdadero
            } else if (resp.equals("n") || resp.equals("no")) { // Si es negativo
                return false; // Retorna falso
            } else { // Si no coincide
                System.out.println("Ingrese 's' o 'n'."); // Mensaje de error
            } // Fin del else
        } // Fin del while
    } // Fin de leerSiNo
} // Fin de la clase App
