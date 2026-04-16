package cloudfogedge;
import java.util.Random;

public class EdgeNode{
    private FogNode fogNode;
    private int edgeID;
    private Random random;

    public EdgeNode(int edgeID, FogNode fogNode){
        this.edgeID = edgeID;
        this.fogNode = fogNode;
        this.random = new Random();
    }

    public boolean datos(){
            double temperatura = 15 + (40 - 15) * random.nextDouble();
            String sensorID = "F-E" + edgeID;
            SensorData dato = new SensorData(sensorID, temperatura);
            System.out.println("Edge " + edgeID + " genera: " + dato);
            return fogNode.procesarDatos(dato, edgeID);
    }
}