package com.groupeisi.companyspringmvc.service;

import com.groupeisi.companyspringmvc.dao.AccountUserDao;
import com.groupeisi.companyspringmvc.dao.IAccountUserDao;
import com.groupeisi.companyspringmvc.dto.AccountUserDto;
import com.groupeisi.companyspringmvc.entities.AccountUserEntity;
import com.groupeisi.companyspringmvc.mapper.AccountUserMapper;

import java.util.List;
import java.util.Optional;

public class AccountUserService implements IAccountUserService{

    private IAccountUserDao accountUserDao = new AccountUserDao();

    @Override
    public Optional<AccountUserDto> login(String email, String password) {

        if(email.isBlank() || password.isBlank()) {
            return Optional.empty();
        }
        else {
            return testLogin(email, password);
        }
    }

    private Optional<AccountUserDto> testLogin(String email, String password) {

        return	accountUserDao.login(email, password)
                .map(user -> Optional.of(AccountUserMapper.toAccountUserDto(user)))
                .orElse(Optional.empty());
    }

    @Override
    public Optional<List<AccountUserDto>> findAll() {
        List<AccountUserEntity> accountUserEntityList = accountUserDao.list(new AccountUserEntity());

        return Optional.of(AccountUserMapper.toListAccountUserDto(accountUserEntityList));
    }

    public void setAccountUserDao(IAccountUserDao accountUserDao) {
        this.accountUserDao = accountUserDao;
    }

    @Override
    public boolean save(AccountUserDto accountUserDto) {
        return accountUserDao.save(AccountUserMapper.toAccountUserEntity(accountUserDto));
    }
}
