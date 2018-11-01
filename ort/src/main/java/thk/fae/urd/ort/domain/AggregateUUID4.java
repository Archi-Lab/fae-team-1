package thk.fae.urd.ort.domain;

import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AggregateUUID4 {

	@Id
	// @Pattern(regexp = "[0-9a-fA-F]{8}-[0-9 a-fA-F]{4}-[0-9 a-fA-F]{4}-[0-9
	// a-fA-F]{4}-[0-9 a-fA-F]{12}", message = "Es muss eine gültige UUID Version 4
	// sein.")
	private UUID id;

	public AggregateUUID4(final UUID id) {
		this.id = id;
	}

	public AggregateUUID4() {
		this.id = UUID.randomUUID();
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

}
