package com.example.trades.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.trades.model.TradesEntity;

@Repository
public interface TradesRepository extends JpaRepository<TradesEntity, Long>{

}
