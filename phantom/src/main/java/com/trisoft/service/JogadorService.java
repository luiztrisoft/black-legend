package com.trisoft.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.trisoft.model.Jogador;
import com.trisoft.repository.JogadorRepository;
import com.trisoft.util.jpa.Transactional;

public class JogadorService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private JogadorRepository repository;

	@Transactional
	public void salvar(Jogador jogador) throws NegocioException {
		repository.salvar(jogador);
	}
}
