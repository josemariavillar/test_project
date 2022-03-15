package com.project.model.id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * Identifier UserRoleKey
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleKey implements Serializable {

	/**
	 * Serial Version UID
	 *
	 */
	private static final long serialVersionUID = -1580004597423670294L;

	/**
	 * coUser
	 *
	 */
	@Column(name = "co_user")
	private String coUser;

	/**
	 * coRole
	 *
	 */
	@Column(name = "co_role")
	private String coRole;

	//sonar
}
