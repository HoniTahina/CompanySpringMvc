package com.groupeisi.companyspringmvc.dao;

import com.groupeisi.companyspringmvc.entities.AccountUserEntity;

import java.util.Optional;

public interface IAccountUserDao extends Repository<AccountUserEntity>{
    Optional<AccountUserEntity> login(String email, String password);
}
