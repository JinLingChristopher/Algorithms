public class Dog{
    /*
    1. Not all classes have a main method.
    */
    public int WeightInPounds;
    public static String binomen = "Canis familiaris";

    /** One interger constructor for dogs. */
    public Dog(int w){
        this.WeightInPounds = w;
    }

    public void makeNoise(){
        if (WeightInPounds < 10){
            System.out.println("yip!");
        }else if (WeightInPounds < 30){
            System.out.println("Bark!");
        }else{
            System.out.println("Woooof!");
        }
    }

    public static Dog maxDog(Dog d1, Dog d2){
        if(d1.WeightInPounds > d2.WeightInPounds){
            return d1;
        }
            return d2;
    }

} 