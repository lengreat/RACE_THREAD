package game;

//Bloque.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Bloque extends JPanel implements Runnable{
  int numPanel;
  Asignacion arreglo;
  Thread hilo;
  int  num;
  int h1=0;//avance del bloque azul
  int primer;//posiciones de los bloques dentro del conjunto de paneles
  int ultimo;
  int medio;
  int velocidad=100;
  int hPanel, hBloque;
    
  public Bloque(int numPanel, Asignacion arreglo){
    this.numPanel=numPanel;
    this.arreglo=arreglo;
    setOpaque(true);
    num=arreglo.a[numPanel];//el elemento del arreglo aleatorio
    primer=1;
    ultimo=arreglo.a.length;//escoje ultimo numero entre el 1 al tamanio del arreglo
    medio=(ultimo/2);
    //En donde se encuentren estos numeros se posicionaran los bloques
    hilo=new Thread(this);
    empezarHilo();
    addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent mouse){
               if (velocidad>10){
                 setBackground(Color.blue);
                 velocidad=velocidad-10;
               }
               
        }
    });//fin de MouseListener      
  }//fin de constructor Bloque

  public void run(){
    do{
      try{
          Thread.sleep(velocidad);
          repaint();//aqui se llama metodo paint
      }
      catch(InterruptedException e){}
      h1++;
    }while(h1<(hPanel-hBloque));//hasta q el avance llegue al final del panel
    Thread.interrupted();
  }//fin de run

  public void paint(Graphics g){//se llama con la creacion del JPanel

    super.paint(g);
    hPanel=getSize().height;
    hBloque=hPanel/14;
    int anchoN=getSize().width;
    int anchoB=anchoN-2;//para dejar margen

    if ((numPanel%2)==0){
      setBackground(Color.white);//paneles blancos
      if ((num==primer)||(num==medio)||(num==ultimo)){//posicionando bloque
        g.setColor(Color.blue);
        g.fillRect(1, h1, anchoB, hBloque);//bloque
      }
    }
    else{
      setBackground(Color.BLACK);//paneles negros
      if ((num==primer)||(num==medio)||(num==ultimo)){//posicionando bloque
        g.setColor(Color.blue);
        g.fillRect(0, h1, anchoN, hBloque);//bloque
      }
    }

  }//fin de paint

  public void empezarHilo(){
    if ((num==primer)||(num==medio)||(num==ultimo)){
     hilo.start();//Arranca el metodo run()
    }//fin de if
  }//fin de metodo empezarHilo














}




