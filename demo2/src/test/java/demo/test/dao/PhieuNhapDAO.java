package demo.test.dao;

import java.util.ArrayList;
import java.util.List;

import demo.bean.HangHoa;
import demo.bean.HangNhap;
import demo.bean.NhaCungCap;
import demo.bean.PhieuNhap;
import junit.framework.TestCase;

public class PhieuNhapDAO extends TestCase {
    public void testThemPhieuNhapFail() {
        NhaCungCap ncc = new NhaCungCap(4, "24h shop", "Da nang", "01234");
        HangHoa hh = new HangHoa();
        hh.setId(1);
        HangNhap hn = new HangNhap(hh);
        List<HangNhap> hns = new ArrayList<HangNhap>();
        PhieuNhap pn = new PhieuNhap(hns, ncc);
        demo.DAO.PhieuNhapDAO.themPhieuNhap(pn);
    }
}
