package org.lessons.java.spring_mypizza.repository;

import org.lessons.java.spring_mypizza.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    
}
