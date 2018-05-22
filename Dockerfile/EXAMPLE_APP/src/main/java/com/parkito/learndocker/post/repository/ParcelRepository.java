package com.parkito.learndocker.post.repository;

import com.parkito.learndocker.post.entity.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Artem Karnov @date 11/6/2017.
 * artem.karnov@t-systems.com
 */
@Repository
public interface ParcelRepository extends JpaRepository<Parcel, Long> {

    Parcel findByNumber(long number);

    @Query("select p from Parcel p where p.userFrom = :email or p.userFrom = :email")
    List<Parcel> findAllParcelsForUser(@Param(value = "email") String email);
}
