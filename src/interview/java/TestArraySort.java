package interview.java;

import java.util.Arrays;
import java.util.Comparator;

import interview.java.entity.dto.Fruit;

public class TestArraySort {
	/*
		자연율(일반적인 정렬순서)이 아니라 사용자가 새롭게 정렬순서를 정의하고 싶거나 오브젝트를 정렬할 때, 오브젝트 정렬에 사용될 값을 지정하는 역할을 하는 인터페이스가 바로
		Comparable과 Comparator입니다.
	 */
	
	/*
	 	"dBcAaEC"와 같은 알파벳 문자열을 aAbBcC와 같은 알파벳 순서로 정렬하는 코드를 작성하세요.
	 */
	
//	compareTo 메소드는 Object 클래스에 정의되어 있지 않으며(자바 1.2에 추가됨), 대신에 Comparable 인터페이스에 유일하게 존재하는 메소드이다.
//	이 메소드는 Object.equals 메소드와 유사한 특성을 가지는데, 차이점이라면 두 객체가 동일한지 비교하는 것과 더불어 순서까지 비교할 수 있으며, 제네릭 타입을 지원한다.
//	클래스에서 Comparable 인터페이스를 구현하면, 이 인터페이스에 의존하는 수많은 알고리즘 및 컬렉션 클래스들과 상호연동이 가능하다.
//	실제로 자바 라이브러리의 모든 값은 Comparable 인터페이스를 구현하므로, 만일 알파벳 순, 숫자 순, 날짜 순과 같은 자연율을 갖는 값 클래스를 작성한다면 반드시 Comparable 인터페이스를 구현해야 한다.
	
//	Comparable 은 위에서 살펴봤듯이 객체 자체에 compareTo(T o) 를 구현하게 하여 정렬 방법을 값(객체) 자신이 알려주는 방식이다.
//	이걸 구현해두면 언젠가 자신을 사용할 객체가 Comparable 을 활용할 줄 아는 녀석이라면 그 객체에 의해 정렬이 되어진다
	
//	순서 판단을 위해 현재 객체(compareTo 메소드가 호출된)와 지정 객체(compareTo 메소드의 인자로 전달된)를 비교한다.
//	현재 객체의 값이 지정 객체보다 작으면 음수 정수값을, 같으면 0을, 크면 양수 정수값을 반환한다.
//	만일 지정 객체 타입이 현재 객체와 비교할 수 없는 타입이면 ClassCastException 예외를 발생시킨다.
//	다음 설명에서 sgn(표현식)은 signum 수학 함수를 나타내며, 표현식의 값이 음수면 -1을, 0이면 0을, 양수면 1을 반환한다.
	
	public static void main(String[] args) {
		String[] fruits = new String[]{"Pineapple", "Apple", "Orange", "Banana"};
		sortStrArray(fruits);
		
		Fruit[] fr = new Fruit[4];
		fr[0] = new Fruit("Pineapple", 70);
		fr[1] = new Fruit("Apple", 30);
		fr[2] = new Fruit("Orange", 35);
		fr[3] = new Fruit("Banana", 50);
		
		//Exception in thread "main" java.lang.ClassCastException: interview.java.entity.dto.Fruit cannot be cast to java.lang.Comparable
		//Object 특성 속성을 가지고 정렬을 되게끔 할려면 Comparable 인터페이스를 구현하고 compareTo 메소드를 오버라이딩해야합니다.
		sortObjectArray(fr);
		
		//Comparator 인터페이스는 compare 메소드를 정의하고 있습니다. compare 메소드는 2개의 인자를 받고 사용자가 구현한 로직대로 대소 관계를 정의할 수 있다.
		//compare 메소드는 2개의 인자를 받고 사용자가 구현한 로직대로 대소관계를 정의할 수 있죠. 
		
		// Arrays.sort 두번째 인자는 Comparator 타입을 받아서 첫 번째 배열 정렬 순서를 재정의 할 수 있습니다.
		Arrays.sort(fr, new Comparator<Fruit>() {

			@Override
			public int compare(Fruit o1, Fruit o2) {
				String name1 = o1.getName().toUpperCase();
				String name2 = o2.getName().toUpperCase();
				
				//Ascending order
				return name1.compareTo(name2);
			}
		});
		
		for(Fruit fruit : fr) {
			System.out.println("compareTo fruits : " + fruit.getName() + ", 가격 : " + fruit.getPrice());
		}
		
	}
	
	// 배열을 정렬하기 위해서 Collection 프레임워크의 Arrays 유틸을 사용합니다.
	public static void sortStrArray(String[] fruits) {
		
		//Arrays의 sort 메소드는 argument로 들어온 배열의 타입들이 참조 자료형일 경우, Comparable, Comparator 인터페이스를 구현하여 정렬 순서가 정의된 자료형만 정렬할 수 있습니다.
		//그러니까 Arrays.sort() 메소드로 정렬이 완료된 String 은 참조 자료형이므로 내부적으로 이미 compararble 인터페이스를 구현한다는 사실을 알 수 있습니다.
		Arrays.sort(fruits);
		
		for(int i = 0; i < fruits.length; i++) {
			System.out.println("fruits :" + fruits[i]);
		}
	}
	
	public static void sortObjectArray(Fruit[] fruits) {
		
		//Arrays의 sort 메소드는 argument로 들어온 배열의 타입들이 참조 자료형일 경우, Comparable, Comparator 인터페이스를 구현하여 정렬 순서가 정의된 자료형만 정렬할 수 있습니다.
		//그러니까 Arrays.sort() 메소드로 정렬이 완료된 String 은 참조 자료형이므로 내부적으로 이미 compararble 인터페이스를 구현한다는 사실을 알 수 있습니다.
		Arrays.sort(fruits);
		
		for(Fruit fruit : fruits) {
			System.out.println("fruits : " + fruit.getName() + ", 가격 : " + fruit.getPrice());
		}
	}
}
