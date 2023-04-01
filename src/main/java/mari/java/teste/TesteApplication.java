package mari.java.teste;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class TesteApplication {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};

		System.out.println("Matriz com ordem inversa: ");
		reverse(nums);
		System.out.println(Arrays.toString(nums));


		System.out.println("Reversão in-place: ");
		int[] mewNums = {1,2,3,4,5};
		System.out.println(Arrays.toString(reverseInPlace(mewNums)));


		System.out.println("Reversão in-place List: ");
		List<String> colors = new ArrayList<>(Arrays.asList("RED", "BLUE", "BLACK"));
		reverseList(colors);
		System.out.println(colors);


		System.out.println("Arquivo CSV (valores separados por vírgula) passado como um java.io.BufferedReader");

		getFileCSV();

	}

	public static void reverse(int[] nums)
	{
		int[] temp = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			temp[nums.length - 1 - i] = nums[i];
		}

		for (int i = 0; i < nums.length; i++) {
			nums[i] = temp[i];
		}
	}

	public static int[] reverseInPlace(int A[]) {
		int n = A.length;
		for (int i = 0; i < n / 2; i++) {
			int temp = A[i];
			A[i] = A[n - 1 - i];
			A[n - 1 - i] = temp;
		}
		return A;
	}

	public static<T> void reverseList(List<T> list) {
		if (list == null || list.size() <= 1) {
			return;
		}
		T value = list.remove(0);

		reverseList(list);
		list.add(value);
	}

	public static void getFileCSV() {
		String path = "D:\\Projetos\\doc.txt";
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);

			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		finally {
			try{
				br.close();
				fr.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
