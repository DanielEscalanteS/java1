package Herencia;

import java.util.ArrayList; // Importa ArrayList para manejar la lista dinamica de vehiculos
import java.util.List; // Importa la interfaz List para programar contra la abstraccion
import java.util.Scanner; // Importa Scanner para leer entradas desde la consola

//========================================================================================================
// Clase principal de la aplicacion que implementa un menu CRUD completo
//========================================================================================================
public class AppCrud { // Declaracion de la clase App que contiene el metodo main
    
    //========================================================================================================
    // Metodo principal que arranca la aplicacion
    //========================================================================================================
    public static void main(String[] args) { // Punto de entrada de la aplicacion
        Scanner sc = new Scanner(System.in); // Crea un lector de consola para capturar entradas del usuario
        List<Vehiculo> inventario = new ArrayList<>(); // Inicializa la lista que almacenara objetos de subclases de Vehiculo
        boolean salir = false; // Bandera de control para finalizar el bucle del menu principal
        //========================================================================================================
        // Bucle principal para mostrar el menu hasta que se elija salir
        //========================================================================================================
        while (!salir) { // Itera mientras la opcion no sea salir
            System.out.println("======================================================================");
            System.out.println("***** CRUD Vehiculos *****"); // Muestra el titulo del menu
            System.out.println("======================================================================");
            System.out.println("1) Crear vehiculo"); // Opcion para crear un nuevo vehiculo
            System.out.println("2) Listar vehiculos"); // Opcion para listar todos los vehiculos
            System.out.println("3) Buscar vehiculo por ID"); // Opcion para buscar un vehiculo por su ID
            System.out.println("4) Actualizar vehiculo por ID"); // Opcion para actualizar un vehiculo existente
            System.out.println("5) Eliminar vehiculo por ID"); // Opcion para eliminar un vehiculo del inventario
            System.out.println("0) Salir"); // Opcion para cerrar la aplicacion

            int opcion = leerEntero(sc, "Seleccione una opcion (0-5): ", 0, 5); // Lee la opcion de menu validando rango y formato

            //========================================================================================================
            // Selecciona la accion correspondiente segun la opcion ingresada
            //========================================================================================================
            switch (opcion) { // Inicia el switch para manejar casos del menu
                case 1: { // Caso de creacion de vehiculo
                    crearVehiculo(sc, inventario); // Llama al metodo que gestiona la creacion por tipo de vehiculo
                    break; // Finaliza el caso 1
                }
                case 2: { // Caso de listado
                    listarInventario(inventario); // Llama al metodo que imprime el inventario en consola
                    break; // Finaliza el caso 2
                }
                case 3: { // Caso de busqueda por ID
                    int id = leerEntero(sc, "Ingrese ID a buscar: ", 1, Integer.MAX_VALUE); // Solicita el ID a buscar
                    int idx = buscarIndicePorId(inventario, id); // Busca el indice del vehiculo con ese ID
                    if (idx == -1) { // Verifica si no se encontro
                        System.out.println("No existe un vehiculo con ID=" + id); // Informa que no se encontro el vehiculo
                    } else { // Si se encontro
                        System.out.println("Encontrado: " + inventario.get(idx)); // Muestra la informacion del vehiculo hallado
                    } // Fin del else de encontrado
                    break; // Finaliza el caso 3
                }
                case 4: { // Caso de actualizacion
                    actualizarVehiculo(sc, inventario); // Llama al metodo que actualiza un vehiculo segun su subclase
                    break; // Finaliza el caso 4
                }
                case 5: { // Caso de eliminacion
                    eliminarVehiculo(sc, inventario); // Llama al metodo que elimina un vehiculo por ID
                    break; // Finaliza el caso 5
                }
                case 0: { // Caso de salida
                    salir = true; // Cambia la bandera para terminar el bucle principal
                    System.out.println("Saliendo..."); // Muestra un mensaje de salida
                    break; // Finaliza el caso 0
                }
                default: { // Caso por defecto en caso de error (no deberia ocurrir por validacion)
                    System.out.println("Opcion no valida."); // Mensaje de opcion invalida
                } // Fin del default
            } // Fin del switch del menu principal
        } // Fin del while principal del menu

        sc.close(); // Cierra el Scanner para liberar el recurso de entrada
    } // Fin del metodo main

