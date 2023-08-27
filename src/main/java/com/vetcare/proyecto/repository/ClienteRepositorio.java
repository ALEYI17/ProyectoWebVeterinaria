package com.vetcare.proyecto.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.vetcare.proyecto.entities.Cliente;

@Repository
public class ClienteRepositorio {
    private Map<String,Cliente> ClienteMap = new HashMap<>();

    public ClienteRepositorio(){
        ClienteMap.put("1234", new Cliente("1234", "Pablo ruiz", "PR@gmail.com", "34566", new ArrayList<Integer>(List.of(1, 2, 3))));
        ClienteMap.put("456", new Cliente("456", "Adriana Barrero", "AB@gmail.com", "12677", new ArrayList<Integer>(List.of(1, 2, 3))));
        ClienteMap.put("6789", new Cliente("6789", "Camila Sabedra", "CS@gmail.com", "927459", new ArrayList<Integer>(List.of(1, 2, 3))));
        ClienteMap.put("90123", new Cliente("90123", "Uru Garcia", "UG@gmail.com", "83264", new ArrayList<Integer>(List.of(1, 2, 3))));
    }

    public Cliente SearchById(String id){
        return ClienteMap.get(id);
    }

    public Collection<Cliente> findAll(){
        return ClienteMap.values();
    }
    
    public void add(Cliente cliente){
        ClienteMap.put(cliente.getCedula(), cliente);
    }

    public void removeById(String id){
        ClienteMap.remove(id);
    }

    public void updateById(Cliente cliente){
        ClienteMap.put(cliente.getCedula(), cliente);
        
    }

    public Map<String, Cliente> getClienteMap() {
        return ClienteMap;
    }

    public void setClienteMap(Map<String, Cliente> clienteMap) {
        ClienteMap = clienteMap;
    }
    
}
