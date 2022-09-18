package io.github.thallesryan.game_store.domain.enums;

public enum RoleEnum {

	ADMIN(0, "ROLE_ADMIN"), CLIENTE(1, "ROLE_CLIENTE");
	
	private Integer code;
	private String description;
	
	private RoleEnum(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
	
	public static RoleEnum toEnum(Integer code) {
		if(code == null) {
			return null;
		}
		
		for(RoleEnum x : RoleEnum.values()) {
			if(code.equals(x.getCode())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Perfil inválido");
	}
}
