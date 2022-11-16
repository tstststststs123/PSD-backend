package com.swift.ihikerz.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.swift.ihikerz.models.Hiker;

@Repository
public interface HikerRepository extends MongoRepository<Hiker, String>{

}