    //========================================================================================================
    // Operaciones CRUD principales
    //========================================================================================================
    
    //========================================================================================================
    // Gestion de creacion de un vehiculo con seleccion de subclase
    //========================================================================================================
    private static void crearVehiculo(Scanner sc, List<Vehiculo> inventario) { // Metodo para crear un vehiculo del tipo elegido
        System.out.println("\n--- Crear Vehiculo ---"); // Titulo de la seccion de creacion
        System.out.println("1) Automovil"); // Opcion para crear Automovil
        System.out.println("2) Tren"); // Opcion para crear Tren
        System.out.println("3) Avion"); // Opcion para crear Avion
        System.out.println("4) Barco"); // Opcion para crear Barco
        System.out.println("5) Scooter Electrico"); // Opcion para crear ScooterElectrico
        int tipo = leerEntero(sc, "Seleccione tipo (1-5): ", 1, 5); // Lee y valida el tipo de subclase a crear
        
        //========================================================================================================
        switch (tipo) { // Selecciona la construccion segun el tipo
            case 1: { // Automovil
                Automovil a = crearAutomovil(sc, inventario); // Crea un objeto Automovil pidiendo datos validados
                inventario.add(a); // Agrega el automovil al inventario
                System.out.println("Automovil creado y agregado."); // Confirma la creacion
                break; // Termina el caso 1
            }
            case 2: { // Tren
                Tren t = crearTren(sc, inventario); // Crea un objeto Tren con validaciones
                inventario.add(t); // Agrega el tren al inventario
                System.out.println("Tren creado y agregado."); // Confirma la creacion
                break; // Termina el caso 2
            }
            case 3: { // Avion
                Avion v = crearAvion(sc, inventario); // Crea un objeto Avion con datos validados
                inventario.add(v); // Agrega el avion al inventario
                System.out.println("Avion creado y agregado."); // Confirma la creacion
                break; // Termina el caso 3
            }
            case 4: { // Barco
                Barco b = crearBarco(sc, inventario); // Crea un objeto Barco con validaciones
                inventario.add(b); // Agrega el barco al inventario
                System.out.println("Barco creado y agregado."); // Confirma la creacion
                break; // Termina el caso 4
            }
            case 5: { // Scooter Electrico
                ScooterElectrico s = crearScooter(sc, inventario); // Crea un objeto ScooterElectrico con datos validados
                inventario.add(s); // Agrega el scooter al inventario
                System.out.println("Scooter Electrico creado y agregado."); // Confirma la creacion
                break; // Termina el caso 5
            }
            default: { // Control redundante por seguridad
                System.out.println("Tipo no valido."); // Mensaje en caso de error
            } // Fin del default
        } // Fin del switch de creacion
    } // Fin de crearVehiculo

    //========================================================================================================
    // Lista todos los vehiculos del inventario
    //========================================================================================================
    private static void listarInventario(List<Vehiculo> inventario) { // Metodo para listar el contenido del inventario
        System.out.println("\n--- Inventario ---"); // Encabezado del listado
        if (inventario.isEmpty()) { // Verifica si la lista esta vacia
            System.out.println("Inventario vacio."); // Mensaje cuando no hay elementos
            return; // Retorna porque no hay mas que mostrar
        } // Fin del if de inventario vacio
        for (Vehiculo v : inventario) { // Recorre cada vehiculo en la lista
            System.out.println(v); // Imprime la representacion textual del vehiculo
        } // Fin del for-each
    } // Fin de listarInventario

