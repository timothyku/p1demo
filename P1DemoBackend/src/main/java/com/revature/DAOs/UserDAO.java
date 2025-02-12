package com.revature.DAOs;

import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Extending JpaRepository gives us access to a bunch of basic CRUD methods. We don't have to write them!
//This includes find all, find by id, insert, update, delete

//Jpa Repository takes 2 generics:
    //1. The entity we're working with (User in this case)
    //2. The type of the primary key (Integer in this case)
@Repository // 1 of the 4 stereotype annotations (make a class a bean)
public interface UserDAO extends JpaRepository<User, Integer> {


}
