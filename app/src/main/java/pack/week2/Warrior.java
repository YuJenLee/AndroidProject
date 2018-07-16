package pack.week2;

/**
 * Created by user on 2018/7/16.
 */

public class Warrior extends Human
{
//    public final static int FIRE_BRADE = 1 ;
//    public final static int ICE_BRADE = 2 ;
//    public final static int DEFAULT_BRADE = 3 ;
    public int weapon;
    public Warrior()
    {
        this.weapon=DEFAULT_BRADE;
    }

    public Warrior(int weapon)
    {
        this.weapon=weapon;
    }

    @Override
    public void attack()
    {
        switch(weapon)
        {
            case FIRE_BRADE:
                System.out.println( "Fire Slash" ) ;
                break;
            case ICE_BRADE:
                System.out.println( "Ice Slash" ) ;
                break;
            case DEFAULT_BRADE:
                System.out.println( "Slash" ) ;
                break;
        }
    }
}
