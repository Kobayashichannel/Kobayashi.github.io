package Learn_Intermediate_Java.Regular_Expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example05 {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("gray|grey", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("Vibrant light bloomed across the gray sky, illuminating its grey haze in flashes amidst rolling hills of wispy gray clouds. Colors of gold, pink, and purple painted the horizon, the dull grey of the sky overtaken by brief moments of a quiet twilight storm.");

        int count = 0;
        while (matcher.find())
            count++ ;
            System.out.println(count);
    }
}
