import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class sun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class sun extends Bullet
{
    GreenfootImage sprite1 = new GreenfootImage("images/sun1.png");
    GreenfootImage sprite2 = new GreenfootImage("images/sun2.png");
    int frame, count;
    double accel = -0.2;
    int atkType;
    int dir = 1;
    int spiralAng = Greenfoot.getRandomNumber(359);
    int playerAng = -1;
    int i = 30;
    
    public sun(Actor own, int atk){
        speed = 7;
        this.owner = own;
        setRotation(-90);
        atkType = atk;
        
        if(Greenfoot.getRandomNumber(2) == 0){
            dir = -1;
        }
    }
    
    public void act() 
    {
        if(((GameWorld)getWorld()).timeFrozen && owner.getClass() != Player.class){
            return;
        }
        
        if(frame < 30){
            if(speed > 0){
                move((int)speed);
                speed += accel;
            }else{
                speed = 0;
            }
        }else if(frame < 200){
            switch(atkType){
                case 0:
                    spiral();
                    break;
                case 1:
                    aimed();
                    break;
                case 2:
                    shockwave();
                    break;
                case 3:
                    laser();
                    break;
                default:
                    break;
            }
        }else if(frame >= 200){
            getWorld().removeObject(this);
        }
        
        flash();
        frame++;
    }    
    
    public void flash(){
        count++;
        if(count == 2){
            setImage(sprite2);
        }
        if(count == 4){
            setImage(sprite1);
            count = 0;
        }
    }
    
    public void spiral(){
        int num = 8;
        
        if(frame % 15 == 0 && frame < 150){
            for(int i=0; i<num; i++){
                getWorld().addObject(new sunBullet(2, 5, 0.05, spiralAng + 360*i/num,
                  new GreenfootImage("images/sunbullet21.png"), new GreenfootImage("images/sunbullet22.png"), this.owner), getX(), getY());
            }
            spiralAng += 2 * dir;
        }
    }
    public void aimed(){
        Player p;
        List<Player> players = getObjectsInRange(getWorld().getWidth(), Player.class);
        
        if(players != null && players.size() > 0) {
            p = players.get(0);
            if(playerAng == -1){
                playerAng = (int)( 180 + Math.atan2(getY() - p.getY(), getX()-p.getX() ) * 180/Math.PI);
            }
            
            if(frame % 4 == 0 && frame < 150){
                getWorld().addObject(new sunBullet(5, 8, 0.1, playerAng + Greenfoot.getRandomNumber(12) - 6,
                 new GreenfootImage("images/sunbullet21.png"), new GreenfootImage("images/sunbullet22.png"), this.owner), getX(), getY());
            }
        }
    }
    public void laser(){
        Player p;
        List<Player> players = getObjectsInRange(getWorld().getWidth(), Player.class);
        
        if(players != null && players.size() > 0) {
            p = players.get(0);
            
            if(frame < 30 + 80){
                if(getX() +10 < p.getX()){
                    setLocation(getX() + 1, getY());
                }
                if(getX() -10 > p.getX()){
                    setLocation(getX() - 1, getY());
                }
            }else if(frame % 2 == 0){
                if(getX() +10 < p.getX()){
                    setLocation(getX() + 1, getY());
                }
                if(getX() -10 > p.getX()){
                    setLocation(getX() - 1, getY());
                }
            }
            if(frame == 31){
                getWorld().addObject(new prepLaser(owner, this), getX(), getY()+225);
            }
        }
    }
    public void shockwave(){
        setRotation(90);
        accel = 0.1;
        speed += accel;
        if(getY() < getWorld().getHeight() - 30){
            move((int)speed);
        }
        
        if(getY() >= getWorld().getHeight() - 30){
            if(frame % 5 == 0){
                getWorld().addObject(new sunBullet(7, 9, -0.9, -90,
                  new GreenfootImage("images/sunbullet21.png"), new GreenfootImage("images/sunbullet22.png"), this.owner), getX() + i, 390);
                getWorld().addObject(new sunBullet(7, 9, -0.9, -90,
                  new GreenfootImage("images/sunbullet21.png"), new GreenfootImage("images/sunbullet22.png"), this.owner), getX() - i, 390);
                
                i += 20;
            }
        }
    }
}
