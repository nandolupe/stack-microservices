package org.acme.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.acme.model.Beneficiario;

@ApplicationScoped
public class BeneficiarioService {
	
	@Inject
    EntityManager em; 
	
	@Transactional
    public void createBeneficiario(Beneficiario beneficiario) {
        em.persist(beneficiario);
    }
	
    public List<Beneficiario> findAll() {
        return Beneficiario.listAll();
    }
	
}
