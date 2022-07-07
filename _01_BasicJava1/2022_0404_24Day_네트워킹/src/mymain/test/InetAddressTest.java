package mymain.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
	public static void main(String[] args) {
		//cmd���� ping www.naver.com �ϸ� naver�ּҸ� �� �� ����
		//DNS : domain name service server (www.naver.com)
		        //������ �̸��� ����
		try {
			System.out.println("-----Daum  Server IP-----");
			InetAddress[] ip_daum = InetAddress.getAllByName("www.daum.net");
			for(InetAddress tmp : ip_daum)
				System.out.println(tmp.getHostAddress());
			
			System.out.println("-----Naver Server IP-----");
			//InetAddress ip_naver = InetAddress.getByName("www.naver.com");
			InetAddress[] ip_naver = InetAddress.getAllByName("www.naver.com");
			for(InetAddress tmp : ip_naver)
				System.out.println(tmp.getHostAddress());
			
			//Global Broadcast 
			//local broadcast : �ش� ������ broadcast
			System.out.println("-----Global BroadCast IP-----");
			InetAddress ip_global_broadcast = InetAddress.getByName("255.255.255.255");
			System.out.println(ip_global_broadcast.getHostName());
			
		} catch (UnknownHostException e) {
			System.out.println("���� �ּ�");
		}
	}
}
