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
public class EndpointRoleKey implements Serializable {

    /**
     * Serial Version UID
     */
    private static final long serialVersionUID = 6888650746834033671L;

    /**
	 * coEndpoint
	 *
	 */
	@Column(name = "co_endpoint")
	private Integer coEndpoint;

	/**
	 * coRole
	 *
	 */
	@Column(name = "co_role")
	private String coRole;

	//sonar
}
