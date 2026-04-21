package cloudfogedge;

public class FogNode{
    private CloudServer cloudServer;
    private int contadorTemp;
    private final int limite = 20;
    private int fogID;

    private SensorData[] buffer;
    private int bufferIndex;
    
    public FogNode(int fogID, CloudServer cloudServer) {
        this.fogID = fogID;
        this.cloudServer = cloudServer;
        this.contadorTemp = 0;
        this.buffer = new SensorData[5];
        this.bufferIndex = 0;
    }

    public boolean procesarDatos(SensorData dato, int edgeID){
        System.out.println("FogNode " + fogID + " recibe de " + edgeID + ": " + dato);

        if(dato.getTemperatura() > 30){
            contadorTemp++;
            System.out.println("Temperatura alta detectada: " + contadorTemp);
        }
        
        buffer[bufferIndex++] = dato;
        
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        if(bufferIndex == 5) {
            System.out.println("Fog " + fogID + " envía 5 datos a Cloud");

            for (int i = 0; i < 5; i++) {
                cloudServer.guardarDato(buffer[i]);
            }

            bufferIndex = 0; // reset buffer
        }
        
        if (contadorTemp >= limite) {
            System.out.println("\nLimite de 20 temperaturas alcanzado por fog " + fogID);
            return false;
        }
        return true;
    }
}