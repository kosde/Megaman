import greenfoot.*;
import java.util.List;
import java.util.Random;
/**
 *Clase robot en la cual se crearan todos los metodos que hacen que se mueva
 */
public class Robot extends Enemigos
{
    private int x,y,v=0;
    private int dir,lado=0;
    private int cont=0;
    private boolean hit=false;
    
    private World w;
    Random rnd = new Random();
     /**
     * Metodo en el cual se inicializan los parametros del enemigo
     */
    public Robot()
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
         
        World w=getWorld();
        Move();
        if(getX()<=0)
           w.removeObject(this);
        if(v== 50)
                dispara(x-3,y,3);
               if(v == 100)
                v = 0;
            
                v++;
        //if((rnd.nextDouble()* 3 + 1)==2)
          //  dispara(x-10,y,2);
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
           //setLocation(x-2,y);
           cont=cont+1;
           }
       
        
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
            setImage("d-rv6.png");
             if(p!=null)
              ((Megaman)p).aumentaDano();
        }
        if(cont == 9)
        {
            setImage("d-rv5.png");
             if(p!=null)
              ((Megaman)p).aumentaDano();
        }
        if(cont == 15)
        {
            setImage("d-rv4.png");
             if(p!=null)
              ((Megaman)p).aumentaDano();
        }
        if(cont == 21)
        {
            setImage("d-rv3.png");
             if(p!=null)
              ((Megaman)p).aumentaDano();
        }
        if(cont == 27)
        {
            setImage("d-rv2.png");
             if(p!=null)
              ((Megaman)p).aumentaDano();
        }
        if(cont == 33)
        {
            setImage("d-rv1.png");
             if(p!=null)
              ((Megaman)p).aumentaDano();
              cont = 0;
        }
    }else 
    if(dir==3) 
    {
         if(cont == 3)
        {
            setImage("rv6.png");
             if(p!=null)
              ((Megaman)p).aumentaDano();
        }
        if(cont == 9)
        {
            setImage("rv5.png");
             if(p!=null)
              ((Megaman)p).aumentaDano();
        }
        if(cont == 15)
        {
            setImage("rv4.png");
             if(p!=null)
              ((Megaman)p).aumentaDano();
        }
        if(cont == 21)
        {
            setImage("rv3.png");
             if(p!=null)
              ((Megaman)p).aumentaDano();
        }
        if(cont == 27)
        {
            setImage("rv2.png");
             if(p!=null)
              ((Megaman)p).aumentaDano();
        }
        if(cont == 33)
        {
            setImage("rv1.png");
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
/**
 * Metodo que agrega un objeto de tipo bala que sera usada contra el jugador
 */
public void dispara(int x,int y,int dir)
    {
        World b=getWorld();
        b.addObject(new Balae(dir),x,y);
    }
}