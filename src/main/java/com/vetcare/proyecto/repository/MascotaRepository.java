package com.vetcare.proyecto.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.vetcare.proyecto.entities.Mascota;

@Repository
public class MascotaRepository {
    private Map<Integer , Mascota> MascotasMap = new HashMap<>();

    public MascotaRepository(){
        MascotasMap.put(1, new Mascota("Patas","persa" , 2, 12.7, "Cojo", 0));
        MascotasMap.put(2, new Mascota("Pecas","kohana" , 1, 10.2, "ciego", 1));
        MascotasMap.put(3, new Mascota("Candy","Elfo" , 5, 25.6, "peritonitis", 2));
        MascotasMap.put(4, new Mascota("Turron","Bambino" , 4, 15.6, "Otitis", 3));
        MascotasMap.put(5, new Mascota("Juanor","Ucraniano" , 2, 23.7, "Alergias", 4));
    }

    public Mascota SeracrhById(int id){
        return MascotasMap.get(id);
    } 

    public Collection<Mascota> findAll(){
        return MascotasMap.values();
    }

    public void add(Mascota mascota){
        int tam = MascotasMap.size();
        int lastId = MascotasMap.get(tam).getID();
        mascota.setID(lastId+1);
        MascotasMap.put(lastId+1, mascota);
    }

    public void removeById(int id){
        MascotasMap.remove(id);
    }

    public void updateById(Mascota mascota){
        MascotasMap.put(mascota.getID(), mascota);
    }
    
}
