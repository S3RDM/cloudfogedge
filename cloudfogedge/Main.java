package cloudfogedge;

public class Main{
    public static void main(String[] args){
        CloudServer cloudServer = new CloudServer();
        FogNode fogNode = new FogNode(cloudServer);
        EdgeNode edgeNode = new EdgeNode(fogNode);

        edgeNode.datos(5);

        cloudServer.resumen();
    }
}