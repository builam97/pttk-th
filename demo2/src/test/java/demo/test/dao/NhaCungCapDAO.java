package demo.test.dao;

import java.util.List;

import demo.bean.NhaCungCap;
import junit.framework.TestCase;

public class NhaCungCapDAO extends TestCase {

    public void testFindNhaccByName() {
        List<NhaCungCap> listncc = demo.DAO.NhaCungCapDAO.findNhaCungCapByName("di dong");
        assertEquals(1, listncc.size());
    }
    
    public void testFindNhaccAll() {
        List<NhaCungCap> listncc = demo.DAO.NhaCungCapDAO.findAll();
        assertEquals(3, listncc.size());
    }
    public void testfindNhaCungCapById() {
        NhaCungCap ncc = demo.DAO.NhaCungCapDAO.findNhaCungCapById(1);
        assertEquals(true, ncc.getName() != null);
    }
    public void testSaveNhaCungCap() {
        List<NhaCungCap> listncc = demo.DAO.NhaCungCapDAO.findAll();
        int sizeDebut = listncc.size();
        NhaCungCap nhaCungCap = new NhaCungCap("Dien may HN", "Ha Noi", "012345");
        demo.DAO.NhaCungCapDAO.saveNhaCungCap(nhaCungCap);
        assertEquals(sizeDebut+1, demo.DAO.NhaCungCapDAO.findAll().size());
    }
}
