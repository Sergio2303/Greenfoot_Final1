import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyWalker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyWalker extends Enemies
{
    /**
     * Act - do whatever the EnemyWalker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean upDown;
    int speed = 2;
    public EnemyWalker(boolean upAndDown)
    {
        getImage().scale(getImage().getWidth()/2, getImage().getHeight()/2);
        //esto es para reducir el tamaño de los personajes.
        upDown = upAndDown;
    }

    public void act()
    {
        moveAround();
        enemyParedes();
        
    }
    public void enemyParedes()
    {
         if (Paredes()|| isAtEdge())
        {
            speed = -speed;
            
        
        }
    }

    private void moveAround()
    {
        int x = getX();
        int y = getY();
        if(upDown)
        {
            setLocation(x,y + speed);
        }
        else if (!upDown)
        {
            setLocation(x + speed, y);
        }

    }
}
