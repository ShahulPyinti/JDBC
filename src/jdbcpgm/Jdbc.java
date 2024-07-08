package jdbcpgm;

public class Jdbc {
	private int registrationnumber;
	private String name;
	private String dept;
	private long mobileno;
	public int getRegistrationnumber() {
		return registrationnumber;
	}
	public void setRegistrationnumber(int registrationnumber) {
		this.registrationnumber = registrationnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
}
