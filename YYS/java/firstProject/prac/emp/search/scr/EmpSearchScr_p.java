package a.b.c.prac.emp.search.scr;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import a.b.c.prac.emp.search.service.EmpSearchServiceImpl_p;
import a.b.c.prac.emp.search.service.EmpSearchService_p;
import a.b.c.prac.emp.search.vo.EmpSearchVO_p;

public class EmpSearchScr_p {
	
	// ȭ��� ���񽺸� �����ϴ� �Լ��� <-- ��Ʈ�ѷ�
	
	// 1. ��ü �˻�
	public ArrayList<EmpSearchVO_p> empSelectAll(){
		System.out.println("<<< 0. EmpSearchScr_p :: empSelectAll() :: ����  >>>  \n");
		
		EmpSearchService_p es = new EmpSearchServiceImpl_p();
		// ���� Ŭ���� ȣ��
		
		ArrayList<EmpSearchVO_p> aList = es.empSelectAll();
		System.out.println("<<< 8. EmpSearchScr_p :: empSelectAll() :: EmpSearchService_p���� ��� �޾ƿ��� ���� >>> \n");
		
		return aList;
	}
	
	// 2. ��� �˻�
	public ArrayList<EmpSearchVO_p> empSelectEmpno(String empno){
		System.out.println("<<< 0. EmpSearchScr_p :: empSelectEmpno(String empno) :: ����  >>>  \\n");
		
		EmpSearchService_p es = new EmpSearchServiceImpl_p();
		// ���� Ŭ���� ȣ��
		
		EmpSearchVO_p evo=null;
		evo = new EmpSearchVO_p();
		evo.setEmpno(empno);
		
		ArrayList<EmpSearchVO_p> aList = es.empSelectEmpno(evo);
		System.out.println("<<< 8. EmpSearchScr_p :: empSelectEmpno(String empno) :: EmpSearchService_p���� ��� �޾ƿ��� ���� >>> \n");
	
		return aList;
	}
	
	// 3. �̸� �˻�
	public ArrayList<EmpSearchVO_p> empSelectEname(String ename){
		System.out.println("<<< 0. EmpSearchScr_p :: empSelectEname(String ename) :: ����  >>>  \\n");
		
		EmpSearchService_p es = new EmpSearchServiceImpl_p();
		// ���� Ŭ���� ȣ��
		
		EmpSearchVO_p evo=null;
		evo = new EmpSearchVO_p();
		evo.setEname(ename);
		
		ArrayList<EmpSearchVO_p> aList = es.empSelectEname(evo);
		System.out.println("<<< 8. EmpSearchScr_p :: empSelectEname(String ename) :: EmpSearchService_p���� ��� �޾ƿ��� ���� >>> \n");

		return aList;
	}
	
	// 4. ���, �̸��˻�
	public ArrayList<EmpSearchVO_p> empSelectEmpnoEname(String empno, String ename){
		System.out.println("<<< 0. EmpSearchScr_p :: empSelectEmpnoEname(String empno, String ename) :: ����  >>>  \\n");
		
		
		EmpSearchService_p es = new EmpSearchServiceImpl_p();
		// ���� Ŭ���� ȣ��
		
		EmpSearchVO_p evo=null;
		evo = new EmpSearchVO_p();
		evo.setEmpno(empno);
		evo.setEname(ename);
		
		ArrayList<EmpSearchVO_p> aList = es.empSelectEmpnoEname(evo);
		System.out.println("<<< 8. EmpSearchScr_p :: empSelectEmpnoEname(String empno, String ename) :: EmpSearchService_p���� ��� �޾ƿ��� ���� >>> \n");
		
		return aList;
	}
	
