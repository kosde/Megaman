import greenfoot.*;
import java.util.List;
/**
 *Clase pajaro en la cual se crearan todos los metodos que hacen que se mueva
 */
public class Pajaro extends Enemigos
{
    private int x,y;
    private int dir,lado=0;
    private int cont=0;
    private boolean hit=false;
    
    private World w;
    /**
     * Metodo en el cual se inicializan los parametros del enemigo
     */
    public Pajaro()
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
    }  
    /**
     * Metodo que deacuerdo a la direccion que recibe le indica al enemigo hacia que lado debera de moverse
     */
    public void Move()
    {
        x=getX();
        y=getY();
        
        if(lado<100)
           {
           dir=3;
           Walk(dir);
           setLocation(x-2,y);
           lado=lado+1;
           cont=cont+1;
           }else
           {
               dir=2;
               Walk(dir);
               setLocation(x+2,y);
               lado=lado+1;
               cont=cont+1;
               if(lado==201)
                    lado=0;
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
            setImage("d-p1.png");
             if(p!=null)
              ((Megaman)p).aumentaDano();
        }
        if(cont == 9)
        {
            setImage("d-p2.png");
             if(p!=null)
              ((Megaman)p).aumentaDano();
        }
        if(cont == 15)
        {
            setImage("d-p3.png");
             if(p!=null)
              ((Megaman)p).aumentaDano();
        }
        if(cont == 21)
        {
            setImage("d-p4.png");
             if(p!=null)
              ((Megaman)p).aumentaDano();
        }
        if(cont == 27)
        {
            setImage("d-p5.png");
             if(p!=null)
              ((Megaman)p).aumentaDano();
        }
        if(cont == 33)
        {
            setImage("d-p6.png");
             if(p!=null)
              ((Megaman)p).aumentaDano();
        }
        if(cont == 39)
        {
            setImage("d-p7.png");
            if(p!=null)
              ((Megaman)p).aumentaDano();
            cont = 0;
        }
    }else 
    if(dir==3) 
    {
         if(cont == 3)
        {
            setImage("p1.png");
             compruebaObjetivo();
        }
        if(cont == 9)
        {
            setImage("p2.png");
             compruebaObjetivo();
        }
        if(cont == 15)
        {
            setImage("p3.png");
             compruebaObjetivo();
        }
        if(cont == 21)
        {
            setImage("p4.png");
            compruebaObjetivo();
        }
        if(cont == 27)
        {
            setImage("p5.png");
            compruebaObjetivo();
        }
        if(cont == 33)
        {
            setImage("p6.png");
           compruebaObjetivo();
        }
        if(cont == 39)
        {
            setImage("p7.png");
            compruebaObjetivo();
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
