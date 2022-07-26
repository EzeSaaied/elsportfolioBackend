package com.argprograma.elsportfolio.service;

import com.argprograma.elsportfolio.model.AppUser;
import com.argprograma.elsportfolio.repository.AppUserRepository;
import com.argprograma.elsportfolio.servinterface.InterfAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService implements InterfAppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public List<AppUser> getAppUser() {

        List<AppUser> listaUsers = appUserRepository.findAll();
        return listaUsers;
    }

    @Override
    public void saveAppUser(AppUser user) {

        appUserRepository.save(user);
    }

    @Override
    public void deleteAppUser(Long id_user) {

        appUserRepository.deleteById(id_user);
    }

    @Override
    public AppUser findAppUser(Long id_user) {

        AppUser user = appUserRepository.findById(id_user).orElse(null);
        return user;
    }
}
