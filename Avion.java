package Herencia;
//========================================================================================================
// Subclase Avion que extiende de Vehiculo
//========================================================================================================
public class Avion extends Vehiculo { // Definición de la clase Avion
    //========================================================================================================
    // Atributos específicos del avión
    //========================================================================================================
    private int motores; // Número de motores del avión
    private String aerolinea; // Aerolínea a la que pertenece o modelo comercial
    
    //========================================================================================================
    // Constructor que inicializa base y propios
    //========================================================================================================
    public Avion(int id, String marca, String modelo, int anio, int capacidadPasajeros, int motores, String aerolinea) { // Constructor completo
        super(id, marca, modelo, anio, capacidadPasajeros); // Inicializa atributos de Vehiculo
        this.motores = motores; // Asigna motores
        this.aerolinea = aerolinea; // Asigna aerolínea
    }
    
    //========================================================================================================
    // Getters y setters
    //========================================================================================================

    public int getMotores() {
        return motores;
    }

    public void setMotores(int motores) {
        this.motores = motores;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }
    
    
    //========================================================================================================
    // toString con detalles del avión
    //========================================================================================================
    @Override // Sobreescritura del método
    public String toString() {
        return "Avion{" + super.toString() + ", motores=" + motores + ", aerolinea='" + aerolinea + '\'' + '}';
    }
}
