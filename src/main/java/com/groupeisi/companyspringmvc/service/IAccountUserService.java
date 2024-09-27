package com.groupeisi.companyspringmvc.service;

import com.groupeisi.companyspringmvc.dto.AccountUserDto;

import java.util.List;
import java.util.Optional;

public interface IAccountUserService {
    Optional<AccountUserDto> login(String email, String password);

    Optional<List<AccountUserDto>> findAll();

    boolean save(AccountUserDto accountUserDto);
}
