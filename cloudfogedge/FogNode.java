package cloudfogedge;

public class FogNode {
    private CloudServer cloudServer;

    public FogNode(CloudServer cloudServer){
        this.cloudServer = cloudServer;
    }

    public void procesarDatos(SensorData dato){
        System.out.println("FogNode recibe: " + dato);

        if(dato.getTemperatura() > 30){
            System.out.println("Temperatura alta detectada.");
        }
        cloudServer.saveData(dato);
    }
}
