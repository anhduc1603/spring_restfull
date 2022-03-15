package com.anhduc.hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anhduc.hello.model.Employee;
import com.anhduc.hello.model.Transcript;

@Repository
public interface TrancriptReponsitory extends JpaRepository<Transcript,Long> {

}
