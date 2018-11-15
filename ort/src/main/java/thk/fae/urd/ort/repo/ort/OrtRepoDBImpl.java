package thk.fae.urd.ort.repo.ort;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import thk.fae.urd.ort.domain.ort.Ort;
import thk.fae.urd.ort.domain.ort.OrtRepo;

@Repository
public class OrtRepoDBImpl implements OrtRepo {

	private final OrtRepoDBBase dbBase;

	public OrtRepoDBImpl(final OrtRepoDBBase dbBase) {
		this.dbBase = dbBase;
	}

	@Override
	public Optional<Ort> findById(final UUID id) {
		return this.dbBase.findById(id);
	}

	@Override
	public Ort create(final Ort ort) {
		return this.dbBase.save(ort);
	}

}