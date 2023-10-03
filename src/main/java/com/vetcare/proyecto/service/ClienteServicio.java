package com.vetcare.proyecto.service;



import java.util.List;

import com.vetcare.proyecto.entities.Cliente;



public interface ClienteServicio {
    
   // Obtener un cliente por su ID
   public Cliente GetById(Long id);

   // Obtener todos los clientes
   public List<Cliente> GetAll();

   // Agregar un nuevo cliente
   public void addCliente(Cliente cliente);

   // Eliminar un cliente por su ID
   public void removerCliente(Long id);

   // Actualizar la información de un cliente
   public void updateCliente(Cliente cliente);

   // Obtener un cliente por su número de cédula
   public Cliente getByCedula(String cedula);

   // Eliminar un cliente por su número de cédula
   public void removerClienteByCedula(String cedula);
}
