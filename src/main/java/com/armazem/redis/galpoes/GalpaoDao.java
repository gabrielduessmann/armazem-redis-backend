package com.armazem.redis.galpoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public class GalpaoDao {

    public static final String HASH_KEY = "Galpao";
    @Autowired
    private RedisTemplate template;

    public void save(Galpao galpao){
        template.opsForHash().put(HASH_KEY, galpao.getGalpaoId(), galpao);
    }

    public List<Galpao> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public Galpao findById(UUID id){
        return (Galpao) template.opsForHash().get(HASH_KEY,id);
    }


    public void delete(UUID id){
         template.opsForHash().delete(HASH_KEY,id);
    }
}
