package demo.test.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.mockito.Mockito;

import demo.bean.HangHoa;
import demo.controller.BillServlet;

public class Test_BillController extends Mockito{
    @Test
    public void testServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    
        List<HangHoa> listHH = new ArrayList<HangHoa>();
        listHH.add(new HangHoa(1, "Mac pro", "", 1000.0, 10));
        when(request.getParameter("nccId")).thenReturn("1");
        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
        Mockito.doReturn(listHH).when(session).getAttribute("cart");
        RequestDispatcher rd=mock(RequestDispatcher.class);
        when(request.getRequestDispatcher("/HomeView.jsp")).thenReturn(rd);

        new BillServlet().doGet(request, response);
    }
    @Test
    public void testServlet2() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    
        List<HangHoa> listHH = new ArrayList<HangHoa>();
        listHH.add(new HangHoa(1, "Mac pro", "", 1000.0, 10));
        when(request.getParameter("nccId")).thenReturn("1");
        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
        RequestDispatcher rd=mock(RequestDispatcher.class);
        when(request.getRequestDispatcher("/HomeView.jsp")).thenReturn(rd);

        new BillServlet().doGet(request, response);
    }

}
