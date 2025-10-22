package Herencia;
//========================================================================================================
// Subclase ScooterElectrico que extiende de Vehiculo
//========================================================================================================
public class ScooterElectrico extends Vehiculo { // Definición de la clase ScooterElectrico

    //========================================================================================================
    // Atributos específicos del scooter eléctrico
    //========================================================================================================
    
    private int autonomiaKm; // Autonomía en kilómetros
    private int potenciaW; // Potencia del motor en watts

    //========================================================================================================
    // Constructor que inicializa base y propios
    //========================================================================================================
    
    public ScooterElectrico(int id, String marca, String modelo, int anio, int capacidadPasajeros, int autonomiaKm, int potenciaW) { // Constructor completo
        super(id, marca, modelo, anio, capacidadPasajeros); // Inicializa atributos de Vehiculo
        this.autonomiaKm = autonomiaKm; // Asignación de autonomía
        this.potenciaW = potenciaW; // Asignación de potencia
    } // Fin del constructor

    //========================================================================================================
    // Getters y setters
    //========================================================================================================

    public int getAutonomiaKm() {
        return autonomiaKm;
    }

    public void setAutonomiaKm(int autonomiaKm) {
        this.autonomiaKm = autonomiaKm;
    }

    public int getPotenciaW() {
        return potenciaW;
    }

    public void setPotenciaW(int potenciaW) {
        this.potenciaW = potenciaW;
    }
    
    //========================================================================================================
    // toString para mostrar datos del scooter
    //========================================================================================================
    @Override
    public String toString() { // Representación de texto
        return "ScooterElectrico{" + super.toString() + ", autonomiaKm=" + autonomiaKm + ", potenciaW=" + potenciaW + '}';
    } // Fin de toString
} // Fin de la clase ScooterElectrico
