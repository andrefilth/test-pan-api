package com.andre.client.pan.endpoint.response;


import com.andre.client.pan.model.Customer;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.ZonedDateTime;

public class CustomerResponse {

	private String nome;

	private String cpf;

	private AddressResponse addressResponse;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private ZonedDateTime createdAt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private ZonedDateTime updatedAt;

	public CustomerResponse(Customer customer) {
		this.nome = customer.getName();
		this.cpf = customer.getDocument();
		this.createdAt = customer.getCreatedAt();
		this.updatedAt = customer.getUpdatedAt();
	}
	
	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public ZonedDateTime getCreatedAt() {
		return createdAt;
	}

	public ZonedDateTime getUpdatedAt() {
		return updatedAt;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
				.append("nome", nome)
				.append("cpf", cpf)
				.append("createdAt", createdAt)
				.append("updatedAt", updatedAt)
				.build();
	}
}
