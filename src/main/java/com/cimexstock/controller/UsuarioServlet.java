package com.cimexstock.controller;

import com.cimexstock.modelo.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/put")
@WebServlet(name="UsuarioServlet" , urlPatterns={"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {


    protected  void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        String nombre = request.getParameter("nombre");
        String direccion = request.getParameter("direccion");
        Integer telefono =  Integer.getInteger(request.getParameter("telefono"));
        String usser = request.getParameter("usser");
        String passw = request.getParameter("passware");

        Usuario usuario= new Usuario(01,nombre,direccion,telefono,usser,passw);
        request.setAttribute("Usuario",usuario);
        request.getRequestDispatcher("Salida.html").forward(request,response);
    }

}
