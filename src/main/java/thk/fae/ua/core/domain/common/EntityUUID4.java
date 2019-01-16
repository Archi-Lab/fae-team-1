package thk.fae.ua.core.domain.common;

import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.hateoas.Identifiable;

@MappedSuperclass
public class EntityUUID4 implements Identifiable<UUID> {

	@JsonIgnore
	@Id
	private UUID id;

	public EntityUUID4(final UUID id) {
		this.id = id;
	}

	public EntityUUID4() {
		this.id = UUID.randomUUID();
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || !(obj instanceof EntityUUID4)) {
			return false;
		}

		final EntityUUID4 other = (EntityUUID4) obj;
		final EqualsBuilder eb = new EqualsBuilder();

		eb.append(this.getId(), other.getId());

		return eb.isEquals();
	}

	@Override
	public int hashCode() {
		final HashCodeBuilder hcb = new HashCodeBuilder();

		hcb.append(this.getId());

		return hcb.toHashCode();
	}
}
