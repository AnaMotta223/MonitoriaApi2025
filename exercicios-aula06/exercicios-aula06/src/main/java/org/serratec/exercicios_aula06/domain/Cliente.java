package org.serratec.exercicios_aula06.domain;

import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Preencha o campo nome")
	@Size(min = 3, max = 60, message = "O nome deve ter entre {min} e {max} caracteres")
	@Column(name = "nome", nullable = false, length = 60)
	private String nome;

	@NotBlank(message = "Preencha o campo CPF")
	@CPF(message = "Insira um CPF válido")
	@Column(name = "cpf", nullable = false, unique = true, length = 11)
	private String cpf;

	// Por padrao, a anotacao email valida emails simples, mas podemos melhorar essa
	// verificacao colocando um padrao (regex)
	// assim conseguimos ser mais restritos no que o email pode ou nao ter:
	// a flag case insensitive permite que possam ser usadas letras maiusculas ou
	// minusculas
	@NotBlank(message = "Preencha o campo email")
	@Email(regexp = "[a-z0-9.-_]+@[a-z._]+\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Insira um email válido")
	@Column(name = "email", nullable = false, unique = true, length = 50)
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_endereco")
	@Valid
	private Endereco endereco;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	@Valid
	private List<Pedido> pedidos;

	public Cliente() {
	}

	public Cliente(Long id, String nome, String cpf, String email, Endereco endereco, List<Pedido> pedidos) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.endereco = endereco;
		this.pedidos = pedidos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
}
