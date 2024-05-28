package com.example.truecaller.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.example.truecaller.models.common.Buniness;
import com.example.truecaller.models.common.Contact;
import com.example.truecaller.models.common.PersonalInfo;
import com.example.truecaller.models.common.SocialInfo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
    private String id;
    private String userName;
    private String password;
    private LocalDateTime lastAccessed;
    private Tags tag;
    private Contact contact;
    private PersonalInfo personalInfo;
    private SocialInfo socialInfo;
    private Buniness business;
    private UserCategory userCategory;
    private Map<String, User> contacts;
    private List<String> blockedContacts;
    // private Set<String> blockedSet;
    // private ContactTrie contactTrie;
}