    //========================================================================================================
    // Actualiza un vehiculo identificado por su ID
    //========================================================================================================
    private static void actualizarVehiculo(Scanner sc, List<Vehiculo> inventario) { // Metodo para actualizar un vehiculo existente
        System.out.println("\n--- Actualizar Vehiculo ---"); // Encabezado de actualizacion
        int id = leerEntero(sc, "Ingrese ID a actualizar: ", 1, Integer.MAX_VALUE); // Solicita el ID del vehiculo a actualizar
        int idx = buscarIndicePorId(inventario, id); // Busca el indice del vehiculo con ese ID
        if (idx == -1) { // Si no se encuentra el ID
            System.out.println("No existe un vehiculo con ID=" + id); // Informa que no existe
            return; // Sale del metodo porque no hay nada que actualizar
        } // Fin del if de no encontrado

        Vehiculo actual = inventario.get(idx); // Obtiene la referencia al vehiculo actual
        System.out.println("Actual actual: " + actual); // Muestra el estado actual del vehiculo para referencia

        // Actualiza atributos comunes para cualquier subclase
        String nuevaMarca = leerTextoNoVacio(sc, "Nueva marca: "); // Solicita nueva marca
        String nuevoModelo = leerTextoNoVacio(sc, "Nuevo modelo: "); // Solicita nuevo modelo
        int nuevoAnio = leerEntero(sc, "Nuevo año (1900-2100): ", 1900, 2100); // Solicita nuevo año
        int nuevaCap = leerEntero(sc, "Nueva capacidad de pasajeros: ", 0, 10000); // Solicita nueva capacidad de pasajeros

        // Determina el tipo de subclase y reconstruye el objeto con los nuevos datos
        if (actual instanceof Automovil) { // Verifica si es Automovil
            int puertas = leerEntero(sc, "Puertas (2-6): ", 2, 6); // Lee puertas
            String combustible = leerTextoNoVacio(sc, "Tipo combustible: "); // Lee tipo de combustible
            Automovil nuevo = new Automovil(id, nuevaMarca, nuevoModelo, nuevoAnio, nuevaCap, puertas, combustible); // Crea nuevo Automovil con datos actualizados
            inventario.set(idx, nuevo); // Reemplaza el objeto en el inventario
            System.out.println("Automovil actualizado."); // Confirma actualizacion
        } else if (actual instanceof Tren) { // Si es Tren
            int vagones = leerEntero(sc, "Vagones (1-200): ", 1, 200); // Lee cantidad de vagones
            boolean electrico = leerSiNo(sc, "¿Es electrico? (s/n): "); // Lee si es electrico
            Tren nuevo = new Tren(id, nuevaMarca, nuevoModelo, nuevoAnio, nuevaCap, vagones, electrico); // Crea nuevo Tren con datos actualizados
            inventario.set(idx, nuevo); // Reemplaza el objeto
            System.out.println("Tren actualizado."); // Confirma actualizacion
        } else if (actual instanceof Avion) { // Si es Avion
            int motores = leerEntero(sc, "Motores (1-8): ", 1, 8); // Lee numero de motores
            String aerolinea = leerTextoNoVacio(sc, "Aerolinea: "); // Lee aerolinea
            Avion nuevo = new Avion(id, nuevaMarca, nuevoModelo, nuevoAnio, nuevaCap, motores, aerolinea); // Crea nuevo Avion con datos actualizados
            inventario.set(idx, nuevo); // Reemplaza el objeto
            System.out.println("Avion actualizado."); // Confirma actualizacion
        } else if (actual instanceof Barco) { // Si es Barco
            double tonelaje = leerDouble(sc, "Tonelaje (0.1 - 500000.0): ", 0.1, 500000.0); // Lee tonelaje
            String tipoBarco = leerTextoNoVacio(sc, "Tipo de barco: "); // Lee tipo de barco
            Barco nuevo = new Barco(id, nuevaMarca, nuevoModelo, nuevoAnio, nuevaCap, tonelaje, tipoBarco); // Crea nuevo Barco con datos actualizados
            inventario.set(idx, nuevo); // Reemplaza el objeto
            System.out.println("Barco actualizado."); // Confirma actualizacion
        } else if (actual instanceof ScooterElectrico) { // Si es ScooterElectrico
            int autonomia = leerEntero(sc, "Autonomia (km, 1-300): ", 1, 300); // Lee autonomia
            int potencia = leerEntero(sc, "Potencia (W, 100-10000): ", 100, 10000); // Lee potencia
            ScooterElectrico nuevo = new ScooterElectrico(id, nuevaMarca, nuevoModelo, nuevoAnio, nuevaCap, autonomia, potencia); // Crea nuevo Scooter con datos actualizados
            inventario.set(idx, nuevo); // Reemplaza el objeto
            System.out.println("Scooter Electrico actualizado."); // Confirma actualizacion
        } else { // Tipo desconocido (no esperado)
            System.out.println("Tipo de vehiculo no soportado para actualizacion."); // Mensaje de seguridad
        } // Fin de la cascada de instanceof
    } // Fin de actualizarVehiculo

