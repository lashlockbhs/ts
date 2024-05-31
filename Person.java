public class Person {
    private String name;
    private String description;
    public Person(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public void diolog(String playerSay){
        if(playerSay.equals("Hello")){
            System.out.println(this.name + " says wassup");
        }
        else if(playerSay.equals("Bye")){
            System.out.println(this.name + " says Seeya");
        
        }
    }

    public void dioOptions(){
        System.out.println("Diolog options for " + this.name + ": Hello, Bye"); 
    }
}
