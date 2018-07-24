package pack.week2;

import android.util.Log;

/**
 * Created by user on 2018/7/16.
 */

public class Human
{
    /**
     **************** Tips ****************
     * Jobs: Hunter, Warrior, Mage
     * Weapons and Skills:
     * -----------------------------------
     * | Default Blade | Slash |
     * | Fire Blade | Fire Slash |
     * | Ice Blade | Ice Slash |
     * -----------------------------------
     * | Default Bow | Arrow |
     * | Fire Bow | Fire Arrow |
     * | Ice Bow | Ice Arrow |
     * -----------------------------------
     * | Default Staff | Arcane Missiles |
     * | Fire Staff | Fireball |
     * | Ice Staff | Frostbolt |
     * -----------------------------------
     *
     */
    private String name ;
    public final static int DEFAULT_BOW = 0 ;
    public final static int FIRE_BOW = 1 ;
    public final static int ICE_BOW = 2 ;
    public final static int FIRE_BRADE = 3 ;
    public final static int ICE_BRADE = 4;
    public final static int DEFAULT_BRADE = 5 ;
    public final static int FIRE_STAFF = 6 ;
    public final static int ICE_STAFF = 7;
    public final static int DEFAULT_STAFF = 8;

    public Human ()
    {
    }
    public void attack ()
    {
        Log.e("human", "Fist Attack!" ) ;
    }
}
