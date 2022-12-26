package com.example.demo.domain;

import com.example.demo.domain.Hello;
import com.example.demo.domain.QHello;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class HelloTest {

    @Autowired
    EntityManager em;

    @Test
    public void query_dsl_test() throws Exception {

        Hello hello = new Hello();
        em.persist(hello);

        JPAQueryFactory query = new JPAQueryFactory(em);

        QHello qHello = QHello.hello;

        Hello result = query.selectFrom(qHello).fetchOne();

        Assertions.assertThat(result).isEqualTo(hello);
    }
}