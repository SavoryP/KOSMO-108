package a.b.c.prac.emp.search.sql;

public abstract class EmpSearchQueryMap_p {
	// ��ü �˻�
	public static String getEmpSelectAll(){
	   	StringBuffer sb=new StringBuffer();
			
		sb.append("SELECT  													\n");
        sb.append("		A.EMPNO         					 AS EMPNO	    \n");
        sb.append("		,A.ENAME        					 AS ENAME 	    \n");
        sb.append("		,A.JOB                				 AS JOB 	    \n");
        sb.append("		,A.MGR              				 AS MGR		    \n");
        sb.append("		,TO_CHAR(A.HIREDATE, 'YYYY-MM-DD')   AS HIREDATE    \n");    
        sb.append("		,A.SAL                 			     AS SAL		    \n");
        sb.append("		,A.COMM           					 AS COMM	    \n");
        sb.append("		,A.DEPTNO       					 AS DEPTNO      \n");
        sb.append("FROM EMP A 												\n");
        sb.append("ORDER BY 1 DESC											\n");
        // ORDER BY 1 DESC; �̷��� ���� �� ��. ;�̰� ������.
        
        System.out.println("<<< 5. EmpSearchQueryMap_p :: getEmpSelectAll() :: ������ �ۼ� ��  >>> \n");
            
            return sb.toString();
	};
	
	// ��� �˻�
	public static String getEmpSelectEmpno(){
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT													 \n");
        sb.append("		A.EMPNO         					     AS EMPNO 	 \n");
        sb.append("		,A.ENAME        				  		 AS ENAME 	 \n");
        sb.append("		,A.JOB                				     AS JOB 	 \n");
        sb.append("		,TO_CHAR(A.HIREDATE, 'YYYY-MM-DD')       AS HIREDATE \n");
        sb.append("		,A.DEPTNO       					     AS DEPTNO 	 \n");
        
        sb.append("FROM EMP A 												 \n");

        sb.append("WHERE  A.EMPNO LIKE '%'||?||'%'		\n"); // place holder 1
        
        System.out.println("<<< 5. EmpSearchQueryMap_p :: getEmpSelectEmpno() :: ������ �ۼ� ��  >>> \n");
		
		return sb.toString();
	};
	
	// ��� �̸� �˻�
	public static String getEmpSelectEname(){
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT													 \n");
        sb.append("		A.EMPNO         					     AS EMPNO 	 \n");
        sb.append("		,A.ENAME        				  		 AS ENAME 	 \n");
        sb.append("		,A.JOB                				     AS JOB 	 \n");
        sb.append("		,TO_CHAR(A.HIREDATE, 'YYYY-MM-DD')       AS HIREDATE \n");
        sb.append("		,A.DEPTNO       					     AS DEPTNO 	 \n");
        
        sb.append("FROM EMP A 												 \n");

        // ���� ����� ��� : sb.append("WHERE  A.ENAME = UPPER(?)"); // place holder 1
        sb.append("WHERE A.ENAME	LIKE	UPPER('%'||?||'%')				 \n");
        
        
        System.out.println("<<< 5. EmpSearchQueryMap_p :: getEmpSelectEname() :: ������ �ۼ� ��  >>> \n");
		
		return sb.toString();	
	};
	
	public static String getEmpSelectEmpnoEname(){
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT													 \n");
        sb.append("		A.EMPNO         					     AS EMPNO 	 \n");
        sb.append("		,A.ENAME        				  		 AS ENAME 	 \n");
        sb.append("		,A.JOB                				     AS JOB 	 \n");
        sb.append("		,TO_CHAR(A.HIREDATE, 'YYYY-MM-DD')       AS HIREDATE \n");
        sb.append("		,A.DEPTNO       					     AS DEPTNO 	 \n");
        
        sb.append("FROM EMP A 												 \n");

        sb.append("WHERE  A.EMPNO LIKE '%'||?||'%'			\n"); // place holder 1
        sb.append("AND 	  A.ENAME LIKE UPPER('%'||?||'%')	\n"); // place holder 2
        
        System.out.println("<<< 5. EmpSearchQueryMap_p :: getEmpSelectEmpnoEname() :: ������ �ۼ� ��  >>> \n");
        
		return sb.toString();
	};
	
	public static String getEmpSelectJob(){
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT													 \n");
        sb.append("		A.EMPNO         					     AS EMPNO 	 \n");
        sb.append("		,A.ENAME        				  		 AS ENAME 	 \n");
        sb.append("		,A.JOB                				     AS JOB 	 \n");
        sb.append("		,TO_CHAR(A.HIREDATE, 'YYYY-MM-DD')       AS HIREDATE \n");
        sb.append("		,A.DEPTNO       					     AS DEPTNO 	 \n");
        
        sb.append("FROM EMP A 												 \n");

        sb.append("WHERE  A.JOB LIKE UPPER('%'||?||'%')"); // place holder 1
        
        System.out.println("<<< 5. EmpSearchQueryMap_p :: getEmpSelectJob() :: ������ �ۼ� ��  >>> \n");
        
		return sb.toString();
	};
	
	
	public static String getEmpSelectHiredate(){
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT													 \n");
        sb.append("		A.EMPNO         					     AS EMPNO 	 \n");
        sb.append("		,A.ENAME        				  		 AS ENAME 	 \n");
        sb.append("		,A.JOB                				     AS JOB 	 \n");
        sb.append("		,TO_CHAR(A.HIREDATE, 'YYYY-MM-DD')       AS HIREDATE \n");
        sb.append("		,A.DEPTNO       					     AS DEPTNO 	 \n");
        
        sb.append("FROM EMP A 												 \n");

        sb.append("WHERE  TO_CHAR(TO_DATE(A.HIREDATE), 'YYYYMMDD')  >= TO_CHAR(TO_DATE(?), 'YYYYMMDD')  \n");
        //  place holder 1
		sb.append("AND   TO_CHAR(TO_DATE(A.HIREDATE), 'YYYYMMDD') 	<= TO_CHAR(TO_DATE(?), 'YYYYMMDD')");
		// place holder 2
		
		System.out.println("<<< 5. EmpSearchQueryMap_p :: getEmpSelectHiredate() :: ������ �ۼ� ��  >>> \n");
		
		return sb.toString();
	};
}