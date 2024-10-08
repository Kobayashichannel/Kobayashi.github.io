package Java_BasicLearning.Inheritance_and_Polymorphism;

class NoodleRestaurant {
    String name;

    public NoodleRestaurant(String customerName){
        name = customerName;
    }

    public void order(Noodle06 noodle06) {
        System.out.println(noodle06.getCookPrep());
        System.out.println("Order for " + name + " is ready.");
    }

    public static void main(String[] args) {
        Noodle06 ramen, pho;
        ramen = new Ramen06();
        pho = new Pho06();

        NoodleRestaurant customer1 = new NoodleRestaurant("Sagirah");
        NoodleRestaurant customer2 = new NoodleRestaurant("Maritza");

        // Add your code here
        customer1.order(pho);
        customer2.order(ramen);
    }
}
