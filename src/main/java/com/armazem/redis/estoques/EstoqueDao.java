package com.armazem.redis.estoques;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public class EstoqueDao {

    public static final String HASH_KEY = "Estoque";
    @Autowired
    private RedisTemplate template;

    public void save(Estoque estoque){
        template.opsForHash().put(HASH_KEY, estoque.getEstoqueId(), estoque);
    }

    public List<Estoque> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public Estoque findById(UUID id){
        return (Estoque) template.opsForHash().get(HASH_KEY, id);
    }


    public void delete(UUID id){
         template.opsForHash().delete(HASH_KEY,id);
    }
}
