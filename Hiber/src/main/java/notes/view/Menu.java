 package notes.view;

import notes.domain.Notebook;
import notes.service.NotebookService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

 /**
  * Created with IntelliJ IDEA.
  * User: al1
  * Date: 4/7/13
  */
 public class Menu {
     private static final int SHOW_ALL_NOTE_ITEM = 1;
     private static final int EXIT_ITEM = 0;
     private static final int ADD_NEW_NOTE_ITEM = 2;
     private static final int DELETE_NOTE_BY_ID = 3;
     private static final int CHANGE_PRICE_BY_ID=4;
     private static final int CHANGE_SERIAL_AND_VENDOR_BY_ID=5;
     private static final int DELETE_BY_MODEL=6;
     private static final int SHOW_BY_VENDOR=7;
     private static final int SHOW_BY_PRICE_AND_YEAR=8;

     private NotebookService noteService;
     private Scanner scan;

     public Menu(NotebookService noteService) {
         this();
         this.noteService  = noteService;;
     }

     public Menu() {
         scan = new Scanner(System.in);
     }

     public void main() {
         int choise = EXIT_ITEM;

         do {
             showMenu();
             choise = getInput();

             switch (choise) {
                 case EXIT_ITEM:
                     System.exit(0);
                     break;
                 case SHOW_ALL_NOTE_ITEM:
                     showAllUsers();
                     break;
                 case ADD_NEW_NOTE_ITEM:
                     addNewUser();
                     break;
                 case DELETE_NOTE_BY_ID:
                     deleteNtb();
                     break;
                 case CHANGE_PRICE_BY_ID:
                     changePrice();
                     break;
                 case CHANGE_SERIAL_AND_VENDOR_BY_ID:
                     changeSerialVendor();
                     break;
                 case DELETE_BY_MODEL:
                     deleteByModel();
                     break;
                 case SHOW_BY_VENDOR:
                     showByVendor();
                     break;
                 case SHOW_BY_PRICE_AND_YEAR:
                      showByPriceManufDate();



             }
         } while (choise != EXIT_ITEM);

     }

     private void showAllUsers() {
         for (Object ntb : noteService.findAll()) {
             System.out.println(ntb);
         }
     }



     public void showByVendor() {
         System.out.println("Input vendor");
         String vendor = scan.nextLine();
         for (Object ntb : noteService.findByVendor(vendor)) {
             System.out.println(ntb);}

     }

     void showByPriceManufDate(){
         int price = scanIntWithRetry("Input price");
         Date date = scanDateWithRetry("Input date");
         for (Object ntb : noteService. findByPriceManufDate(price, date)) {
             System.out.println(ntb);}
     }

     private void addNewUser() {
         int serial = scanIntWithRetry("Input serial");

         System.out.println("Input vendor");
         String vendor = scan.nextLine();

         System.out.println("Input model");
         String model = scan.nextLine();

         Date date = scanDateWithRetry("Input date");
         int price = scanIntWithRetry("Input price");

         Notebook note = new Notebook(serial,vendor,model,date,price);
         System.out.println("Added note " + note);
         noteService.add(note);

     }

     void deleteNtb(){
         Long id = scanLongWithRetry("Input id");
         System.out.println("del id " + id);
         noteService.delete(id);

     }
      void deleteByModel() {
         System.out.println("Input model");
         String model = scan.nextLine();
          noteService.deleteByModel(model);

     }
     void changePrice(){
         Long id = scanLongWithRetry("Input id");
         Integer price= scanIntWithRetry("Input price");
         System.out.println("Change price by id= "+id+" new price= " + price);
         noteService.changePrice(id,price);
     }

     void changeSerialVendor(){
         Long id = scanLongWithRetry("Input id");
         Integer serial= scanIntWithRetry("Input serial");
         System.out.println("Input vendor");
         String vendor = scan.nextLine();
         System.out.println("Change price by id= "+id+" new serial= " + serial+" new vendor= "+vendor);
         noteService.changeSerialVendor(id,serial,vendor);
     }


     private double scanDoubleWithRetry(String message) {
         return 0;
     }

     private Date scanDateWithRetry(String message) {
         final String DATE_FORMAT = "dd.mm.yyyy";
         Date date = null;
         String dateStr;
         do {
             System.out.println(message);
             dateStr = scan.nextLine();
             SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
             try {
                 date = sdf.parse(dateStr);
             } catch (ParseException pe) {
                 System.out.println("Illegal date format, correct format is \'" + DATE_FORMAT + "\', try again");
             }
         } while (date == null);
         return date;
     }

     private Long scanLongWithRetry(String ageMsg) {
         Long age = null;
         String ageStr;
         do {
             System.out.println(ageMsg);
             ageStr = scan.nextLine();
             try {
                 age = Long.valueOf(ageStr);
             } catch (NumberFormatException nfe) {
                 System.out.println("Not an int value, input again");
             }
         } while (age == null);

         return age;
     }
     private int scanIntWithRetry(String ageMsg) {
         Integer age = null;
         String ageStr;
         do {
             System.out.println(ageMsg);
             ageStr = scan.nextLine();
             try {
                 age = Integer.valueOf(ageStr);
             } catch (NumberFormatException nfe) {
                 System.out.println("Not an int value, input again");
             }
         } while (age == null);

         return age;
     }

     private int getInput() {
         int res = -1;
         String inputStr = scan.nextLine();
         try {
             res = Integer.parseInt(inputStr);
         } catch (NumberFormatException nfe) {
             System.out.println("String " + inputStr + " is not a number");
         }

         return res;
     }

     public void showMenu() {
         System.out.println("-----------------");
         System.out.println("1. Show all notebooks");
         System.out.println("2. Add new notebook");
         System.out.println("3.Del notebook by id");
         System.out.println("4.Change price by id");
         System.out.println("5.Change serial and vendor by Id");
         System.out.println("6.Del by model");
         System.out.println("7.Show by vendor");
         System.out.println("8.Show by price and date");
         System.out.println("0. Exit");
     }
 }