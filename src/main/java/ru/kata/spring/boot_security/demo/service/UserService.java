package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repository.UserRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface UserService extends UserDetailsService {

    public User findByUsername(String username);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    public Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles);

    public Optional<User> fineOne(int id);

    public void saveUser(User user);

    public void deleteUser(int id);

    public void update(int id, User updatedUser);

    public List<User> allUsers();
}
