package git;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class ListIteratorFile {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		//컬렉션 인스턴스 생성과 반환 및 복사
		List<String> list = Arrays.asList("Apple", "Banana", "Candy", "Durian", "Mango");
		list = new ArrayList<>(list);
		
		Iterator<String> itr = list.iterator(); //반복자 획득
		String str;
		while(itr.hasNext()) { //next메소드 호출시 참조값 반환 가능 여부 확인
			str = itr.next(); //다음 인스턴스의 참조값 반환(왼쪽에서 오른쪽으로 진행)
			System.out.print(str + '\t'); //배열 형식으로 출력
			if(str.equals("Mango")) { //참조값중에서 "Mango"랑 같은 문자열이 있다면 remove메소드로 제거한다(단, next메소드로 호출된값중에서만 가능)
				itr.remove();
			}
		}
		System.out.println();
		//remove로 "Mango"만 제거하고 출력
		
		ListIterator<String> litr = list.listIterator(); //양방향 반복자 획득
		while(litr.hasNext()) { //next메소드 호출시 참조값 반환 가능 여부 확인
			str = litr.next(); //다음 인스턴스의 참조값 반환(왼쪽에서 오른쪽으로 진행)
			System.out.print(str + '\t');
			if(str.equals("Banana")) { //참조값중에서 "Banana"랑 같은 문자열이 있다면 add메소드로 "Banana"왼쪽에 인스턴스 "Choco"생성
				litr.add("Choco");
			}
		}
		System.out.println();
		//**기존 값 "Apple" "Banana" "Candy" "Durian"을 왼쪽부터 하나씩 출력을 하는데 "Banana"가 출력되고 if문을 만족하여 "Banana"인스턴스 왼쪽에 "Choco"인스턴스를 생성한다 
		//그러나 이미 while문은 이미 "Banana"인스턴스를 지나고 있으므로 "Choco"인스턴스가 추가되어도 출력반복문이 이 인스턴스를 받지 않아 출력은 "Choco"인스턴스를 뺀 나머지 인스턴스가 된다
		//순방향 출력값: "Apple" "Banana" "Candy" "Durian"
		
		//양방향 반복자를 획득하지않는 이유는 previous로 오른쪽으로 왔던 것을 꺽어 다시 왼쪽으로 돌아가기 때문에 처음으로 되돌아갈 필요가 없어서 다시 획득하지 않는다
		while(litr.hasPrevious()) { //hasNext()와 같은 기능을 하지만 방향이 반대(오른쪽에서 왼쪽) -> 왼쪽방향으로 가서 참조값이 있는지 확인
			str = litr.previous(); //이전 인스턴스의 참조값 반환(오른쪽에서 왼쪽으로 진행)
			System.out.print(str + '\t');
			if(str.equals("Candy")) { //참조값중에서 "Candy"랑 같은 문자열이 있다면 add메소드로 "Candy"왼쪽에 인스턴스 "It's not fruit"생성
				litr.add("It's not fruit");
			}
		}
		System.out.println();
		//***기존 값 "Apple" "Banana" "Candy" "Durian" 을 오른쪽부터 하나씩 출력을 하는데 "Candy"랑 같은 문자열이 있으면 "It's not fruit"라는 인스턴스를 equals메소드의 인자로 받은 인스턴스의 왼쪽에 생성한다***
		//역방향 출력값: "Durian" "Candy" "It's not fruit" "Banana" "Choco" "Apple"
		Iterator<String> itr2 = list.iterator(); //다시 반복자 획득(순방향으로 최종출력하기 위해서)
		while(itr2.hasNext()) {
			str = itr2.next();
			System.out.print(str + '\t');
		}
		System.out.println();
		//최종 출력값 : "Apple" "Choco" "Banana" "It's not fruit" "Candy" "Durian"
	}

}