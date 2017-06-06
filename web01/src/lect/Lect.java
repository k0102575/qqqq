// 역활: memb 테이블의 값을 보관할 떄 사용할 클래스

package lect;

public class Lect {
	int no;
	int crmno;
	int mrno;
	String titl;
	String dscp;
	int pric;
	int thrs;
	String sdt;
	String edt;
	int qty;
	
	@Override
	public String toString() {
		return "Lect [no=" + no + ", crmno=" + crmno + ", mrno=" + mrno + ", titl=" + titl + ", dscp=" + dscp
				+ ", pric=" + pric + ", thrs=" + thrs + ", sdt=" + sdt + ", edt=" + edt + ", qty=" + qty + "]";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getCrmno() {
		return crmno;
	}

	public void setCrmno(int crmno) {
		this.crmno = crmno;
	}

	public int getMrno() {
		return mrno;
	}

	public void setMrno(int mrno) {
		this.mrno = mrno;
	}

	public String getTitl() {
		return titl;
	}

	public void setTitl(String titl) {
		this.titl = titl;
	}

	public String getDscp() {
		return dscp;
	}

	public void setDscp(String dscp) {
		this.dscp = dscp;
	}

	public int getPric() {
		return pric;
	}

	public void setPric(int pric) {
		this.pric = pric;
	}

	public int getThrs() {
		return thrs;
	}

	public void setThrs(int thrs) {
		this.thrs = thrs;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEdt() {
		return edt;
	}

	public void setEdt(String edt) {
		this.edt = edt;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	
	



}
