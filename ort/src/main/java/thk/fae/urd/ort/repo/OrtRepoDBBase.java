package thk.fae.urd.ort.repo;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import thk.fae.urd.ort.domain.ort.Ort;

public interface OrtRepoDBBase extends CrudRepository<Ort, UUID> {
	Iterable<Ort> findAll();

	Optional<Ort> findById(UUID id);

	Iterable<Ort> findAllById(Iterable<UUID> id);

}
