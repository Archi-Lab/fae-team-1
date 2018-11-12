package thk.fae.urd.hl.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import thk.fae.urd.hl.model.HistorischeLokation;

@Repository
public interface HistorischeLokationenRepository extends CrudRepository<HistorischeLokation, Long> {
}
