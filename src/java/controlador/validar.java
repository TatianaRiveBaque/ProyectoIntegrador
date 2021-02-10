/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Empleado;
import modelo.EmpleadoDao;

/**
 *
 * @author jhonn
 */
public class validar extends HttpServlet {

   EmpleadoDao edao=new EmpleadoDao();
   Empleado em=new Empleado();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        
    }
        
        
    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion=request.getParameter("accion");
        if(accion.equalsIgnoreCase("Ingresar")){
            String usser=request.getParameter("txtusser");
            String pass=request.getParameter("tstpass");
            
            em=edao.validar(usser, pass);
            if(em.getUsser()!=null){
                request.setAttribute("usuario", em);
                request.getRequestDispatcher("controlador?menu=Principal").forward(request, response);
            }else{
                request.getRequestDispatcher("Principal.jsp").forward(request, response);
            }  
        }
        else{
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
