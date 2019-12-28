package MavenTest01;

import been.EmpInfo;
import dao.EmpInfoDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    //获取emp表中的所有数据
    public static void Test_FindAllEmp() {
        List<EmpInfo> list = new EmpInfoDAO().findAllEmp();
        for (EmpInfo ei : list) {
            System.out.println(ei);
        }
    }

    //自增添加数据
    public static void Test_InsertEmp() {
        EmpInfo ei1 = new EmpInfo("赵四", "程序员", null, "2001-12-12", 6790, 788, 2);
        EmpInfo ei2 = new EmpInfo("王五", "架构师", 1, "2002-12-3", 10000, 1200, 2);
        new EmpInfoDAO().saveEmp(ei2);
    }

    public static void Test_deleteEmp() {
        new EmpInfoDAO().deleteEmp(6);
    }

    public static void Test_updateEmp() {
        EmpInfo ei = new EmpInfo(9, "王五", "架构师", 1, "2002-12-3", 10000, 1400, 2);
        new EmpInfoDAO().updateEmp(ei);
    }

    public static void Test_findByEmpno() {
        EmpInfo empInfo = new EmpInfoDAO().findByEmpno(2);
        System.out.println(empInfo);
    }

    public static void main(String[] args) {
        //Test_InsertEmp();
        //Test_deleteEmp();
        //Test_updateEmp();
        //Test_FindAllEmp();
        Test_findByEmpno();
    }
}
