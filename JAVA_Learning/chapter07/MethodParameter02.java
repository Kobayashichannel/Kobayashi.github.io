

public class MethodParameter02 {

	//编写一个main方法
	public static void main(String[] args) {

		//测试
		B b = new B();
		// int[] arr = {1, 2, 3};
		// b.test100(arr);
		// System.out.println("main的 arr数组");
		// //遍历数组
		// for(int i = 0; i < arr.length; i++) {
		// 	System.out.print(arr[i] + "\t");
		// }
		// System.out.println();

		//测试
		Person p = new Person();
		p.name = "jack";
		p.age = 10;

		b.test200(p);
		//测试题,如果 test200 执行的是 p = null,下面结果是 10
		System.out.println("main 的p.age=" 
		+ p.age);//10000;
	}
}
class Person {
	String name;
	int age;
}

class B {

	public void test200(Person p) {
		//p.age = 10000;
		//思考
		//p = null;
		//思考
		p = new Person();
		p.name = "tom";
		p.agee = 99;
	}
	
	//B类编写一个方法test100
	//可以接收一个数组,在方法中修改数组,看看原来的数组是否变化
	//
	public void test100(int[] arr) {
		arr[0] = 200;
		System.out.println("test100的 arr数组");
		//遍历数组
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
	}
}