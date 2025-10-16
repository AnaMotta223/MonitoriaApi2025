package org.serratec.exercicios_aula06.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O logradouro é obrigatório")
    @Size(min = 10, max = 150, message = "O logradouro deve ter entre {min} e {max} caracteres")
    @Column(nullable = false, length = 150)
    private String logradouro;

    @NotBlank(message = "O bairro é obrigatório")
    @Size(min = 2, max = 100, message = "O bairro deve ter entre {min} e {max} caracteres")
    @Column(nullable = false, length = 100)
    private String bairro;

    @Size(min = 2, max = 100, message = "O complemento deve ter entre {min} e {max} caracteres")
    @Column(nullable = false, length = 100)
    private String complemento;
    
    public Endereco() {
    	
    }
    
	public Endereco(Long id, String logradouro, String bairro, String complemento) {
		this.id = id;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.complemento = complemento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
}