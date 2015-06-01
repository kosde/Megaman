import greenfoot.*;
import java.util.List;
public class Balae extends Actor
{
    private int x,y;
    private int dir;
    private boolean golpe=false;
    private int cont;
    
    private World w;
    /**
     * Metodo que inicializa los valores de la bala
     */
    public Balae(int d){
        
         dir=d;
         cont=0;
    }
        
    /**
     * Metodo actor donde se ejecutan las acciones de la bala
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
     * En este metodo se lleva acabo el movimiento de la bala a traves de la pantalla en la direccion que apunto el enemigo
     */
   public void mueveBala(int dir){
          x=getX();
          y=getY();
         // w= getWorld();
       
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
                         
                          }else
             if(x<=0)
              w.removeObject(this);
                           //x++;
                          cont++;
    }
    /**
     * Aqui se comprueva que el objeto te tipo bala intersecte al jugador
     */
   public void compruebaObjetivo() 
    {
         List l;
        Megaman Mega;
        l=w.getObjects(Megaman.class);
        Mega=(Megaman)l.get(0);
       Actor p;
         p=getOneIntersectingObject(Megaman.class);
       if(isTouching(Megaman.class))
        {
            Mega.aumentaDano();
            removeTouching(Megaman.class);
            w.removeObject(this);
            //numeroGusanos ++;
            w.addObject(new Megaman(), 100,560);
            
        }
            
         /*if(p!=null) {
                ((Boy)p).aumentaDano();
                hit = true;
            }*/
    }
    
  
}
