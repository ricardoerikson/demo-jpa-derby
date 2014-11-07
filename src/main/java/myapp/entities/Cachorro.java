package myapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cachorro {

    @Id
    @GeneratedValue
    private Long id;

    private Pessoa pessoa;

    public Cachorro(Long id, Pessoa pessoa) {
	super();
	this.id = id;
	this.pessoa = pessoa;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Pessoa getPessoa() {
	return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
	this.pessoa = pessoa;
    }

}
