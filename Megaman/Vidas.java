import greenfoot.*;

/**
 *Clase donde se modificara y mostrara el contador de las vidas del jugador
 */
public class Vidas extends Actor
{
    /**
     * Act - do whatever the Vidas wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int life;
    
    /**
     * Metodo que inicializa el valor de las vidas del jugador
     */
    public Vidas(){
        
        life=3;
        
    }
    public void act() 
    {
    }   
    /**
     * Metodo que cambia la imagen de acuerdo al contador de las vidas para que puedan ser visualizadas por el jugador
     */
    public void cambia()
    {
        
        life--;
        if(life>=0)
        {
        setImage(life+".png");
        }
    }  
}
