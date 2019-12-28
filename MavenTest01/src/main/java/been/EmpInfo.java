package been;

//对于表所建立的Info
public class EmpInfo {
    //emp表中的各字段
    private Integer Empno;
    private String Ename;
    private String Job;
    private Integer Mgr;
    private String Hiredate;
    private Integer Sal;
    private Integer Comm;
    private Integer Deptno;

    public EmpInfo() {

    }

    public EmpInfo(Integer empno, String ename, String job, Integer mgr, String hiredate, Integer sal, Integer comm, Integer deptno) {
        Empno = empno;
        Ename = ename;
        Job = job;
        Mgr = mgr;
        Hiredate = hiredate;
        Sal = sal;
        Comm = comm;
        Deptno = deptno;
    }

    public EmpInfo(String ename, String job, Integer mgr, String hiredate, Integer sal, Integer comm, Integer deptno) {
        Ename = ename;
        Job = job;
        Mgr = mgr;
        Hiredate = hiredate;
        Sal = sal;
        Comm = comm;
        Deptno = deptno;
    }

    @Override
    public String toString() {
        return "EmpInfo{" +
                "Empno=" + Empno +
                ", Ename='" + Ename + '\'' +
                ", Job='" + Job + '\'' +
                ", Mgr=" + Mgr +
                ", Hiredate='" + Hiredate + '\'' +
                ", Sal=" + Sal +
                ", Comm=" + Comm +
                ", Deptno=" + Deptno +
                '}';
    }

    public Integer getEmpno() {
        return Empno;
    }

    public void setEmpno(Integer empno) {
        Empno = empno;
    }

    public String getEname() {
        return Ename;
    }

    public void setEname(String ename) {
        Ename = ename;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String job) {
        Job = job;
    }

    public Integer getMgr() {
        return Mgr;
    }

    public void setMgr(Integer mgr) {
        Mgr = mgr;
    }

    public String getHiredate() {
        return Hiredate;
    }

    public void setHiredate(String hiredate) {
        Hiredate = hiredate;
    }

    public Integer getSal() {
        return Sal;
    }

    public void setSal(Integer sal) {
        Sal = sal;
    }

    public Integer getComm() {
        return Comm;
    }

    public void setComm(Integer comm) {
        Comm = comm;
    }

    public Integer getDeptno() {
        return Deptno;
    }

    public void setDeptno(Integer deptno) {
        Deptno = deptno;
    }
}


