package interview.java;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

public class ExamArraySort {
	/*
	 	"bBcAaEC"와 같은 알파벳 문자열을 aAbBcC와 같은 알파벳 순서로 정렬하는 코드를 작성하세요.
	 */
	
	
	public static void main(String[] args) {
		String val = "EbBcAaC";
		String[] arrayVal = val.split("");
		
		Arrays.sort(arrayVal, String.CASE_INSENSITIVE_ORDER);	//대소문자 상관없이 abc 순으로 정렬
//		Arrays.sort(arrayVal, CASE_ORDER);						//정렬된 상태에서 소문자로 치환 후 같은 경우에만 비교하여  
		
		for(String value : arrayVal){
			System.out.println("value =" + value);
		}
		
	}
	
	/**
		final은 상속불가 또는 변할 수 없는 상수 선언에 사용되고,
		static은 공용의 변수를 만들 때 사용되는 예약어라서 완전 반대의 성격을 띄고 있다.
		
		[final]
		변수 : final 로 선언된 변수는 값을 초기화만 할 수 있고, 그 값의 변경 및 새로운 할당이 불가능하다
		class : final 접근제어자 클래스명, 상속불가 클래스, 따라서 상속이 필수적인 abstract와는 함께 사용할 수 없다.
		메소드 : 오버라이딩을 통해 재정의 할 수 없는 메소드가 됩니다.
		
		[static]
		변수 : static이 붙은 변수는 클래스의 모든 객체가 공유할 수 있다고 class 변수라고도 불립니다, 클래스 객체의 생성 없이도 사용할 수 있다는 장점이 있습니다.
		메소드 : 어느 객체의 내용에도 의존적이지 않은 하나의 작업을 수행, 오버라이딩 되지않고 메소드 숨김이 일어나 상속받은 클래스에서 사용이 불가능합니다.
		static 초기화 블록, 클래스에서 static 키워드만을 사용하여 초기화 블록으로 사용할 수 있습니다.
		static 초기화 블록은 클래스가 초기화 될 대 수행되고, main() 메소드보다 먼저 수행된다는 것이 큰 특징입니다.
		
	 **/
	public static final Comparator<String> CASE_ORDER = new CaseComparator();
	
	private static class CaseComparator implements Comparator<String>, Serializable {

		/*
		 	serialVersionUID 는 직렬화에 사용되는 고유 아이디인데, 선언하지 않으면 JVM에서 디폴트로 자동 생성된다.
			따라서 선언하지 않아도 동작하는데 문제는 없지만, 불안하기 때문에 JAVA에서는 명시적으로 serialVersionUID를 선언할 것을 적극 권장하고 있다.
		 */
		private static final long serialVersionUID = -3561504081198103985L;
		@Override
		public int compare(String o1, String o2) {
			char c1 = o1.charAt(0);
			char c2 = o2.charAt(0);
			
			if (c1 != c2) {
				char c1Lower = Character.toLowerCase(c1);
				char c2Lower = Character.toLowerCase(c2);
				if (c1Lower == c2Lower) {
					return c2 - c1;
				}
				System.out.println(String.format("c2 : %s, %s, c1 : %s, %s", (int)c2, c2, (int)c1, c1));
				System.out.println(String.format("c2-c1 = %s", c2-c1));
//				return c1 - c2;
			}
			//음수이면 o1이 o2보다 순서가 앞에 위치한다.
			//양수이면 o2이 o1보다 순서가 앞에 위치한다.
			return 0;
		}
		
	}
			
}
