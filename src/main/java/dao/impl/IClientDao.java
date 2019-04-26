package dao.impl;

import models.Client;

import java.util.List;

public interface IClientDao {

    Client findById(int id);

    void save(Client client);

    void update(Client client);

    void delete(Client client);

    List<Client> findAll();
}
