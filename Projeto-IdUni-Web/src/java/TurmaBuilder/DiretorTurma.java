/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TurmaBuilder;

import models.Disciplina;
import models.Professor;

/**
 *
 * @author joell
 * Autor do código: Joel Lopes Cunha de Souza
 * Matricula: 119083024
 */

public class DiretorTurma {
    private TurmaBuilder builder;
    
    /*
    Um TurmaBuilder concreto é passado para que o diretor trabalhe com ele e 
    esse builder também pode ser alterado através desse método. 
    O diretor trabalha com a interface TurmaBuilder, permitindo que receba 
    diversos tipos de Builder que implementem a interface e trabalhe com eles
    utilizando o mesmo trecho de código.
    */
    public void setBuilder(TurmaBuilder builder){
        this.builder = builder;
    }
    
    //Cria um diretor e passa um TurmaBuilder para ele utilizar
    public DiretorTurma(TurmaBuilder builder){
        this.setBuilder(builder);
    }
    
    //Constroi uma turma comum, com todos os atributos previstos
    public void TurmaComum(Professor professor, String sala, String codigo,
            String horario, Disciplina disciplina){
            builder.setProfessor(professor);
            builder.setCodigo(codigo);
            builder.setSala(sala);
            builder.setHorario(horario);
            builder.setDisciplina(disciplina);
    }
    
    
    /* Constroi uma turma de TCC, que necessita apenas de um código e a 
    disciplina a qual está relacionada (Por exemplo, TCC00111 e Projeto de 
    Aplicação).
    */
    public void TurmaTCC(String codigo, Disciplina disciplina){
        builder.setCodigo(codigo);
        builder.setDisciplina(disciplina);
    }
    
    
    /* Constroi uma turma de estágio, esse tipo de turma ainda precisa de um 
    professor orientador pré-definido mas não requer uma sala.
    */
    public void TurmaEstagio(Professor professor, String codigo, String horario,
            Disciplina disciplina){
        builder.setProfessor(professor);
        builder.setCodigo(codigo);
        builder.setHorario(horario);
        builder.setDisciplina(disciplina);
    }
}
