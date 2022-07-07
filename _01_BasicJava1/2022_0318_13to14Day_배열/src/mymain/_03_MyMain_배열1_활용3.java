package mymain;

public class _03_MyMain_배열1_활용3{

	public static void main(String[] args){
		String gan = "경신임계갑을병정무기";
		String ji = "신유술해자축인묘진사오미";
		
		int birthYear = 1993;
		
		String ganji = String.format("%c%c",gan.charAt(birthYear%10),ji.charAt(birthYear%12));
		System.out.printf("태어난 해의 간지 : %s",ganji);
	}

}
