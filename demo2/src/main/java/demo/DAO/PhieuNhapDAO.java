package demo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import demo.bean.HangNhap;
import demo.bean.PhieuNhap;
import demo.utils.MySQLConnUtils;

public class PhieuNhapDAO {
   public static void themPhieuNhap(PhieuNhap phieuNhap) {
        Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        try {
            conn = MySQLConnUtils.getMySQLConnection();
            ps = conn.prepareStatement("insert into phieu_nhap(nha_cc_id,nv_id) values(?,?);",  Statement.RETURN_GENERATED_KEYS);
            conn.setAutoCommit(false);
            ps.setInt(1, phieuNhap.getNhaCungCap().getId());
            ps.setInt(2, 1);
            ps.executeUpdate();
            int phieuNhapId =0;
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()) {
                phieuNhapId = rs.getInt(1);
            }
            if(phieuNhapId <= 0) {
                conn.rollback();
            }
            
            if(phieuNhapId >0) {
                ps2 = conn.prepareStatement("insert into hang_nhap(nhap_date,hang_hoa_id,phieu_nhap_id,amount,price) values (now(),?,?,?,?)");
                for(HangNhap hn: phieuNhap.getHangNhap()) {
                    ps2.setInt(1, hn.getHangHoa().getId());
                    ps2.setInt(2, phieuNhapId);
                    ps2.setInt(3, hn.getHangHoa().getAmount());
                    ps2.setDouble(4, hn.getHangHoa().getPrice());
                    ps2.addBatch();
                }
                ps2.executeBatch();
                conn.commit();
                ps2.close();
            }
            
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}
