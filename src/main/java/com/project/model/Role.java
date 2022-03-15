package com.project.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.List;

/**
 * Entity Role
 *
 */
@Entity
@Table(name = "api_role")
@Data
@Builder
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Role {

	/**
	 * coRole
	 *
	 */
	@Id
	@Column(name = "co_role", length = 256, nullable = false)
	private String coRole;

	/**
	 * dsRole
	 *
	 */
	@Column(name = "ds_role", length = 256)
	private String dsRole;

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
	 * associations
	 *
	 */
	@OneToMany(mappedBy = "role")
	private List<UserRole> associations;
	
	/**
     * mappings
     *
     */
    @OneToMany(mappedBy = "role")
    private List<EndpointRole> mappings;

	/**
	 * Constructor
	 * 
	 * @param coRole coRole
	 * @param dsRole dsRole
	 * @param tsDelete tsDelete
	 * @param coUserModification coUserModification
	 * @param tsModification tsModification
	 * @param associations associations
	 * @param mappings mappings
	 */
	public Role(String coRole, String dsRole, Timestamp tsDelete,
                String coUserModification, Timestamp tsModification,
                List<UserRole> associations, List<EndpointRole> mappings) {
		this.coRole = coRole;
		this.dsRole = dsRole;
		this.tsDelete = tsDelete == null ? null : new Timestamp(tsDelete.getTime());
		this.coUserModification = coUserModification;
		this.tsModification = tsModification == null ? null
				: new Timestamp(tsModification.getTime());
		this.associations = associations;
		this.mappings = mappings;
	}

	/**
	 * Builder class
	 *
	 */
	public static class RoleBuilder {
		/**
		 * tsDelete
		 * 
		 * @param tsDelete tsDelete
		 * @return RoleBuilder
		 */
		public RoleBuilder tsDelete(Timestamp tsDelete) {
			this.tsDelete = tsDelete == null ? null : new Timestamp(tsDelete.getTime());
			return this;
		}

		/**
		 * tsModification
		 * 
		 * @param tsModification tsModification
		 * @return RoleBuilder
		 */
		public RoleBuilder tsModification(Timestamp tsModification) {
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
