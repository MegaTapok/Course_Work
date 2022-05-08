package com.alze.kurs.db;

import com.alze.kurs.db.repository.CollectedNewsRep;
import com.alze.kurs.searchEngine.Search;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

// Сервис по взаимодействию с H2 базой данных

@Service
@AllArgsConstructor
public class DbService
{

    private CollectedNewsRep cnRepo;

    public void bdCheck (){ if(cnRepo.findById(0L).isPresent()){cnRepo.deleteAll();}}
    public void bdUpdate(Search req)
    {
        for(int i = 0; i <req.getSearchFinal().getArticles().size(); i++)
        {
            cnRepo.save(new CollectedNews((long)i,req.getSearchFinal().getArticles().get(i).getUrl(),req.getSearchFinal().getArticles().get(i).getUrlToImage(),req.getSearchFinal().getArticles().get(i).getTitle(),req.getSearchFinal().getArticles().get(i).getDescription()));
        }
    }
    public Iterable<CollectedNews> bdFindAll ()
    {
        return cnRepo.findAll();
    }


}