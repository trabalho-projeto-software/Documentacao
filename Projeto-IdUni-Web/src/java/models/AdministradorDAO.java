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
public class AdministradorDAO implements InterfaceDAO{
    private Connection conexao;
    
    public AdministradorDAO(){
        
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
       Administrador objeto = (Administrador)ob; 
        
       try {
            String sql = "INSERT INTO Administradors (nome, cpf, senha,matricula,CR) VALUES (?,?,?,?,?)";
            
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
            System.out.println("O Administrador foi adicionda com chave:"+objeto.getId());
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
    

    @Override
    public boolean atualizar(Object objeto) {
        Administrador Administrador = (Administrador)objeto;
        
        try{
            String sql = "UPDATE Administradors SET nome=?, cpf=?, senha=?, CR=?, matricula=? WHERE id=?";

            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setString(1, Administrador.getNome());
            ps.setString(2, Administrador.getCpf());
            ps.setString(3, Administrador.getSenha());
            ps.setInt(4, Administrador.getId());

            ps.execute();
            
            System.out.println("Os dados do Administrador foram atualizados");
            
            return true;
        
        } catch (SQLException e){
            System.out.println("Erro de SQL:" + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean remover(int id) {
        try {
            String sql = "DELETE FROM Administradors WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            System.out.println("Administrador removido");
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Object buscar(int codigo) {
       Administrador Administrador = new Administrador();
        try {
            String sql = "SELECT * FROM Administradors WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                Administrador.setId(rs.getInt("id"));
                Administrador.setNome( rs.getString("nome") );
                Administrador.setCpf(rs.getString("cpf"));
                Administrador.setSenha(rs.getString("senha"));
               
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return Administrador;
    }
    
    public List<Administrador> buscarAdministradors(){
        List<Administrador> resultado = new ArrayList<>();
        try {            
            
            
            Statement stmt = conexao.createStatement();
            
            ResultSet rs = stmt.executeQuery("select * from Administradors");
            
            while( rs.next() ) {
                
                
                Administrador Administrador = new Administrador();
                
                
                Administrador.setId(rs.getInt("id"));
                
                Administrador.setNome( rs.getString("nome") );
                
                Administrador.setCpf(rs.getString("cpf") );
                
               
                resultado.add(Administrador);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
       
        return resultado;
        
        
    }
    
}
