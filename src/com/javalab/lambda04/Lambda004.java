package com.javalab.lambda04;
// 함수형 인터페이스
@FunctionalInterface
interface MyFunctionalInterface{
	//반환형이 있고 매개 변수가 두개인 추상메소드
	public int run(int x, int y);	// 유일한 메소드
}
// 매개 변수가 있고 return문이 있는 경우 람다 함수
public class Lambda004 {
	
	public static void main(String[] args) {
		
		MyFunctionalInterface fi;
		
		int sum = 0;
		
		// 람다식 사용하지 않고 익명 구현 객체 생성
		fi = new MyFunctionalInterface() {
			@Override
			public int run(int x, int y) {
				return x + y;
			}
		};
		sum = fi.run(2, 3);
		System.out.println(sum);
		System.out.println(fi);
		System.out.println();
		
		
		/*
		 * [1] 실행문이 여러줄인 경우 람다식
		 *  - 실행문이 여러줄이면 중괄호 {} 있어야 함.
		 */
		fi = ( x,  y) -> {
			System.out.println("run 메소드콜");
			return x + y;
		};
		sum = fi.run(2, 3);
		System.out.println(sum);
		System.out.println(fi);
		System.out.println();
		/*
		 * [2] 실행문이 return 구문 한줄인 람다식
		 * 	   a와 b를 받아서 큰 수를 반환해주는 람다식 구현
		 */
		fi = (x, y) -> {
			System.out.println("큰 수");	
			return x > y ? x : y;			// 익명 구현 객체 생성 (run()메소드 있다)
		};
		//fi = (a,b) -> x > y ? x : y;		//한 줄이라 이렇게 써도 됨. 결과는 같음.
		sum = fi.run(10, 5);
		System.out.println(sum);
		System.out.println(fi);
	}
}
