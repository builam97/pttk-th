package demo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import demo.bean.HangHoa;
import demo.utils.MySQLConnUtils;

public class HangHoaDAO {
   public static List<HangHoa> findHangHoaByName(Integer nhaccId, String name) {
        List<HangHoa> listHh = new ArrayList<HangHoa>();
        try {
            Connection conn = MySQLConnUtils.getMySQLConnection();
            PreparedStatement ps = conn.prepareStatement("Select * from hang_hoa hh inner join nha_cung_cap ncc on hh.nha_cc_id = ncc.id where ncc.id = ? and hh.name like ?");
            ps.setInt(1, nhaccId);
            ps.setString(2, "%"+ name +"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Integer id = rs.getInt("id");
                String name_hh = rs.getString("name");
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                Integer amount = rs.getInt("amount");
                HangHoa hh = new HangHoa(id,name_hh,description,price,amount);
                listHh.add(hh);
            }
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listHh;
    }
   public static List<HangHoa> findAll(Integer nhaccId) {
       List<HangHoa> listHh = new ArrayList<HangHoa>();
       try {
           Connection conn = MySQLConnUtils.getMySQLConnection();
           PreparedStatement ps = conn.prepareStatement("Select * from hang_hoa hh inner join nha_cung_cap ncc on hh.nha_cc_id = ncc.id where ncc.id = ? ");
           ps.setInt(1, nhaccId);
           ResultSet rs = ps.executeQuery();
           while(rs.next()) {
               Integer id = rs.getInt("id");
               String name_hh = rs.getString("name");
               String description = rs.getString("description");
               double price = rs.getDouble("price");
               Integer amount = rs.getInt("amount");
               HangHoa hh = new HangHoa(id,name_hh,description,price,amount);
               listHh.add(hh);
           }
           conn.close();
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return listHh;
   }
   public static HangHoa findHangHoaById(Integer hangHoaId) {
       HangHoa hh = new HangHoa();
       try {
        Connection conn = MySQLConnUtils.getMySQLConnection();
        PreparedStatement ps = conn.prepareStatement("Select * from hang_hoa where id =?");
        ps.setInt(1, hangHoaId);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            Integer id = rs.getInt("id");
            String name_hh = rs.getString("name");
            String description = rs.getString("description");
            double price = rs.getDouble("price");
            Integer amount = rs.getInt("amount");
            hh.setId(id);
            hh.setName(name_hh);
            hh.setDescription(description);
            hh.setPrice(price);
            hh.setAmount(amount);
        }
    } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
       return hh;
   }
   public static Integer saveHangHoa(HangHoa hangHoa, Integer nccId) {
       int hangId =0;
       try {
           Connection conn = MySQLConnUtils.getMySQLConnection();
           PreparedStatement ps = conn.prepareStatement("Insert into hang_hoa(name,description,price,amount,nha_cc_id) values(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
           ps.setString(1, hangHoa.getName());
           ps.setString(2, hangHoa.getDescription());
           ps.setDouble(3, hangHoa.getPrice());
           ps.setDouble(4, hangHoa.getAmount());
           ps.setDouble(5, nccId);
           ps.executeUpdate();
           ResultSet rs = ps.getGeneratedKeys();
           if(rs.next()) {
               hangId = rs.getInt(1);
           }
           ps.close();
           conn.close();
       } catch (ClassNotFoundException | SQLException e) {
           e.printStackTrace();
       }
       return hangId;
   }
}
