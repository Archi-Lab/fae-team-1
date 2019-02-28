package thk.fae.ua.persistence.ort;

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
	public Iterable<Ort> findByDvpId(UUID dvpId) {
		return this.dbBase.findAllByDemenziellVeraendertePerson_Id(dvpId);
	}

	@Override
	public Ort save(final Ort ort) {
		return this.dbBase.save(ort);
	}

	@Override
	public void deleteById(UUID id) { this.dbBase.deleteById(id); }

	@Override
	public boolean existsById(UUID id) { return this.existsById(id); }

}
