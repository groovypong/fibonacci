import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigInteger;

public class Fibo {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Программа вывода числа Фибоначчи." +
			" Для выхода из программы введите любое НЕ числовое значение");
		while (true) {
				System.out.print("Введи порядковый номер числа Фибоначчи: ");
				String line = in.readLine();
				if (!isDigit(line)) {
					System.out.println("Выход из программы.\n");
					break;
				}
				int num = Integer.parseInt(line);
				BigInteger fibo = fibo(num);

				StringBuilder resultMSG = new StringBuilder();
				resultMSG.append("Число Фибоначчи: ").append(fibo).append("\n");
				resultMSG.append("Число Фибоначчи в long: ").append(fibo.longValue()).append("\n");
		
				System.out.println(resultMSG);
			}
	}

	public static BigInteger fibo(int x) {
		if (x < 3) return x == 0 ? BigInteger.valueOf(0) : BigInteger.valueOf(1);

		BigInteger a = BigInteger.valueOf(1);
		BigInteger b = BigInteger.valueOf(2);
		BigInteger tmp;

		for (int i = 3; i < x; i++) {
			tmp = a;
			a = b;
			b = tmp.add(a);
		}
		return b;
	}

	public static boolean isDigit(String line) {
		try {
			Integer.parseInt(line);
			return true;
		} catch(NumberFormatException nfe) {
			return false;
		}
	}
}

// 0 1 2 3 4 5 6 7  8  9  10 11 12  13  14
// 0 1 1 2 3 5 8 13 21 34 55 89 144 233 377