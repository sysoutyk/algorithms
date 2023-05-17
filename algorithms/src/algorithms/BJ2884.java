package algorithms;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ2884 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
		int H = 0;
		int M = 0;
		//배열리스트에 입력값 저장
		ArrayList<Integer> list  = new ArrayList<>();
		for(int i=0; i<st.countTokens(); i++) {
			while(st.hasMoreTokens()) {
				list.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		System.out.println("list" + list);
		//리스트에서 값 빼오기
		H = list.get(0);
		M = list.get(1);
		
		//현재시간 - 45분
		if(M < 45) {
			M += 15;
		}else {
			M -= 45;
		}
		
		if(H == 0) {
			H += 23;
		}else {
			H -= 1;
		}
		System.out.println("H:" + H);
		System.out.println("M:" + M);
	}

}
