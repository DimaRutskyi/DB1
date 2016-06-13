/**
 * Created by Rrr on 11.06.2016.
 */
import com.mongodb.*;

import java.util.Arrays;

public class MongoDBJDBC {

    private static DBCollection table;

      MongoDBJDBC() {

        try{

            // To connect to mongodb server
            MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

            // Now connect to your databases
            DB db = mongoClient.getDB( "test" );
            System.out.println("Connect to database successfully");

            // Выбираем коллекцию/таблицу для дальнейшей работы
            table = db.getCollection("Users");
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
    private static DBObject createDBObject(User user) {
        BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();

        docBuilder.append("_id", user.getId());
        docBuilder.append("name", user.getName());
        docBuilder.append("role", user.getRole());
        docBuilder.append("isEmployee", user.isEmployee());
        return docBuilder.get();
    }

    private static User createUser() {
        User u = new User();
        u.setId(2);
        u.setName("anna");
        u.setEmployee(true);
        u.setRole("CEO");
        return u;
    }
    public  void add(User user){
        BasicDBObject document = new BasicDBObject();
        //DBObject doc = createDBObject(user);
        // указываем поле с объекта User
        // это поле будет записываться в коллекцию/таблицу
        document.put("name", user.getName());

        // записываем данные в коллекцию/таблицу
        table.insert(document);
    }
    public User getByName(String name){
        BasicDBObject query = new BasicDBObject();

        // задаем поле и значение поля по которому будем искать
        query.put("name", name);

        // осуществляем поиск
        DBObject result = table.findOne(query);

        // Заполняем сущность полученными данными с коллекции
        User user = new User();
        user.setName(String.valueOf(result.get("login")));
       //user.setId(String.valueOf(result.get("_id")));

        // возвращаем полученного пользователя
        return user;
    }
    public static void main( String args[] ) throws Exception {
         MongoDBJDBC MongoConnection= new  MongoDBJDBC();

        User user = createUser();

        MongoConnection.add(user);
        System.out.println(user);

        MongoConnection.getByName("anna");
        System.out.println("return"+user);


    }
}