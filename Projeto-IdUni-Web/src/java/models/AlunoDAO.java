/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas Fernandes Ramos
 */
public class AlunoDAO implements InterfaceDAO{
    private Connection conexao;
    
    public AlunoDAO(){
        
      try {
            // Cria a conexão com o banco de dados
            conexao = Conexao.criaConexao();
        }
        catch( Exception e ) {
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        }
    }
    @Override
    public boolean adicionar(Object ob) {
       Aluno objeto = (Aluno)ob; 
        
       try {
            String sql = "INSERT INTO alunos (nome, cpf, senha,matricula,CR) VALUES (?,?,?,?,?)";
            
            PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, objeto.getNome());
            ps.setString(2, objeto.getCpf());
            ps.setString(3, objeto.getSenha());
            
       
            ps.execute();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            int chaveGerada = 0;
            if(rs.next()){
                chaveGerada = rs.getInt(1);
            }
            
            
            objeto.setId(chaveGerada);
            System.out.println("O aluno foi adicionda com chave:"+objeto.getId());
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
    

    @Override
    public boolean atualizar(Object objeto) {
        Aluno aluno = (Aluno)objeto;
        
        try{
            String sql = "UPDATE alunos SET nome=?, cpf=?, senha=?, CR=?, matricula=? WHERE id=?";

            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getCpf());
            ps.setString(3, aluno.getSenha());
            ps.setInt(4, aluno.getId());

            ps.execute();
            
            System.out.println("Os dados do aluno foram atualizados");
            
            return true;
        
        } catch (SQLException e){
            System.out.println("Erro de SQL:" + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean remover(int id) {
        try {
            String sql = "DELETE FROM alunos WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            System.out.println("Aluno removido");
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Object buscar(int codigo) {
       Aluno aluno = new Aluno();
        try {
            String sql = "SELECT * FROM alunos WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                aluno.setId(rs.getInt("id"));
                aluno.setNome( rs.getString("nome") );
                aluno.setCpf(rs.getString("cpf"));
                aluno.setSenha(rs.getString("senha"));
               
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return aluno;
    }
    
    public List<Aluno> buscarAlunos(){
        List<Aluno> resultado = new ArrayList<>();
        try {            
            
            
            Statement stmt = conexao.createStatement();
            
            ResultSet rs = stmt.executeQuery("select * from alunos");
            
            while( rs.next() ) {
                
                
                Aluno aluno = new Aluno();
                
                
                aluno.setId(rs.getInt("id"));
                
                aluno.setNome( rs.getString("nome") );
                
                aluno.setCpf(rs.getString("cpf") );
                
               
                resultado.add(aluno);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
       
        return resultado;
        
        
    }
    
}
