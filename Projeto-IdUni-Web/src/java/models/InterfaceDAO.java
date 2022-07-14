/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Ramos
 */
public interface InterfaceDAO {
    public boolean adicionar(Object objeto);
    public boolean atualizar(Object objeto);
    public boolean remover(int id);
    public Object buscar(int id);
}
