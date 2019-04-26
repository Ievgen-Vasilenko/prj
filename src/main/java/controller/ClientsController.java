package controller;

import models.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.ClientService;

import java.util.List;

@RequestMapping("/clients")
@Controller
public class ClientsController {

    private ClientService clientService = new ClientService();

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model uiModel) {
        List<Client> clients = clientService.findAllClients();
        uiModel.addAttribute("clients", clients);
        return "clients/list";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String clientsWorks(
            @RequestParam(value = "button") String button,
            @RequestParam(value = "id") String id,
            @RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "lastName") String lastName
    ) {
        Client client = new Client();

        if (button.equals("Обновить")) {
            client = clientService.findClient(Integer.parseInt(id));
            client.setFirstName(firstName);
            client.setLastName(lastName);
            clientService.updateClient(client);
        }

        if (button.equals("Удалить")) {
            client = clientService.findClient(Integer.parseInt(id));
            clientService.deleteClient(client);
        }

        if (button.equals("Добавить")) {
            client.setFirstName(firstName);
            client.setLastName(lastName);
            clientService.saveClient(client);
        }
        return "redirect:/clients";
    }
}
