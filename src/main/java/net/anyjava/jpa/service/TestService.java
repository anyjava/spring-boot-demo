package net.anyjava.jpa.service;

import net.anyjava.jpa.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    public void selectMember() {
    }
}
