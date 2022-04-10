package a.b.c.prac.emp.search.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import java.util.ArrayList;

import a.b.c.prac.emp.search.sql.EmpSearchQueryMap_p;
import a.b.c.prac.emp.search.vo.EmpSearchVO_p;
import a.b.c.prac2.OracleConnProperty_p;

public class EmpSearchDAOImpl_p implements EmpSearchDAO_p{
	
	// ��ü�˻� =============================================================
	@Override
	public ArrayList<EmpSearchVO_p> empSelectAll(){
		System.out.println("<<< 2. EmpSearchDAOImpl_p :: empSelectAll() ����  >>> \n");
		// Ŀ�ؼ�
		// ������ ����
		// ���� ��� �ް�
		
		Connection conn=null;
		// Connection Ŭ������ ����
		
		PreparedStatement pstmt=null;
		// �������� �ۼ��Ѵ�.
		
		ResultSet rsRs=null;
		// �������� ����� �޴´�.
		
		EmpSearchVO_p esvo=null;
		// EmpSearchVO_p Ŭ������ ��������
		
		ArrayList<EmpSearchVO_p> aList=null;
		// ����� �迭�� �����Ѵ�.
		
		try{
			// Ŀ�ؼ� ����
			conn=OracleConnProperty_p.getConnection();
			
			// ������ ����
			String sql=EmpSearchQueryMap_p.getEmpSelectAll();
			System.out.println("sql >>> : \n"+sql);
			
			// error
			pstmt=conn.prepareStatement(sql);
			
			// ���� ���
			rsRs=pstmt.executeQuery();
			System.out.println("\n <<< 6. EmpSearchDAOImpl_p :: empSelectAll() :: Result Ŭ������ ������  ��� �������� ���� >>>");
			
			pstmt.clearParameters();
			// PreparedStatement�� ���������� ���� ���� �� clearParameters�� �ٿ��� ������ ���־�� �Ѵ�.
						
			/* 
			 ���� ����� dvo���� service�� �����ϱ�
			 1. ���� ����� �ִ��� Ȯ��
			 2. ���� ����� ������ ArrayList �ν��Ͻ��ϱ�
			 3. ResultSet�� �ִ� next �Լ��� ���ڵ� ��������
 			 4. ������ ���ڵ� VO ���
 			 5.  VO�� ArrayList�� ���
			*/
			
			 if(rsRs != null){
				 // 2.  ���� ����� ������ ArrayList �ν��Ͻ��ϱ�
				 aList = new ArrayList<EmpSearchVO_p>();
				 
				 // 3. ResultSet�� �ִ� next �Լ��� ���ڵ� ��������
				 while (rsRs.next()){
					 esvo = new EmpSearchVO_p();
					 esvo.setEmpno(rsRs.getString("EMPNO"));
					 esvo.setEname(rsRs.getString("ENAME"));
					 esvo.setJob(rsRs.getString("JOB"));
					 esvo.setMgr(rsRs.getString("MGR"));
					 esvo.setHiredate(rsRs.getString("HIREDATE"));
					 esvo.setSal(rsRs.getString("SAL"));
					 esvo.setComm(rsRs.getString("COMM"));
					 esvo.setDeptno(rsRs.getString("DEPTNO"));
					 
					 aList.add(esvo);
				 }
				 System.out.println("\n <<< 7. EmpSearchDAOImpl_p :: empSelectAll() :: EmpSearchVO_p :: setter method�� this���� �Է� ��  >>> \n");
				 
			 }else{
				 System.out.println("if�� ���� ����");
				 boolean bool = rsRs != null;
				 System.out.println("EmpSearchDAOImpl_p :: empSelectAll() :: rsRs != null >>> : "+bool);
				 System.out.println("EmpSearchDAOImpl_p :: empSelectAll() :: ��ü �˻� ����� �����ϴ�. >>>> : "+rsRs);
			 }
			 
			 
			 
		}catch(Exception e){
			System.out.println("EmpSearchDAOImpl_p :: empSelectAll() :: error >>> : "+e.getMessage());
		}
		
		// ���� ��� �ޱ�
		boolean bool_a = aList == null;
		if(bool_a){
			System.out.println("EmpSearchDAOImpl_p :: empSelectAll() :: aList�� null�� ���ϵ˴ϴ�.");
		}
		
		return aList;
	}
	
