package com.example.beneficiario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.beneficiario.model.Beneficiario;

public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long>{

}
