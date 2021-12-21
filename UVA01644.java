import java.util.Scanner;

public class  UVA01644{

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);		//抓輸入
		boolean[] primepoint = new boolean[1299711];		//設立題目範圍大小的布林矩陣，要加1不然會overflow
		
		int max, min;			//宣告範圍頭尾
		
		for (int i = 2; i < 1299710; i++) {		//紀錄1299710內的質數，可以只判斷到那個數字開根號後的數字就好
			if (primecheck(i)) {
				primepoint[i] = true;		//是質數就把該點設為true
			}
		}

		while (input.hasNext()) {		//無限迴圈
			max = 0;		//頭
			min = 0;		//尾
			int num = input.nextInt();	//測試的數字

			if (num == 0) {		//如果是0就結束
				break;
			}

			for (int j = num; j < 1299710; j++) {	//開始找包含那個數字頭
				if (primepoint[j]) {		//如果跑到true，就是頭，就把該點的值給max
					max = j;
					break;
				}
			}

			for (int k = num; k < 1299710; k--) {
				if ((k - 1) < 0) {		//這一定要加，不會overflow
					break;
				}
				if (primepoint[k]) {		//如果跑到true，就是尾，就把該點的值給min
					min = k;
					break;
				}
			}

			System.out.println(max - min);		//最後就輸出max-min，就11-7=4的道理

		}

	}

	public static boolean primecheck(int num) {		//這邊就是呼叫的函式，其實也可以直接寫一起啦，只是我是想說這樣我比較好看的董
		for (int j = 2; j <= Math.sqrt(num); j++) {		//這邊就是去判斷跑到當下的那個數裡的到開根號的每一個數
			if (num % j == 0) {
				return false;
			}
		}
		return true;
	}
}