	// ��� �˻�=============================================================
	@Override
	public ArrayList<EmpSearchVO_p> empSelectEmpno(EmpSearchVO_p evo){
		System.out.println("<<< 2. EmpSearchDAOImpl_p :: empSelectEmpno(EmpSearchVO_p evo) ����  >>> \n");
		System.out.println("\n 2-1. EmpSearchDAOImpl_p :: empSelectEmpno(EmpSearchVO_p evo) :: evo.getEmpno() >>> : "+evo.getEmpno());
		// �μ��� ���� EmpSearchVO_p getEmpno() => this.empno
		// �������� evo�� ��ȸ�غ��� 
		
		//  �������� ���� �� default value initialization
		//  �⺻������ �ʱ�ȭ �ϱ�
		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rsRs=null;
		EmpSearchVO_p _evo=null;
		String empno=null;
		// �� _evo?? ���� �μ��� evo�� �ִµ� ���⼭ EmpSearchVO_p Ŭ������
		// �������� evo�� null�� �ʱ�ȭ �ϸ� �� �ǹǷ�, _evo�� �������� ����
		ArrayList<EmpSearchVO_p> aList=null;
		
		/*
		 * Ŀ�ؼ�
		 * ������ ����
		 * ���ǰ�� �޾ƿ���
		 * */
		
		try{
			conn=OracleConnProperty_p.getConnection();
			// Ŀ�ؼ�
			String sql=EmpSearchQueryMap_p.getEmpSelectEmpno();
			// sb.append()�� ������ �ۼ��� �������� String Ŭ���� sql ����������
			// ����
			empno=evo.getEmpno();
			
			// conn�� null�ε�, getConnection �Լ��� ����
			// Class.forName(OracleConnProperty_p.JDBC_DRIVER)
			// ���� JDBC_DRIVER�� �ִ��� Ȯ���غ���.
			
			System.out.println("sql >>> : \n"+sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empno);
			
			// ���� ���
			rsRs=pstmt.executeQuery();
			System.out.println("\n <<< 6. EmpSearchDAOImpl_p :: empSelectEmpno(EmpSearchVO_p evo) :: Result Ŭ������ ������  ��� �������� ���� >>> \n");
			
			pstmt.clearParameters();
			// PreparedStatement�� ���������� ���� ���� �� clearParameters�� �ٿ��� ������ ���־�� �Ѵ�.
			
			/*
			 * 1. ���� ����� �ִ� �� Ȯ��
			 * 2. ���� ����� ������ ArrayList �ν��Ͻ� �ϱ�
			 * 3. ResultSet�� �ִ� boolean Ŀ�� next �Լ��� ���ڵ� ��������
			 * 4. ������ ���ڵ� VO ��� 
			 * 5. VO�� ArrayList�� ���
			 * */
			
			// 1. ���� ����� �ִ��� Ȯ��
			if (rsRs != null){
				// 2. ���� ����� ������ ArrayList �ν��Ͻ� �ϱ�
				aList = new ArrayList<EmpSearchVO_p>();
				
				// 3. ResultSet�� �ִ� boolean Ŀ�� next �Լ��� ���ڵ� ��������
				while (rsRs.next()){
					// 4. ������ ���ڵ� VO ���
					// // EMPNO, ENAME, JOB, HIREDATE, DEPTNO
					
					_evo = new EmpSearchVO_p();
					_evo.setEmpno(rsRs.getString("EMPNO"));
					_evo.setEname(rsRs.getString("ENAME"));
					_evo.setJob(rsRs.getString("JOB"));
					_evo.setHiredate(rsRs.getString("HIREDATE"));
					_evo.setDeptno(rsRs.getString("DEPTNO"));
					
					// 5. VO�� ArrayList�� ���
					aList.add(_evo);
				}	
				System.out.println("\n <<< 7. EmpSearchDAOImpl_p :: empSelectEmpno(EmpSearchVO_p evo) :: EmpSearchVO_p :: setter method�� this���� �Է� ��  >>> \n");
			}else{
				System.out.println("if�� ���� ����");
				boolean bool= rsRs==null;
				System.out.println("EmpSearchDAOImpl_p :: empSelectEmpno :: rsRs==null >>> : "+bool);
				System.out.println("��� �˻� ����� �����ϴ�. >>> : "+rsRs);
			}
		}catch(Exception e){
			System.out.println("EmpSearchDAOImpl_p :: empSelectEmpno :: ��� �˻��� ������ >>> : "+e.getMessage());
		}
		
		// ArrayList  �����ϱ�
		boolean bool_a = aList == null;
		if(bool_a){
			System.out.println("EmpSearchDAOImpl_p :: empSelectEmpno() :: aList�� null�� ���ϵ˴ϴ�.");
		}
		
		return aList;
	}
	
