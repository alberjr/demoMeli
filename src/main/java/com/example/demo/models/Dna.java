package com.example.demo.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;

import com.example.demo.models.input.DnaRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "dnas")
@Proxy(lazy = false)
@JsonInclude(Include.NON_NULL)
//@TypeDef(name = "json", typeClass = JsonType.class)
@JsonIgnoreProperties(ignoreUnknown = true, value = { "hibernateLazyInitializer", "handler" })
public class Dna implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", length = 11, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Type(type = "json")
	@Column(name = "title", columnDefinition = "jsonb", nullable = false)
	private DnaRequest properties;
	

	@Column(name = "mutant", nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean mutant;

	@Column(name = "createdate", nullable = false)
	private LocalDateTime createDate;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the properties
	 */
	@JsonIgnore
	public DnaRequest getProperties() {
		return properties;
	}

	/**
	 * @param properties the properties to set
	 */
	public void setProperties(DnaRequest properties) {
		this.properties = properties;
	}

	/**
	 * @return the mutant
	 */
	public boolean isMutant() {
		return mutant;
	}

	/**
	 * @param mutant the mutant to set
	 */
	public void setMutant(boolean mutant) {
		this.mutant = mutant;
	}

	/**
	 * @return the createDate
	 */
	public LocalDateTime getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

}
