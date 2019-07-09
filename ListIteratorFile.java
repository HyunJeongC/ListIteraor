package git;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class ListIteratorFile {

	public static void main(String[] args) {
		// TODO �ڵ� ������ �޼ҵ� ����
		//�÷��� �ν��Ͻ� ������ ��ȯ �� ����
		List<String> list = Arrays.asList("Apple", "Banana", "Candy", "Durian", "Mango");
		list = new ArrayList<>(list);
		
		Iterator<String> itr = list.iterator(); //�ݺ��� ȹ��
		String str;
		while(itr.hasNext()) { //next�޼ҵ� ȣ��� ������ ��ȯ ���� ���� Ȯ��
			str = itr.next(); //���� �ν��Ͻ��� ������ ��ȯ(���ʿ��� ���������� ����)
			System.out.print(str + '\t'); //�迭 �������� ���
			if(str.equals("Mango")) { //�������߿��� "Mango"�� ���� ���ڿ��� �ִٸ� remove�޼ҵ�� �����Ѵ�(��, next�޼ҵ�� ȣ��Ȱ��߿����� ����)
				itr.remove();
			}
		}
		System.out.println();
		//remove�� "Mango"�� �����ϰ� ���
		
		ListIterator<String> litr = list.listIterator(); //����� �ݺ��� ȹ��
		while(litr.hasNext()) { //next�޼ҵ� ȣ��� ������ ��ȯ ���� ���� Ȯ��
			str = litr.next(); //���� �ν��Ͻ��� ������ ��ȯ(���ʿ��� ���������� ����)
			System.out.print(str + '\t');
			if(str.equals("Banana")) { //�������߿��� "Banana"�� ���� ���ڿ��� �ִٸ� add�޼ҵ�� "Banana"���ʿ� �ν��Ͻ� "Choco"����
				litr.add("Choco");
			}
		}
		System.out.println();
		//**���� �� "Apple" "Banana" "Candy" "Durian"�� ���ʺ��� �ϳ��� ����� �ϴµ� "Banana"�� ��µǰ� if���� �����Ͽ� "Banana"�ν��Ͻ� ���ʿ� "Choco"�ν��Ͻ��� �����Ѵ� 
		//�׷��� �̹� while���� �̹� "Banana"�ν��Ͻ��� ������ �����Ƿ� "Choco"�ν��Ͻ��� �߰��Ǿ ��¹ݺ����� �� �ν��Ͻ��� ���� �ʾ� ����� "Choco"�ν��Ͻ��� �� ������ �ν��Ͻ��� �ȴ�
		//������ ��°�: "Apple" "Banana" "Candy" "Durian"
		
		//����� �ݺ��ڸ� ȹ�������ʴ� ������ previous�� ���������� �Դ� ���� ���� �ٽ� �������� ���ư��� ������ ó������ �ǵ��ư� �ʿ䰡 ��� �ٽ� ȹ������ �ʴ´�
		while(litr.hasPrevious()) { //hasNext()�� ���� ����� ������ ������ �ݴ�(�����ʿ��� ����) -> ���ʹ������� ���� �������� �ִ��� Ȯ��
			str = litr.previous(); //���� �ν��Ͻ��� ������ ��ȯ(�����ʿ��� �������� ����)
			System.out.print(str + '\t');
			if(str.equals("Candy")) { //�������߿��� "Candy"�� ���� ���ڿ��� �ִٸ� add�޼ҵ�� "Candy"���ʿ� �ν��Ͻ� "It's not fruit"����
				litr.add("It's not fruit");
			}
		}
		System.out.println();
		//***���� �� "Apple" "Banana" "Candy" "Durian" �� �����ʺ��� �ϳ��� ����� �ϴµ� "Candy"�� ���� ���ڿ��� ������ "It's not fruit"��� �ν��Ͻ��� equals�޼ҵ��� ���ڷ� ���� �ν��Ͻ��� ���ʿ� �����Ѵ�***
		//������ ��°�: "Durian" "Candy" "It's not fruit" "Banana" "Choco" "Apple"
		Iterator<String> itr2 = list.iterator(); //�ٽ� �ݺ��� ȹ��(���������� ��������ϱ� ���ؼ�)
		while(itr2.hasNext()) {
			str = itr2.next();
			System.out.print(str + '\t');
		}
		System.out.println();
		//���� ��°� : "Apple" "Choco" "Banana" "It's not fruit" "Candy" "Durian"
	}

}