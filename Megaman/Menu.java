import greenfoot.*;
import java.util.List;

/**
 *Clase menu se crean las opciones del juego mandando llamar a diferentes clases entre ellas se encuentra la clase botones,ayudas,creditos
 */
public class Menu extends Actor
{
    public void act() 
    {
        // Add your action code here.
        World w=getWorld();
        Jugar j;
        Ayuda a;
        Creditos cr;
        Control c;
        
        
        
        
        List lp,lh,lc,lcr;
        
        lp=w.getObjects(Jugar.class);
        lh=w.getObjects(Ayuda.class);
        lcr=w.getObjects(Creditos.class);
        
      
        
        if(lp.size()==0 && lh.size()==0) 
        {
            w.addObject(new Jugar(), w.getWidth()/2 ,150);
            w.addObject(new Ayuda(), w.getWidth()/2 ,300);
            w.addObject(new Creditos(),w.getWidth()/2,450);
        }
         else {
            j=(Jugar)lp.get(0);
            a=(Ayuda)lh.get(0);
            cr=(Creditos)lcr.get(0);
            if(Greenfoot.mousePressed(j)) 
            {
                w.removeObject(j);
                w.removeObject(a);
                w.removeObject(cr);
                w.removeObject(this);
                lc=w.getObjects(Control.class);
                c=(Control)lc.get(0);
                c.ContadorBandera();
                
            }
            if(Greenfoot.mousePressed(a)) {
                
                w.removeObject(j);
                w.removeObject(a);
                w.removeObject(cr);
                w.addObject(new Ayudas(), w.getWidth()/2 , w.getHeight()/2 );
                w.removeObject(this);
                
            }
            if(Greenfoot.mousePressed(cr)) {
                
                w.removeObject(j);
                w.removeObject(a);
                w.removeObject(cr);
                w.addObject(new Credito(), w.getWidth()/2 , w.getHeight()/2 );
                w.removeObject(this);
                
            }
        }
    }    
}
