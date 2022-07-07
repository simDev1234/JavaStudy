// Practice
// 로또 번호 만들기

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

public class Practice {
    public static void main(String[] args) {

        // HashSet을 통해 중복되지 않은 6개 수의 집합을 만든다.
        HashSet<Integer> set = new HashSet<Integer>();
        
        for (int i = 0; set.size() < 6; i++) {
            int num = (int)(Math.random() * 45) + 1;
            set.add(num);
        }

        // Set -> List으로 변환한 뒤, 컬렉션 인터페이스를 활용해 정렬을 한다.
        LinkedList list = new LinkedList(set);
        Collections.sort(list);
        
        // 출력
        System.out.println("로또 번호 : " + list);

    }
}
