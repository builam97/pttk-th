package demo.test.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Mockito;

import demo.controller.HangHoaController;

public class Test_HangHoaController extends Mockito{
    @Test
    public void testServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    

        when(request.getParameter("ncc_id")).thenReturn("1");
        when(request.getParameter("name_mh")).thenReturn("Mac");
        RequestDispatcher rd=mock(RequestDispatcher.class);
        when(request.getRequestDispatcher("/TimMatHangView.jsp")).thenReturn(rd);
        new HangHoaController().doGet(request, response);
    }
    @Test
    public void testServlet2() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    

        when(request.getParameter("ncc_id")).thenReturn("1");
        when(request.getParameter("name_mh")).thenReturn("abc");
        RequestDispatcher rd=mock(RequestDispatcher.class);
        when(request.getRequestDispatcher("/TimMatHangView.jsp")).thenReturn(rd);
        new HangHoaController().doGet(request, response);
    }
    @Test
    public void testServlet3() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    

        when(request.getParameter("ncc_id")).thenReturn("1");
        when(request.getParameter("name_mh")).thenReturn("");
        RequestDispatcher rd=mock(RequestDispatcher.class);
        when(request.getRequestDispatcher("/TimMatHangView.jsp")).thenReturn(rd);
        new HangHoaController().doGet(request, response);
    }
    @Test
    public void testServlet4() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    

        when(request.getParameter("ncc_id")).thenReturn("1");
        RequestDispatcher rd=mock(RequestDispatcher.class);
        when(request.getRequestDispatcher("/TimMatHangView.jsp")).thenReturn(rd);
        new HangHoaController().doGet(request, response);
    }
}
