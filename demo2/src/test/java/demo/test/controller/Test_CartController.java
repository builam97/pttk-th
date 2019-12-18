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
import demo.controller.CartServlet;

public class Test_CartController extends Mockito{
    @Test
    public void testServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    

        when(request.getParameter("hh_id")).thenReturn("1");
        when(request.getParameter("amount")).thenReturn("10");
        when(request.getParameter("ncc_id")).thenReturn("1");
        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
        RequestDispatcher rd=mock(RequestDispatcher.class);
        when(request.getRequestDispatcher("/TimMatHangView.jsp")).thenReturn(rd);

        new CartServlet().doGet(request, response);
    }
    
    @Test
    public void testServlet2() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    
        List<HangHoa> listHH = new ArrayList<HangHoa>();
        listHH.add(new HangHoa(1, "Mac pro", "", 1000.0, 10));
        when(request.getParameter("hh_id")).thenReturn("1");
        when(request.getParameter("amount")).thenReturn("10");
        when(request.getParameter("ncc_id")).thenReturn("1");
        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
        Mockito.doReturn(listHH).when(session).getAttribute("cart");
        RequestDispatcher rd=mock(RequestDispatcher.class);
        when(request.getRequestDispatcher("/TimMatHangView.jsp")).thenReturn(rd);

        new CartServlet().doGet(request, response);
    }
    
    @Test
    public void testServlet3() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    
        List<HangHoa> listHH = new ArrayList<HangHoa>();
        listHH.add(new HangHoa(1, "Mac pro", "", 1000.0, 10));
        
        when(request.getParameter("hh_id")).thenReturn("2");
        when(request.getParameter("amount")).thenReturn("10");
        when(request.getParameter("ncc_id")).thenReturn("1");
        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
        Mockito.doReturn(listHH).when(session).getAttribute("cart");
        RequestDispatcher rd=mock(RequestDispatcher.class);
        when(request.getRequestDispatcher("/TimMatHangView.jsp")).thenReturn(rd);

        new CartServlet().doGet(request, response);
    }
    
    @Test
    public void testServlet4() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    
        List<HangHoa> listHH = new ArrayList<HangHoa>();
        listHH.add(new HangHoa(1, "Mac pro", "", 1000.0, 10));
        
        when(request.getParameter("hh_id")).thenReturn("2");
        when(request.getParameter("amount")).thenReturn("10");
        when(request.getParameter("ncc_id")).thenReturn("1");
        when(request.getParameter("name_mh")).thenReturn("mac");
        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
        Mockito.doReturn(listHH).when(session).getAttribute("cart");
        RequestDispatcher rd=mock(RequestDispatcher.class);
        when(request.getRequestDispatcher("/TimMatHangView.jsp")).thenReturn(rd);

        new CartServlet().doGet(request, response);
    }
    @Test
    public void testServlet5() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    
        List<HangHoa> listHH = new ArrayList<HangHoa>();
        listHH.add(new HangHoa(1, "Mac pro", "", 1000.0, 10));
        
        when(request.getParameter("hh_id")).thenReturn("2");
        when(request.getParameter("amount")).thenReturn("10");
        when(request.getParameter("ncc_id")).thenReturn("1");
        when(request.getParameter("name_mh")).thenReturn("");
        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
        Mockito.doReturn(listHH).when(session).getAttribute("cart");
        RequestDispatcher rd=mock(RequestDispatcher.class);
        when(request.getRequestDispatcher("/TimMatHangView.jsp")).thenReturn(rd);

        new CartServlet().doGet(request, response);
    }
}
