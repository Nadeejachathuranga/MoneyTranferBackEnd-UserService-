package com.EBanking_UserServices.UserServices.EBanking.repo;

import com.EBanking_UserServices.UserServices.EBanking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,String> {
    @Query(value = " SELECT user_id FROM user ORDER BY user_id DESC LIMIT 1", nativeQuery = true)
    public String gettingLastId();
}
