package com.argprograma.elsportfolio.controller;

import com.argprograma.elsportfolio.model.AppUser;
import com.argprograma.elsportfolio.servinterface.InterfAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppUserController {

    @Autowired
    private InterfAppUserService interfAppUserService;

    @GetMapping ("/user/traer")
    public List<AppUser> getAppUser() {

        return interfAppUserService.getAppUser();
    }

    @PostMapping ("/user/crear")
    public String createAppUser (@RequestBody AppUser user) {

        interfAppUserService.saveAppUser(user);
        return "El usuario fue creado correctamente";
    }

    @DeleteMapping ("/user/borrar/{id_user}")
    public String deleteAppUser (@PathVariable Long id_user) {

        interfAppUserService.deleteAppUser(id_user);
        return "El ususario fue eliminado correctamente";
    }

    @PutMapping ("user/editar/{id_user}")
    public AppUser editAppUser (@PathVariable Long id_user,
                                 @RequestParam ("username") String nuevoUsername,
                                 @RequestParam ("password") String nuevoPassword) {

        AppUser user = interfAppUserService.findAppUser(id_user);

        user.setUsername(nuevoUsername);
        user.setPassword(nuevoPassword);

        interfAppUserService.saveAppUser(user);

        return user;
    }
}
