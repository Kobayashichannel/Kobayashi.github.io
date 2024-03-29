package Learn_Advanced_Java.Database_Connectivity;

public class ConnectionTest {
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            System.out.println("The driver was successfully loaded.");
        } catch (ClassNotFoundException e) {
            System.out.println("The driver class was not found in the program files at runtime.");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
