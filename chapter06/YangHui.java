

public class YangHui {

	//编写一个main的方法
	public static void main(String[] args) {
		/*
		1
		1 1
		1 2 1
		1 3 3  1
		1 4 6  4  1
		1 5 10 10 5 1

		规律
		1.第一行有 1 个元素,第n行有n个元素
		2.每一行的第一个元素和最后一个元素都是1
		3.从第三行开始,对于非第一个元素和最后一个元素的元素的值. arr[i][j]
		  arr[i][j] = arr[i-1][j] + arr[i-1][j-1];//必须找到这个规律

		  */
		int[][] yangHui = new int[10][];
		for(int i = 0; i < yangHui.length; i++) {

			//给每个一维数组(行)开空间
			yangHui[i] = new int[i+1];
			//给每一一维数组(行) 赋值
			for(int j = 0; j < yangHui[i].length; j++) {
				//每一行的第一个元素和最后一个元素都是1
				if(j == 0 || j == yangHui[i].length - 1) {
					yangHui[i][j] = 1;
				} else {
					yangHui[i][j] = yangHui[i-1][j] + yangHui[i-1][j-1];
				}
			}
		}
		//输出杨辉三角
		for(int i = 0; i < yangHui.length; i++) {
			for(int j = 0; j < yangHui[i].length; j++){
				System.out.println(yangHui[i][j] + "\t");
			}
			System.out.println();//换行
		}
	}	
}