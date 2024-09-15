package com.example.Models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Data
@Builder
@Entity
@Table(
    name = "user",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {

  @Id @GeneratedValue
  Integer id;

  @Basic
  @Column(nullable = false)
  String username;

  String email;
  String password;

  @Enumerated(EnumType.STRING)
  ERole role;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority((role.name())));
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
