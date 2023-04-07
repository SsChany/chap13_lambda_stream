package com.javalab.stream03;

import java.util.*;

public class MapToInt01 {

	public static void main(String[] args) {
		
		List<Student> studentList = Arrays.asList(
				new Student("홍길동", 10),
				new Student("신용권", 20),
				new Student("유미선", 30)
				);
		
		studentList.stream()	//Stream<Student> 객체  생성	//반복할 수 있도록 stream()객체로 만들어줌.
			//.mapToInt(s -> s.getScore())	//Student 객체에서 정수만 빼옴	//학생의 점수로만 된 IntStream 생성
			.mapToInt(Student :: getScore)	//학생의 점수로만 된 IntStream 생성 
			.forEach(score -> System.out.println(score));
	}
}
