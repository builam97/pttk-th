package demo.test.dao;

import java.util.List;

import demo.bean.HangHoa;
import junit.framework.TestCase;

public class HangHoaDAO extends TestCase {

    public void testFindHangHoaById() {
        HangHoa hh = demo.DAO.HangHoaDAO.findHangHoaById(1);
        assertEquals("Laptop hp", hh.getName());
    }
    public void testfindHangHoaByName() {
        List<HangHoa> listHH = demo.DAO.HangHoaDAO.findHangHoaByName(1, "laptop");
        assertEquals(2, listHH.size());
    }
    public void testSaveHangHoa() {
        List<HangHoa> all = demo.DAO.HangHoaDAO.findAll(1);
        HangHoa hh = new HangHoa("Iphone 1", "older", 100.0, 200);
        int sizeDebut = all.size();
        demo.DAO.HangHoaDAO.saveHangHoa(hh, 1);
        int sizeLater = demo.DAO.HangHoaDAO.findAll(1).size();
        assertEquals(sizeDebut+1, sizeLater);
    }
}