	// ����̸�
	@Override
	public ArrayList<EmpSearchVO_p> empSelectEname(EmpSearchVO_p evo){
		System.out.println("<<< 2. EmpSearchDAOImpl_p :: empSelectEname(EmpSearchVO_p evo) ����  >>> \n");
		System.out.println("\n 2-1. EmpSearchDAOImpl_p ::  empSelectEname(EmpSearchVO_p evo) :: evo.getEname() >>> "+evo.getEname());

		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rsRs=null;
		EmpSearchVO_p _evo=null;
		ArrayList<EmpSearchVO_p> aList=null;
		String ename=null;
		
		try{
			conn=OracleConnProperty_p.getConnection();
			// Ŀ�ؼ�
			String sql=EmpSearchQueryMap_p.getEmpSelectEname();
			ename=evo.getEname();
			
			// conn�� null�ε�, getConnection �Լ��� ����
			// Class.forName(OracleConnProperty_p.JDBC_DRIVER)
			// ���� JDBC_DRIVER�� �ִ��� Ȯ���غ���.
			
			System.out.println("sql >>> : \n"+sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ename);
			
			// ���� ���
			rsRs=pstmt.executeQuery();
			System.out.println("\n <<< 6. EmpSearchDAOImpl_p :: empSelectEname(EmpSearchVO_p evo) :: Result Ŭ������ ������  ��� �������� ���� >>>");
			
			pstmt.clearParameters();
	
			// 1. ���� ����� �ִ��� Ȯ��
			if (rsRs != null){
				// 2. ���� ����� ������ ArrayList �ν��Ͻ� �ϱ�
				aList = new ArrayList<EmpSearchVO_p>();
				
				// 3. ResultSet�� �ִ� boolean Ŀ�� next �Լ��� ���ڵ� ��������
				while (rsRs.next()){
					// 4. ������ ���ڵ� VO ���
					// // EMPNO, ENAME, JOB, HIREDATE, DEPTNO
					
					_evo = new EmpSearchVO_p();
					_evo.setEmpno(rsRs.getString("EMPNO"));
					_evo.setEname(rsRs.getString("ENAME"));
					_evo.setJob(rsRs.getString("JOB"));
					_evo.setHiredate(rsRs.getString("HIREDATE"));
					_evo.setDeptno(rsRs.getString("DEPTNO"));
					
					// 5. VO�� ArrayList�� ���
					aList.add(_evo);
				}
				System.out.println("<<< 7. EmpSearchDAOImpl_p :: empSelectEname(EmpSearchVO_p evo) :: EmpSearchVO_p :: setter method�� this���� �Է� ��  >>> \n");
			}else{
				System.out.println("if�� ���� ����");
				boolean bool= rsRs==null;
				System.out.println("EmpSearchDAOImpl_p :: empSelectEname :: rsRs==null >>> : "+bool);
				System.out.println("��� �˻� ����� �����ϴ�. >>> : "+rsRs);
			}
		}catch(Exception e){
			System.out.println("EmpSearchDAOImpl_p :: empSelectEname :: ��� �˻��� ������ >>> : "+e.getMessage());
		}
		
		// ArrayList  �����ϱ�
		boolean bool_a = aList == null;
		if(bool_a){
			System.out.println("EmpSearchDAOImpl_p :: empSelectEname() :: aList�� null�� ���ϵ˴ϴ�.");
		}
				
		return aList;
	}
	

