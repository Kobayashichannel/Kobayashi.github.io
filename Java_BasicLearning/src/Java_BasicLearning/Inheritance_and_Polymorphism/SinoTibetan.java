package Java_BasicLearning.Inheritance_and_Polymorphism;

public class SinoTibetan extends Language{
    SinoTibetan(String languageName, int speakers) {
        super(languageName, speakers, "Asia", "subject-object-verb");
        if (languageName.contains("Chinese")) {
            this.wordOrder = "subject-verb-object";
        }
    }
}
