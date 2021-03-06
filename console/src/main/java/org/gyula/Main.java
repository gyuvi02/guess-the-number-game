package org.gyula;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Main {
//    public static final Logger log = LoggerFactory.getLogger(Main.class);

//    public static final String CONFIG_LOCATION = "old_beans.xml";

    public static void main(String[] args) {
        log.info("Guess The Number Game");

        SpringApplication.run(Main.class, args);

        //create context (container)
//        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);
//        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(GameConfig.class);

//        //get the number generator bean from context (container)
//        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);
//
//        //call method next() to get a random number
//        int number = numberGenerator.next();
//
//        //logging the generated number
//        log.info("number = {}", number);
//
//        //call reset method - but we removed it to use a different approach
////        game.reset();
//
//        // get messageGenerator bean
//        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
//        log.info("getMainMessage = {}", messageGenerator.getMainMessage());
//        log.info("getResultMessage = {}", messageGenerator.getResultMessage());
//
        //close context (container)


    }
}
