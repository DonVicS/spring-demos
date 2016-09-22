package org.victor.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.victor.boot.comments.Comment;
import org.victor.boot.comments.CommentRepository;
import org.victor.boot.section.Section;
import org.victor.boot.section.SectionRepository;
import org.victor.boot.topics.Topic;
import org.victor.boot.topics.TopicRepository;
import org.victor.boot.users.User;
import org.victor.boot.users.UserRepository;
import org.victor.boot.utils.Role;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demoComment(CommentRepository repository) {
    	return (args) -> {
    		repository.save(new Comment(1L, 1L, 1L, "1 Lalalalaa lalala  lalala  lalala  lalala ", null));
    		repository.save(new Comment(2L, 2L, 1L, "2 Lalalalaa lalala  lalala  lalala  lalala ", null));
    		repository.save(new Comment(3L, 6L, 1L, "3 Lalalalaa lalala  lalala  lalala  lalala ", null));
    		repository.save(new Comment(4L, 4L, 1L, "4 Lalalalaa lalala  lalala  lalala  lalala ", null));
    		repository.save(new Comment(5L, 10L, 1L, "5 Lalalalaa lalala  lalala  lalala  lalala ", null));
    		repository.save(new Comment(6L, 2L, 1L, "6 Lalalalaa lalala  lalala  lalala  lalala ", null));
    		repository.save(new Comment(7L, 7L, 1L, "7 Lalalalaa lalala  lalala  lalala  lalala ", null));
    		repository.save(new Comment(8L, 10L, 1L, "8 Lalalalaa lalala  lalala  lalala  lalala ", null));
    		repository.save(new Comment(9L, 3L, 1L, "9 Lalalalaa lalala  lalala  lalala  lalala ", null));
    		repository.save(new Comment(10L, 1L, 1L, "10 Lalalalaa lalala  lalala  lalala  lalala ", null));
    		repository.save(new Comment(11L, 7L, 1L, "11 Lalalalaa lalala  lalala  lalala  lalala ", null));
    		repository.save(new Comment(12L, 12L, 1L, "12 Lalalalaa lalala  lalala  lalala  lalala ", null));
    	};
    }
    
    @Bean
    public CommandLineRunner demoTopic(TopicRepository repository) {
    	return (args) -> {
    		repository.save(new Topic(1L, "sports", "Futbol 1", "Lalalala", "Lalalalaa lalala  lalala  lalala  lalala ", null));
    		repository.save(new Topic(2L, "history", "Lepanto 1", "Lalalala", "Lalalalaa lalala  lalala  lalala  lalala ", null));
    		repository.save(new Topic(3L, "tv", "Game of Thrones 1", "Lalalala", "Lalalalaa lalala  lalala  lalala  lalala ", null));
    		repository.save(new Topic(4L, "movies", "Avengers 1", "Lalalala", "Lalalalaa lalala  lalala  lalala  lalala ", null));
    		repository.save(new Topic(5L, "sports", "Futbol 2", "Lalalala", "Lalalalaa lalala  lalala  lalala  lalala ", null));
    		repository.save(new Topic(6L, "history", "Lepanto 2", "Lalalala", "Lalalalaa lalala  lalala  lalala  lalala ", null));
    		repository.save(new Topic(7L, "tv", "Game of Thrones 2", "Lalalala", "Lalalalaa lalala  lalala  lalala  lalala ", null));
    		repository.save(new Topic(8L, "movies", "Avengers 2", "Lalalala", "Lalalalaa lalala  lalala  lalala  lalala ", null));
    		repository.save(new Topic(9L, "sports", "Futbol 3", "Lalalala", "Lalalalaa lalala  lalala  lalala  lalala ", null));
    		repository.save(new Topic(10L, "history", "Lepanto 3", "Lalalala", "Lalalalaa lalala  lalala  lalala  lalala ", null));
    		repository.save(new Topic(11L, "tv", "Game of Thrones 3", "Lalalala", "Lalalalaa lalala  lalala  lalala  lalala ", null));
    		repository.save(new Topic(12L, "movies", "Avengers 3", "Lalalala", "Lalalalaa lalala  lalala  lalala  lalala ", null));
    	};
    }
    
    @Bean
    public CommandLineRunner demoSection(SectionRepository repository) {
    	return (args) -> {
    		repository.save(new Section(1L, "sports"));
    		repository.save(new Section(2L, "history"));
    		repository.save(new Section(3L, "tv"));
    		repository.save(new Section(4L, "movies"));
    	};
    }
    
    @Bean
    public CommandLineRunner demo(UserRepository repository) {
    	return (args) -> {
	    	repository.save(new User(1L, Role.USER, "aaa", "aaa", "aaaaaa", "21", null));
			repository.save(new User(2L, Role.USER, "bbb", "bbb", "bbbbbb", "22", null));
			repository.save(new User(3L, Role.USER, "ccc", "ccc", "cccccc", "23", null));
	    	repository.save(new User(4L, Role.USER, "ddd", "ddd", "dddddd", "24", null));
			repository.save(new User(5L, Role.USER, "eee", "eee", "eeeeee", "25", null));
			repository.save(new User(6L, Role.USER, "fff", "fff", "ffffff", "26", null));
	    	repository.save(new User(7L, Role.USER, "ggg", "ggg", "gggggg", "27", null));
			repository.save(new User(8L, Role.USER, "hhh", "hhh", "hhhhhh", "28", null));
			repository.save(new User(9L, Role.USER, "jjj", "jjj", "jjjjjj", "29", null));
	    	repository.save(new User(10L, Role.USER, "kkk", "kkk", "kkkkkk", "30", null));
			repository.save(new User(11L, Role.USER, "lll", "lll", "llllll", "31", null));
			repository.save(new User(12L, Role.USER, "mmm", "mmm", "mmmmmm", "32", null));
			/*
			log.info("\nfindAll:\n");
			repository.findAll().forEach(System.out::println);
			
			log.info("\nfindOne:\n");
			User user = repository.findOne(1L);
			log.info(user.toString());
			
			log.info("\nfindByLastName:\n");
			repository.findBySurname("bbbbbb").forEach(System.out::println);
			*/
    	};
    }

}