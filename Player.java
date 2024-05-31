
import java.util.*;

public class Player {
   private String name;
   private int life;
   private Location currentLocation;
   private ArrayList<Item> inventory;


   public Player(String name, Location startingLocation) {


       this.name = name;
       this.life = 100;
       this.currentLocation = startingLocation;
       this.inventory = new ArrayList<Item>();
   }


   public String getName() {
       return name;
   }


   public int getLife() {
       return life;


   }


   public void addItem(Item item) {
       inventory.add(item);
       System.out.println("Picked up " + item.getName());

   }


   public void moveTo(Location newLocation) {
       this.currentLocation = newLocation;
   }


   public Location getCurrentLocation() {
       return currentLocation;
   }


   public void rItem(Item item) {
       inventory.remove(item);
       System.out.println("Dropped " + item.getName());


   }


   public void drop(int object) {
       if (object >= 0 && object < inventory.size()) {
           Item item = inventory.remove(object);
           System.out.println("Dropped " + item.getName());
       } else {
           System.out.println("No item dropped");


       }


   }


   public void showInventory() {
       System.out.println("Inventory");
       for (int i = 0; i < inventory.size(); i++) {
           System.out.println(i + " " + inventory.get(i).toString());
       }
   }

   public ArrayList<Item> getInventory(){
    return this.inventory;
   }


}