    //========================================================================================================
    // Elimina un vehiculo identificado por su ID
    //========================================================================================================
    private static void eliminarVehiculo(Scanner sc, List<Vehiculo> inventario) { // Metodo para eliminar un vehiculo por ID
        System.out.println("\n--- Eliminar Vehiculo ---"); // Encabezado de eliminacion
        int id = leerEntero(sc, "Ingrese ID a eliminar: ", 1, Integer.MAX_VALUE); // Solicita el ID a eliminar
        int idx = buscarIndicePorId(inventario, id); // Busca el indice correspondiente en la lista
        if (idx == -1) { // Si no existe ese ID
            System.out.println("No existe un vehiculo con ID=" + id); // Informa que no fue encontrado
            return; // Sale del metodo porque no puede eliminar
        } // Fin del if de no encontrado
        Vehiculo eliminado = inventario.remove(idx); // Elimina el vehiculo y obtiene la referencia del eliminado
        System.out.println("Eliminado: " + eliminado); // Muestra el vehiculo que fue eliminado
    } // Fin de eliminarVehiculo

    //========================================================================================================
    // Constructores de subclases
    //========================================================================================================
    
    //========================================================================================================
    // Crea un Automovil validando ID unico y datos
    //========================================================================================================
    private static Automovil crearAutomovil(Scanner sc, List<Vehiculo> inventario) { // Metodo para construir un Automovil
        int id = leerIdUnico(sc, inventario); // Lee un ID unico que no exista en el inventario
        String marca = leerTextoNoVacio(sc, "Marca: "); // Lee la marca del automovil
        String modelo = leerTextoNoVacio(sc, "Modelo: "); // Lee el modelo del automovil
        int anio = leerEntero(sc, "Año (1900-2100): ", 1900, 2100); // Lee el año de fabricacion
        int cap = leerEntero(sc, "Capacidad de pasajeros (1-1000): ", 1, 1000); // Lee la capacidad de pasajeros
        int puertas = leerEntero(sc, "Puertas (2-6): ", 2, 6); // Lee el numero de puertas
        String combustible = leerTextoNoVacio(sc, "Tipo de combustible (gasolina/diesel/hibrido/electrico): "); // Lee el tipo de combustible
        return new Automovil(id, marca, modelo, anio, cap, puertas, combustible); // Retorna la instancia construida
    } // Fin de crearAutomovil

    //========================================================================================================
    // Crea un Tren con validaciones
    //========================================================================================================
    private static Tren crearTren(Scanner sc, List<Vehiculo> inventario) { // Metodo para construir un Tren
        int id = leerIdUnico(sc, inventario); // Lee un ID unico
        String marca = leerTextoNoVacio(sc, "Marca: "); // Lee la marca
        String modelo = leerTextoNoVacio(sc, "Modelo: "); // Lee el modelo
        int anio = leerEntero(sc, "Año (1900-2100): ", 1900, 2100); // Lee el año
        int cap = leerEntero(sc, "Capacidad de pasajeros (1-2000): ", 1, 2000); // Lee la capacidad
        int vagones = leerEntero(sc, "Numero de vagones (1-200): ", 1, 200); // Lee los vagones
        boolean electrico = leerSiNo(sc, "¿Es electrico? (s/n): "); // Lee si es electrico
        return new Tren(id, marca, modelo, anio, cap, vagones, electrico); // Retorna la instancia
    } // Fin de crearTren

    //========================================================================================================
    // Crea un Avion con validaciones
    //========================================================================================================
    private static Avion crearAvion(Scanner sc, List<Vehiculo> inventario) { // Metodo para construir un Avion
        int id = leerIdUnico(sc, inventario); // Lee un ID unico
        String marca = leerTextoNoVacio(sc, "Marca: "); // Lee la marca
        String modelo = leerTextoNoVacio(sc, "Modelo: "); // Lee el modelo
        int anio = leerEntero(sc, "Año (1900-2100): ", 1900, 2100); // Lee el año
        int cap = leerEntero(sc, "Capacidad de pasajeros (1-1000): ", 1, 1000); // Lee la capacidad
        int motores = leerEntero(sc, "Motores (1-8): ", 1, 8); // Lee numero de motores
        String aerolinea = leerTextoNoVacio(sc, "Aerolinea: "); // Lee la aerolinea
        return new Avion(id, marca, modelo, anio, cap, motores, aerolinea); // Retorna la instancia
    } // Fin de crearAvion

