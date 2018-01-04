package com.pablinchapin.backendninjaws.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pablinchapin.backendninjaws.entity.Contact;

@Repository("contactRepository")
public interface ContactRepository extends JpaRepository<Contact, Serializable>{

}
