import greenfoot.*;
import java.util.List;
/**
 * Clase donde se lleva el control de todo lo que sucede en el escenario, niveles, puntos, etc.
 */
public class Control extends Actor
{
    /**
     * Act - do whatever the Control wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int BanderaC;
    private int puntos;
    public int nivel=1;
    private boolean portada;
    private boolean Nivel_1;
    private boolean Nivel_1p2;
    private boolean Nive2_2;
    private boolean Nive2_2p2;
    private boolean Nive3_3;
    private boolean Nive3_3p2;
    private boolean Win;
    private GreenfootSound audio; 
    private GreenfootSound nivels;
    private GreenfootSound win;
    int c=0;
    private World w;
    /**
     * Metodo que inicializa los valores de la clase
     */
    public Control()
    {
        BanderaC=0;
        puntos=0;    
        audio = new GreenfootSound("2.mid");   
        nivels = new GreenfootSound("metalcap.mid");
        //win = new GreenfootSound("screen.mp3");
        
    }
    /**
     * Metodo que realiza todo el movimiento y control del escenario
     */
    public void  act()
    {
         List cn;
        Control n;
        w=getWorld();
         
        switch(BanderaC)
        {
            case 0: 
                    if(!portada)
                    {
                        w.addObject(new Menu(),w.getWidth()/2,w.getHeight()/2);
                        audio.playLoop();
                        //audio.stop();
                        portada=true;
                        c=0;
                    }
                    break;
            case 1:
                    if(!Nivel_1)
                    {
                        audio.stop();
                        nivels.playLoop();
                        CargaN1_p1();
                        
                        Nivel_1=true;
                    }
                    break;
            case 2:
                    if(!Nivel_1p2)
                        {
                         cambiaN1();
                         CargaN1_p2();
                         Nivel_1p2=true;
                        }
                    break;
            case 3: 
                    if(!Nive2_2)
                    {
                        cambiaN2();
                        CargaN2_p1();
                        Nive2_2=true;
                    }
                    break;
            case 4: 
                    if(!Nive2_2p2)
                    {
                        cambiaN2_p2();
                        CargaN2_p2();
                        Nive2_2p2=true;
                    }
                    break;
            case 5: 
                    if(!Nive3_3)
                    {
                        cambiaN3();
                        CargaN3_p1();
                        Nive3_3=true;
                    }
                    break;
            case 6: 
                    if(!Nive3_3p2)
                    {
                        cambiaN3_p2();
                        CargaN3_p2();
                        Nive3_3p2=true;
                        if(isTouching(M1.class))
                         {
                         w.removeObjects(w.getObjects(M1.class));
                         w.addObject(new M2(),700,498);
              
                          cn=w.getObjects(Control.class);
                          n=(Control)cn.get(0);
                          n.ContadorBandera();
                          Win=true;
              
                         }
                        Nive3_3p2=true;
                    }
                    break;
            case 7: 
                    if(!Win)
                    {
                           World w=getWorld();
                           nivels.stop();
                           //win.play();
                           //Greenfoot.playSound("Screen.mp3");
                           w.removeObjects(w.getObjects(N1.class));
                           w.removeObjects(w.getObjects(M1.class));
                           w.removeObjects(w.getObjects(Megaman.class));
                           w.removeObjects(w.getObjects(Vidas.class));
                           w.removeObjects(w.getObjects(Gato.class));
                           w.removeObjects(w.getObjects(Pajaro.class));
                           w.removeObjects(w.getObjects(Robot.class));
                           w.removeObjects(w.getObjects(Salida.class));
                        w.addObject(new Win(), w.getWidth()/2 , w.getHeight()/2 );
                        
                    }
                    break;
               
        }
    }  
    /**
     * Este metodo sirve para cambiar el escenario
     */
    public void ContadorBandera()
    {
        BanderaC++;
    }
    /**
     * Aqui se carga el nivel 1
     */
    public void CargaN1_p1()
    {
        World w=getWorld();
        //audio.stop();
        w.addObject(new nubes(), 400,300);
        w.addObject(new N1(),0,590);
        w.addObject(new Megaman(), 100,560);
        w.addObject(new Vidas(),100,40);
        w.addObject(new Gato(),500,565);
        w.addObject(new Pajaro(),650,560);
        w.addObject(new Pajaro(),300,560);
        w.addObject(new Entrada(),750,560);
        
    }
    /**
     * En este metodo se quitan todos los objetos que existen en el primer nivel para poder cargar la segunda parte
     */
    public void cambiaN1()
    {
        w.removeObjects(w.getObjects(Megaman.class));
       w.removeObjects(w.getObjects(N1.class));
       w.removeObjects(w.getObjects(nubes.class));
       w.removeObjects(w.getObjects(Gato.class));
       w.removeObjects(w.getObjects(Vidas.class));
       w.removeObjects(w.getObjects(Pajaro.class));
       w.removeObjects(w.getObjects(Entrada.class));
    }
    /**
     * Aqui se carga la segunda parte del nivel 1
     */
    public void CargaN1_p2()
    {
        World w=getWorld();
        w.addObject(new nubes(), 400,300);
        w.addObject(new N1(),0,590);
        w.addObject(new M1(),700,498);
        w.addObject(new Megaman(), 200,560);
        w.addObject(new Vidas(),100,40);
         w.addObject(new Robot(),680,565);
        w.addObject(new Pajaro(),650,560);
        w.addObject(new Pajaro(),300,560);
        w.addObject(new Salida(),0,560);
    }
    /**
     * Metodo que quita los objetos para pasar al nivel 2
     */
     public void cambiaN2()
    {
        w.removeObjects(w.getObjects(Megaman.class));
       w.removeObjects(w.getObjects(N1.class));
       w.removeObjects(w.getObjects(M1.class));
       w.removeObjects(w.getObjects(nubes.class));
       w.removeObjects(w.getObjects(Vidas.class));
       w.removeObjects(w.getObjects(Pajaro.class));
       w.removeObjects(w.getObjects(Salida.class));
         w.removeObjects(w.getObjects(Robot.class));
    }
    /**
     * Metodo que inicializa todos los objetos para el segundo nivel
     */
     public void CargaN2_p1()
    {
        World w=getWorld();
        w.addObject(new nubes2(), 400,300);
        w.addObject(new N1(),0,590);
        w.addObject(new Megaman(), 100,560);
        w.addObject(new Vidas(),100,40);
        w.addObject(new Robot(),680,565);
        w.addObject(new Gato(),500,565);
        w.addObject(new Pajaro(),300,560);
        w.addObject(new Entrada(),760,560);
        
    }
    /**
     * Quita los objetos que se encontraban en la primera parte del segundo nivel
     */
     public void cambiaN2_p2()
    {
        w.removeObjects(w.getObjects(Megaman.class));
          w.removeObjects(w.getObjects(Robot.class));
       w.removeObjects(w.getObjects(N1.class));
      w.removeObjects(w.getObjects(Vidas.class));
       w.removeObjects(w.getObjects(Pajaro.class));
       w.removeObjects(w.getObjects(Gato.class));
       w.removeObjects(w.getObjects(Entrada.class));
    }
    /**
     * Coloca los obejtos de la segunda parte del nivel 2
     */
    public void CargaN2_p2()
    {
        World w=getWorld();
        w.addObject(new N1(),0,590);
        w.addObject(new M1(),700,498);
        w.addObject(new Megaman(), 100,560);
        w.addObject(new Vidas(),100,40);
        w.addObject(new Gato(),500,565);
        w.addObject(new Pajaro(),300,560);
        w.addObject(new Pajaro(),450,560);
        w.addObject(new Pajaro(),650,560);
        w.addObject(new Gato(),200,565);
        w.addObject(new Salida(),0,560);
        
    }
    /**
     * Quita los objetos del nivel 3
     */    
    public void cambiaN3()
    {
        w.removeObjects(w.getObjects(Megaman.class));
        w.removeObjects(w.getObjects(M1.class));
       w.removeObjects(w.getObjects(N1.class));
      w.removeObjects(w.getObjects(Vidas.class));
       w.removeObjects(w.getObjects(Pajaro.class));
       w.removeObjects(w.getObjects(Gato.class));
       w.removeObjects(w.getObjects(Salida.class));
    }
    /**
     * Carga los objetos de la primra parte del nivel 3
     */
    public void CargaN3_p1()
    {
        World w=getWorld();
        w.addObject(new nubes3(), 400,300);
        w.addObject(new N1(),0,590);
        w.addObject(new Megaman(), 100,560);
        w.addObject(new Vidas(),100,40);
        w.addObject(new Gato(),300,565);
        w.addObject(new Gato(),550,565);
        w.addObject(new Pajaro(),600,555);
        w.addObject(new Pajaro(),300,555);
        w.addObject(new Entrada(),760,560);
        
    }
    /**
     * Retira los obejtos de la primra parte del nivel 3
     */
     public void cambiaN3_p2()
    {
        w.removeObjects(w.getObjects(Megaman.class));
       w.removeObjects(w.getObjects(N1.class));
      w.removeObjects(w.getObjects(Vidas.class));
       w.removeObjects(w.getObjects(Pajaro.class));
       w.removeObjects(w.getObjects(Gato.class));
       w.removeObjects(w.getObjects(Entrada.class));
    }
    /**
     * Coloca los objetos de la segunda parte del nivel 3 
     */
    public void CargaN3_p2()
    {
        World w=getWorld();
        w.addObject(new N1(),0,590);
        w.addObject(new M1(),700,498);
        w.addObject(new Megaman(), 100,560);
        w.addObject(new Vidas(),100,40);
        w.addObject(new Gato(),500,565);
        w.addObject(new Pajaro(),300,560);
        w.addObject(new Gato(),200,565);
        w.addObject(new Robot(),680,565);
        w.addObject(new Robot(),400,565);
        w.addObject(new Salida(),0,560);
        
    }
    /**
     * Metodo que manda a llamar a la clase Gameover que es donde se encuentra la imagen que nos cambiara al aperder todas las vidas
     */
    public void gameOver()
        {
            nivels.stop();
         World w=getWorld();
         w.addObject(new Gameover(), w.getWidth()/2, w.getHeight()/2);
         int c=0;
         
         if(c>10)
            {
                  portada=false;
                  Nivel_1=false;
                  Nivel_1p2=false;
                  Nive2_2=false;
                  Nive2_2p2=false;
                  Nive3_3=false;
                  Nive3_3p2=false;
                  Win=false;
                  BanderaC=0;
                  List cn;
                  Control n;
            }
            c++;
            
        }
    }