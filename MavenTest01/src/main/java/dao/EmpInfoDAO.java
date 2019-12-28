package dao;

import been.EmpInfo;
import db.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//对于表所建立的DAO,对emp表和EmpInfo的增删改查CRUD
public class EmpInfoDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    /**
     * 获取数据库emp表中的所有数据；将它们封装为一个list集合并且返回。
     *
     * @return
     */
    public List<EmpInfo> findAllEmp() {
        List<EmpInfo> list = new ArrayList<>();
        String sql = "SELECT * FROM emp";
        try {
            conn = DBManager.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                EmpInfo ei = new EmpInfo();
                ei.setEmpno(rs.getInt(1));
                ei.setEname(rs.getString(2));
                ei.setJob(rs.getString(3));
                ei.setMgr(rs.getInt(4));
                ei.setHiredate(rs.getString(5));
                ei.setSal(rs.getInt(6));
                ei.setComm(rs.getInt(7));
                ei.setDeptno(rs.getInt(8));
                list.add(ei);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("数据已读取！");
            DBManager.closeConnection(conn, ps, rs);
        }
        return list;
    }

    /**
     * 将一组数据存入表中
     *
     * @param ei
     */
    public void saveEmp(EmpInfo ei) {
        String sql = "INSERT INTO emp VALUES (null,?,?,?,?,?,?,?)";
        try {
            conn = DBManager.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, ei.getEname());
            ps.setString(2, ei.getJob());
            try {
                if (ei.getMgr() == null) {
                    ei.setMgr(0);
                }
                ps.setInt(3, ei.getMgr());
            } catch (Exception e) {
                e.printStackTrace();
            }

            ps.setString(4, ei.getHiredate());
            ps.setDouble(5, ei.getSal());
            ps.setDouble(6, ei.getComm());
            ps.setInt(7, ei.getDeptno());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("数据已添加");
            DBManager.closeConnection(conn, ps, rs);
        }
    }

    /**
     * 主键索引，删除一组数据
     *
     * @param empno
     */
    public void deleteEmp(Integer empno) {
        String sql = "delete from emp where empno=?";
        try {
            conn = DBManager.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, empno);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("数据已删除");
            DBManager.closeConnection(conn, ps, rs);
        }
    }

    /**
     * 主键索引，更新一组数据
     *
     * @param ei
     */
    public void updateEmp(EmpInfo ei) {
        String sql = "update emp set ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=? where empno=?";
        try {
            conn = DBManager.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, ei.getEname());
            ps.setString(2, ei.getJob());
            try {
                if (ei.getMgr() == null) {
                    ei.setMgr(0);
                }
                ps.setInt(3, ei.getMgr());
            } catch (Exception e) {
                e.printStackTrace();
            }
            ps.setString(4, ei.getHiredate());
            ps.setDouble(5, ei.getSal());
            ps.setDouble(6, ei.getComm());
            ps.setInt(7, ei.getDeptno());
            ps.setInt(8, ei.getEmpno());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("数据已修改");
            DBManager.closeConnection(conn, ps, rs);
        }
    }

    /**
     * 主键索引，查找一组数据
     *
     * @param empno
     * @return
     */
    public EmpInfo findByEmpno(Integer empno) {
        EmpInfo ei = new EmpInfo();
        String sql = "SELECT * FROM emp where empno=?";
        try {
            conn = DBManager.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, empno);
            rs = ps.executeQuery();
            while (rs.next()) {
                ei.setEmpno(rs.getInt(1));
                ei.setEname(rs.getString(2));
                ei.setJob(rs.getString(3));
                ei.setMgr(rs.getInt(4));
                ei.setHiredate(rs.getString(5));
                ei.setSal(rs.getInt(6));
                ei.setComm(rs.getInt(7));
                ei.setDeptno(rs.getInt(8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("数据已读取！");
            DBManager.closeConnection(conn, ps, rs);
        }
        return ei;
    }


}
