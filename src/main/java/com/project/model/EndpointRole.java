package com.project.model;

import com.project.model.id.EndpointRoleKey;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * DTO Endpoint Role
 *
 */
@Entity
@Table(name = "api_endpoint_role_rel")
@Data
@Builder
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class EndpointRole {

	/**
	 * id
	 *
	 */
	@EmbeddedId
	private EndpointRoleKey id;

	/**
	 * Endpoint
	 *
	 */
	@ManyToOne
	@MapsId("coEndpoint")
	@JoinColumn(name = "co_endpoint")
	private Endpoint endpoint;

	/**
	 * role
	 *
	 */
	@ManyToOne
	@MapsId("coRole")
	@JoinColumn(name = "co_role")
	private Role role;

	/**
	 * tsDelete
	 *
	 */
	@Column(name = "ts_delete")
	private Timestamp tsDelete;

	/**
	 * coUserModification
	 *
	 */
	@Column(name = "co_user_modification", length = 10)
	private String coUserModification;

	/**
	 * tsModification
	 *
	 */
	@CreatedDate
	@Column(name = "ts_modification")
	private Timestamp tsModification;

	/**
	 * Constructor
	 * 
	 * @param id id
	 * @param endpoint endpoint
	 * @param role role
	 * @param tsDelete tsDelete
	 * @param coUserModification coUserModification
	 * @param tsModification tsModification
	 */
	public EndpointRole(EndpointRoleKey id, Endpoint endpoint, Role role,
                        Timestamp tsDelete, String coUserModification, Timestamp tsModification) {
		this.id = id;
		this.endpoint = endpoint;
		this.role = role;
		this.tsDelete = tsDelete == null ? null : new Timestamp(tsDelete.getTime());
		this.coUserModification = coUserModification;
		this.tsModification = tsModification == null ? null
				: new Timestamp(tsModification.getTime());
	}

	/**
	 * Builder class
	 *
	 */
	public static class EndpointRoleBuilder {
		/**
		 * tsDelete
		 * 
		 * @param tsDelete tsDelete
		 * @return UserRoleBuilder
		 */
		public EndpointRoleBuilder tsDelete(Timestamp tsDelete) {
			this.tsDelete = tsDelete == null ? null : new Timestamp(tsDelete.getTime());
			return this;
		}

		/**
		 * tsModification
		 * 
		 * @param tsModification tsModification
		 * @return UserRoleBuilder
		 */
		public EndpointRoleBuilder tsModification(Timestamp tsModification) {
			this.tsModification = tsModification == null ? null
					: new Timestamp(tsModification.getTime());
			return this;
		}
	}

	/**
	 * setTsDelete
	 * 
	 * @param tsDelete tsDelete
	 */
	public void setTsDelete(Timestamp tsDelete) {
		this.tsDelete = tsDelete == null ? null : new Timestamp(tsDelete.getTime());
	}

	/**
	 * setTsModification
	 * 
	 * @param tsModification tsModification
	 */
	public void setTsModification(Timestamp tsModification) {
		this.tsModification = tsModification == null ? null
				: new Timestamp(tsModification.getTime());
	}

	// sonar
	// sonar
	// sonar
	// sonar
	// sonar
	// sonar
	// sonar
	// sonar
}
