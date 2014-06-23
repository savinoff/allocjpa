package com.spc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Tnved implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TNVED_ID_GENERATOR", sequenceName="SEQ_TNVED")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TNVED_ID_GENERATOR")
	private Long id;
	private String tncode;
	private String tnname;
	private String tnnote;
	
	public Tnved(){
	}
	
	public Long getId() {
		return id;
	}
	public String getTncode() {
		return tncode;
	}
	public String getTnname() {
		return tnname;
	}
	public String getTnnote() {
		return tnnote;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setTncode(String tncode) {
		this.tncode = tncode;
	}
	public void setTnname(String tnname) {
		this.tnname = tnname;
	}
	public void setTnnote(String tnnote) {
		this.tnnote = tnnote;
	}

}
