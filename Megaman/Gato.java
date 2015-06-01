import greenfoot.*;
import java.util.List;
/**
 * Clase gato en la cual se crearan todos los metodos que hacen que se mueva
 */
public class Gato extends Enemigos
{
    private int x,y;
    private int dir,lado=0;
    private int cont=0;
    private boolean hit=false;
    
    private World w;
    /**
     * Metodo en el cual se inicializan los parametros del enemigo
     */
    public Gato()
    {
      cont=0;
      dir=0;   
      lado=0;
    }
     /**
     * Metodo principal que hace la ejecucion del movimiento de este enemigo
     */
    public void act() 
    {
        // Add your action code here.
        w=getWorld();
        Move();
    }  
    /**
     * Metodo que deacuerdo a la direccion que recibe le indica al enemigo hacia que lado debera de moverse
     */
    public void Move()
    {
        x=getX();
        y=getY();
        
        if(lado<800)
           {
           dir=3;
           Walk(dir);
           setLocation(x-2,y);
           cont=cont+1;
           }
           if(x<=0)
              w.removeObject(this);
        
    }
     /**
     * Metodo que hace que el enemigo pajaro tenga una secuencia de movimiento
     */
    public void Walk(int dir)
    {
         Actor p;
         p=getOneIntersectingObject(Megaman.class);
    if(dir==2) 
    {
         if(cont == 3)
        {
            setImage("d-z1.png");
             if(p!=null)
              ((Megaman)p).aumentaDano();
        }
        if(cont == 9)
        {
            setImage("d-z2.png");
             if(p!=null)
              ((Megaman)p).aumentaDano();
        }
        if(cont == 15)
        {
            setImage("d-z3.png");
             if(p!=null)
              ((Megaman)p).aumentaDano();
        }
        if(cont == 21)
        {
            setImage("d-z4.png");
             if(p!=null)
              ((Megaman)p).aumentaDano();
        }
        if(cont == 27)
        {
            setImage("d-z5.png");
             if(p!=null)
              ((Megaman)p).aumentaDano();
        }
         if(cont == 33)
        {
            setImage("d-z6.png");
             if(p!=null)
              ((Megaman)p).aumentaDano();
        }
        if(cont == 39)
        {
            setImage("d-z7.png");
             if(p!=null)
              ((Megaman)p).aumentaDano();
              cont = 0;
        }
    }else 
    if(dir==3) 
    {
         if(cont == 3)
        {
            setImage("z1.png");
             if(p!=null)
              ((Megaman)p).aumentaDano();
        }
        if(cont == 9)
        {
            setImage("z2.png");
             if(p!=null)
              ((Megaman)p).aumentaDano();
        }
        if(cont == 15)
        {
            setImage("z3.png");
             if(p!=null)
              ((Megaman)p).aumentaDano();
        }
        if(cont == 21)
        {
            setImage("z4.png");
             if(p!=null)
              ((Megaman)p).aumentaDano();
        }
        if(cont == 27)
        {
            setImage("z5.png");
             if(p!=null)
              ((Megaman)p).aumentaDano();
        }
         if(cont == 33)
        {
            setImage("z6.png");
             if(p!=null)
              ((Megaman)p).aumentaDano();
        }
        if(cont == 39)
        {
            setImage("z7.png");
             if(p!=null)
              ((Megaman)p).aumentaDano();
              cont = 0;
        }
    }
        }
      /**
     * En este metodo se comprueva que durante el movimiento realizado por el enemigo no tenga contacto con el jugador megaman y si es asi se disminuyen vidas
     */
     public void compruebaObjetivo() {
        Actor p;
        
        p = getOneIntersectingObject(Megaman.class);
        if(p!=null) {
                ((Megaman)p).aumentaDano();
                hit = true;
            }
    }
}
