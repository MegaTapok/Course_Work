package com.alze.kurs.db.repository;

import com.alze.kurs.db.CollectedNews;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectedNewsRep extends CrudRepository<CollectedNews, Long> {
}
