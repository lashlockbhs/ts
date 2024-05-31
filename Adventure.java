import java.util.*;

public class Adventure {
    public static void main(String[] args) {
        Location[][] world = new Location[4][4];

        world[0][0] = new Location("Room1", ""); //no spaces in names
        world[0][1] = new Location("Room2", "");
        world[1][1] = new Location("Room3", "");
        world[1][2] = new Location("Room4", "");
        world[2][2] = new Location("Room5", "");
        world[2][3] = new Location("Room6", "");
        world[3][3] = new Location("Room7", "");

        world[0][0].addConnection(world[0][1]);
        world[0][1].addConnection(world[0][0]);
        world[0][1].addConnection(world[1][1]);
        world[1][1].addConnection(world[0][1]);
        world[1][1].addConnection(world[1][2]);
        world[1][2].addConnection(world[1][1]);
        world[1][2].addConnection(world[2][2]);
        world[2][2].addConnection(world[1][2]);
        world[2][2].addConnection(world[2][3]);
        world[2][3].addConnection(world[2][2]);
        world[2][3].addConnection(world[3][3]);
        world[3][3].addConnection(world[2][3]);


        world[0][0].addItem(new Item("Plant", "A small garden plant that speaks fluent Sindarin"));
        world[1][1].addItem(new Item("Book", "A book---maybe?"));


        world[0][1].addPerson(new Person("cool person", "interesting shop keeper"));
        Player player = new Player("mainPlayer", world[0][0]);

        Scanner scanner = new Scanner(System.in);

        boolean notdead = true;
        while (notdead) {
            System.out.println("C => goto, take, drop, say (Hello, Bye)");
            player.showInventory();
            player.getCurrentLocation().describe();

            System.out.print("Now what shall u do? -> ");
        
            String command = scanner.nextLine();
            String first = ""; 
            String second = ""; 
    
            for (int i = 0; i < command.length(); i++) { 
                if (command.substring(i, i + 1).equals(" ")) {
                    first = command.substring(0, i);
                    second = command.substring(i + 1, command.length());
                }
            }

            ArrayList<Location> connenctions = player.getCurrentLocation().getConnections();
            ArrayList<Item> items = player.getCurrentLocation().getItems();
            ArrayList<Item> inventory = player.getInventory();
            
            if (first.equals("goto")) {
                for (int i = 0; i < connenctions.size(); i++) {
                    if (connenctions.get(i).getName().equals(second)) {
                        player.moveTo(connenctions.get(i));
                        System.out.println("Entering " + connenctions.get(i).getName());
                    }
                }
            }else if (first.equals("take")) {
                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i).getName().equals(second)) {
                        player.addItem(items.get(i));
                        player.getCurrentLocation().removeItem(i);
                    }
                }

            }else if (first.equals("drop")) {
                for (int i = 0; i < inventory.size(); i++) {
                    if (inventory.get(i).getName().equals(second)) {
                        player.getCurrentLocation().addItem(inventory.get(i));
                        player.rItem(inventory.get(i));
                    }
                }

            }
            else if(first.equals("say")){
                if(!player.getCurrentLocation().getPeople().isEmpty()){
                    player.getCurrentLocation().getPeople().get(0).diolog(second);
                }else{
                    System.out.println("no people");
                }
            }


            System.out.println();
            
        }
        scanner.close();
    }
}