	// �����ȣ, ����̸�
	@Override
	public ArrayList<EmpSearchVO_p> empSelectEmpnoEname(EmpSearchVO_p evo){
		System.out.println("<<< 2. EmpSearchDAOImpl_p :: empSelectEmpnoEname(EmpSearchVO_p evo) ����  >>> \n");
		System.out.println("\n 2-1. EmpSearchDAOImpl_p ::  empSelectEmpnoEname(EmpSearchVO_p evo) :: evo.getEmpno() >>> : "+evo.getEmpno());
		System.out.println("\n 2-2. EmpSearchDAOImpl_p ::  empSelectEmpnoEname(EmpSearchVO_p evo) :: evo.getEname() >>> : "+evo.getEname());
		
		//  �������� ���� �� default value initialization
		//  �⺻������ �ʱ�ȭ �ϱ�
		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rsRs=null;
		EmpSearchVO_p _evo=null;
		ArrayList<EmpSearchVO_p> aList=null;
		String empno=null;
		String ename=null;
		
		
		try{
			conn=OracleConnProperty_p.getConnection();
			// Ŀ�ؼ�
			String sql=EmpSearchQueryMap_p.getEmpSelectEmpnoEname();
			empno=evo.getEmpno();
			ename=evo.getEname();
			
			
			System.out.println("sql >>> : \n"+sql);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, empno);
			pstmt.setString(2, ename);
			
			
			// ���� ���
			rsRs=pstmt.executeQuery();
			System.out.println("\n <<< 6. EmpSearchDAOImpl_p :: empSelectEmpnoEname(EmpSearchVO_p evo) :: Result Ŭ������ ������  ��� �������� ���� >>>");
			
			pstmt.clearParameters();
	
			// 1. ���� ����� �ִ��� Ȯ��
			if (rsRs != null){
				// 2. ���� ����� ������ ArrayList �ν��Ͻ� �ϱ�
				aList = new ArrayList<EmpSearchVO_p>();
				
				// 3. ResultSet�� �ִ� boolean Ŀ�� next �Լ��� ���ڵ� ��������
				while (rsRs.next()){
					// 4. ������ ���ڵ� VO ���
					// // EMPNO, ENAME, JOB, HIREDATE, DEPTNO
					
					_evo = new EmpSearchVO_p();
					_evo.setEmpno(rsRs.getString("EMPNO"));
					_evo.setEname(rsRs.getString("ENAME"));
					_evo.setJob(rsRs.getString("JOB"));
					_evo.setHiredate(rsRs.getString("HIREDATE"));
					_evo.setDeptno(rsRs.getString("DEPTNO"));
					
					// 5. VO�� ArrayList�� ���
					aList.add(_evo);
				}
				System.out.println("\n <<< 7. EmpSearchDAOImpl_p :: empSelectEmpnoEname(EmpSearchVO_p evo) :: EmpSearchVO_p :: setter method�� this���� �Է� ��  >>> \n");
			}else{
				System.out.println("if�� ���� ����");
				boolean bool= rsRs==null;
				System.out.println("EmpSearchDAOImpl_p :: empSelectEmpnoEname :: rsRs==null >>> : "+bool);
				System.out.println("��� �˻� ����� �����ϴ�. >>> : "+rsRs);
			}
		}catch(Exception e){
			System.out.println("EmpSearchDAOImpl_p :: empSelectEmpnoEname :: ��� �˻��� ������ >>> : "+e.getMessage());
		}
		
		// ArrayList  �����ϱ�
		boolean bool_a = aList == null;
		if(bool_a){
			System.out.println("EmpSearchDAOImpl_p :: empSelectEmpnoEname() :: aList�� null�� ���ϵ˴ϴ�.");
		}
				