    //========================================================================================================
    // Crea un Barco con validaciones
    //========================================================================================================
    private static Barco crearBarco(Scanner sc, List<Vehiculo> inventario) { // Metodo para construir un Barco
        int id = leerIdUnico(sc, inventario); // Lee un ID unico
        String marca = leerTextoNoVacio(sc, "Marca: "); // Lee la marca
        String modelo = leerTextoNoVacio(sc, "Modelo: "); // Lee el modelo
        int anio = leerEntero(sc, "Año (1900-2100): ", 1900, 2100); // Lee el año
        int cap = leerEntero(sc, "Capacidad de pasajeros (0-10000): ", 0, 10000); // Lee la capacidad
        double tonelaje = leerDouble(sc, "Tonelaje (0.1 - 500000.0): ", 0.1, 500000.0); // Lee el tonelaje
        String tipo = leerTextoNoVacio(sc, "Tipo de barco (carga/pasajeros/velero/pesquero/...): "); // Lee el tipo de barco
        return new Barco(id, marca, modelo, anio, cap, tonelaje, tipo); // Retorna la instancia
    } // Fin de crearBarco

    //========================================================================================================
    // Crea un ScooterElectrico con validaciones
    //========================================================================================================
    private static ScooterElectrico crearScooter(Scanner sc, List<Vehiculo> inventario) { // Metodo para construir un ScooterElectrico
        int id = leerIdUnico(sc, inventario); // Lee un ID unico
        String marca = leerTextoNoVacio(sc, "Marca: "); // Lee la marca
        String modelo = leerTextoNoVacio(sc, "Modelo: "); // Lee el modelo
        int anio = leerEntero(sc, "Año (1900-2100): ", 1900, 2100); // Lee el año
        int cap = leerEntero(sc, "Capacidad de pasajeros (1-2): ", 1, 2); // Lee la capacidad tipica
        int autonomia = leerEntero(sc, "Autonomia (km, 1-300): ", 1, 300); // Lee la autonomia
        int potencia = leerEntero(sc, "Potencia (W, 100-10000): ", 100, 10000); // Lee la potencia
        return new ScooterElectrico(id, marca, modelo, anio, cap, autonomia, potencia); // Retorna la instancia
    } // Fin de crearScooter

    //========================================================================================================
    // Utilidades de busqueda y validacion
    //========================================================================================================

    //========================================================================================================
    // Busca el indice de un vehiculo por su ID, o -1 si no existe
    //========================================================================================================
    private static int buscarIndicePorId(List<Vehiculo> inventario, int id) { // Metodo para obtener el indice de un ID
        for (int i = 0; i < inventario.size(); i++) { // Recorre la lista con indices
            if (inventario.get(i).getId() == id) { // Compara el ID del elemento actual
                return i; // Retorna el indice cuando encuentra coincidencia
            } // Fin del if de coincidencia
        } // Fin del for
        return -1; // Retorna -1 cuando no se encontro el ID
    } // Fin de buscarIndicePorId

    //========================================================================================================
    // Lee un ID que no este repetido en el inventario
    //========================================================================================================
    private static int leerIdUnico(Scanner sc, List<Vehiculo> inventario) { // Metodo para leer un ID unico
        while (true) { // Bucle hasta obtener un ID valido y unico
            int id = leerEntero(sc, "ID (entero positivo, no repetido): ", 1, Integer.MAX_VALUE); // Lee un entero positivo
            int idx = buscarIndicePorId(inventario, id); // Verifica si ya existe en la lista
            if (idx == -1) { // Si no se encuentra el ID
                return id; // Retorna el ID al no estar repetido
            } // Fin del if de no repetido
            System.out.println("El ID ya existe, ingrese otro."); // Pide reintentar cuando el ID esta repetido
        } // Fin del while
    } // Fin de leerIdUnico

    //========================================================================================================
    // Lectura validada de entradas
    //========================================================================================================

