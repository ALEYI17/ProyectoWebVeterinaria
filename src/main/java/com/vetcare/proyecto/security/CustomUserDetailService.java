package com.vetcare.proyecto.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vetcare.proyecto.entities.Admin;
import com.vetcare.proyecto.entities.Cliente;
import com.vetcare.proyecto.entities.Rol;
import com.vetcare.proyecto.entities.UserEntity;
import com.vetcare.proyecto.entities.Veterinario;
import com.vetcare.proyecto.repository.RolRepository;
import com.vetcare.proyecto.repository.UserEntityRepository;

@Service
public class CustomUserDetailService implements UserDetailsService{

    @Autowired
    UserEntityRepository userEntityRepository;

    @Autowired
    RolRepository rolRepository;

    @Autowired 
    PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        UserEntity userDB = userEntityRepository.findByUsername(username).orElseThrow(
            ()-> new UsernameNotFoundException("User not found")
        );

        UserDetails userDetails = new User(userDB.getUsername(),userDB.getPassword(),MapToGrantedAuthorities(userDB.getRoles()));

        return userDetails;
    }

    private Collection<GrantedAuthority> MapToGrantedAuthorities(List<Rol> roles){
        return roles.stream().map(role-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    public UserEntity ClienteToUser(Cliente cliente){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(cliente.getCedula());
        userEntity.setPassword(passwordEncoder.encode("123"));

        Rol rol = rolRepository.findByName("CLIENTE").get();
        userEntity.setRoles(List.of(rol));
        return userEntity;
    }

    public UserEntity VeterinarioToUser(Veterinario veterinario){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(veterinario.getCedula());
        userEntity.setPassword(passwordEncoder.encode(veterinario.getContrasena()));

        Rol rol = rolRepository.findByName("VETERINARIO").get();
        userEntity.setRoles(List.of(rol));
        return userEntity;
    }

    public UserEntity AdminToUser(Admin admin){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(admin.getUsuario());
        userEntity.setPassword(passwordEncoder.encode(admin.getContrasena()));

        Rol rol = rolRepository.findByName("ADMINISTRADOR").get();
        userEntity.setRoles(List.of(rol));
        return userEntity;
    }
    
}
