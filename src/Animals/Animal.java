package Animals;

public class Animal {
    private String animalType, sound, size;
    public void setters(String animalType,String sound, String size){
        this.animalType = animalType;
        this.sound = sound;
        this.size = size;
    }
    public void getType(){
        System.out.println("this animal is a " + animalType);
    }
    public void getSize(){
        System.out.println("this animal is " + size + " in size");
    }
    public void getSound(){
        System.out.println("this animal sounds like " + sound);
    }
}
