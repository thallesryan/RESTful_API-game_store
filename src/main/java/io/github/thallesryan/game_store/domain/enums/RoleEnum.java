package io.github.thallesryan.game_store.domain.enums;

public enum RoleEnum {

	ADMIN(0, "ROLE_ADMIN"), CLIENTE(1, "ROLE_CLIENTE"), TECNICO(2, "ROLE_TECNICO");
	
	private Integer codigo;
	private String descricao;
	
	private RoleEnum(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static RoleEnum toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(RoleEnum x : RoleEnum.values()) {
			if(cod.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Perfil inválido");
	}
}
