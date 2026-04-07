package cloudfogedge;

public class SensorData{
    private final String sensorID;
    private final double temperatura;

    public SensorData(String sensorID, double temperatura){
        this.sensorID = sensorID;
        this.temperatura = temperatura;
    }

    public String getSensorID(){
        return sensorID;
    }

    public double getTemperatura(){
        return temperatura;
    }

    @Override
    public String toString(){
        return "Sensor: " + sensorID + ", Temperatura: " + temperatura;
    }
}