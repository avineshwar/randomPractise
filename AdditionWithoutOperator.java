package randomPractise;

//import java.math.*;
import java.util.*;

public class AdditionWithoutOperator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int operand_1 = scanner.nextInt();
		int operand_2 = scanner.nextInt();
		ArrayList<Integer> integers = new ArrayList<Integer>();
		ArrayList<Integer> integers2 = new ArrayList<Integer>();

		while (operand_1 != 1) {
			integers.add(operand_1 % 2);
			operand_1 = operand_1 / 2;
		}
		integers.add(1);
		// if (integers.size() % 2 != 0) {
		// integers.add(0);
		// integers.add(2);
		// } else
		// integers.add(2);
		// // System.out.println(integers.toString());

		while (operand_2 != 1) {
			integers2.add(operand_2 % 2);
			operand_2 = operand_2 / 2;
		}
		integers2.add(1);
		// if (integers2.size() % 2 != 0) {
		// integers2.add(0);
		// integers2.add(2);
		// } else
		// integers2.add(2);
		// // System.out.println(integers2.toString());

		int size_1 = integers.size();
		int size_2 = integers2.size();

		if (size_1 > size_2) { // integers2 needs to have more zeroes!
			size_2++;
			integers2.add(0);
			while (size_1 != size_2) {
				integers2.add(0);
				size_2++;
			}
			System.out.println(integers.toString());
			System.out.println(integers2.toString());
		} else if (size_2 > size_1) { // integers needs to have more zeroes!
			size_1++;
			integers.add(0);
			while (size_1 != size_2) {
				integers.add(0);
				size_1++;
			}
			System.out.println(integers.toString());
			System.out.println(integers2.toString());

		} else {
			System.out.println(integers.toString());
			System.out.println(integers2.toString());
		}

		ArrayList<Integer> integers3 = new ArrayList<Integer>();
		int carry = 0;
		int i = 0;
		int j = 0;
		for (; !(size_1 < 1 && size_2 < 1); size_1--, size_2--, i++, j++) {
			if (integers.get(i) == 0 && integers2.get(j) == 0) { // case 1
				if (carry == 0)
					integers3.add(0);
				else {
					integers3.add(1);
					carry = 0;
				}
			} else if (integers.get(i) == 0 && integers2.get(j) == 1) { // case
																		// 2
				if (carry == 0)
					integers3.add(1);
				else {
					integers3.add(0);
					carry = 1;
				}
			} else if (integers.get(i) == 1 && integers2.get(j) == 0) { // case
																		// 3
				if (carry == 0)
					integers3.add(1);
				else {
					integers3.add(0);
					carry = 1;
				}
			} else { // case 4
				if (carry == 1)
					integers3.add(1);
				else {
					integers3.add(0);
					carry = 1;
				}
			}
		}
		if (carry == 1)
			integers3.add(1);

		StringBuilder stringBuilder = new StringBuilder();
		for (Integer integer : integers3) {
			stringBuilder.append(integer);
		}

		System.out.println("Binary representation is: " + stringBuilder.toString());

		// System.out.println(Integer.toString(Integer.parseInt(stringBuilder.toString()),
		// 9));
	}
}
