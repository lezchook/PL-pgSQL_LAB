package org.example;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

public class Generator {

    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("script2.sql");
        for (int i = 0; i < 1000; i++) {
            String name = RandomStringUtils.randomAlphabetic(10) + ' ' + RandomStringUtils.randomAlphabetic(10);
            String role = RandomStringUtils.randomAlphabetic(5);
            String biography = RandomStringUtils.randomAlphabetic(25);
            int minDay = (int) LocalDate.of(1950, 1, 1).toEpochDay();
            int maxDay = (int) LocalDate.of(1980, 1, 1).toEpochDay();
            Random random = new Random();
            long randomDay = minDay + random.nextInt(maxDay - minDay);
            LocalDate birth = LocalDate.ofEpochDay(randomDay);
            writer.write("insert into regents (name, role, biography, birthday) values (" + "'"
                    + name + "', '" + role + "', '" + biography + "', '" + birth + "');");
            writer.write('\n');
        }
        for (int i = 0; i < 130; i++) {
            String description = RandomStringUtils.randomAlphabetic(25);
            int minDay = (int) LocalDate.of(2020, 1, 1).toEpochDay();
            int maxDay = (int) LocalDate.of(2022, 1, 1).toEpochDay();
            Random random = new Random();
            long randomDay = minDay + random.nextInt(maxDay - minDay);
            LocalDate date = LocalDate.ofEpochDay(randomDay);
            writer.write("insert into regents_session (date_session, description) values (" + "'"
                    + date + "', '" + description + "');");
            writer.write('\n');
        }
        for (int i = 0; i < 221; i++) {
            String description = RandomStringUtils.randomAlphabetic(25);
            int minDay = (int) LocalDate.of(1996, 1, 1).toEpochDay();
            int maxDay = (int) LocalDate.of(2010, 1, 1).toEpochDay();
            Random random = new Random();
            long randomDay = minDay + random.nextInt(maxDay - minDay);
            LocalDate date = LocalDate.ofEpochDay(randomDay);
            writer.write("insert into regents_session (date_session, description) values (" + "'"
                    + date + "', '" + description + "');");
            writer.write('\n');
        }
        for (int i = 1; i <= 251; i++) {
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            Random r = new Random();
            while (numbers.size() < 4) {
                int random = r.nextInt(500);
                while (random == 0) {
                    random = r.nextInt(500);
                }
                if (!numbers.contains(random)) {
                    numbers.add(random);
                }
            }
            final int index1 = numbers.get (0);
            final int index2 = numbers.get (1);
            final int index3 = numbers.get (2);
            final int index4 = numbers.get (3);
            writer.write("insert into regent_set (ID_REGENT_SESSION, ID_REGENT) values ("
                    + i + ", " + index1 + ");");
            writer.write('\n');
            writer.write("insert into regent_set (ID_REGENT_SESSION, ID_REGENT) values ("
                    + i + ", " + index2 + ");");
            writer.write('\n');
            writer.write("insert into regent_set (ID_REGENT_SESSION, ID_REGENT) values ("
                    + i + ", " + index3 + ");");
            writer.write('\n');
            writer.write("insert into regent_set (ID_REGENT_SESSION, ID_REGENT) values ("
                    + i + ", " + index4 + ");");
            writer.write('\n');
        }
        for (int i = 0; i < 1000; i++) {
            String name = RandomStringUtils.randomAlphabetic(10) + ' ' + RandomStringUtils.randomAlphabetic(10);
            String biography = RandomStringUtils.randomAlphabetic(25);
            int minDay = (int) LocalDate.of(1955, 1, 1).toEpochDay();
            int maxDay = (int) LocalDate.of(1980, 1, 1).toEpochDay();
            Random random = new Random();
            long randomDay = minDay + random.nextInt(maxDay - minDay);
            LocalDate birth = LocalDate.ofEpochDay(randomDay);
            int id_session = random.nextInt(199) + 1;
            int weight = random.nextInt(50) + 40;
            writer.write("insert into agents (name, biography, birthday, weight, id_session) values ('"
                    + name + "', '" + biography + "', '" + birth + "', " + weight + ", '" + id_session + "'" + ");");
            writer.write('\n');
        }
        for (int i = 0; i < 500; i++) {
            String name = RandomStringUtils.randomAlphabetic(10) + ' ' + RandomStringUtils.randomAlphabetic(10);
            String biography = RandomStringUtils.randomAlphabetic(25);
            int minDay = (int) LocalDate.of(1974, 1, 1).toEpochDay();
            int maxDay = (int) LocalDate.of(1982, 1, 1).toEpochDay();
            Random random = new Random();
            long randomDay = minDay + random.nextInt(maxDay - minDay);
            LocalDate birth = LocalDate.ofEpochDay(randomDay);
            int id_session = random.nextInt(100) + 101;
            String skill = RandomStringUtils.randomAlphabetic(5);
            writer.write("insert into technical_staff (name, best_skill, biography, birthday, id_session) values ('"
                    + name + "', '" + skill + "', '" + biography + "', '" + birth + "', " + id_session + ");");
            writer.write('\n');
        }
        for (int i = 0; i < 125; i++) {
            String name = RandomStringUtils.randomAlphabetic(10);
            writer.write("insert into technical_command (name) values ('"
                    + name + "'"  + ");");
            writer.write('\n');
        }
        for (int i = 1; i <= 125; i++) {
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            Random r = new Random();
            while (numbers.size() < 4) {
                int random = r.nextInt(500);
                while (random == 0) {
                    random = r.nextInt(500);
                }
                if (!numbers.contains(random)) {
                    numbers.add(random);
                }
            }
            final int index1 = numbers.get (0);
            final int index2 = numbers.get (1);
            final int index3 = numbers.get (2);
            final int index4 = numbers.get (3);
            writer.write("insert into technical_set (ID_COMMAND, id_technic) values ("
                    + i + ", " + index1 + ");");
            writer.write('\n');
            writer.write("insert into technical_set (ID_COMMAND, id_technic) values ("
                    + i + ", " + index2 + ");");
            writer.write('\n');
            writer.write("insert into technical_set (ID_COMMAND, id_technic) values ("
                    + i + ", " + index3 + ");");
            writer.write('\n');
            writer.write("insert into technical_set (ID_COMMAND, id_technic) values ("
                    + i + ", " + index4 + ");");
            writer.write('\n');
        }
        for (int i = 0; i < 1000; i++) {
            String description = RandomStringUtils.randomAlphabetic(25);
            Random random = new Random();
            int id_command = random.nextInt(124) + 1;
            String name = RandomStringUtils.randomAlphabetic(10);
            writer.write("insert into equipment (name, description, id_command) values (" + "'"
                    + name + "', '" + description + "', " + id_command + ");");
            writer.write('\n');
        }
        for (int i = 0; i < 20; i++) {
            String name = RandomStringUtils.randomAlphabetic(10) + ' ' + RandomStringUtils.randomAlphabetic(10);
            String biography = RandomStringUtils.randomAlphabetic(25);
            int minDay = (int) LocalDate.of(1941, 1, 1).toEpochDay();
            int maxDay = (int) LocalDate.of(1970, 1, 1).toEpochDay();
            Random random = new Random();
            long randomDay = minDay + random.nextInt(maxDay - minDay);
            LocalDate birth = LocalDate.ofEpochDay(randomDay);
            int id_session = i + 202;
            writer.write("insert into boss (name, biography, birthday, active, id_session) values ('"
                    + name + "', '" + biography + "', '" + birth + "', " + false + ", " + id_session  + ");");
            writer.write('\n');
        }
        for (int i = 0; i < 400; i++) {
            String description = RandomStringUtils.randomAlphabetic(25);
            int minDay = (int) LocalDate.of(1999, 1, 1).toEpochDay();
            int maxDay = (int) LocalDate.of(2022, 1, 1).toEpochDay();
            Random random = new Random();
            long randomDay = minDay + random.nextInt(maxDay - minDay);
            LocalDate date = LocalDate.ofEpochDay(randomDay);
            int id_boss = random.nextInt(19) + 1;
            writer.write("insert into signal (description, signal_date, pross_boss) values ('" +
                    description + "', '" + date + "', " + id_boss  + ");");
            writer.write('\n');
        }
        for (int i = 0; i < 20; i++) {
            String name = RandomStringUtils.randomAlphabetic(10) + ' ' + RandomStringUtils.randomAlphabetic(10);
            String description = RandomStringUtils.randomAlphabetic(25);
            writer.write("insert into warehouse_sectors (name, description) values ('"
                    + name + "', '" + description + "'" + ");");
            writer.write('\n');
        }
        for (int i = 0; i < 1000; i++) {
            String name = RandomStringUtils.randomAlphabetic(10) + ' ' + RandomStringUtils.randomAlphabetic(10);
            String description = RandomStringUtils.randomAlphabetic(25);
            Random random = new Random();
            int sector = random.nextInt(19) + 1;
            int weight = random.nextInt(50) + 4000;
            writer.write("insert into artifact (name, description, sector, weight) values ('"
                    + name + "', '" + description + "', " + sector + ", '" + weight + "'" + ");");
            writer.write('\n');
        }
        int j = 0;
        for (int i = 1; i <= 200; i++) {
            String name = RandomStringUtils.randomAlphabetic(10) + ' ' + RandomStringUtils.randomAlphabetic(10);
            String description = RandomStringUtils.randomAlphabetic(25);
            Random random = new Random();
            int artifact_set = random.nextInt(199) + 1;
            writer.write("insert into mission (id_signal, description, crimers_is, crimers_catch) values ("
                    + i + ", '" + description + "', "  + false + ", " + false + ");");
            writer.write('\n');
        }
        for (int i = 201; i <= 300; i++) {
            String name = RandomStringUtils.randomAlphabetic(10) + ' ' + RandomStringUtils.randomAlphabetic(10);
            String description = RandomStringUtils.randomAlphabetic(25);
            Random random = new Random();
            int artifact_set = random.nextInt(199) + 1;
            writer.write("insert into mission (id_signal, description, crimers_is, crimers_catch) values ("
                    + i + ", '" + description + "', " + true + ", " + false + ");");
            writer.write('\n');
        }
        for (int i = 301; i <= 400; i++) {
            String name = RandomStringUtils.randomAlphabetic(10) + ' ' + RandomStringUtils.randomAlphabetic(10);
            String description = RandomStringUtils.randomAlphabetic(25);
            Random random = new Random();
            int artifact_set = random.nextInt(199) + 1;
            writer.write("insert into mission (id_signal, description, crimers_is, crimers_catch) values ("
                    + i + ", '" + description + "', " + true + ", " + true + ");");
            writer.write('\n');
        }
        for (int i = 1; i <= 400; i++) {
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            Random r = new Random();
            while (numbers.size() < 4) {
                int random = r.nextInt(500);
                while (random == 0) {
                    random = r.nextInt(500);
                }
                if (!numbers.contains(random)) {
                    numbers.add(random);
                }
            }
            final int index1 = numbers.get (0);
            final int index2 = numbers.get (1);
            final int index3 = numbers.get (2);
            final int index4 = numbers.get (3);
            writer.write("insert into artifact_set (id_mission, id_artifact) values ("
                    + i + ", " + index1 + ");");
            writer.write('\n');
            writer.write("insert into artifact_set (id_mission, id_artifact) values ("
                    + i + ", " + index2 + ");");
            writer.write('\n');
            writer.write("insert into artifact_set (id_mission, id_artifact) values ("
                    + i + ", " + index3 + ");");
            writer.write('\n');
            writer.write("insert into artifact_set (id_mission, id_artifact) values ("
                    + i + ", " + index4 + ");");
            writer.write('\n');
            j = j + 3;
        }
        for (int i = 1; i <= 400; i++) {
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            Random r = new Random();
            while (numbers.size() < 4) {
                int random = r.nextInt(1000);
                while (random == 0) {
                    random = r.nextInt(1000);
                }
                if (!numbers.contains(random)) {
                    numbers.add(random);
                }
            }
            final int index1 = numbers.get (0);
            final int index2 = numbers.get (1);
            final int index3 = numbers.get (2);
            final int index4 = numbers.get (3);
            writer.write("insert into equipment_set (ID_MISSION, id_item) values ("
                    + i + ", " + index1 + ");");
            writer.write('\n');
            writer.write("insert into equipment_set (ID_MISSION, id_item) values ("
                    + i + ", " + index2 + ");");
            writer.write('\n');
            writer.write("insert into equipment_set (ID_MISSION, id_item) values ("
                    + i + ", " + index3 + ");");
            writer.write('\n');
            writer.write("insert into equipment_set (ID_MISSION, id_item) values ("
                    + i + ", " + index4 + ");");
            writer.write('\n');
        }
        for (int i = 1; i <= 200 ; i++) {
            String name = RandomStringUtils.randomAlphabetic(10) + ' ' + RandomStringUtils.randomAlphabetic(10);
            String description = RandomStringUtils.randomAlphabetic(25);
            int minDay = (int) LocalDate.of(1950, 1, 1).toEpochDay();
            int maxDay = (int) LocalDate.of(1980, 1, 1).toEpochDay();
            Random random = new Random();
            long randomDay = minDay + random.nextInt(maxDay - minDay);
            LocalDate birth = LocalDate.ofEpochDay(randomDay);
            writer.write("insert into criminals (name, description, arrest_date, id_session, birthday, judgment) values ('"
                    + name + "', '" + description + "', " + null + ", " + null + ", '" + birth + "', " + null + ");");
            writer.write('\n');
        }
        for (int i = 201; i <= 400 ; i++) {
            String name = RandomStringUtils.randomAlphabetic(10) + ' ' + RandomStringUtils.randomAlphabetic(10);
            String description = RandomStringUtils.randomAlphabetic(25);
            String jud = RandomStringUtils.randomAlphabetic(10);
            int minDay = (int) LocalDate.of(1950, 1, 1).toEpochDay();
            int maxDay = (int) LocalDate.of(1980, 1, 1).toEpochDay();
            Random random = new Random();
            long randomDay = minDay + random.nextInt(maxDay - minDay);
            LocalDate birth = LocalDate.ofEpochDay(randomDay);
            minDay = (int) LocalDate.of(2010, 1, 1).toEpochDay();
            maxDay = (int) LocalDate.of(2020, 1, 1).toEpochDay();
            random = new Random();
            randomDay = minDay + random.nextInt(maxDay - minDay);
            LocalDate arrest_date = LocalDate.ofEpochDay(randomDay);
            int id_session = random.nextInt(120) + 222;
            writer.write("insert into criminals (name, description, arrest_date, id_session, birthday, judgment) values ('"
                    + name + "', '" + description + "', '" + arrest_date + "', " + id_session + ", '" + birth + "', '" + jud + "');");
            writer.write('\n');
        }
        for (int i = 1; i <= 400; i++) {
            writer.write("insert into criminal_direct (ID_MISSION, id_criminal) values ("
                    + i + ", " + i + ");");
            writer.write('\n');
        }
        for (int i = 1; i <= 400; i++) {
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            Random r = new Random();
            while (numbers.size() < 4) {
                int random = r.nextInt(1000);
                while (random == 0) {
                    random = r.nextInt(1000);
                }
                if (!numbers.contains(random)) {
                    numbers.add(random);
                }
            }
            final int index1 = numbers.get (0);
            final int index2 = numbers.get (1);
            final int index3 = numbers.get (2);
            final int index4 = numbers.get (3);
            writer.write("insert into agents_attention (ID_AGENT, ID_MISSION, LOCATION) values ("
                    + index1 + ", " + i + ", " + false + ");");
            writer.write('\n');
            writer.write("insert into agents_attention (ID_AGENT, ID_MISSION, LOCATION) values ("
                    + index2 + ", " + i + ", " + true + ");");
            writer.write('\n');
            writer.write("insert into agents_attention (ID_AGENT, ID_MISSION, LOCATION) values ("
                    + index3 + ", " + i + ", " + false + ");");
            writer.write('\n');
            writer.write("insert into agents_attention (ID_AGENT, ID_MISSION, LOCATION) values ("
                    + index4 + ", " + i + ", " + true + ");");
            writer.write('\n');
        }
        writer.flush();
    }
}