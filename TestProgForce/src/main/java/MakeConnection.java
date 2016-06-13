import com.mongodb.DB;
import com.mongodb.MongoClient;

/**
 * Created by Rrr on 13.06.2016.
 */
public class MakeConnection {
    private static DB db;


    public static DB makeConnection() {

        try{

            // To connect to mongodb server
            MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

            // Now connect to your databases
            db = mongoClient.getDB( "DB" );
            System.out.println("Connect to database successfully");

        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        return  db;
    }
}
