package com.geekster.repository;

import com.geekster.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStatusRepository extends JpaRepository<Status,Integer> {
}
