package a.b.c.prac.comm;

import java.text.SimpleDateFormat;
// SimpleDateFormat(String pattern)
import java.util.Date;

public abstract class DateFormatUtil_p {
	public static String ymdFormat(){
		// �� �� �� �������� �����͸� �ٲپ� �ִ� �Լ�
		return new SimpleDateFormat("yyyyMMdd").format(new Date());
		// Date Ŭ������ �����ڸ� �����.
		// SimpleDateFormat Ŭ���� �� "yyyyMMdd" �����ڸ� �����.
		// ���� ��¥�� yyyyMMdd �������� �ٲ۴�.
	}
	
	public static String ymFormat(){
		// �� �� �������� �����͸� �ٲپ� �ִ� �Լ�
		return new SimpleDateFormat("yyyyMM").format(new Date());
		// Date Ŭ������ �����ڸ� ���� ��, SimpleDateFormat Ŭ������
		// yyyyMM �����ڸ� �����.
	}
	
	public static String yFormat(){
		// �� �������� �����͸� �ٲپ� �ִ� �Լ�
		return new SimpleDateFormat("yyyy").format(new Date());
	}
	

	public static String ymdFormats(String ymdFlag) {
		System.out.println("<<< 5. DateFormatUtil_p :: ymdFormats(String ymdFlag) ���� >>>");
		System.out.println("ymdFlag >>> : "+ymdFlag);
		
		String y="";
		
		if ("D".equals(ymdFlag.toUpperCase())){
			y = DateFormatUtil_p.ymdFormat();
			// ���� ������ �빮�ڰ� D��
			// �����
		}
		if ("M".equals(ymdFlag.toUpperCase())){
			y = DateFormatUtil_p.ymFormat();
			// ���� ������ �빮�ڰ� M�̸�
			// ���
		}
		if ("Y".equals(ymdFlag.toUpperCase())){
			y = DateFormatUtil_p.yFormat();
			// ���� ������ �빮�ڰ� Y��
			// ��
		}
		if ("N".equals(ymdFlag.toUpperCase())){
			y = "";
			// ���� ���ڰ� N�̸�
			// �ƹ��͵� ������� ����� �ǹ�
		}
		
		System.out.println("<<< 6. DateFormatUtil_p :: ymdFormats(String ymdFlag) :: y >>> : "+y);
		return y;
	}

	// public static void main(String[] args) {
		// TODO Auto-generated method stub

	// }
}
