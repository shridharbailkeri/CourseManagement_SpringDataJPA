package com.aliboucoding.jpa.repositories;

import com.aliboucoding.jpa.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer>, JpaSpecificationExecutor<Author> {
    @Transactional
    List<Author> findByNamedQuery(@Param("age") int age);

    @Modifying
    @Transactional
    void updateByNamedQuery(@Param("age") int age);

    //@Query("update Author a set a.age = 22 where a.id = 1")
    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age where a.id = :id")
    int updateAuthor(int age, int id);

    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age")
    void updateAllAuthorsAges(int age);

    // select * from author where first_name = '' native query database first_name
    List<Author> findAllByFirstName(String f_name);

    List<Author> findAllByFirstNameIgnoreCase(String f_name);

    // select * from author where first_name = 'al'
    // select * from author where first_name like '%al%'
    List<Author> findAllByFirstNameContainingIgnoreCase(String f_name);

    // select * from author where first_name like 'al%'
    // % means anything
    List<Author> findAllByFirstNameStartsWithIgnoreCase(String f_name);

    // select * from author where first_name like '%al'

    List<Author> findAllByFirstNameEndsWithIgnoreCase(String f_name);

    // select * from author where first_name in ('ali', 'bou', 'coding') ali or bou or coding

    List<Author> findAllByFirstNameInIgnoreCase(List<String> f_names);

}
