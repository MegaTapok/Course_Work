package com.alze.kurs.db;

import com.alze.kurs.db.repository.CollectedNewsRep;
import com.alze.kurs.searchEngine.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DbService
{
    @Autowired
    private CollectedNewsRep cnRepo;

    public void bdCheck (){ if(cnRepo.findById(0L).isPresent()){cnRepo.deleteAll();}}
    public void bdUpdate(Search req)
    {
        for(int i = 0; i <req.getSearchFinal().getArticles().size(); i++)
        {
            cnRepo.save(new CollectedNews((long)i,req.getSearchFinal().getArticles().get(i).getUrl(),req.getSearchFinal().getArticles().get(i).getUrlToImage(),req.getSearchFinal().getArticles().get(i).getTitle()));
        }
    }
    public Iterable<CollectedNews> bdFindAll ()
    {
        return cnRepo.findAll();
    }

    public DbService() {

    }
}