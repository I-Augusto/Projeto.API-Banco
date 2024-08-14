package me.study.apiBanco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.study.apiBanco.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
