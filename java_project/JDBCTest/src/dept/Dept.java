package dept;

//부서 정보를 저장하는 기능 클래스 
public class Dept {  //사용자 입력하는 데이터를 클래스 DEPT에 넣어서 처리.. //DB에 있는 dept테이블에있는데이터 -> 클래스 DEPT에 저장 (배열이나 list로저장)

	private int deptno ; // 부서번호
	private String dname ; // 부서이름
	private String loc; // 부서위치
	
	
	
	public Dept(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}

	
	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}

	
	
	
	
	
}
