package algorithms;

import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ1063 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
		String k = st.nextToken();
		String s = st.nextToken();
		int n = Integer.parseInt(st.nextToken());
		String[] columns = {"A", "B", "C", "D", "E", "F", "G", "H"};
		String[] rows = {"1","2","3","4","5","6","7","8"};
		String[][] chess = new String[rows.length][columns.length];
	
		long sx = 0;
		long sy = 0;
		long kx = 0;
		long ky = 0;
	
		//체스판
		for(int i=0; i<rows.length; i++) {
			for(int j=0; j<columns.length; j++) {
				String square = columns[i].concat(rows[j]);
				chess[i][j] = square;
				
			}
		}
	
		
		for(int j=0; j<columns.length; j++) {
			if(columns[j].charAt(0) ==  k.charAt(0)) {
				kx = j;
			}
			if(columns[j].charAt(0) == s.charAt(0)) {
				sx = j;
			}
		}

		sy = Integer.parseInt(s.substring(1))-1; 
		ky = Integer.parseInt(k.substring(1))-1;
	
		//동작키 받아오기
		for(int i=0; i<n; i++) {
			String nextMov = sc.next();
			
			//체스돌 움직이기
			switch(nextMov) {
				case "R":
					if(sy == ky && kx < sx) {
						sx += 1;
						
					}
						kx += 1;
					if(sx == columns.length || kx == columns.length ) {
						sx -= 1;
						kx -= 1;
					}
					
					break;
				case "L":
					if(sy == ky && sx < kx) {
						sx -= 1; 
					}
						kx -= 1;
					if(sx < 0 || kx < 0) {
						sx += 1;
						kx += 1;
					}
					break;
				case "B":
					if(kx == sx && ky > sy) {
						sy -= 1;
					}
						ky -= 1;
					if(sy < 0 || ky < 0) {
						sy += 1;
						ky += 1;
					}
					break;
				case "T":
					if(kx == sx && ky < sy) {
						sy +=1;
					}
						ky += 1;
					if(sy == rows.length || ky == rows.length) {
						sy -= 1;
						ky -= 1;
					}
					break;
				case "RT":
					if(kx+1 == sx && ky+1 == sy) {
						sx += 1;
						sy += 1;
					}
						kx += 1; 
						ky += 1;
					if(sx == columns.length || kx == columns.length || 
						sy == rows.length || ky  == rows.length) {
						sx -= 1; sy -= 1; kx -= 1; ky -= 1;
					}
					break;
				case "RB":
					if((kx+1 == sx) && (ky-1 == sy)) {
						sx += 1;
						sy -= 1;
					}
						kx += 1;
						ky -= 1;
					if(sx == columns.length || kx == columns.length ||
						sy < 0 || ky < 0) {
						sx -= 1; kx -= 1; sy += 1; ky += 1;
					}
					break;
				case "LB":
					if((kx-1 == sx) && (ky-1 == sy)) {
						sx -= 1;
						sy -= 1;
					}
						kx -= 1;
						ky -= 1;
					if(sx < 0 || kx < 0 || sy < 0 || ky < 0) {
						sx += 1; kx += 1; sy += 1; ky += 1;
					}
					break;
				
			}

		}//for	
		String king = chess[(int) kx][(int) ky];
		String stone = chess[(int) sx][(int) sy];
		System.out.println(king);
		System.out.println(stone);
	}

}
