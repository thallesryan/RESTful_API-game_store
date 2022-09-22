package io.github.thallesryan.game_store.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.github.thallesryan.game_store.domain.enums.RoleEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor
public class UserModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	@Column(unique = true)
	private String email;
	
	private String password;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "person_roles")
	private Set<Integer> roles = new HashSet<>();
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dt = LocalDate.now();
	
	public Set<RoleEnum> getRoles() {
		return roles.stream().map(x -> RoleEnum.toEnum(x)).collect(Collectors.toSet());
	}

	public UserModel(Integer id, String name, String email, String password, Set<Integer> roles) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}
	
	

}
