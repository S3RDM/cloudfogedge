package cloudfogedge;
import java.util.ArrayList;

public class CloudServer{
    private SensorData[] dataList;
    private int cont;
    
    public CloudServer(){
        dataList = new SensorData[1000];
        cont = 0;
    }

    public void guardarDato(SensorData data){
        if (cont < dataList.length) {
            dataList[cont++] = data;
        }
    }

    public void resumen(){
        System.out.println("\n--- Resumen Cloud Server ---");
        for (SensorData data : dataList) {
            System.out.println(data);
        }
        System.out.println("Total de datos: " + cont);
    }
}