package Herencia; // Declaración del paquete para organizar las clases

//========================================================================================================
// Clase base abstracta que modela atributos comunes de cualquier vehículo
//========================================================================================================
public class Vehiculo { // Definición de clase abstracta para evitar instanciación directa
    
    //========================================================================================================
    // Atributos protegidos accesibles por subclases
    //========================================================================================================
    protected int id; // Identificador único del vehículo
    protected String marca; // Marca del vehículo
    protected String modelo; // Modelo del vehículo
    protected int anio; // Año de fabricación
    protected int capacidadPasajeros; // Capacidad de pasajeros
    
    //========================================================================================================
    // Constructor para inicializar todos los atributos comunes
    //========================================================================================================
    
    public Vehiculo(int id, String marca, String modelo, int anio, int capacidadPasajeros) { // Constructor con parámetros
        this.id = id; // Asignación del identificador
        this.marca = marca; // Asignación de la marca
        this.modelo = modelo; // Asignación del modelo
        this.anio = anio; // Asignación del año
        this.capacidadPasajeros = capacidadPasajeros; // Asignación de la capacidad de pasajeros
    }
    
    //========================================================================================================
    // Getters y setters para cada atributo
    //========================================================================================================
    /*
        Los getters devuelven el valor de un atributo y los setters lo modifican, ofreciendo una interfaz estable para acceder al estado y 
        posibilitando validaciones o lógica antes de asignar, lo cual es parte típica de la encapsulación en Java. La encapsulación se logra 
        habitualmente haciendo los campos privados y exponiendo getters/setters públicos; usar protected, como en la clase, es una forma más débil 
        porque da acceso directo a subclases y clases del mismo paquete. Aunque existan getters/setters, si los campos no están encapsulados 
        (por ejemplo, públicos), estos métodos no aportarían control efectivo; su valor está en canalizar el acceso a través de la API de la clase.
    */
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }
    //========================================================================================================
    // Representación de texto básica del vehículo
    //========================================================================================================
    /*
        @Override indica explícitamente que un método pretende sobrescribir uno declarado en una superclase, y si la firma no coincide 
        el compilador emitirá un error, evitando “sobrecargas accidentales” por nombres o parámetros erróneos. Además mejora la legibilidad 
        del código al dejar claro qué métodos provienen de la jerarquía y cuáles son nuevos en la subclase, lo que es considerada una buena práctica habitual.
    */
    
    @Override // Anotación para indicar sobreescritura
    /*
        toString pertenece a Object y devuelve una representación textual del objeto; por defecto produce algo como NombreDeClase@hashHex, 
        por lo que sobrescribirlo permite mostrar información significativa del estado. Cuando se imprime una referencia (por ejemplo, 
        con System.out.println(obj)), Java invoca internamente toString, de ahí su utilidad para logging y depuración. Oracle recomienda 
        que el resultado sea conciso pero informativo, describiendo textualmente el objeto de forma útil.
    */
    
    public String toString() { // Método para describir el objeto como texto
        return "Vehiculo{" + "id=" + id + ", marca='" + marca + '\'' + ", modelo='" + modelo + '\'' + ", anio=" + anio + ", capacidadPasajeros=" + capacidadPasajeros + '}';
    }
}
