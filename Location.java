import java.util.*;

public class Location {
    private String name;
    private String description;
    private ArrayList<Location> connections;
    private ArrayList<Item> items;
    private ArrayList<Person> people;

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
        this.connections = new ArrayList<Location>();
        this.items = new ArrayList<Item>();
        this.people = new ArrayList<Person>();
    }

    public void addConnection(Location location) {
        connections.add(location);
    }

    public ArrayList<Location> getConnections() {
        return connections;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public Item removeItem(int s) {
        if (s >= 0 && s < items.size()) {
            return items.remove(s);
        }
        return null;
    }

    public void addPerson(Person person){
        this.people.add(person);
    }

    public ArrayList<Person> getPeople(){
        return this.people;
    }

    public void describe() {
        System.out.println(name);

        System.out.println(description);
        if (!items.isEmpty()) {
            System.out.println("You see the following items: ");
            {
                for (int i = 0; i < items.size(); i++) {
                    System.out.println(i + ": " + items.get(i).toString());

                }
                System.out.print("Rooms : ");

                for (int i = 0; i < connections.size(); i++) {
                    System.out.println(i + ": " + connections.get(i).getName());

                }

                
            }

        } else {
            System.out.println("No items");

        }

        if (!people.isEmpty()) {
            System.out.println("You see the following people: ");
            {
                for (int i = 0; i < people.size(); i++) {
                    System.out.println(i + ": " + people.get(i).getName());
            
                }
            }
        } else {
            System.out.println("You see no people. ");

        }
    }

    public String getName() {
        return name;
    }
}