	// 5. ��å �˻�
	public ArrayList<EmpSearchVO_p> empSelectJob(String job){
		System.out.println("<<< 0. EmpSearchScr_p :: empSelectJob(String job) :: ����  >>>  \n");
		
		EmpSearchService_p es = new EmpSearchServiceImpl_p();
		// ���� Ŭ���� ȣ��
		
		EmpSearchVO_p evo=null;
		evo = new EmpSearchVO_p();
		evo.setJob(job);
		
		ArrayList<EmpSearchVO_p> aList = es.empSelectJob(evo);
		System.out.println("<<< 8. EmpSearchScr_p :: empSelectJob(String job) :: EmpSearchService_p���� ��� �޾ƿ��� ���� >>> \n");
		
		return aList;
	}
	
	// 6. ��¥ �˻�
	public ArrayList<EmpSearchVO_p> empSelectHiredate(String fromdate, String todate){
		System.out.println("<<< 0-3. EmpSearchScr_p :: empSelectHiredate(String fromdate, String todate) :: ����  >>>  \n");
		
		EmpSearchService_p es = new EmpSearchServiceImpl_p();
		// ���� Ŭ���� ȣ��
		
		EmpSearchVO_p evo=null;
		evo = new EmpSearchVO_p();
		evo.setFromdate(fromdate);
		evo.setTodate(todate);
		
		ArrayList<EmpSearchVO_p> aList = es.empSelectHiredate(evo);
		System.out.println("<<< 8. EmpSearchScr_p :: empSelectHiredate(String fromdate, String todate) :: EmpSearchService_p���� ��� �޾ƿ��� ���� >>> \n");
		
		return aList;
	}
	
