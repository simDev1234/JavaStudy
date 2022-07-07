//  Practice
//  다음 클래스 직접 만든 후 객체 생성
//  클래스명: Animal
//  특성: 이름, 무게, 분류
//  기능: 먹기, 잠자기, 걷기, 뛰기

class Animal {
    String name;
    double weight;
    String cate;

    Animal(String name, double weight, String cate) {
        this.name = name;
        this.weight = weight;
        this.cate = cate;
    }

    public void eat() {
        System.out.println("냠냠");
    }

    public void sleep() {
        System.out.println("쿨쿨");
    }

    public void walk() {
        System.out.println("걷기!");
    }

    public void run() {
        System.out.println("뛰기!");
    }

    public void printInfo() {
        System.out.println("== Animal Info ==");
        System.out.println("name : " + this.name + ", weight : " + this.weight + ", cate : " + this.cate);
    }
}
public class Practice {
    public static void main(String[] args) {
        // Test code
        Animal animal1 = new Animal("강아지", 5.0, "포유류");
        Animal animal2 = new Animal("구피", 0.01, "어류");

        animal1.printInfo();
        animal2.printInfo();
    }
}
