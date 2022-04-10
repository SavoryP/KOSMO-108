package a.b.c.prac.comm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import a.b.c.prac2.OracleConnProperty_p;

public abstract class ChabunQuery_p {
	
	public static final short CHABUN_QUERY_TEST=0;
	
	public static String chabun_query[]={
		// �������� �ۼ�
		"SELECT NVL(MAX(SUBSTR(A.T1, -4)), 0)+1 AS COMM_NUM FROM TEST_T4 A"
		// (SCOTT.)TEST_T4 ���̺��� alias�� A�̴�. �ش� ���̺���
		// T1 Į���� �ڿ��� ���� 4��° ��¥������ 0�� ���Ͽ�
		// ū ���� �����϶�. (��, null���̸� 0���� ��ü)
		
			// �������� ���� sqldeveloper ���� �����غ���
	};
	
	
	public static String getTestChabumQuery() {
		System.out.println("<<< 2. ChabunQuery_p :: getTestChabumQuery() ���� >>> ");
		Connection conn =null;
		PreparedStatement pstmt=null;
		ResultSet rsRs=null;
		String commNum="";
		
		try {
			conn=OracleConnProperty_p.getConnection();
			// OracleConnProperty_p Ŭ������
			// getConnection() �޼���
			
			String sql=ChabunQuery_p.chabun_query[CHABUN_QUERY_TEST];
			pstmt=conn.prepareStatement(sql);
			System.out.println("ChabunQuery_p ���� �ۼ� :: sql >>> \n"+sql);
			
			rsRs=pstmt.executeQuery();
			// �������� ResultSet Ŭ������ ���������� ����� �޾ƿ´�.
			
			// pstmt.clearParameters();
			// Ŭ���� ���ֱ�
			
			if (rsRs!=null){
				// rsRs�� null�� �ƴ� ��쿡�� ����
				while (rsRs.next()){
					commNum=rsRs.getString("COMM_NUM");
					// COMM_NUM Į���� ���� String Ŭ������ ��������
					// commNum �� �����Ѵ�.
				}
			}else{
				// rsRs != null �� �ƴ϶� else ������ �´�. Ȯ���غ���
				boolean bool= rsRs == null;
				System.out.println("OracleConnProperty_p :: rsRs == null >>> "+bool);
				System.out.println("OracleConnProperty_p :: rsRs >>> : "+rsRs);
			}			
		}catch(Exception e){
			System.out.println("OracleConnProperty_p :: getTestChabumQuery() ������ error >>> : "+e.getMessage());
		}
		
		return commNum;
	}

	// public static void main(String[] args) {
		// TODO Auto-generated method stub

	// }
}
