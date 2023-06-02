package algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BJ8979 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] num = new int[N];
		int rank = 1;
	
		//데이터 저장
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<N; i++) {
				num[i] = sc.nextInt();
				//금 - *3, 은 - *2, 동 - *1; 
				int gold = (sc.nextInt())*3;
				int silver = (sc.nextInt())*2;
				int bronze = sc.nextInt();
				int score = gold + silver+ bronze;
				map.put(num[i], score);
		}
		//랭킹 더하기
		for(int i=0; i<map.size(); i++) {
			if(map.get(num[i]) > map.get(K)) {
				rank = rank + 1;
			}
		}
		System.out.println("rank: " + rank);

	}
	
}
