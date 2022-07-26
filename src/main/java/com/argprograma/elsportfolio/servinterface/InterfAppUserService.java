package com.argprograma.elsportfolio.servinterface;

import com.argprograma.elsportfolio.model.AppUser;

import java.util.List;

public interface InterfAppUserService {

    List<AppUser> getAppUser();
    void saveAppUser (AppUser user);
    void deleteAppUser (Long id_user);
    AppUser findAppUser (Long id_user);
}
