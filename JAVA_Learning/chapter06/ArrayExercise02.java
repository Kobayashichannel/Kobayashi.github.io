

public class ArrayExercise02 {

	
	public static void main(String[] args) {

		int[] arr = {4,-1,9,10,23,110,-23,56,888,-256};
		int max = arr[0]; 
		int maxIndex = 0; 

		for(int i = 1; i < arr.length; i++){

			if(max < arr[i]) {
				max = arr[i];
				maxIndex = i;
			}
		}
		System.out.println("max=" + max + "maxIndex=" + maxIndex);
	}
		
}