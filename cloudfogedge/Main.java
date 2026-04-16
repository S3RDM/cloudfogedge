package cloudfogedge;

public class Main{
    public static void main(String[] args){
        CloudServer cloudServer = new CloudServer();
        FogNode[] fogNodes = new FogNode[5];
        EdgeNode[] edgeNodes = new EdgeNode[25];
        int cont = 0;
        
        for(int i = 0; i < 5; i++){
            fogNodes[i] = new FogNode(i + 1, cloudServer);
            for(int j = 0; j < 5; j++){
                edgeNodes[cont] = new EdgeNode(cont + 1, fogNodes[i]);
                cont++;
            }
        }
        boolean continuar = true;
        while(continuar){
            for(int i = 0; i < edgeNodes.length; i++){
                continuar = edgeNodes[i].datos();
                if (!continuar) break;
            }
        }
        System.out.println("\nSistema detenido.");
        cloudServer.resumen();
    }
}