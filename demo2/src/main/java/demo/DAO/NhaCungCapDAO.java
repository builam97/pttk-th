package demo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import demo.bean.NhaCungCap;
import demo.utils.MySQLConnUtils;

public class NhaCungCapDAO {
    public static List<NhaCungCap> findNhaCungCapByName(String name) {
        List<NhaCungCap> listNhacc = new ArrayList<NhaCungCap>();
        try {
            Connection conn = MySQLConnUtils.getMySQLConnection();
            PreparedStatement ps = conn.prepareStatement("Select * from nha_cung_cap where name like ?");
            ps.setString(1, "%"+name+"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Integer id = rs.getInt("id");
                String name_ncc = rs.getString("name");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                NhaCungCap ncc = new NhaCungCap(id,name_ncc, address,phone);
                listNhacc.add(ncc);
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return listNhacc;
    }
    public static List<NhaCungCap> findAll() {
        List<NhaCungCap> listNhacc = new ArrayList<NhaCungCap>();
        try {
            Connection conn = MySQLConnUtils.getMySQLConnection();
            PreparedStatement ps = conn.prepareStatement("Select * from nha_cung_cap");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Integer id = rs.getInt("id");
                String name_ncc = rs.getString("name");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                NhaCungCap ncc = new NhaCungCap(id,name_ncc, address,phone);
                listNhacc.add(ncc);
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return listNhacc;
    }
    
    public static NhaCungCap findNhaCungCapById(Integer nccId) {
        NhaCungCap ncc = new NhaCungCap();
        try {
            Connection conn = MySQLConnUtils.getMySQLConnection();
            PreparedStatement ps = conn.prepareStatement("Select * from nha_cung_cap where id = ?");
            ps.setInt(1, nccId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Integer id = rs.getInt("id");
                String name_ncc = rs.getString("name");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                ncc = new NhaCungCap(id,name_ncc, address,phone);
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return ncc;
    }
    
    public static Integer saveNhaCungCap(NhaCungCap nhaCungCap) {
        int nhaCcId =1;
        try {
            Connection conn = MySQLConnUtils.getMySQLConnection();
            PreparedStatement ps = conn.prepareStatement("Insert into nha_cung_cap(name,address,phone) values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, nhaCungCap.getName());
            ps.setString(2, nhaCungCap.getAddress());
            ps.setString(3, nhaCungCap.getPhone());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()) {
                nhaCcId = rs.getInt(1);
            }
            ps.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return nhaCcId;
    }
}
