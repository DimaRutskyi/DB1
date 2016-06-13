/**
 * Created by Rrr on 13.06.2016.
 */
public class ShopFactory {
    public static ShopInterface getShop(String criteria)
{
    if ( criteria.equals("shop1") )
        return Shop.getInstance();
    else if ( criteria.equals("shop2") )
        return Shop2.getInstance();;

    return null;
}
}
