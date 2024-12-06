package com.ineutm.backend.evaluaciones.repository;

import com.ineutm.backend.evaluaciones.model.Account;
import com.ineutm.backend.evaluaciones.model.AccountDetail;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDetailRepository extends JpaRepository<AccountDetail,Long>{

    List<AccountDetail>  findByAccount(Account account);

  
}
