package pack.week2;

/**
 * Created by user on 2018/7/16.
 */

public class Hunter extends Human
{
//    public final static int FIRE_BOW = 1 ;
//    public final static int ICE_BOW = 2 ;
//    public final static int DEFAULT_BOW = 3 ;
    public int weapon;
    public Hunter()
    {
        this.weapon=DEFAULT_BOW;
    }

    public Hunter(int weapon)
    {
        this.weapon=weapon;
    }
    @Override
    public void attack()
    {
        switch(weapon)
        {
            case FIRE_BOW:
                System.out.println( "Fire Arrow" ) ;
                break;
            case ICE_BOW:
                System.out.println( "Ice Arrow" ) ;
                break;
            case DEFAULT_BOW:
                System.out.println( "Arrow" ) ;
                break;
        }
    }
}
