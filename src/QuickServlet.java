package coms.ss.javabasics.QuickServlet.src.net.codejava.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Example servlet running with a Tomcat server
 * to display a very basic HTML message in browser
 *
 * @author Joshua Tyler
 */
public class QuickServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  /**
   * this life-cycle method is invoked when this servlet is first accessed
   * by the client
   */
  public void init(ServletConfig config) {
    System.out.println("Servlet is being initialized");
  }

  /**
   * handles HTTP GET request
   * @throws IOException
   */
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException {
    try (PrintWriter writer = response.getWriter()) {
      writer.println("<html>Hello, I am a Java servlet!</html>");
    } catch (IOException e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * handles HTTP POST request
   * @throws IOException
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException {
    String paramWidth = request.getParameter("width");
    int width = Integer.parseInt(paramWidth);

    String paramHeight = request.getParameter("height");
    int height = Integer.parseInt(paramHeight);

    try (PrintWriter writer = response.getWriter()) {
      writer.println("<html>Width of this rectangle is: " + width + ".\nHeight of this rectangle is: " + height + "</html>");
    } catch (IOException e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * this life-cycle method is invoked when the application or the server
   * is shutting down
   */
  public void destroy() {
    System.out.println("Servlet is being destroyed");
  }
}
