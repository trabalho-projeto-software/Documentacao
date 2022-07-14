/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.EstadoDoPeriodo;

/**
 *
 * @author Gabriel Vieira de Carvalho, Matrícula: 119083048
 */

//Padrão State

// Estado Referente ao Periodo em Andamento. Os métodos se adaptarão para permitir
// ou bloquear a ação escolhida.
public class PeriodoEmAndamento extends EstadoDoPeriodo{
    
    @Override
    public void FazerInscricao(){
        //Bloqueado, não faz nada.
    }
    
    @Override
    public void LancarNotas(){
        //Permitido, As notas serão lançadas
    }
}
