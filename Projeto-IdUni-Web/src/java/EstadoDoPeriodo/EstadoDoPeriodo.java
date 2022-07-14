/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.EstadoDoPeriodo;

/**
 *
 * @author Gabriel Vieira de Carvalho, Matrícula: 119083048
 */


// A classe de estado base declara métodos que todos os estados
// concretos devem implementar e também fornece uma referência
// anterior ao objeto de contexto associado com o estado.
// Estados podem usar a referência anterior para realizar a
// transição contexto para outro estado.

abstract class EstadoDoPeriodo {
    
    PeriodoDAO periodoAtual = new PeriodoDAO();

    public EstadoDoPeriodo() {
        
    }

    public abstract void FazerInscricao();
    public abstract void LancarNotas();  
    
}
