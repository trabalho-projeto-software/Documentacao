/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author joell
 */
public class TurmaBuilder {
    //Objeto do tipo turma que deverá ser instanciado e retornado pelo builder
    private Turma turmaACriar;
    
    /* O construtor usa o método resetar para instanciar um objeto turma ainda
    sem nenhum de seus atributos setados no momento da criação do construtor.
    */ 
    public TurmaBuilder(){
        this.resetar();
    }
    
    /* O método resetar instancia um objeto turma vazio para o construtor */
    public void resetar(){
        this.turmaACriar = new Turma();
    }
    
    /* Etapas de construção do objeto Turma, a classe que utilizar o Builder
    pode escolher utilizar apenas os métodos necessários para a ocasião
    */
    public void setProfessor(Professor professor){
        this.turmaACriar.setProfessor(professor);
    }
    
    public void setCodigo(String codigo){
        this.turmaACriar.setCodigo(codigo);
    }
    
    public void setDisciplina(Disciplina disciplina){
        this.turmaACriar.setDisciplina(disciplina);
    }
    
    public void setSala(String sala){
        this.turmaACriar.setSala(sala);
    }
    
    public void setHorario(String horario){
        this.turmaACriar.setHorario(horario);
    }
}
