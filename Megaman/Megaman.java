import greenfoot.*;
import java.util.List;

/**
 * En esta clase se contienen todos los movimientos y acciones relacionadas con el jugador
 */
public class Megaman extends Actor
{
    //public boolean img=true
    /**
     * Act - do whatever the Megaman wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int x,y,v=0;
    private int alt,piso=560;
    private int cont=0,t=0;
    private int dir;
    private int hp;
    private int hpsuport;
    private int daño,puntos;
    private int damage;
    private int fin=0;
    //private int salto=0,csal=0;
    protected boolean salto=false;
    protected boolean BalaAct=false;
    private int Ob=0;
    protected boolean ArribaOb=false;
    private GreenfootSound audio; 
    private GreenfootSound Over; 
    private GreenfootSound saltos;
    
    double dy=0;
    double g=1.3;
    //private int dirA;
    private World w;
    /**
     * inicializacion de los parametros del jugador
     */
    public Megaman()
    {
        cont=0;
        dir=0;
        salto=false;
        t=0;
        hpsuport=3;
      hp=3;
      audio = new GreenfootSound("firelock.mp3"); 
      Over= new GreenfootSound("death.wav");
      saltos= new GreenfootSound("40.wav");
      //damage=0;
        //jugador = new GreenfootImage[21];
        //jugador[i] = new GreenfootImage("caminar" + i + ".png");
    }
    /**
     * Metodo que realiza las acciones principales
     */
    public void act() 
    {
        List l;
        List L1;
        List lc;
        List cn;
        Control c,n;
        Vidas vi;
        Control ctrl;
        
        
        
        Move();
        World w=getWorld();
          if(isLive(hpsuport)){
          hp--;
          damage=0;
           L1=w.getObjects(Vidas.class);
                 vi=(Vidas)L1.get(0);
                 vi.cambia();
        }
        if(hp<=0) {
                 l=w.getObjects(Control.class);
                 ctrl=(Control)l.get(0);
                 ctrl.gameOver();
                 if(fin<60)
                   Over.play();
                 if(fin>=65)
                   Over.stop();
                 fin=fin+1;
        }
        if(isTouching(M1.class))
        {
               w.removeObjects(w.getObjects(M1.class));
               w.addObject(new M2(),700,498);
              
               cn=w.getObjects(Control.class);
               n=(Control)cn.get(0);
               n.ContadorBandera();
              
        }
     }    
    /**
     * En este metodo se realizan las lecturas de teclas de direcciones para determinar el sentido de las imagenes y asi mover el jugador en la direccion correcta
     */
    public void Move()
    {
         x=getX();
         y=getY();
          List lc;
        List cn;
        Control c,n;
        if(isTouching(M1.class))
        {
              w.removeObjects(w.getObjects(M1.class));
              w.addObject(new M2(),700,498);
              
               cn=w.getObjects(Control.class);
               n=(Control)cn.get(0);
               n.ContadorBandera();
              
        }else
        if(Greenfoot.isKeyDown("left"))
              {
                 dir=3;
                //MoveAux(x,y,dir);
                 if(cont == 3&&cont<11)
                 setImage("n4.png");
                 if(cont == 12&&cont<20)
                 setImage("n5.png");
                 if(cont == 21)
                 setImage("n6.png");
                 if(cont>22)
                 cont = 0;
                  setLocation(x-3,y);
                  
                 cont=cont+1;
              }else
               
                      
        if(Greenfoot.isKeyDown("right"))
         {
                 dir=2;    
                 //MoveAux(x,y,dir);
            if(cont == 3&&cont<11)
            setImage("d-n4.png");
            if(cont == 12&&cont<20)
             setImage("d-n5.png");
            if(cont == 21)
            setImage("d-n6.png");
            if(cont>22)
                 cont = 0;
                 setLocation(x+3,y);
                 cont=cont+1;      
                 
         }else
//salta--------------------------------------------
        if(Greenfoot.isKeyDown("up")&&salto==false)
        {
                dir=1;
                salto=true;
                saltos.play();
        }else

//dispara
        if(Greenfoot.isKeyDown("space")==true)
        { 
                
                if(v== 3)
                {
                dispara(x-3,y,2);
                Greenfoot.playSound("firelock.mp3");
                }
               if(v == 10)
                v = 0;
            
                v++;
        }
        else
            if(BalaAct==true)
            {
                dispara(x-3,y,dir);
                BalaAct=false;
            }
                else
        if(Greenfoot.isKeyDown("space")==false&&Greenfoot.isKeyDown("up")==false&&Greenfoot.isKeyDown("left")==false&&Greenfoot.isKeyDown("right")==false)
        {
                dir=6;
                MoveAux(x,y,dir);
                cont=cont+1;   
        }else
         {
        if(dir==4)
          setImage("cd1.png"); 
        if(dir==5)
          setImage("d-cd1.png");                 
        if(dir==1)
          setImage("e1.png");
        if(dir==2)
          setImage("d-n4.png");
        if(dir==3)
          setImage("n4.png");
        if(dir==6)
          setImage("d-n1.png");
        } 
        if(salto)
        {
          //salto=false;
          
          salta();
          //baja();
        }
         
       
                        }
                    
/**
 * Metodo que realiza la secuencia de imagenes para que se vea la animacion correcta en la direccion recivida
 */                            
public void MoveAux(int x,int y,int dir)
{
    
    if(dir==5) 
    {
         if(cont<= 3)
        {
            setImage("d-cd1.png");
            
        }
        if(cont <= 12&&cont>3)
        {
            setImage("d-cd2.png");
        }
        if(cont <= 21&&cont>12)
        {
            setImage("d-cd3.png");
        }
        if(cont <= 30&&cont>21)
        {
            setImage("d-cd4.png");
                
           
        }if(cont>31)
         cont = 0;
    }else 
    if(dir==4) 
    {
         if(cont <= 3)
        {
            setImage("cd1.png");
            
        }
        if(cont <= 12)
        {
            setImage("cd2.png");
        }
        if(cont <= 21)
        {
            setImage("cd3.png");
        }
        if(cont <= 30)
        {
            setImage("cd4.png");
                
            cont = 0;
        }
    }else
    if(dir==6) 
    {
         if(cont <= 3)
        {
            setImage("d-n1.png");
            
        }
        if(cont <= 21)
        {
            setImage("d-n2.png");
        }
        if(cont <= 39)
        {
            setImage("d-n3.png");
            cont = 0;
        }
    } else
     if(dir==1)
     {
         
        if(cont <= 3)
        {
            setImage("e1.png");
            
        }
        if(cont <= 12)
        {
            setImage("e2.png");
        }
        if(cont <= 21)
        {
            setImage("e1.png");
                
            cont = 0;
        }
     } else
       if(dir==2)
       {

            if(cont <= 3&&cont<11)
            {
            setImage("d-n4.png");
            }
            if(cont <= 12&&cont<20)
            {
             setImage("d-n5.png");
            }
            if(cont <= 21)
            {
            setImage("d-n6.png");
                //System.out.println("der");
           
            }if(cont>22)
                 cont = 0;
         }
          else
          if(dir==3)
          {
                  
                 if(cont == 3&&cont<11)
                 {
                 setImage("n4.png");
                 }
                 if(cont == 12&&cont<20)
                 {
                 setImage("n5.png");
                 }
                 if(cont <= 21)
                 
                 setImage("n6.png");
                 if(cont>22)
                 cont = 0;
                 
          }
          //cont++; 
        }
    /**
     * Metodo que hace saltar al jugador y regresarlo a la plataforma donde lo reealizo
     */
    public void salta()
    {
       int y=0;
           //if(t<)
             if(t <25)
               y=-5;
             else
               y=5;
          /* if(ob!=null) {
              setLocation(getX(),getY()-10);
              ArribaOb=true;
            }*/
                  t=t+1;
                  if(t>=50)
                  {
                     salto=false;
                     t=0;
                     
                    } 
             setLocation(getX(),getY()+(y));
           
            
            
    }
    /**
     * Metodo que hace que se proyecte una bala que pertenece al jugador
     */
    public void dispara(int x,int y,int dir)
    {
        World b=getWorld();
        b.addObject(new Bala(dir),x,y);
    }
    
    /**
     * Metodo que aumenta el daño y asi reduce las vidas del jugador
     */
    public void aumentaDano(){
        damage++;
    }    
    /**
     * Metodo que realiza un chequeo de las vidas que tiene y el daño que a recivido para determinar si sigue con vida o el juego termino
     */
    public boolean isLive(int hpoints) {
        boolean band=false;
        
        if(damage>=hpoints) {
            band = true;
        }
        
        return (band);
       }
}

