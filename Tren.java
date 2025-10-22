package Herencia;

//========================================================================================================
// Subclase Tren que extiende de Vehiculo
//========================================================================================================
public class Tren extends Vehiculo { // Definición de la clase Tren
    
    //========================================================================================================
    // Atributos específicos del tren
    //========================================================================================================
    private int vagones; // Cantidad de vagones
    private boolean electrico; // Indica si es eléctrico
    
    //========================================================================================================
    // Constructor con llamada al constructor de la superclase
    //========================================================================================================
    public Tren(int id, String marca, String modelo, int anio, int capacidadPasajeros, int vagones, boolean electrico) { // Constructor completo
        super(id, marca, modelo, anio, capacidadPasajeros); // Inicialización de atributos base
        this.vagones = vagones; // Asignación de vagones
        this.electrico = electrico; // Asignación de si es eléctrico
    }
    
    //========================================================================================================
    // Getters y setters
    //========================================================================================================

    public int getVagones() {
        return vagones;
    }

    public void setVagones(int vagones) {
        this.vagones = vagones;
    }

    public boolean isElectrico() {
        return electrico;
    }

    public void setElectrico(boolean electrico) {
        this.electrico = electrico;
    }
    
    //========================================================================================================
    // toString para describir el tren
    //========================================================================================================
    @Override // Sobreescritura
    public String toString() {
        return "Tren{" + super.toString() + ", vagones=" + vagones + ", electrico=" + electrico + '}';
    }
}
