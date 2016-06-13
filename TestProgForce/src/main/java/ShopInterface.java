import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

import java.util.List;

/**
 * Created by Rrr on 12.06.2016.
 */
public interface ShopInterface {

    void read(DBCollection table, String sms, String value );
    void  addProduct(DBCollection table, String categorie, String title, int price, String status );
    void changeStatus (DBCollection table,String curStatus );
    void changeValue (DBCollection table,double koef );
   }
