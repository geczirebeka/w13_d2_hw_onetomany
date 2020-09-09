package com.codeclan.example.onetomany;

import com.codeclan.example.onetomany.models.Folder;
import com.codeclan.example.onetomany.models.User;
import com.codeclan.example.onetomany.repositories.FileRepository;
import com.codeclan.example.onetomany.repositories.FolderRepository;
import com.codeclan.example.onetomany.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class OnetomanyApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	FileRepository fileRepository;

	@Autowired
	FolderRepository folderRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createUserAndFolder() {
		User user = new User("George");
		userRepository.save(user);

		Folder photos = new Folder("Photos", user);
		folderRepository.save(photos);
	}

}
