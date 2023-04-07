package com.javalab.lambda05;
/*
 * [스레드를 람다식으로 구현하는 예제]
 *  - 스레드를 구현하는데 람다식과 함수형 인터페이스를 이용
 */
public class Lambda005 {

	public static void main(String[] args) {
		
		/*
		 * [1] 스레드 클래스를 바로 정의하여 사용함(익명 구현 객체 사용)
		 * 스레드의 생성자에 Runnable 인터페이스를 구현한 익명 구현 객체를 바로 정의해
		 * 선언하면서 바로 객체화 됨.
		 */
		//new Runnable 익명 구현 객체
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i < 5; i++) {
					//현재 실행중인 Thread 이름을 반환한다.
					System.out.println(Thread.currentThread().getName()+"❤"+i);
				}
			}
		});
		thread.start(); //스레드는 실행 대기 (ready) 상태가 됨.
		System.out.println();
		
		//[2] Runnable 구현하는 익명 객체를 함수형 인터페이스에 타입에 저장
		// 자바에서 Runnable이라는 함수형 인터페이스를 미리 만들어 둠.
		Runnable runnable1 = new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i <= 10; i++) {
					System.out.println("runnable : " + i);
				}
			}
		};
		// 위에서 Runnable을 구현한 Runnable1, Runnable2 
		// Thread 생성자에 Runnable 인터페이스 타입 변수
		Thread thread1 = new Thread(runnable1);
		thread1.start();			// 스레드는 실행 대기 (ready) 상태가 됨.
		System.out.println();
		
		Runnable runnable2 = () -> {
	         for (int i = 1; i <= 10; i++) {
	            System.out.println("runnable2 " + i);
	         }
	      };
	      Thread thread2 = new Thread(runnable2); // Thread 생성자에 Runnable
	      thread2.start();   // 스레드는 실행 대기(ready) 상태가 됨
	      System.out.println();
	      /*
	       * 스레드의 생성자에 람다식을 이용한 익명 구현 객체를 정의해서 구현
	       * - 람다식을 통하여 생성된 익명 구현 객체가 스레드의 생성자에 매개변수로 전달
	       * - 람다식이 곧 Runnable 구현하는 익명 객체를 대신함
	       */
		Thread thread3 = new Thread(() -> {	//Runnable을 구현한 익명 구현 객체 탄생
			for (int i = 1; i <= 10; i++) {
				System.out.println("메인 스레드 : " + i);
			}
		});
		thread3.run();
	}
}


