package com.revature.GoGato.service;

import com.revature.GoGato.model.Likes;
import com.revature.GoGato.repository.LikesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikesService {
    //@Autowired would do this too I have just read somewhere this is more secure
    private final LikesRepository likesRepository;
    public LikesService(LikesRepository likesRepository){this.likesRepository = likesRepository;}//^
    // gets all likes so that it can display if a user has a previous interaction with
    // the post and prevent future issues where users can keep liking nad refreshing the posts
    public List<Likes> findAllLikes(){return likesRepository.findAll();}

    // creates the relationship between users and posts
    public Likes createLikes(Likes likes){return likesRepository.save(likes);}
    // Updates the like_status so that I can refrain from breaking 1NF
    public Likes updateLikes(Likes likes){return likesRepository.save(likes);}

    // this gets all likes by the user id
    // currently for future implementations if we get to adding likes on the user profile the logic is there
    public List<Likes> findAllLikesByUserId(Integer userid){return likesRepository.findAllLikesByuserid(userid);}

// this sends the request into the repository interface
    //So that I can get likes by the like id and update the like state by like id
    public Optional<Likes> getAllLikesByLikesId(Integer id){return likesRepository.findById(id);}


    public void deleteById(Integer id) {likesRepository.deleteById(id);
    }
}
