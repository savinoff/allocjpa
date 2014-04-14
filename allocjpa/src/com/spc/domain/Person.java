package com.spc.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;
import java.util.Set;


@Entity
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PERSON_ID_GENERATOR", sequenceName="SEQ_PERSONS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSON_ID_GENERATOR")
	private Long id;

	private String firstname;

	private String lastname;

	private String phonenumber;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="boss_id")
	private Person person;

	//bi-directional many-to-one association to Person
	@OneToMany(mappedBy="person")
	private List<Person> persons;

	//bi-directional many-to-one association to PersonAdress
//	@OneToMany(mappedBy="person")
//	private List<PersonAdress> personAdresses;
	
	@ElementCollection
    private Set<Adress> adresses; 

	public Person() {
	}
	
    public Set<Adress> getAdresses() {
		return adresses;
	}

	public void setAdresses(Set<Adress> adresses) {
		this.adresses = adresses;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhonenumber() {
		return this.phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public Person addPerson(Person person) {
		getPersons().add(person);
		person.setPerson(this);

		return person;
	}

	public Person removePerson(Person person) {
		getPersons().remove(person);
		person.setPerson(null);

		return person;
	}


}