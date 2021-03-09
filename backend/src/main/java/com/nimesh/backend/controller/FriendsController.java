package com.nimesh.backend.controller;

import java.util.ArrayList;
import java.util.List;

import com.nimesh.backend.model.Friend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/twitter")
public class FriendsController {
    private List<Friend> friends;

    public FriendsController() {
        friends = new ArrayList<>();
        friends.add(new Friend("friend1", "friend1"));
        friends.add(new Friend("friend2", "friend2"));
        friends.add(new Friend("friend3", "friend3"));
        friends.add(new Friend("friend4", "friend4"));
        friends.add(new Friend("friend5", "friend5"));
    }

    @GetMapping("/")
    public List<Friend> list() {
        return friends;
    }

    @GetMapping("/{id}")
    public Friend get(@PathVariable String id) {
        return friends.stream().filter(f -> id.equals(f.getId())).findAny().orElse(null);
    }

}
