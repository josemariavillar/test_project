package com.project.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.List;

/**
 * Entity Endpoint
 *
 */
@Entity
@Table(name = "api_endpoint", indexes = @Index(columnList = "co_api, co_path, co_verb"))
@Data
@Builder
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Endpoint {

	/**
	 * coEndpoint
	 *
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "co_endpoint", length = 15, nullable = false)
	private Integer coEndpoint;

	/**
	 * coApi
	 *
	 */
	@Column(name = "co_api", length = 256)
	private String coApi;
	
	/**
     * coPath
     *
     */
    @Column(name = "co_path", length = 1024)
    private String coPath;
    
    /**
     * coVerb
     *
     */
    @Column(name = "co_verb", length = 7)
    private String coVerb;

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
	@OneToMany(mappedBy = "endpoint")
	private List<EndpointRole> mappings;

	/**
	 * Constructor 
	 * 
	 * @param coEndpoint coEndpoint
	 * @param coApi coApi
	 * @param coPath coPath
	 * @param coVerb coVerb
	 * @param tsDelete tsDelete
	 * @param coUserModification coUserModification
	 * @param tsModification tsModification
	 * @param mappings mappings
	 */
	public Endpoint(Integer coEndpoint, String coApi, String coPath, String coVerb, Timestamp tsDelete,
                    String coUserModification, Timestamp tsModification,
                    List<EndpointRole> mappings) {
		this.coEndpoint = coEndpoint;
		this.coApi = coApi;
		this.coPath = coPath;
		this.coVerb = coVerb;
		this.tsDelete = tsDelete == null ? null : new Timestamp(tsDelete.getTime());
		this.coUserModification = coUserModification;
		this.tsModification = tsModification == null ? null
				: new Timestamp(tsModification.getTime());
		this.mappings = mappings;
	}

	/**
	 * Builder class
	 *
	 */
	public static class EndpointBuilder {
		/**
		 * tsDelete
		 * 
		 * @param tsDelete tsDelete
		 * @return RoleBuilder
		 */
		public EndpointBuilder tsDelete(Timestamp tsDelete) {
			this.tsDelete = tsDelete == null ? null : new Timestamp(tsDelete.getTime());
			return this;
		}

		/**
		 * tsModification
		 * 
		 * @param tsModification tsModification
		 * @return RoleBuilder
		 */
		public EndpointBuilder tsModification(Timestamp tsModification) {
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
