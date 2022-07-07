// Java 프로그래밍 - 람다식

interface ComputeTool {
    public abstract int compute(int x, int y);

//    public abstract int compute2(int x, int y);
}

// 추상 메소드가 2개 이상이 있는 인터페이스의 경우 람다식 사용이 제한된다.
interface ComputeTool2 {
    public abstract int compute(int x, int y);

    public abstract int compute2(int x, int y);
}

public class Main {

    public static void main(String[] args) {

        ComputeTool cTool1 = new ComputeTool(){
            @Override
            public int compute(int x, int y) {
                return x + y;
            }
        };
        System.out.println(cTool1.compute(1, 2));

        // 람다식
        ComputeTool cTool2 = (x, y) -> { return x + y; };
        System.out.println(cTool2.compute(1, 2));


        // [주의] 추상 메소드가 2개 이상이 있는 인터페이스의 경우 람다식 사용이 제한된다.
        // 익명 클래스 내 익명 함수 O
        ComputeTool2 cTool3 = new ComputeTool2(){
            @Override
            public int compute(int x, int y) {
                return x + y;
            }

            @Override
            public int compute2(int x, int y) {
                return x - y;
            }
        };
        System.out.println(cTool1.compute(1, 2));

        // 람다식 X
        //ComputeTool2 cTool4 = (x, y) -> { return x + y; };
        //System.out.println(cTool2.compute(1, 2));

    }
}
