package net.godaa.SpringSecurity.repositories;

import net.godaa.SpringSecurity.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
    @Override
    <S extends Role> S save(S entity);
}
