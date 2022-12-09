package game;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;




public class Juego extends JFrame {
    Bloque[] bloque;
    int[] carriles;//arreglo equivalente a carriles
    int cantidadPistas=15;//NO PUEDE SER MENOR A 3
    JPanel container;
    Asignacion arregloLleno;//objeto que realiza la aletoriedad de ubicacion de los bloques
    public Juego(){
        super("Juego Pista de Bloques");
        creacionArreglo();//Arreglo equivalente a cantidad de carriles
        bloque=new Bloque[carriles.length];
        add(container=new JPanel());
        mostrar();//creacion de pista
        setVisible(true);
    }

    private void creacionArreglo() {
      carriles=new int[cantidadPistas];
      for(int i=0; i<cantidadPistas;i++)
         carriles[i]=(i+1);
    }

    public void mostrar(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(588,700);
        setResizable(false);
        container.setLayout(new GridLayout(1, carriles.length));
        //container.setBackground(Color.red);
        crearPaneles();
    }
    public void crearPaneles(){
        arregloLleno=new Asignacion(carriles.length);//creo el arreglo aleatorio
        for(int i=0; i<carriles.length;i++)
          System.out.print(arregloLleno.a[i]+"-");
        for(int i=0; i<carriles.length;i++){
              bloque[i]=new Bloque(i, arregloLleno);//creo los bloques con la informacion del arreglo aleatorio
              container.add(bloque[i]);//en realidad no hay bloques sino paneles con porcion pintada
        }

  }
}
