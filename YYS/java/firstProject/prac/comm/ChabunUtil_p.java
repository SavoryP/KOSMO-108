package a.b.c.prac.comm;

import a.b.c.prac.comm.ChabunQuery_p;
import a.b.c.prac.comm.DateFormatUtil_p;

public class ChabunUtil_p {
	
	public static final String BIZ_GUBUN_TEST="T";
	// �������
	
	public static String numPad(String t, String c){
		System.out.println(" <<< 4. ChabunUtil_p :: numPad(String t, String c) ���� >>>");
		System.out.println("String t >>> : "+t);
		System.out.println("Stirng c >>> : "+c);
		System.out.println("String c.length() >>> "+c.length());
		
		for (int i=c.length(); i<4; i++){
			c="0"+c;
			/*
			 * i�� c.length() ���� ����
			 * c�� "0"�� ���δ�.
			 * �������� ����?
			 * i�� 4���� ������ ��� ����
			 * 
			 * */
		}
		
		String ymd=DateFormatUtil_p.ymdFormats(t);
		
		System.out.println("<<< 7. ChabunUtil_p :: numPad(String t, String c) :: t >>> : "+ymd);
		return ymd.concat(c);
	}

	public static String getTestChabun(String type) {
		System.out.println("<<< 1. ChabunUtil_p :: getTestChabun(String type) :: ���� >>>");
		System.out.println("\n type >>> : "+type);
		// main �Լ�����  ChabunUtil_p Ŭ������ 
		// getTestChabun(String type) �Լ��� String �����Ͱ�
		// ���´�.
		
		String commNum=ChabunQuery_p.getTestChabumQuery();
		// ChabunQuery_p Ŭ������ 
		// getTestChabumQuery() �Լ� (staic �Լ�, return �ִ� �Լ�)
		// �� ���� �޾� String ������Ÿ���� commNum ���������� �����Ѵ�.
		
		System.out.println("\n 3. ChabunUtil_p :: commNum >>> : "+commNum);
		return BIZ_GUBUN_TEST.concat(ChabunUtil_p.numPad(type, commNum));
	}
	
	public static void main(String[] args) {
		System.out.println("\n 8. ChabunUtil_p Ŭ������ main �Լ�  >>> : "+ChabunUtil_p.getTestChabun("d"));

	}
}


