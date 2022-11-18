package game;

public class Asignacion{
    int tam;
    public int a[];
    public  Asignacion(int tam){
        this.tam=tam;
        num();
    }
    public  void num(){
         
            boolean repetidoAleatorio;
            int i=0, stop=0;
            a=new int[tam];
            for (int K_i=0; K_i<a.length; K_i++)
              a[K_i]=0;//enecerando arreglo
            do{
                repetidoAleatorio=true;
                i=(int)(Math.random()*(a.length))+1;//[1 al 30]
                for (int K_j=0; K_j<a.length; K_j++)//buscando aleatorio repetido
                  if (i==a[K_j]){
                    repetidoAleatorio=!repetidoAleatorio;
                    break;
                  }
                if (repetidoAleatorio){//si encontro un repetido no incrementa y continua el loop
                  a[stop]=i;
                  stop++;
                }
            } while(stop<a.length);                            
    }
}