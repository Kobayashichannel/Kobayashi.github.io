//课堂练习题
public class ArithmeticOperatorExercise03 {

    //编写一个main方法
    public static void main(String[] args) {

      //1.需求：
      //假如假期还有59天放假,问：合XX个星期天零XX天
      //2.思路分析
      //(1) 使用int 变量 days 保存 天数
      //(2) 一个星期是7天 星期数weeks： days / 7 零XX天lefDays days % 7
      //(3) 输出 

      //3.走代码
      int days = 59;
      int weeks = days / 7;
      int lefDays = days % 7;
      System.out.println(days + "天 合" + weeks + "星期零" 
        + lefDays + "天");

    }
}