package thk.fae.ua.persistence;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import thk.fae.ua.core.domain.entities.Ort;
import thk.fae.ua.core.domain.repositories.OrtRepository;

@Repository
public class OrtRepoDBImpl implements OrtRepository {

	private final OrtRepoDBBase dbBase;

	public OrtRepoDBImpl(final OrtRepoDBBase dbBase) {
		this.dbBase = dbBase;
	}

	@Override
	public Optional<Ort> findById(final UUID id) {
		return this.dbBase.findById(id);
	}

	@Override
	public Ort save(final Ort ort) {
		return this.dbBase.save(ort);
	}

}
