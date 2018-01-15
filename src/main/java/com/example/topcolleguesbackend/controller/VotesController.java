package com.example.topcolleguesbackend.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.topcolleguesbackend.entity.Vote;
import com.example.topcolleguesbackend.repository.VoteRepository;

/**
 * Controller pour l'api votes
 * @author Sandra Le Thiec
 *
 */
@RestController
@RequestMapping("/votes")
public class VotesController {
	@Autowired private VoteRepository voteRepository;
	
	@GetMapping
	public List<Vote> getVotes(@RequestParam("since") String vote_id) {
		if(vote_id != "" ) {
			return this.voteRepository.findAll().stream().filter(v -> v.getId() >= Integer.valueOf(vote_id)).collect(Collectors.toList());
		}
		return this.voteRepository.findAll();
	}

}
