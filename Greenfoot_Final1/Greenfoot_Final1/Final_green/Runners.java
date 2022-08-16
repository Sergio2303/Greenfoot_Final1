import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Runners here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Runners extends Actor
{
    //variables: 
    int speed = 4;
    /**
     * Act - do whatever the Runners wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    public void maxSpeed()
    //Esta es la cantidad maxima de velocidad a la cual la tortuga puede llegar.
    {
        if (speed>=7)
        {
            speed = 7;
        }
    }
    public void moveAndTurn(){
        //esto lo usare para poder mover mi obejto en cualquier parte del mapa
        if(Greenfoot.isKeyDown("right"))
        {
            setRotation(0);
            move(4);
        }
        if(Greenfoot.isKeyDown("left")){
            setRotation(188);
            move(4);
        }
        if(Greenfoot.isKeyDown("up")){
            setRotation(270);
            move(4);
        }
        if(Greenfoot.isKeyDown("down")){
            setRotation(90);
            move(4);
        }
    }

    public void slideAround()
    {
        int x = getX();
        int y = getY();
        //esto es para poder mover a mi personaje principal en cualquier parte que
        // que el jugador desee. 

        //Paredes es el metodo que me permite marcar los limites del laberinto. 
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(x + speed, y);
            if(Paredes())
            {
                setLocation(x- speed, y);
            }

        }
        if(Greenfoot.isKeyDown("left")){
            setLocation(x - speed, y);
            if(Paredes())
            {
                setLocation(x + speed, y);
            }
        }
        if(Greenfoot.isKeyDown("up")){
            setLocation(x, y-speed);
            if(Paredes())
            {
                setLocation(x, y+speed);
            }
        }
        if(Greenfoot.isKeyDown("down")){
            setLocation(x, y + speed);
            if(Paredes())
            {
                setLocation(x, y-speed);
            }
        } 

    }

    public boolean Paredes()
    {
        if (isTouching(MazeBlock.class))
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
    public void collectBoost()
    //este metodo es para que las cerezas le dan más velocidad al corredor. 
    {
        if (isTouching(SpeedBoost.class))
        {
            speed++;
            removeTouching(SpeedBoost.class);
            
        
        }
    }
    public boolean hitEnemy()
    {
        if(isTouching(Enemies.class))
        {
        return true;
        }
        else
        {
            return false;
        }
    }
}
