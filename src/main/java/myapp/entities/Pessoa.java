package myapp.entities;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany
    @JoinColumn(name = "id_pessoa")
    @Basic(fetch = FetchType.EAGER)
    private List<Cachorro> cachorros = new LinkedList<Cachorro>();

    public Pessoa() {
    }

    public Pessoa(Long id, String name) {
	this.id = id;
	this.name = name;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public List<Cachorro> getCachorros() {
	return cachorros;
    }

    public void setCachorros(List<Cachorro> cachorros) {
	this.cachorros = cachorros;
    }

}
