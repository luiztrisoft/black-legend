package com.trisoft.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.trisoft.model.Jogador;
import com.trisoft.model.Posicao;
import com.trisoft.repository.JogadorRepository;
import com.trisoft.util.jsf.FacesUtil;

import teste.util.print.Print;

@Named
@ViewScoped
public class CadastroJogadorMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private Jogador jogador;

	@Inject
	private JogadorRepository jogadorRepository;

	@PostConstruct
	public void iniciar() {
		if (this.jogador == null) {
			limpar();
		}
	}

	public Posicao[] getPosicoes() {
		return Posicao.values();
	}

	private void limpar() {
		this.jogador = new Jogador();
	}

	public void salvar() {
		try {
			jogadorRepository.salvar(jogador);
			FacesUtil.addInfoMessage("Jogador cadastrado com sucesso no sistema");
		} catch (Exception e) {
			FacesUtil.addErrorMessage("Erro ao cadastrar");
		}
		limpar();
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	@SuppressWarnings("unused")
	private void print() {
		Print.value("Nome", jogador.getNome());
		Print.value("Posição", jogador.getPosicao().getDescricao());
		Print.value("Salario", jogador.getSalario());
		Print.value("Transferencia", jogador.getValorTransferenciaMaisEncargos());
		Print.value("Duração do contrato", jogador.getDuracaoContrato());
		Print.value("Integrado", jogador.isIntegrado());
	}
	
	private void salvarJogadorDireto(){
		EntityManagerFactory f = Persistence.createEntityManagerFactory("PhantomPU");
		EntityManager manager = f.createEntityManager();

		EntityTransaction t = manager.getTransaction();
		t.begin();		
		manager.persist(jogador);
		t.commit();
	}

}
