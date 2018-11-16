package thk.fae.urd.hl.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import thk.fae.urd.hl.models.HistorischeLokation;

@Repository
public interface HistorischeLokationenRepository extends CrudRepository<HistorischeLokation, Long> {
}