		return aList;
	}
	
	
	// �����å
	@Override
	public ArrayList<EmpSearchVO_p> empSelectJob(EmpSearchVO_p evo){
		System.out.println("<<< 2. EmpSearchDAOImpl_p :: empSelectJob(EmpSearchVO_p evo) ����  >>> \n");
		System.out.println("\n 2-1. EmpSearchDAOImpl_p ::  empSelectJob(EmpSearchVO_p evo) :: evo.empSelectEname() >>> : "+evo.getJob());

		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rsRs=null;
		EmpSearchVO_p _evo=null;
		ArrayList<EmpSearchVO_p> aList=null;
		String job=null;
		
		try{
			conn=OracleConnProperty_p.getConnection();
			// Ŀ�ؼ�
			String sql=EmpSearchQueryMap_p.getEmpSelectJob();
			job=evo.getJob();
			
			
			System.out.println("sql >>> : \n"+sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, job);
			
			// ���� ���
			rsRs=pstmt.executeQuery();
			System.out.println("\n <<< 6. EmpSearchDAOImpl_p :: empSelectJob(EmpSearchVO_p evo) :: Result Ŭ������ ������  ��� �������� ���� >>>");
			
			pstmt.clearParameters();
	
			// 1. ���� ����� �ִ��� Ȯ��
			if (rsRs != null){
				// 2. ���� ����� ������ ArrayList �ν��Ͻ� �ϱ�
				aList = new ArrayList<EmpSearchVO_p>();
				
				// 3. ResultSet�� �ִ� boolean Ŀ�� next �Լ��� ���ڵ� ��������
				while (rsRs.next()){
					// 4. ������ ���ڵ� VO ���
					// // EMPNO, ENAME, JOB, HIREDATE, DEPTNO
					
					_evo = new EmpSearchVO_p();
					_evo.setEmpno(rsRs.getString("EMPNO"));
					_evo.setEname(rsRs.getString("ENAME"));
					_evo.setJob(rsRs.getString("JOB"));
					_evo.setHiredate(rsRs.getString("HIREDATE"));
					_evo.setDeptno(rsRs.getString("DEPTNO"));
					
					// 5. VO�� ArrayList�� ���
					aList.add(_evo);
				}
				System.out.println("\n <<< 7. EmpSearchDAOImpl_p :: empSelectJob(EmpSearchVO_p evo) :: EmpSearchVO_p :: setter method�� this���� �Է� ��  >>> \n");
			}else{
				System.out.println("if�� ���� ����");
				boolean bool= rsRs==null;
				System.out.println("EmpSearchDAOImpl_p :: empSelectJob :: rsRs==null >>> : "+bool);
				System.out.println("��� �˻� ����� �����ϴ�. >>> : "+rsRs);
			}
		}catch(Exception e){
			System.out.println("EmpSearchDAOImpl_p :: empSelectJob :: ��� �˻��� ������ >>> : "+e.getMessage());
		}
		
		// ArrayList  �����ϱ�
		boolean bool_a = aList == null;
		if(bool_a){
			System.out.println("EmpSearchDAOImpl_p :: empSelectJob() :: aList�� null�� ���ϵ˴ϴ�.");
		}
		
		return aList;
	}
	
	// �Ի���
	@Override
	public ArrayList<EmpSearchVO_p> empSelectHiredate(EmpSearchVO_p evo){
		System.out.println("<<< 2. EmpSearchDAOImpl_p :: empSelectHiredate(EmpSearchVO_p evo) ����  >>> \n");
		System.out.println("\n 2-1. EmpSearchDAOImpl_p :: empSelectHiredate(EmpSearchVO_p evo) :: evo.getFromdate() >>> : "+evo.getFromdate());
		System.out.println("\n 2-2. EmpSearchDAOImpl_p ::  empSelectHiredate(EmpSearchVO_p evo) :: evo.getTodate() >>> : "+evo.getTodate());
		
		//  �������� ���� �� default value initialization
		//  �⺻������ �ʱ�ȭ �ϱ�
		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rsRs=null;
		EmpSearchVO_p _evo=null;
		ArrayList<EmpSearchVO_p> aList=null;
		String fromDate=null;
		String toDate=null;
		
		
		try{
			conn=OracleConnProperty_p.getConnection();
			// Ŀ�ؼ�
			String sql=EmpSearchQueryMap_p.getEmpSelectHiredate();
			fromDate=evo.getFromdate();
			toDate=evo.getTodate();
			
			System.out.println("sql >>> : \n"+sql);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, fromDate);
			pstmt.setString(2, toDate);
			
			
			// ���� ���
			rsRs=pstmt.executeQuery();
			System.out.println("\n <<< 6. EmpSearchDAOImpl_p :: empSelectHiredate(EmpSearchVO_p evo) :: Result Ŭ������ ������  ��� �������� ���� >>>");
			
			pstmt.clearParameters();
	
			// 1. ���� ����� �ִ��� Ȯ��
			if (rsRs != null){
				// 2. ���� ����� ������ ArrayList �ν��Ͻ� �ϱ�
				aList = new ArrayList<EmpSearchVO_p>();
				
				// 3. ResultSet�� �ִ� boolean Ŀ�� next �Լ��� ���ڵ� ��������
				while (rsRs.next()){
					// 4. ������ ���ڵ� VO ���
					// // EMPNO, ENAME, JOB, HIREDATE, DEPTNO
					
					_evo = new EmpSearchVO_p();
					_evo.setEmpno(rsRs.getString("EMPNO"));
					_evo.setEname(rsRs.getString("ENAME"));
					_evo.setJob(rsRs.getString("JOB"));
					_evo.setHiredate(rsRs.getString("HIREDATE"));
					_evo.setDeptno(rsRs.getString("DEPTNO"));
					
					// 5. VO�� ArrayList�� ���
					aList.add(_evo);
				}	
				System.out.println("\n <<< 7. EmpSearchDAOImpl_p :: empSelectHiredate(EmpSearchVO_p evo) :: EmpSearchVO_p :: setter method�� this���� �Է� ��  >>> \n");
			}else{
				System.out.println("if�� ���� ����");
				boolean bool= rsRs==null;
				System.out.println("EmpSearchDAOImpl_p :: empSelectHiredate :: rsRs==null >>> : "+bool);
				System.out.println("��� �˻� ����� �����ϴ�. >>> : "+rsRs);
			}
		}catch(Exception e){
			System.out.println("EmpSearchDAOImpl_p :: empSelectHiredate :: ��� �˻��� ������ >>> : "+e.getMessage());
		}
		
		// ArrayList  �����ϱ�
		boolean bool_a = aList == null;
		if(bool_a){
			System.out.println("EmpSearchDAOImpl_p :: empSelectHiredate() :: aList�� null�� ���ϵ˴ϴ�.");
		}
		
		return aList;
	}
}
