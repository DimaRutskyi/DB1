import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rrr on 13.06.2016.
 */
public class Shop2 implements ShopInterface  {
    private static Shop2 _instance = null;


    private Shop2(){    }

    public static synchronized Shop2 getInstance() {
        if (_instance == null)
            _instance = new Shop2();
        return _instance;
    }


    @Override
    public void read(DBCollection table, String sms, String value) {

        BasicDBObject query = new BasicDBObject();
        query.put(sms, value);
        DBCursor cur = table.find(query);
        while (cur.hasNext()) {
            System.out.println(cur.next());
        }

    }


    @Override
    public void addProduct(DBCollection table, String categorie, String title, int price, String status) {
        BasicDBObject document = new BasicDBObject();
        document.put("Categorie", categorie);

        BasicDBObject documentDetail = new BasicDBObject();
        documentDetail.put("Title", title);
        documentDetail.put("Price",price);
        documentDetail.put("Status",status );

        document.put("Product", documentDetail);
        table.insert(document);

    }

    @Override
            public void changeStatus(DBCollection table, String curStatus) {

            BasicDBObject updateQuery = new BasicDBObject();
            updateQuery.append("$set",
                    new BasicDBObject().append("Product.Status", curStatus));

            List<String> list = new ArrayList<String>();
            list.add("Available");
            list.add("Expected");

            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.append("Product.Status", new BasicDBObject("$in", list));
            searchQuery.append("Categorie", "Car");
            table.updateMulti(searchQuery, updateQuery);
        }
    @Override
    public void changeValue(DBCollection table, double koef) {
        BasicDBObject newDocument =
                new BasicDBObject().append("$mul",
                        new BasicDBObject().append("Product.Price", 1.2));

        table.updateMulti(new BasicDBObject().append("Product.Status", "Available"), newDocument);
    }

}
