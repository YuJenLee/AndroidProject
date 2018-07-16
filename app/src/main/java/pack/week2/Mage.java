package pack.week2;

/**
 * Created by user on 2018/7/16.
 */

public class Mage extends Human
{
//    public final static int FIRE_STAFF = 1 ;
//    public final static int ICE_STAFF = 2 ;
//    public final static int DEFAULT_STAFF = 3 ;
    public int weapon;
    public Mage()
    {
        this.weapon=DEFAULT_STAFF;
    }

    public Mage(int weapon)
    {
        this.weapon=weapon;
    }

    @Override
    public void attack()
    {
        switch(weapon)
        {
            case FIRE_STAFF:
                System.out.println( "Fireball" ) ;
                break;
            case ICE_STAFF:
                System.out.println( "Frostbolt" ) ;
                break;
            case DEFAULT_STAFF:
                System.out.println( "Arcane Missiles" ) ;
                break;
        }
    }
}
