package com.cdss4pcp.cqltestserver.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import java.io.*;
import java.nio.file.Files;
import java.util.List;


@Controller
public class HomeController {
    Logger logger = LoggerFactory.getLogger(HomeController.class);


    @RequestMapping("/")
    public String home() {
        return "home";
    }


    @RequestMapping(path = "/translate", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> translate(@RequestBody String cqlContent) {


        String cqlToElmCliPath = System.getenv("CQL_TO_ELM_CLI_PATH");


        File inputFile = new File(cqlToElmCliPath + "/input.cql");
        File outputFile = new File(cqlToElmCliPath + "/output.json");

        try {
            outputFile.delete();
            inputFile.delete();
            inputFile.createNewFile();
            FileWriter writer = new FileWriter(inputFile);
            writer.write(cqlContent);
            writer.close();

        } catch (IOException e) {
            return new ResponseEntity<String>("{\"conversion\": \"IOException creating file\"}", HttpStatus.INTERNAL_SERVER_ERROR);

        }

        ProcessBuilder builder = new ProcessBuilder();


        builder = builder.command("bash", "-c", "$CQL_TO_ELM_CLI_PATH/bin/cql-to-elm-cli --input ./input.cql --output output.json --format=JSON");
        builder = builder.directory(new File(cqlToElmCliPath));

        Process process = null;
        try {
            process = builder.start();
            BufferedReader output = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader error = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            int exitCode = process.waitFor();
            StringBuilder outputBuilder = new StringBuilder();
            for (String line = output.readLine(); line != null; line = output.readLine()) {
                outputBuilder.append(line);
                outputBuilder.append("\n");
            }

            StringBuilder errorBuilder = new StringBuilder();
            for (String line = error.readLine(); line != null; line = error.readLine()) {
                errorBuilder.append(line);
                errorBuilder.append("\n");
            }

            if (exitCode != 0) {

                return new ResponseEntity<String>("Failure: Exit code is " + exitCode + "\n\n---pwd---\n" + builder.directory().getAbsolutePath() + "\n\n ---output---\n" + outputBuilder.toString() + "\n\n---error---\n" + errorBuilder.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
            }


            if (!outputFile.exists()) {
                return new ResponseEntity<String>("Failure: Output file does not exist\n\n---pwd---\n" + builder.directory().getAbsolutePath() + "\n\n ---output---\n" + outputBuilder.toString() + "\n\n---error---\n" + errorBuilder.toString(), HttpStatus.INTERNAL_SERVER_ERROR);

            }


            List<String> lines = Files.readAllLines(outputFile.toPath());

            StringBuilder sb = new StringBuilder();
            for (String line : lines) {
                sb.append(line);
                sb.append("\n");
            }
            return new ResponseEntity<String>(sb.toString(), HttpStatus.OK);


        } catch (IOException e) {

            return new ResponseEntity<String>("Failure: IOException\n\n---exception---\n" + e.toString() + "\n", HttpStatus.INTERNAL_SERVER_ERROR);


        } catch (InterruptedException e) {
            return new ResponseEntity<String>("Failure: InterruptedException\n\n---exception---\n" + e.toString() + "\n", HttpStatus.INTERNAL_SERVER_ERROR);


        }


    }
}
