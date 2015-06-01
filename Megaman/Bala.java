import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
public class Bala  extends Actor
{
    private int x,y;
    private int dir;
    private boolean golpe=false;
    private int cont;
    
    private World w;
    public Bala(int d){
        
         dir=d;
         cont=0;
    }
        
    /**
    * Metodo Actor donde se ejecuta el codigo de la bala
    */
    public void act() 
    {
        // Add your action code here.
        Actor ac;
       // x=getX();
        //y=getY();
        mueveBala(dir);
        w= getWorld();
        compruebaObjetivo() ;
        /*ac=getOneIntersectingObject(Boy.class);
        
        if(ac!=null) {
                ((Boy)ac).aumentaDano();
                //((Vidas)ac).cambiaImagen();
                hit = true;
            }
        
        if(x>=798 || y>=598 || x<=2 || y<=2 || hit){
        getWorld().removeObject(this);
        }*/
        

    }
    /** 
     * Metodo que mueve la bala a la direccion donde se le indica, en este caso la direccion donde este el jugador
       */
   public void mueveBala(int dir){
          x=getX();
          y=getY();
      
       
          if(dir==1){
              setLocation(x-2,y-2);
              }
               else
                  if(dir==2){
                     setLocation(x+2,y);
                     }
                     else
                       if(dir==3){
                          setLocation(x-2,y);
                         
                          }
             if(x==0)
              w.removeObject(this);
                           //x++;
                          cont++;
    }
    /**
    *Metodo que comprueba si la bala le a dado al objetivo; serian los enemigos del mundo
    */
   public void compruebaObjetivo() 
    {
        Enemigos e;
       e=(Enemigos)getOneObjectAtOffset(10,10,Enemigos.class);
       if(isTouching(Enemigos.class))
        {
            removeTouching(Enemigos.class);
            w.removeObject(this);
            //numeroGusanos ++;
        }
         /*if(p!=null) {
                ((Boy)p).aumentaDano();
                hit = true;
            }*/
    }
  
}
