package com.codeclan.example.onetomany.components;

import com.codeclan.example.onetomany.models.File;
import com.codeclan.example.onetomany.models.Folder;
import com.codeclan.example.onetomany.models.User;
import com.codeclan.example.onetomany.repositories.FileRepository;
import com.codeclan.example.onetomany.repositories.FolderRepository;
import com.codeclan.example.onetomany.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    public DataLoader() {}

    public void run(ApplicationArguments args) {
        User joana = new User("Joana");
        userRepository.save(joana);
        User moa = new User("Moa");
        userRepository.save(moa);
        User john = new User("John");
        userRepository.save(john);
        User neil = new User("Neil");
        userRepository.save(neil);
        User nana = new User("Nana");
        userRepository.save(nana);
        Folder documents = new Folder("To Do", joana);
        folderRepository.save(documents);
        Folder photos = new Folder("Photos", moa);
        folderRepository.save(photos);
        Folder important = new Folder("Important", nana);
        folderRepository.save(important);
        File document1 = new File("Shopping list", "doc", 20, documents);
        fileRepository.save(document1);
        File document2 = new File("licence copy", "pdf", 500, important);
        fileRepository.save(document2);
        neil.addFolder(important);
        john.addFolder(documents);
        photos.addFile(document1);
        important.addFile(document2);
    }
}
