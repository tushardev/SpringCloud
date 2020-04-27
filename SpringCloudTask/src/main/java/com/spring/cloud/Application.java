package com.spring.cloud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

import java.util.Objects;

@SpringBootApplication
@EnableTask
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }


    @Bean
    public TollProcessingTask tollProcessingTask() {
        return new TollProcessingTask();
    }


    public class TollProcessingTask implements CommandLineRunner {

        @Override
        public void run(String... strings) throws Exception {
            if(null != strings) {

                String stationId = strings[0];
                String licensePlate = strings[1];
                String timestamp = strings[2];

                System.out.println("Station Id is: " + stationId + " License is: " + licensePlate + " Time is: " + timestamp);
            }
        }
    }
}

/*** The details of task execution is stored in MySQL DB **/

/*** ToDo
 * Check the options to invoke this task.
 * Check Spring Cloud Stream and broker option to invoke the task using web request
 *
 * Spring Cloud Task will be server less component
 * **/
