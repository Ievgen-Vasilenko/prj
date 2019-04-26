package service;

import dao.ClientDao;
import models.Client;
import org.springframework.stereotype.Service;
import service.impl.IClientService;

import java.util.List;

@Service("IClientService")
public class ClientService implements IClientService {

    private ClientDao clientDAO = new ClientDao();

    public ClientService() {
    }

    @Override
    public Client findClient(int id) {
        return clientDAO.findById(id);
    }

    @Override
    public void saveClient(Client client) {
        clientDAO.save(client);
    }

    @Override
    public void deleteClient(Client client) {
        clientDAO.delete(client);
    }

    @Override
    public void updateClient(Client client) {
        clientDAO.update(client);
    }

    @Override
    public List<Client> findAllClients() {
        return clientDAO.findAll();
    }

}
