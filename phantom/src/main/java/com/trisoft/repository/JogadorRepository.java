package com.trisoft.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.trisoft.model.Jogador;

public class JogadorRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager manager;

	public void salvar(Jogador jogador) {
		manager.merge(jogador);
	}

}
