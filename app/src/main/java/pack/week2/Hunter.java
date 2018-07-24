package pack.week2;

import android.util.Log;

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
    /*@Override
    public void attack()
    {
        switch(weapon)
        {
            case FIRE_BOW:
                Log.e("hunter","Fire Arrow") ;
                break;
            case ICE_BOW:
                Log.e("hunter", "Ice Arrow" ) ;
                break;
            case DEFAULT_BOW:
                Log.e("hunter", "Arrow" ) ;
                break;
        }
    }*/
}
