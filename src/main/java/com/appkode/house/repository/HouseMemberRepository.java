package com.appkode.house.repository;

import com.appkode.house.entity.HouseMember;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HouseMemberRepository extends CrudRepository<HouseMember, Long> {

    @Query("FROM HouseMember AS hm LEFT JOIN hm.house AS h WHERE h.id = ?1")
    List<HouseMember> findAllHouseMember(Long houseID);

    @Query("FROM HouseMember AS hm LEFT JOIN hm.house AS h WHERE h.id = ?1 and hm.isActiveMember=true")
    List<HouseMember> findAllActiveHouseMember(Long houseID);

    List<HouseMember> findAllActiveHouseMemberByUserId(Long userId);


    @Query("select hm.userId from HouseMember hm LEFT JOIN hm.house AS h WHERE h.id = ?1 and hm.isActiveMember=true")
    List<Long> findAllActiveUserIdsByHouseId(Long houseId);

    @Query("select h.id from HouseMember hm LEFT JOIN hm.house AS h WHERE hm.userId = ?1 and hm.isActiveMember=true")
    Long findHouseIdByUserId(Long userId);


}
