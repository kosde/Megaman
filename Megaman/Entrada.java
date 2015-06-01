import greenfoot.*;
import java.util.List;
/**
 * La clase Entrada nos mostrara el tubo que megaman usara para pasar escenario
 */
public class Entrada extends Pasaje
{
    /**
     * Act - do whatever the Entrada wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private World w;
    private GreenfootSound audio; 
    //audio = new GreenfootSound("42.wav");
    public void act() 
    {
        // Add your action code here.
        List lc;
        Control c;
        World w=getWorld();
        audio = new GreenfootSound("42.wav");
        if(isTouching(Megaman.class))
        {
              lc=w.getObjects(Control.class);
              c=(Control)lc.get(0);
              c.ContadorBandera();
              audio.play();
        }
    }    
}
