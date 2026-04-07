package cloudfogedge;

public class FogNode {
    private CloudServer cloudServer;
    private int contadorTemp;
    private final int limite = 20;

    public FogNode(CloudServer cloudServer){
        this.cloudServer = cloudServer;
    }

    public boolean procesarDatos(SensorData dato){
        System.out.println("FogNode recibe: " + dato);

        if(dato.getTemperatura() > 30){
            contadorTemp++;
            System.out.println("Temperatura alta detectada.");
        }
        cloudServer.saveData(dato);
        
        if (contadorTemp >= limite) {
            System.out.println("\n--- Limite de 20 temperaturas alcanzado ---");
            return false;
        }

        return true;
    }
}