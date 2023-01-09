package com.owaiss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.owaiss.model.Wallet;

@Repository
public interface WalletRepo extends JpaRepository<Wallet, Integer>{

}
