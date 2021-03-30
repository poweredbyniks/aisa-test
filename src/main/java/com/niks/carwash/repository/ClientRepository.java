package com.niks.carwash.repository;

import com.niks.carwash.entity.Client;
import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @NotNull
    List<Client> findClientsByFirstNameAndAndLastName(@NotNull final String name);

}
