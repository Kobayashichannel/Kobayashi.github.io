import java.util.Scanner;
//
public class Chapter05HomeWork03 {

	//��дһ��main����
	public static void main(String[] args) {
		System.out.println("���������:");
		Scanner myScanner = new Scanner(System.in);

		int year = myScanner.nextInt();
		if(((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)){
			System.out.println(year + "��������");
		} else {
			System.out.println(year + "�겻������");
		}
		System.out.println("����ִ�н���");
	} 
}