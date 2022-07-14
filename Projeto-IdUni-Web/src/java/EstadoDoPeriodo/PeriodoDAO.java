/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.EstadoDoPeriodo;
//Importa as funções necessárias para as funções de Observer
import java.util.Observable;

/**
 *
 * @author Gabriel Vieira de Carvalho, Matrícula: 119083048
 * @author Marllon Oliveira B. Guida, Matrícula: 214083115
 */

//Padrão State

// a classe PeriodoDAO age como um contexto. Ela também mantém
// uma referência para uma instância de uma das classes de
// estado que representa o atual estado do Periodo.

public class PeriodoDAO extends Observable {

    private EstadoDoPeriodo estadoPeriodo;
    private FaseDeInscricao faseDeInscricao;
    //Observable para notificar o aluno da mudança de estado do período
	private ObservableAluno estadoAtual;

    // O Periodo atual inicia na fase de Inscrição;
    public PeriodoDAO() {
        this.estadoPeriodo = new FaseDeInscricao();
        mudarEstado(faseDeInscricao);
    }
    
    // Outros objetos devem ser capazes de trocar o estado do Periodo
    public void mudarEstado(EstadoDoPeriodo estadoPeriodo) {
        this.estadoPeriodo = estadoPeriodo;
    }
    
    public EstadoDoPeriodo getEstadoPeriodo() {
        return estadoPeriodo;
    }
  
    // Alguns métodos delegam a execução para o estado ativo. (FazerInscricao, LancarNotas)
    public void FazerInscricao(){
        estadoPeriodo.FazerInscricao();
    }
        
    public void LancarNotas(){
        estadoPeriodo.LancarNotas();
    }
    
    // Padrão Comportamental Observer
    // Com esse método iremos notificar ao aluno toda vez que acontecer alguma mudança no estado do período

    public void notificaAluno(){
        this.estadoAtual = estadoPeriodo;

        setChanged();
        notifyObservers();
    }
}
