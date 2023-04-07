package com.javalab.lambda03;

/*
 * 함수형 인터페이스(메소드가 하나인 인터페이스)
 *  - 람다식을 만들어서 저장할 인터페이스
 */
@FunctionalInterface
interface MyFunctionalInterface {
	public void run(); // 유일한 추상 메소드(껍데기 메소드), 작업 지시 사항	//public void 사이에 abstract생략
}

/*
 * 람다식 테스트 클래스 - 매개 변수가 없고 return문이 없는 람다 함수
 */
public class Lambda003  {
	public static void main(String[] args) {
		MyFunctionalInterface fi; // 함수형 인터페이스 타입 참조변수

		/*
		 * [1] 매개 변수가 없으면 빈 괄호() 사용가능 - 구현 내용이 여러 문장이면 중활호{}로 감싸야 함.
		 */

		fi = () -> {	//익명 구현 객체 탄생	//2줄 이상이면 중괄호 블록 생략 못함.
			String str = "method call1";
			System.out.println(str);
		};
		fi.run();	//익명 구현 객체의 run()메소드 호출

		// [2] 구현(실행) 내용이 한 줄 이면 중괄호{}를 써도 되고, 생략도 가능함
		// (생략시 세미콜론도 생략 가능)
		fi = () -> {
			System.out.println("method call2");	//run()메소드 내용으로 구현입니다! 컴파일러가 유추해서 알고있는거여
		};
		fi.run();

		// [3] 구현(실행) 내용이 한 줄 이면 중괄호{} 생략 가능
		fi = () -> {	// 제일 간략한형태
			System.out.println("method call3");
		};
		fi.run();
		
		//System.out.println("람다식 사용없이 익명 구현 객체의 run()메소드 호출");
		// 익명 구현 객체
		// 람다식 없이
		fi = new MyFunctionalInterface() {
			@Override
			public void run() {
				System.out.println("람다식 사용없이 익명 구현 객체의 run()메소드 호출");
			}
		};
		fi.run();
	}
}
