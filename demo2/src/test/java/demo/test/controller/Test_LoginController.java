package demo.test.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Mockito;

import demo.controller.LoginController;

public class Test_LoginController extends Mockito{

    @Test
    public void testServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    

        when(request.getParameter("username")).thenReturn("builam");
        when(request.getParameter("password")).thenReturn("builam97");

        new LoginController().doPost(request, response);
    }
    
    @Test
    public void testServlet2() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    

        when(request.getParameter("username")).thenReturn("builam123");
        when(request.getParameter("password")).thenReturn("builam97");

        RequestDispatcher rd=mock(RequestDispatcher.class);
        when(request.getRequestDispatcher("/index.jsp")).thenReturn(rd);
        new LoginController().doPost(request, response);
    }
}
