package game;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;




public class Juego extends JFrame {
    Bloque[] bloque;
    int[] hor;
    int cantidadPistas=15;//NO PUEDE SER MENOR A 3
    JPanel container;
    Asignacion arregloLleno;
    public Juego(){
        super("Juego Pista de Bloques");
        creacionArreglo();
        bloque=new Bloque[hor.length];
        add(container=new JPanel());
        mostrar();
        setVisible(true);
    }

    private void creacionArreglo() {
      hor=new int[cantidadPistas];
      for(int i=0; i<cantidadPistas;i++)
         hor[i]=(i+1);
    }

    public void mostrar(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(588,700);
        setResizable(false);
        container.setLayout(new GridLayout(1, hor.length));
        container.setBackground(Color.red);
        crearPaneles();
    }
    public void crearPaneles(){
        arregloLleno=new Asignacion(hor.length);
        for(int i=0; i<hor.length;i++)
          System.out.print(arregloLleno.a[i]+"-");
        for(int i=0; i<hor.length;i++){
              bloque[i]=new Bloque(i, arregloLleno);
              container.add(bloque[i]);
        }

  }
}
