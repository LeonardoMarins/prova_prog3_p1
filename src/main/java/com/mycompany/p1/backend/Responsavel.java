/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.p1.backend;

/**
 *
 * @author marin
 */
public class Responsavel extends ContatoTelEmail {

   protected static Long idResponsavel = 0l;
   protected String nomeResponsavel;
    private ContatoTelEmail contato;

    public Responsavel(String nomeResponsavel, ContatoTelEmail contato) {
        super(contato.telefone, contato.celular, contato.email);
        this.contato = contato;
        this.nomeResponsavel = nomeResponsavel;
        Responsavel.idResponsavel++;
    }
    
    public Long getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(Long idResponsavel) {
        Responsavel.idResponsavel = idResponsavel;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }
}