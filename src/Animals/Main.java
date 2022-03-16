package Animals;

public class Main {
    public static void main(String []args){
        Animal A = new Animal();
        A.setters(
                "tiger",
                "roar",
                "big"
        );
        A.getSize();
        A.getSound();
        A.getType();
    }
}
