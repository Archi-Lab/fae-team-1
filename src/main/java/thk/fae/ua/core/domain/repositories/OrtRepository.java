package thk.fae.ua.core.domain.repositories;

import thk.fae.ua.core.domain.entities.Ort;

import java.util.Optional;
import java.util.UUID;

public interface OrtRepository {
	Optional<Ort> findById(UUID id);
	Iterable<Ort> findByDvpId(UUID dvpId);
	Ort save(final Ort ort);
	void deleteById(UUID id);
	boolean existsById(UUID id);
}