    //========================================================================================================
    // Lee un entero con validacion de formato y rango usando try-catch
    //========================================================================================================
    private static int leerEntero(Scanner sc, String prompt, int min, int max) { // Metodo para leer enteros con validacion
        while (true) { // Bucle de reintentos hasta que la entrada sea valida
            try { // Intenta parsear la entrada como entero
                System.out.print(prompt); // Muestra el mensaje al usuario
                String linea = sc.nextLine(); // Lee la linea completa ingresada
                int valor = Integer.parseInt(linea.trim()); // Convierte el texto a int despues de recortar espacios
                if (valor < min || valor > max) { // Verifica si el valor esta fuera del rango permitido
                    System.out.println("Valor fuera de rango (" + min + " - " + max + ")."); // Informa el error de rango
                    continue; // Continua con el siguiente intento de lectura
                } // Fin de la validacion de rango
                return valor; // Retorna el entero valido
            } catch (NumberFormatException e) { // Captura el error cuando el texto no es un entero valido
                System.out.println("Entrada invalida. Ingrese un numero entero."); // Informa del formato incorrecto
            } // Fin del bloque catch
        } // Fin del while continuo
    } // Fin de leerEntero
    
    //========================================================================================================
    // Lee un double con validacion de formato y rango usando try-catch
    //========================================================================================================
    private static double leerDouble(Scanner sc, String prompt, double min, double max) { // Metodo para leer decimales con validacion
        while (true) { // Bucle de reintentos
            try { // Intenta convertir el texto a double
                System.out.print(prompt); // Muestra el mensaje al usuario
                String linea = sc.nextLine(); // Lee la linea completa
                double valor = Double.parseDouble(linea.trim()); // Parsea el texto a double
                if (valor < min || valor > max) { // Verifica rango permitido
                    System.out.println("Valor fuera de rango (" + min + " - " + max + ")."); // Informa error de rango
                    continue; // Repite la lectura
                } // Fin de validacion de rango
                return valor; // Retorna el double valido
            } catch (NumberFormatException e) { // Captura entradas no numericas o mal formateadas
                System.out.println("Entrada invalida. Ingrese un numero (decimal permitido)."); // Informa formato incorrecto
            } // Fin del catch
        } // Fin del while
    } // Fin de leerDouble

    //========================================================================================================
    // Lee un texto no vacio con validacion basica
    //========================================================================================================
    private static String leerTextoNoVacio(Scanner sc, String prompt) { // Metodo para leer cadenas no vacias
        while (true) { // Bucle hasta obtener texto valido
            System.out.print(prompt); // Muestra el mensaje para ingresar texto
            String texto = sc.nextLine(); // Captura la linea de texto
            if (texto != null && !texto.trim().isEmpty()) { // Verifica que el texto no sea null ni vacio
                return texto.trim(); // Retorna el texto recortado de espacios
            } // Fin de la verificacion de null o vacio
            System.out.println("El texto no puede estar vacio."); // Informa que debe ingresar un valor
        } // Fin del while
    } // Fin de leerTextoNoVacio

    //========================================================================================================
    // Lee una respuesta si/no y la convierte a boolean
    //========================================================================================================
    private static boolean leerSiNo(Scanner sc, String prompt) { // Metodo para leer un valor booleano a partir de s/n
        while (true) { // Bucle hasta que se ingrese una opcion valida
            System.out.print(prompt); // Muestra el mensaje de s/n
            String resp = sc.nextLine(); // Lee la respuesta completa
            if (resp == null) { // Verifica null por seguridad
                System.out.println("Ingrese 's' o 'n'."); // Pide un valor valido
                continue; // Repite el ciclo
            } // Fin del control de null
            resp = resp.trim().toLowerCase(); // Normaliza la respuesta para comparar
            if (resp.equals("s") || resp.equals("si") || resp.equals("si")) { // Acepta variantes de afirmativo
                return true; // Retorna verdadero para afirmativo
            } else if (resp.equals("n") || resp.equals("no")) { // Acepta variantes de negativo
                return false; // Retorna falso para negativo
            } // Fin de comparacion de opciones
            System.out.println("Ingrese 's' o 'n'."); // Informa que la opcion es invalida y debe reintentar
        } // Fin del while
    } // Fin de leerSiNo
} // Fin de la clase App
