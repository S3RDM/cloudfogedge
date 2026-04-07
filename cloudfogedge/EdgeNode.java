package cloudfogedge;
import java.util.Random;

public class EdgeNode {
    private FogNode fogNode;
    private Random random;

    public EdgeNode(FogNode fogNode) {
        this.fogNode = fogNode;
        this.random = new Random();
    }

    public void datos(int numData){
        for (int i = 0; i < numData; i++){
            String sensorId = "Sensor-" + (i + 1);
            double temperatura = 15 + (40 - 15) * random.nextDouble();
            SensorData dato = new SensorData(sensorId, temperatura);
            System.out.println("EdgeNode genera: " + dato);
            fogNode.procesarDatos(dato);
        }
    }
}