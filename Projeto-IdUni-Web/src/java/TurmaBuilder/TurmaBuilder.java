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
 */

/*
Autor do código: Joel Lopes Cunha de Souza
Matricula: 119083024
*/

/* 
A interface TurmaBuilder especifica os métodos necessários para setar as
propriedades de uma turma, além do método resetar para começar uma turma do 
zero. É com ela que a classe DiretorTurma irá se comunicar.
*/
public interface TurmaBuilder {
    public void resetar();
    public void setProfessor(Professor professor);
    public void setCodigo(String codigo);
    public void setSala(String sala);
    public void setHorario(String horario);
    public void setDisciplina(Disciplina disciplina);
}
