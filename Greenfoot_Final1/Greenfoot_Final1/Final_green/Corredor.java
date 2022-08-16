import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Corredor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Corredor extends Players
{
    /**
     * Act - do whatever the Corredor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int corredorLives;
    //Crear metodo de construcción, para que los personajes sean más pequeños.
    public Corredor(int lives)
    {
        getImage().scale(getImage().getWidth()/2, getImage().getHeight()/2);
        corredorLives = lives;
        //esto es para reducir el tamaño de los personajes.
    }

    public void act()
    {
        slideAround(); // utilizar el metodo de Runners para poderse mover.
        collectBoost(); //metodo para mayor velocidad.
        maxSpeed(); // Velocidad maxima a la que puede llegar la tortuga.
        loseLife(); // indicador de que perdio el jugador. 
        corredorHit(); // si el villano toca a la tortuga,esta reaparece.  
        youWin(); // indicador de haber ganado. 
        YouLose(); // indicador que perdio el jugador. 
    }

    public void corredorHit()
    {
        if(hitEnemy())
        {
            setLocation(40, 576);
        }
    }

    public void loseLife()
    {
        if (hitEnemy())
        {
            corredorLives --;
        }
    }
    public void YouLose()
    {
        if(corredorLives == 0) 
        {
           getWorld().addObject(new YouLose(), getWorld().getWidth()/2, getWorld().getHeight()/2);
           Greenfoot.stop();
        
        } 
    }    
}

