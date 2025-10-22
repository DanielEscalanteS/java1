package Herencia;
//========================================================================================================
// Subclase Barco que extiende de Vehiculo
//========================================================================================================
public class Barco extends Vehiculo {
    
    //========================================================================================================
    // Atributos específicos del barco
    //========================================================================================================
    private double tonelaje; // Tonelaje bruto o desplazamiento
    private String tipoBarco; // Tipo (carga, pasaje, velero, pesquero, etc.)
    
    //========================================================================================================
    // Constructor que inicializa base y propios
    //========================================================================================================
    public Barco(int id, String marca, String modelo, int anio, int capacidadPasajeros, double tonelaje, String tipoBarco) { // Constructor completo
        super(id, marca, modelo, anio, capacidadPasajeros); // Llamada a super
        this.tonelaje = tonelaje; // Asignación de tonelaje
        this.tipoBarco = tipoBarco; // Asignación de tipo de barco
    } // Fin del constructor

    //========================================================================================================
    // Getters y setters
    //========================================================================================================

    public double getTonelaje() {
        return tonelaje;
    }

    public void setTonelaje(double tonelaje) {
        this.tonelaje = tonelaje;
    }

    public String getTipoBarco() {
        return tipoBarco;
    }

    public void setTipoBarco(String tipoBarco) {
        this.tipoBarco = tipoBarco;
    }
    
    
    //========================================================================================================
    // toString de Barco
    //========================================================================================================
    @Override // Sobreescritura de toString
    public String toString() {
        return "Barco{" + super.toString() + ", tonelaje=" + tonelaje + ", tipoBarco='" + tipoBarco + '\'' + '}';
    }
}

