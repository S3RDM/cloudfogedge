package cloudfogedge;

public class FogNode {
    private CloudServer cloudServer;
    private int contadorTemp;
    private final int limite = 20;
    private int fogID;

    public FogNode(int fogID, CloudServer cloudServer) {
        this.fogID = fogID;
        this.cloudServer = cloudServer;
        this.contadorTemp = 0;
    }

    public boolean procesarDatos(SensorData dato, int edgeID){
        System.out.println("FogNode " + fogID + "recibe de " + edgeID + ": " + dato);

        if(dato.getTemperatura() > 30){
            contadorTemp++;
            System.out.println("Temperatura alta detectada: " + contadorTemp);
        }
        cloudServer.guardarDato(dato);
        
        if (contadorTemp >= limite) {
            System.out.println("\nLimite de 20 temperaturas alcanzado por fog " + fogID);
            return false;
        }
        return true;
    }
}