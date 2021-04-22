package com.yunli.web.repositories;

import com.yunli.bigdata.dsep.service.orm.authentication.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


/**
 * @author wei
 */
@Repository
public interface UserRepositoryForResource extends JpaRepository<User, String> {
  Set<User> findAllByIdIn(List<String> ids);
}
