package Herencia;

//========================================================================================================
// Subclase Automovil que extiende de Vehiculo
//========================================================================================================
public class Automovil extends Vehiculo { // Definición de la clase que hereda de Vehiculo
    
    //========================================================================================================
    // Atributos específicos del automóvil
    //========================================================================================================
    private int puertas;
    private String tipoCombustible;

    //========================================================================================================
    // Constructor que llama al constructor de la superclase e inicializa atributos propios
    //========================================================================================================
    public Automovil(int id, String marca, String modelo, int anio, int capacidadPasajeros, int puertas, String tipoCombustible) { // Constructor completo
        super(id, marca, modelo, anio, capacidadPasajeros); // Llamada al constructor de Vehiculo
        this.puertas = puertas; // Asignación del número de puertas
        this.tipoCombustible = tipoCombustible; // Asignación del tipo de combustible
    }
    
    //========================================================================================================
    // Getters y setters específicos
    //========================================================================================================
    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    //========================================================================================================
    // toString que incluye la información de la superclase y de la subclase
    //========================================================================================================
    @Override // Indica que se sobreescribe el método toString
    public String toString() { // Método de representación en texto
        return "Automovil{" + super.toString() + ", puertas=" + puertas + ", tipoCombustible='" + tipoCombustible + '\'' + '}';
    }
}
