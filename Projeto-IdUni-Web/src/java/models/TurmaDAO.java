/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import core.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
/**
 *
 * @author Ramos
 */
@WebServlet(name = "TurmaDAO", urlPatterns = {"/TurmaDAO"})
public class TurmaDAO extends HttpServlet{
    private Connection conexao;
    
    public TurmaDAO(){
        try{
            this.conexao = Conexao.criaConexao();
        } catch(SQLException e){
            System.out.println("Erro de conexão no DB");
        }
    }
    
    public ArrayList<Turma> ler(){
        /* Leitura */
    }
    
    public ArrayList<Turma> criar(){
        /* Criar */
    }
    
    public ArrayList<Turma> apagar(int id){
        /* Apagar */
    }
    
    public ArrayList<Turma> atualizar(int id){
        /* Atualizar */
    }
}
