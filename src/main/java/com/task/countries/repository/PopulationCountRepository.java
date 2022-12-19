package com.task.countries.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.countries.model.PopulationCount;
import com.task.countries.model.PopulationCountPK;

public interface PopulationCountRepository extends JpaRepository<PopulationCount, PopulationCountPK> {
}
