package service.impl;

import models.Client;

import java.util.List;

public interface IClientService {

    Client findClient(int id);

    void saveClient(Client client);

    void deleteClient(Client client);

    void updateClient(Client client);

    List<Client> findAllClients();
}
