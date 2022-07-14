/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Administrador;
import models.Conexao;
import models.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AdministradorDAO;


/**
 *
 * @author Ramos
 */
public class Login implements Acao{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String CPF = request.getParameter("cpf");
        String senha = request.getParameter("senha");
        String tipo = request.getParameter("user");
        
   
        
        Administrador administrador = null;
        Administrador admin = null;
        Usuario usuario = null;
        Usuario user = null;
        
        
        try{
        if(tipo.equals("administrador")){
        AdminDAO admindao = new AdminDAO();
        
        admin = admindao.getAdministradorPorCPF(CPF);
        
            administrador = new Administrador();
            administrador.setCPF(CPF);
            administrador.setSenha(senha);
        } else if(tipo.equals("usuario")){
            UsuarioDAO usuariodao = new UsuarioDAO();
            
            user = usuariodao.getUsuarioPorCPF(CPF);
            usuario = new Usuario();
            usuario.setCPF(CPF);
            usuario.setSenha(senha);
          }
        } catch(NullPointerException e){
              System.out.println("Erro "+ e.getMessage());
              System.out.println("ANTES DO LOGIN");
        }
        
     //   System.out.println("CPF do usuario:" + usuario.getCPF());
        
    
           
        if(administrador != null && tipo.equals("administrador")){   
            if(administrador.getCPF().equals(admin.getCPF())&& administrador.getSenha().equals(admin.getSenha())){
                System.out.println("Administrador Existe");
                HttpSession sessao = request.getSession();
                sessao.setAttribute("individuoLogado",admin);
                return "redirect:entrada?acao=IndexAdm";
            } else {
                return "forward:erroLogin.jsp";
            }
        }
        if(usuario != null && tipo.equals("usuario")){
            if(usuario.getCPF().equals(user.getCPF()) && usuario.getSenha().equals(user.getSenha())  && usuario.isBloqueado() != "S") {
                System.out.println("Usuário Existe");
                HttpSession sessao = request.getSession();
                System.out.println("CPF do usuario:" + user.getCPF());
                sessao.setAttribute("individuoLogado",user);
                return "forward:index-usuario.jsp";
             } else {
                return "forward:erroLogin.jsp";
            }    
         
        }
      return "forward:erroLogin.jsp";
    }
}
