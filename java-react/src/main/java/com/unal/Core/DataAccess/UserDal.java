package com.unal.Core.DataAccess;

import com.unal.Core.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDal extends JpaRepository<User,Integer> {

    User findByEmail(String email);

}