	// 6-1. fromDate, toDate �� �Լ�
	public boolean fromtoDate(String fromdate, String todate) {
		System.out.println("\n 0. EmpSearchScr_p :: fromtoDate(String fromdate, String todate) ���� \n");
		
		boolean bool = false;
		
		try {
			SimpleDateFormat sDate = new SimpleDateFormat("yyyyMMdd");		
			Date fromDate = sDate.parse(fromdate);
			Date toDate = sDate.parse(todate);
			long f = fromDate.getTime();
			long t = toDate.getTime();
			
			bool = f < t;
			System.out.println("\n 0-1. EmpSearchScr_p :: fromtoDate(String fromdate, String todate) :: fromDate > toDate >>> : "+bool);
			
			if (!bool) {
				System.out.println("FROM ��¥�� TO ��¥���� ũ�� �� �˴ϴ�. >>> : " + bool);
				System.out.println("���α׷��� �����մϴ�. �ٽ� �����ؼ� ����Ͻÿ� >>> : ");				
			}
		} catch (Exception e) {
			System.out.println("yyyyMMdd �������� �Է��ؾ� �񱳰� �����մϴ�.");
			System.out.println("FROM TO ���� ������ >>> : " + e.getMessage());
		}
		return bool;
	}
	
	
	// main �Լ��� ȭ�� ����
	public static void main(String args[]){
		System.out.println("<<<  EmpSearchScr_p ���� :: main(String args[])  >>> \n");
		
		System.out.println("�˻��� ��ȣ�� 		\n"
							+"1. ��ü�˻�		\n"
							+"2. ����˻� 		\n"
							+"3. �̸��˻�		\n"
							+"4. ���, �̸��˻�	\n"
							+"5. ��å�˻�		\n"
							+"6. ��¥�˻�		\n");
		Scanner sc = new Scanner(System.in);
		
		try{
			int n=sc.nextInt();
			System.out.println("�Է��Ͻ� ��ȣ��  "+n+"�Դϴ�. \n");
			
			// 1. ��ü�˻� (ALL)
			if (1==n){
				System.out.println(n+" �� �Է� : ��ü�� �˻��մϴ�.");
				EmpSearchScr_p es1= new EmpSearchScr_p();
				ArrayList<EmpSearchVO_p> aList = es1.empSelectAll();
				
				System.out.println("<<< 9. EmpSearchScr_p :: main :: EmpSearchScr_p.empSelectAll() ���� ��� �޾ƿ��� ���� >>> \n");
				if (aList != null && aList.size()>0){
					System.out.println("<<< 10. EmpSearchScr_p :: main :: getter method�� �������ڽ��ϴ�. >>> \n");
					
					System.out.println("\n ========================��� ���================================");
					System.out.println("EMPNO : ENAME : JOB   : MGR  : HIREDATE   : SAL  : COMM : DEPTNO");
					System.out.println("=============================================================== \n");
					for (int i=0; i<aList.size(); i++){
						EmpSearchVO_p esvo=aList.get(i);
						System.out.print(esvo.getEmpno()+" : ");
						System.out.print(esvo.getEname()+" : ");
						System.out.print(esvo.getJob()+" : ");
						System.out.print(esvo.getMgr()+" : ");
						System.out.print(esvo.getHiredate()+" : ");
						System.out.print(esvo.getSal()+" : ");
						System.out.print(esvo.getComm()+" : ");
						System.out.print(esvo.getDeptno());
						System.out.println();
					}
					System.out.println("\n ============================================================== \n");
					System.out.println("\n <<< 11. EmpSearchScr_p :: main :: ��� �� >>> ");
				}
				else {
					boolean bool1= aList !=null;
					boolean bool2= aList.size() >0;
					System.out.println("EmpSearchScr_p :: main ::aList != null "+bool1);
					System.out.println("EmpSearchScr_p :: main :: aList.size() >0 "+bool2);
				}
				sc.close();
			}
			
			// 2. ����˻� (EMPNO)
			if(2==n){
				System.out.println(n+" �� �Է� : �����ȣ�� �Է����ּ���.");
				Scanner sc2=new Scanner(System.in);
				String empno=sc2.next();
				
				EmpSearchScr_p es2= new EmpSearchScr_p();
				ArrayList<EmpSearchVO_p> aList = es2.empSelectEmpno(empno);
				
				System.out.println("<<< 9. EmpSearchScr_p :: main :: EmpSearchScr_p.empSelectEmpno(empno) ���� ��� �޾ƿ��� ���� >>> \n");
				if (aList != null && aList.size()>0){
					System.out.println("<<< 10. EmpSearchScr_p :: main :: getter method�� �������ڽ��ϴ�. >>> \n");
					
					System.out.println("\n ===============��� ���============== \n");
					System.out.println("EMPNO : ENAME : JOB : HIREDATE : DEPTNO");
					for (int i=0; i<aList.size(); i++){
						EmpSearchVO_p esvo=aList.get(i);
						
						System.out.print(esvo.getEmpno()+" : ");
						System.out.print(esvo.getEname()+" : ");
						System.out.print(esvo.getJob()+" : ");

						System.out.print(esvo.getHiredate()+" : ");
						System.out.print(esvo.getDeptno());
						System.out.println();
					}
					System.out.println("\n ================================= \n");
					System.out.println("\n <<< 11. EmpSearchScr_p :: main :: ��� �� >>> ");
				}
				else {
					boolean bool1= aList !=null;
					boolean bool2= aList.size() >0;
					System.out.println("EmpSearchScr_p :: main ::aList != null "+bool1);
					System.out.println("EmpSearchScr_p :: main :: aList.size() >0 "+bool2);
				}
				sc.close();
			}	
			
			// 3. �̸��˻� (ENAME)
			if(3==n){
				System.out.println(n+" �� �Է� : ����̸��� �Է����ּ���.");
				Scanner sc3=new Scanner(System.in);
				String ename=sc3.next();
				
				EmpSearchScr_p es3= new EmpSearchScr_p();
				ArrayList<EmpSearchVO_p> aList = es3.empSelectEname(ename);
				
				System.out.println("<<< 9. EmpSearchScr_p :: main :: EmpSearchScr_p.empSelectEname(ename) ���� ��� �޾ƿ��� ���� >>> \n");
				if (aList != null && aList.size()>0){
					System.out.println("<<< 10. EmpSearchScr_p :: main :: getter method�� �������ڽ��ϴ�. >>> \n");
					
					System.out.println("\n ================��� ���============= \n");
					System.out.println("EMPNO : ENAME : JOB : HIREDATE : DEPTNO");
					for (int i=0; i<aList.size(); i++){
						EmpSearchVO_p esvo=aList.get(i);
						
						System.out.print(esvo.getEmpno()+" : ");
						System.out.print(esvo.getEname()+" : ");
						System.out.print(esvo.getJob()+" : ");

						System.out.print(esvo.getHiredate()+" : ");
						System.out.print(esvo.getDeptno());
						System.out.println();
					}
					System.out.println("\n ================================= \n");
					System.out.println("\n <<< 11. EmpSearchScr_p :: main :: ��� �� >>> ");
				}
				else {
					boolean bool1= aList !=null;
					boolean bool2= aList.size() >0;
					System.out.println("EmpSearchScr_p :: main ::aList != null "+bool1);
					System.out.println("EmpSearchScr_p :: main :: aList.size() >0 "+bool2);
				}
				sc.close();
			}
			
			
			// 4. ���, �̸��˻� (EMPNO, ENAME)
			if(4==n){
				System.out.println(n+" �� �Է� : �����ȣ�� �Է����ּ���.");
				Scanner sc4=new Scanner(System.in);
				String empno=sc4.next();
				
				System.out.println(n+" �� �Է� : ����̸��� �Է����ּ���.");
				sc4.nextLine();
				String ename=sc4.next();
				
				EmpSearchScr_p es4= new EmpSearchScr_p();
				ArrayList<EmpSearchVO_p> aList = es4.empSelectEmpnoEname(empno, ename);
				
				System.out.println("<<< 9. EmpSearchScr_p :: main :: EmpSearchScr_p.empSelectEmpnoEname(empno, ename) ���� ��� �޾ƿ��� ���� >>> \n");
				if (aList != null && aList.size()>0){
					System.out.println("<<< 10. EmpSearchScr_p :: main :: getter method�� �������ڽ��ϴ�. >>> \n");
					
					System.out.println("\n ================��� ���============= \n");
					System.out.println("EMPNO : ENAME : JOB : HIREDATE : DEPTNO");
					for (int i=0; i<aList.size(); i++){
						EmpSearchVO_p esvo=aList.get(i);
						
						System.out.print(esvo.getEmpno()+" : ");
						System.out.print(esvo.getEname()+" : ");
						System.out.print(esvo.getJob()+" : ");

						System.out.print(esvo.getHiredate()+" : ");
						System.out.print(esvo.getDeptno());
						System.out.println();
					}
					System.out.println("\n ================================= \n");
					System.out.println("\n <<< 11. EmpSearchScr_p :: main :: ��� �� >>> ");
				}
				else {
					boolean bool1= aList !=null;
					boolean bool2= aList.size() >0;
					System.out.println("EmpSearchScr_p :: main ::aList != null "+bool1);
					System.out.println("EmpSearchScr_p :: main :: aList.size() >0 "+bool2);
				}
				sc.close();
			}
			
			// 5. ��å�˻� (JOB)
			if(5==n){
				System.out.println(n+" �� �Է� : ��å�� �Է����ּ���.");
				Scanner sc5=new Scanner(System.in);
				String job=sc5.next();
				
				EmpSearchScr_p es5= new EmpSearchScr_p();
				ArrayList<EmpSearchVO_p> aList = es5.empSelectJob(job);
				
				System.out.println("<<< 9. EmpSearchScr_p :: main :: EmpSearchScr_p.empSelectJob(job) ���� ��� �޾ƿ��� ���� >>> \n");
				if (aList != null && aList.size()>0){
					System.out.println("<<< 10. EmpSearchScr_p :: main :: getter method�� �������ڽ��ϴ�. >>> \n");
					
					System.out.println("\n ================��� ���============= \n");
					System.out.println("EMPNO : ENAME : JOB : HIREDATE : DEPTNO");
					for (int i=0; i<aList.size(); i++){
						EmpSearchVO_p esvo=aList.get(i);
						
						System.out.print(esvo.getEmpno()+" : ");
						System.out.print(esvo.getEname()+" : ");
						System.out.print(esvo.getJob()+" : ");

						System.out.print(esvo.getHiredate()+" : ");
						System.out.print(esvo.getDeptno());
						System.out.println();
					}
					System.out.println("\n ================================= \n");
					System.out.println("\n <<< 11. EmpSearchScr_p :: main :: ��� �� >>> ");
				}
				else {
					boolean bool1= aList !=null;
					boolean bool2= aList.size() >0;
					System.out.println("EmpSearchScr_p :: main ::aList != null "+bool1);
					System.out.println("EmpSearchScr_p :: main :: aList.size() >0 "+bool2);
				}
				sc.close();
			}
			
			
			// 6. ��¥�˻� (HIREDATE)
			if(6==n){
				System.out.println(n+" �� �Է� : FROM ��¥�� �Է����ּ���.");
				System.out.println("��¥������ yyyyMMdd �������� �Է����ֽʽÿ�.");
				Scanner sc6=new Scanner(System.in);
				String fromdate=sc6.next();
				System.out.println("�Էµ� FROM ��¥ >>> : "+fromdate);
				
				System.out.println(n+" �� �Է� : TO ��¥�� �Է����ּ���.");
				System.out.println("��¥������ yyyyMMdd �������� �Է����ֽʽÿ�.");
				sc6.nextLine();
				String todate=sc6.next();
				System.out.println("�Էµ� TO ��¥ >>> : "+todate);
							
				EmpSearchScr_p es6= new EmpSearchScr_p();
				
				boolean b=false;
				b=es6.fromtoDate(fromdate, todate);
				System.out.println("\n 0-2. EmpSearchScr_p :: main :: fromtoDate(fromdate, todate) :: fromDate < toDate >>> : "+b);
				
				if (b){
					ArrayList<EmpSearchVO_p> aList = es6.empSelectHiredate(fromdate, todate);
				
					System.out.println("<<< 9. EmpSearchScr_p :: main :: EmpSearchScr_p.empSelectHiredate(fromdate, todate) ���� ��� �޾ƿ��� ���� >>> \n");
					if (aList != null && aList.size()>0){
						System.out.println("<<< 10. EmpSearchScr_p :: main :: getter method�� �������ڽ��ϴ�. >>> \n");
						
						System.out.println("\n ===============��� ���============== \n");
						System.out.println("EMPNO : ENAME : JOB 	: HIREDATE : DEPTNO");
						for (int i=0; i<aList.size(); i++){
							EmpSearchVO_p esvo=aList.get(i);
						
							System.out.print(esvo.getEmpno()+" : ");
							System.out.print(esvo.getEname()+" : ");
							System.out.print(esvo.getJob()+" : ");

							System.out.print(esvo.getHiredate()+" : ");
							System.out.print(esvo.getDeptno());
							System.out.println();
						}
						System.out.println("\n ================================= \n");
						System.out.println("\n <<< 11. EmpSearchScr_p :: main :: ��� �� >>> ");
					}
					else {
						boolean bool1= aList !=null;
						boolean bool2= aList.size() >0;
						System.out.println("EmpSearchScr_p :: main ::aList != null "+bool1);
						System.out.println("EmpSearchScr_p :: main :: aList.size() >0 "+bool2);
					}
				}else{
					System.out.println("��¥ ������ �� ���� �ٽ� �Է����ּ���.");
					System.out.println("Ȥ�� toDate ��¥�� fromDate ��¥���� ū �� �ٽ� �� �� Ȯ�����ּ���.");
				}
				sc.close();
			}
			
			if(6<n || 1>n){
				System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�.");
				sc.close();
			}			
		}catch(Exception e){
			System.out.println("main �Լ� try error >> : "+e.getMessage());
		}finally{
			if (sc!=null){
				try{sc.close(); sc=null;}catch(Exception e){}
			}
			System.out.println("\n Scanner�� close �Ǿ����ϴ�.");
		}
	} // main
} // class
