// Practice
// 아래 GreenOrc 클래스와 NPCSystem, UserSystem 인터페이스를 이용하여
// OrkNPC1, OrkUser1 클래스를 만들어보세요.

abstract class GreenOrc {
    public final String SKIN_COLOR = "녹색";
    public int health;
    public int attackDamage;
    public int defense;

    public abstract void setHealth();
    public abstract void setDamage();
    public abstract void setDefense();
}

interface NPCSystem {
    public abstract void conversationSystem();
    public abstract void questionSystem();
}

interface UserSystem {
    public abstract void partySystem();
    public abstract void tradeSystem();
}

// OrkNPC1 클래스
class OrkNPC1 extends GreenOrc implements NPCSystem {

    //GreenOrc method override
    @Override
    public void setHealth() {
        this.health = 100;
    }

    @Override
    public void setDamage() {
        this.attackDamage = 10;
    }

    @Override
    public void setDefense() {
        this.defense = 5;
    }

    //NPCSystem method override
    @Override
    public void conversationSystem() {
        System.out.println("오늘 하루는 좋은 날이 될 것 같다. 쉬익.");
    }

    @Override
    public void questionSystem() {
        System.out.println("왜 그렇게 서성이지? 가야할 길을 찾고 있나?");
    }

}

// OrkUser1 클래스
class OrkUser1 extends GreenOrc implements UserSystem {

    //GreenOrc method override
    @Override
    public void setHealth() {
        this.health = 150;
    }

    @Override
    public void setDamage() {
        this.attackDamage = 10;
    }

    @Override
    public void setDefense() {
        this.defense = 5;
    }

    //UserSystem method override
    @Override
    public void partySystem() {
        System.out.println("파티를 신청합니다.");
    }

    @Override
    public void tradeSystem() {
        System.out.println("거래를 요청합니다.");
    }
}

public class Practice {
    public static void main(String[] args) {
        // Test code
        OrkNPC1 orkNPC1 = new OrkNPC1();
        orkNPC1.setHealth();
        orkNPC1.setDamage();
        orkNPC1.setDefense();

        OrkUser1 orkUser1 = new OrkUser1();
        orkUser1.setHealth();
        orkUser1.setDamage();
        orkUser1.setDefense();

        // 초기 HP
        System.out.println("====== 초기 HP ======");
        System.out.println("orkNPC1 health : " + orkNPC1.health);
        System.out.println("orkUser1 health : " + orkUser1.health);

        // 대화
        System.out.println("====== 대화 ======");
        // orkUser1이 orkNPC1을 지나갈 때
        System.out.print("[orkNPC1] ");
        orkNPC1.conversationSystem();

        // orkUser1이 orkNPC1를 클릭하면
        System.out.print("[orkNPC1] ");
        orkNPC1.questionSystem();

        // orkUser1이 orkNPC1을 한 번 공격할 때
        System.out.println("====== ATTACK!! : orkUser1 >> orkNPC1 ======");
        orkNPC1.health = orkNPC1.health - orkUser1.attackDamage + orkNPC1.defense;
        System.out.println("orkNPC1 health : " + orkNPC1.health);

        // No test code
    }
}