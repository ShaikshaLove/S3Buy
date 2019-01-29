package io.ibm.app.repository;

import io.ibm.app.model.Rice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiceRepository extends JpaRepository<Rice,Integer> {
}
