import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Clase donde se despliega la informacion acerca del creador del juego
 */
public class Credito  extends Actor
{
    public void act() 
    {
        // Add your action code here.
        World w=getWorld();
        Regresar b;
        Control c;
        List lb,lc;
        
        lb=w.getObjects(Regresar.class);
        
        if(lb.size()==0) {
            w.addObject(new Regresar(), 100 , 550 );
        }
        else {
            b=(Regresar)lb.get(0);
            if(Greenfoot.mousePressed(b)) {
               // lc=w.getObjects(Control.class);
                //c=(Control)lc.get(0);
                //c.PlusCont();
                w.addObject(new Menu(), w.getWidth()/2 , w.getHeight()/2 );
                w.removeObject(b);
                w.removeObject(this);
            }
    }    
}
}