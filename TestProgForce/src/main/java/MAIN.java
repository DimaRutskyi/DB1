import com.mongodb.*;
import com.mongodb.util.JSON;

/**
 * Created by Rrr on 11.06.2016.
 */
class FirstThread extends Thread
{
    @Override
    public void run()	//Этот метод будет выполнен в побочном потоке
    {
        System.out.println("Привет из побочного потока!");
        // create a shop1
        ShopInterface shop = ShopFactory.getShop("shop1");
        MakeConnection con=new MakeConnection();
        DB curDB=  con.makeConnection();
        DBCollection table = curDB.getCollection("Shop111");

        shop.addProduct(table,"Phone","nokia",100,"Expected");
        shop.addProduct(table,"Phone","siemens",300,"Available");
        shop.addProduct(table,"Phone","motorola",100,"Expected");

        shop.addProduct(table,"Notebook","asus",1000,"Absent");
        shop.addProduct(table,"Notebook","acer",2000,"Available");
        shop.addProduct(table,"Notebook","lenovo",3000,"Available");

        shop.addProduct(table,"Truck","man",10000,"Available");
        shop.addProduct(table,"Truck","kamaz",20000,"Absent");
        shop.addProduct(table,"Truck","scania",20000,"Available");

        System.out.println("Shop1 before update");
        DBCursor cursorDocJSON = table.find();
        while (cursorDocJSON.hasNext()) {
            System.out.println(cursorDocJSON.next());}

        shop.changeStatus(table,"Absent");
        shop.changeValue(table,1.2);

        System.out.println("Shop1 after update");
        DBCursor cursorDocJSON2 = table.find();
        while (cursorDocJSON2.hasNext()) {
            System.out.println(cursorDocJSON2.next());}
    }
}

class SecondThread extends Thread
{
    @Override
    public void run()	//Этот метод будет выполнен в побочном потоке
    {
        System.out.println("Привет из побочного потока2!");
        // create a shop2
        ShopInterface shop2 = ShopFactory.getShop("shop2");
        MakeConnection con=new MakeConnection();
        DB curDB=  con.makeConnection();
        DBCollection table2 = curDB.getCollection("Shop2");

        shop2.addProduct(table2,"Car","mazda",10000,"Expected");
        shop2.addProduct(table2,"Car","bmw",30000,"Available");
        shop2.addProduct(table2,"Car","audi",10000,"Expected");

        shop2.addProduct(table2,"Motobike","honda",1000,"Absent");
        shop2.addProduct(table2,"Motobike","yamaha",2000,"Available");
        shop2.addProduct(table2,"Motobike","bmw",3000,"Available");

        shop2.addProduct(table2,"Truck","man",10000,"Available");
        shop2.addProduct(table2,"Truck","kamaz",20000,"Absent");
        shop2.addProduct(table2,"Truck","scania",20000,"Available");

        System.out.println("Shop2 before update");
        DBCursor cursorDocJSON = table2.find();
        while (cursorDocJSON.hasNext()) {
            System.out.println(cursorDocJSON.next());}

        shop2.changeStatus(table2,"Absent");
        shop2.changeValue(table2,1.2);

        System.out.println("Shop2 after update");
        DBCursor cursorDocJSON2 = table2.find();
        while (cursorDocJSON2.hasNext()) {
            System.out.println(cursorDocJSON2.next());}
    }
}
public class Main {

    public static void main( String args[] )  throws InterruptedException {

        System.out.println("This is currently running on the main thread");
        FirstThread thread1=new FirstThread();
        SecondThread thread2=new SecondThread();

        thread1.start();
        try{
            thread2.sleep(10000);		//Ожидание в течении i*2 сек.
        }catch(InterruptedException e){}
        thread2.start();

        thread2.join();

        System.out.println("The main thread stop");
  }
}