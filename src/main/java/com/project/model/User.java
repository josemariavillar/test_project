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
 * Entity User
 *
 */
@Entity
@Table(name = "api_user")
@Data
@Builder
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class User {

	/**
	 * coUser
	 *
	 */
	@Id
	@Column(name = "co_user", length = 1024, nullable = false)
	private String coUser;

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
	@OneToMany(mappedBy = "user")
	private List<UserRole> associations;

	/**
	 * Constructor
	 * 
	 * @param coUser coUser
	 * @param tsDelete tsDelete
	 * @param coUserModification coUserModification
	 * @param tsModification tsModification
	 * @param associations associations
	 */
	public User(String coUser, Timestamp tsDelete,
                String coUserModification, Timestamp tsModification,
                List<UserRole> associations) {
		this.coUser = coUser;
		this.tsDelete = tsDelete == null ? null : new Timestamp(tsDelete.getTime());
		this.coUserModification = coUserModification;
		this.tsModification = tsModification == null ? null
				: new Timestamp(tsModification.getTime());
		this.associations = associations;
	}

	/**
	 * Builder class
	 *
	 */
	public static class UserBuilder {
		/**
		 * tsDelete
		 * 
		 * @param tsDelete tsDelete
		 * @return UserBuilder
		 */
		public UserBuilder tsDelete(Timestamp tsDelete) {
			this.tsDelete = tsDelete == null ? null : new Timestamp(tsDelete.getTime());
			return this;
		}

		/**
		 * tsModification
		 * 
		 * @param tsModification tsModification
		 * @return UserBuilder
		 */
		public UserBuilder tsModification(Timestamp tsModification) {
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
