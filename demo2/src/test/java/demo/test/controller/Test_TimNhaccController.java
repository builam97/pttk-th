package demo.test.controller;

import org.junit.Test;
import org.mockito.Mockito;

import demo.controller.TimNhaccController;

import static org.junit.Assert.assertTrue;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test_TimNhaccController extends Mockito {
    @Test
    public void testServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    

        when(request.getParameter("name_ncc")).thenReturn("di dong");
//        StringWriter stringWriter = new StringWriter();
//        PrintWriter writer = new PrintWriter(stringWriter);
        RequestDispatcher rd=mock(RequestDispatcher.class);
        when(request.getRequestDispatcher("/TimNhaccView.jsp")).thenReturn(rd);

        new TimNhaccController().doGet(request, response);
//        verify(request, atLeast(1)).getParameter("name_ncc"); // only if you want to verify username was called...
//        verify(rd).forward(request, response);
//        assertTrue(stringWriter.toString().contains("My expected string"));
    }
    @Test
    public void testServlet2() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    

        when(request.getParameter("name_ncc")).thenReturn("abc");
//        StringWriter stringWriter = new StringWriter();
//        PrintWriter writer = new PrintWriter(stringWriter);
        RequestDispatcher rd=mock(RequestDispatcher.class);
        when(request.getRequestDispatcher("/TimNhaccView.jsp")).thenReturn(rd);

        new TimNhaccController().doGet(request, response);
//        verify(request, atLeast(1)).getParameter("name_ncc"); // only if you want to verify username was called...
//        verify(rd).forward(request, response);
//        assertTrue(stringWriter.toString().contains("My expected string"));
    }
}
