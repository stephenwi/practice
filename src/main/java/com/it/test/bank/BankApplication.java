package com.it.test.bank;

import com.it.test.bank.model.Photo;
import com.it.test.bank.repository.IPhotoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

@SpringBootApplication
public class BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}

	// CRUD in spring data jpa
	//1) CrudRepository<T, ID>
	//2) PagingAndSortingRepository<T, ID>
	//3) JpaRepository<T, ID>

	CommandLineRunner commandLineRunner(IPhotoRepository repository) {
		return args -> {
			boolean IS_CREATE = true;

			if (IS_CREATE) {
				for (int i=1; i<=26; i++) {
					Photo photo = new Photo();
					photo.setUrl("picture-url"+i);
					photo.setDescription("Creat new record for picture number: " +i);

					repository.save(photo);
				}
			}

			Iterable<Photo> photos = repository.findAll();
			Optional<Photo>photo = repository.findById(26);

			// Find photo by url
			Optional<Photo> photo1 = repository.findByUrl("picture-url26");
		};
	}

	//When we are a set variable
	//Photo photoToRemove = photos.getTags().iterator().next();
}
