package cloudfogedge;
import java.util.ArrayList;

public class CloudServer{
    private ArrayList<SensorData> dataList;

    public CloudServer(){
        dataList = new ArrayList<>();
    }

    public void saveData(SensorData data){
        dataList.add(data);
    }

    public void resumen(){
        System.out.println("\n--- Resumen Cloud Server ---");
        for (SensorData data : dataList) {
            System.out.println(data);
        }
        System.out.println("Total de datos: " + dataList.size());
    }
}