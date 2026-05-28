package ro.skincare.skincare_analyzer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.skincare.skincare_analyzer.model.RutinaProdus;

@Repository
public interface RutinaProdusRepository extends JpaRepository<RutinaProdus, Long> {
}
