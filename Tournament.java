import java.util.ArrayList;
import java.util.Scanner;
public class Tournament {
    private static Scanner scan = new Scanner(System.in);
    private static Fisherman Glen = new Fisherman("Glen");
    private static Fisherman Jack = new Fisherman("Jack");
    private static Fisherman Bob = new Fisherman("Bob");
    private static Fisherman Brent = new Fisherman("Brent");
    private static Fisherman Mark = new Fisherman("Mark");

    public static void main(String[] args) {
        int fisherman = 0;
        int choice = 0;
        while (fisherman != -1){
            while (fisherman != -1 && fisherman <= 6){
                fisherman = chooseFisherman();
                if (fisherman == 0){
                    printScore();
                    choice = -1;
                } else if(fisherman == 1){
                    addTournamentResults();
                    choice = -1;
                } else if (fisherman == 2) {//Glen
                    while (choice != -1) {
                        choice = selectAnAction();
                        if (choice == 1) {
                            addFish(Glen);
                        } else if (choice == 2) {
                            removeFish(Glen);
                        } else if (choice == 3) {
                            printFish(Glen);
                        }
                        if (choice != -1){
                            choice = 0;
                        }
                    }
                } else if (fisherman == 3) {//Jack
                    while (choice != -1) {
                        choice = selectAnAction();
                        if (choice == 1) {
                            addFish(Jack);
                        } else if (choice == 2) {
                            removeFish(Jack);
                        } else if (choice == 3) {
                            printFish(Jack);
                        }
                        if (choice != -1){
                            choice = 0;
                        }
                    }
                } else if (fisherman == 4) {//Bob
                    while (choice != -1) {
                        choice = selectAnAction();
                        if (choice == 1) {
                            addFish(Bob);
                        } else if (choice == 2) {
                            removeFish(Bob);
                        } else if (choice == 3) {
                            printFish(Bob);
                        }
                        if (choice != -1){
                            choice = 0;
                        }
                    }
                } else if (fisherman == 5) {//Brent
                    while (choice != -1) {
                        choice = selectAnAction();
                        if (choice == 1) {
                            addFish(Brent);
                        } else if (choice == 2) {
                            removeFish(Brent);
                        } else if (choice == 3) {
                            printFish(Brent);
                        }
                        if (choice != -1){
                            choice = 0;
                        }
                    }
                } else if (fisherman == 6) {//Mark
                    while (choice != -1) {
                        choice = selectAnAction();
                        if (choice == 1) {
                            addFish(Mark);
                        } else if (choice == 2) {
                            removeFish(Mark);
                        } else if (choice == 3) {
                            printFish(Mark);
                        }
                        if (choice != -1){
                            choice = 0;
                        }
                    }
                }
                if (fisherman != -1){
                    fisherman = 0;
                    choice = 0;
                }
            }
        }
    }

    private static void addFish(Fisherman temp){
        System.out.print("\nWhat day is it? (1, 2, 3, 4, 5, 6, or 7) ");
        int day = scan.nextInt();
        System.out.print("\nWhat type of fish? (w, b, p, n, m, or c) ");
        char type = scan.next().charAt(0);
        System.out.print("\nLength? ");
        double length = scan.nextDouble();
        temp.addFish(day, type, length);
    }

    private static void removeFish(Fisherman temp){
        System.out.print("\nWhat day was it? (1, 2, 3, 4, 5, 6, or 7) ");
        int day = scan.nextInt();
        System.out.print("\nWhat type of fish? (w, b, p, n, m, or c) ");
        char type = scan.next().charAt(0);
        System.out.print("\nLength? ");
        double length = scan.nextDouble();
        temp.removeFish(day, type, length);
    }

    private static void printFish(Fisherman temp){
        int day = -1;
        String dayS;
        do {
            try {
                System.out.print("\nWhat day? (1, 2, 3, 4, 5, 6, or 7) ");
                dayS = scan.next();
                day = Integer.parseInt(dayS);
            } catch (Exception e){
                day = -1;
            }
        } while (day < 1 && day > 7);
        temp.printFish(day);
    }

    private static int chooseFisherman(){
        boolean works = false;
        int choice = -2;
        String choiceS;
        do {
            try{
                System.out.print("Chose a Fisherman or Action (Print Score(0), Add Tournament Results (1), Glen(2), Jack(3), Bob(4), Brent(5), Mark(6)) or enter -1 to quit: ");
                choiceS = scan.next();
                choice = Integer.parseInt(choiceS);
                works = true;
            } catch (Exception ex) {
                works = false;
            }
        } while (!works);
        return choice;
    }

    private static int selectAnAction(){
        boolean works = false;
        int choice = -2;
        String choiceS;
        do {
            try{
                System.out.print("Select an action (add fish(1), remove fish(2), print fish(3), or change fisherman(-1)): ");
                choiceS = scan.next();
                choice = Integer.parseInt(choiceS);
                works = true;
            } catch (Exception ex) {
                works = false;
            }
        } while (!works);
        return choice;
    }


    private static void printScore() {
        updateScores();
        ArrayList<Score> scores = new ArrayList<>();

        scores.add(new Score("Glen", Glen.getScore()));
        scores.add(new Score("Jack", Jack.getScore()));
        scores.add(new Score("Bob", Bob.getScore()));
        scores.add(new Score("Brent", Brent.getScore()));
        scores.add(new Score("Mark", Mark.getScore()));

        for (int i = 0; i < scores.size(); i++) {
            for (int j = i + 1; j < scores.size(); j++) {
                if (scores.get(j).score < scores.get(i).score) {
                    Score temp = scores.get(i);
                    scores.set(i, scores.get(j));
                    scores.set(j, temp);
                }
            }
        }
        for (int i = 0; i < scores.size(); i++){
            System.out.println(i+1 + ": " + scores.get(i).name + " (" + scores.get(i).score +")");
        }
    }

    private static void addTournamentResults(){
        boolean works = false;
        int choice = -2;
        String choiceS;
        do {
            try{
                System.out.print("Select a tournament (Hot Multi Species Action(1), DT6 Pack Trolling(2), " +
                        "Meat Hole Bumper Boats(3),\nLand Shark(4), Basshole Gone Wild(5), Size Matters(6), or exit(-1)): ");
                choiceS = scan.next();
                choice = Integer.parseInt(choiceS);
                works = true;
            } catch (Exception ex) {
                works = false;
            }
        } while (!works && choice != -1);
        if (choice == 1){
            System.out.println("Enter Tournament Results:");
            Glen.hotMultiSpeciesActionPlace = getPlace("Glen");
            Jack.hotMultiSpeciesActionPlace = getPlace("Jack");
            Bob.hotMultiSpeciesActionPlace = getPlace("Bob");
            Brent.hotMultiSpeciesActionPlace = getPlace("Brent");
            Mark.hotMultiSpeciesActionPlace = getPlace("Mark");
        } else if (choice == 2){
            System.out.println("Enter Tournament Results:");
            Glen.DT6PackTrollingPlace = getPlace("Glen");
            Jack.DT6PackTrollingPlace = getPlace("Jack");
            Bob.DT6PackTrollingPlace = getPlace("Bob");
            Brent.DT6PackTrollingPlace = getPlace("Brent");
            Mark.DT6PackTrollingPlace = getPlace("Mark");
        } else if (choice == 3){
            System.out.println("Enter Tournament Results:");
            Glen.meatHoleBumperBoatsPlace = getPlace("Glen");
            Jack.meatHoleBumperBoatsPlace = getPlace("Jack");
            Bob.meatHoleBumperBoatsPlace = getPlace("Bob");
            Brent.meatHoleBumperBoatsPlace = getPlace("Brent");
            Mark.meatHoleBumperBoatsPlace = getPlace("Mark");
        } else if (choice == 4){
            System.out.println("Enter Tournament Results:");
            Glen.landSharkPlace = getPlace("Glen");
            Jack.landSharkPlace = getPlace("Jack");
            Bob.landSharkPlace = getPlace("Bob");
            Brent.landSharkPlace = getPlace("Brent");
            Mark.landSharkPlace = getPlace("Mark");
        } else if (choice == 5){
            System.out.println("Enter Tournament Results:");
            Glen.bassHoleGoneWildPlace = getPlace("Glen");
            Jack.bassHoleGoneWildPlace = getPlace("Jack");
            Bob.bassHoleGoneWildPlace = getPlace("Bob");
            Brent.bassHoleGoneWildPlace = getPlace("Brent");
            Mark.bassHoleGoneWildPlace = getPlace("Mark");
        } else if (choice == 6){
            System.out.println("Enter Tournament Results:");
            Glen.sizeMattersPlace = getPlace("Glen");
            Jack.sizeMattersPlace = getPlace("Jack");
            Bob.sizeMattersPlace = getPlace("Bob");
            Brent.sizeMattersPlace = getPlace("Brent");
            Mark.sizeMattersPlace = getPlace("Mark");
        }
    }

    private static int getPlace(String name){
        boolean works = false;
        int place = 0;
        String placeS;
        do {
            try{
                System.out.print("Enter " + name + "'s place: ");
                placeS = scan.next();
                place = Integer.parseInt(placeS);
                works = true;
            } catch (Exception ex) {
                works = false;
            }
        } while (!works);
        return place;
    }

    private static void updateScores(){
        updateLargestWalleye();
        updateLargestPike();
        updateLargestBass();
        updateLargestPerch();
        updateLargestCrappie();
        updateMostFish();
        updateMostFishInOneDay();
        updateMostWalleye();
    }

    private static void updateLargestWalleye(){
        ArrayList<Score> scores = new ArrayList<>();

        scores.add(new Score("Glen", Glen.getLongestWalleye()));
        scores.add(new Score("Jack", Jack.getLongestWalleye()));
        scores.add(new Score("Bob", Bob.getLongestWalleye()));
        scores.add(new Score("Brent", Brent.getLongestWalleye()));
        scores.add(new Score("Mark", Mark.getLongestWalleye()));

        for (int i = 0; i < scores.size(); i++) {
            for (int j = i + 1; j < scores.size(); j++) {
                if (scores.get(j).score < scores.get(i).score) {
                    Score temp = scores.get(i);
                    scores.set(i, scores.get(j));
                    scores.set(j, temp);
                }
            }
        }
        getPlace(scores);
        for (int i = 0; i < scores.size(); i++){
            if (scores.get(i).name.equalsIgnoreCase("Glen")){
                Glen.largestWalleyePlace = scores.get(i).place;
            }
            if (scores.get(i).name.equalsIgnoreCase("Jack")){
                Jack.largestWalleyePlace = scores.get(i).place;
            }
            if (scores.get(i).name.equalsIgnoreCase("Bob")){
                Bob.largestWalleyePlace = scores.get(i).place;
            }
            if (scores.get(i).name.equalsIgnoreCase("Brent")){
                Brent.largestWalleyePlace = scores.get(i).place;
            }
            if (scores.get(i).name.equalsIgnoreCase("Mark")){
                Mark.largestWalleyePlace = scores.get(i).place;
            }
        }
    }
    private static void updateLargestPike(){
        ArrayList<Score> scores = new ArrayList<>();

        scores.add(new Score("Glen", Glen.getLongestPike()));
        scores.add(new Score("Jack", Jack.getLongestPike()));
        scores.add(new Score("Bob", Bob.getLongestPike()));
        scores.add(new Score("Brent", Brent.getLongestPike()));
        scores.add(new Score("Mark", Mark.getLongestPike()));

        for (int i = 0; i < scores.size(); i++) {
            for (int j = i + 1; j < scores.size(); j++) {
                if (scores.get(j).score < scores.get(i).score) {
                    Score temp = scores.get(i);
                    scores.set(i, scores.get(j));
                    scores.set(j, temp);
                }
            }
        }
        getPlace(scores);
        for (int i = 0; i < scores.size(); i++){
            if (scores.get(i).name.equalsIgnoreCase("Glen")){
                Glen.largestPikePlace = scores.get(i).place;
            }
            if (scores.get(i).name.equalsIgnoreCase("Jack")){
                Jack.largestPikePlace = scores.get(i).place;
            }
            if (scores.get(i).name.equalsIgnoreCase("Bob")){
                Bob.largestPikePlace = scores.get(i).place;
            }
            if (scores.get(i).name.equalsIgnoreCase("Brent")){
                Brent.largestPikePlace = scores.get(i).place;
            }
            if (scores.get(i).name.equalsIgnoreCase("Mark")){
                Mark.largestPikePlace = scores.get(i).place;
            }
        }
    }

    private static void updateLargestBass(){
        ArrayList<Score> scores = new ArrayList<>();

        scores.add(new Score("Glen", Glen.getLongestBass()));
        scores.add(new Score("Jack", Jack.getLongestBass()));
        scores.add(new Score("Bob", Bob.getLongestBass()));
        scores.add(new Score("Brent", Brent.getLongestBass()));
        scores.add(new Score("Mark", Mark.getLongestBass()));

        for (int i = 0; i < scores.size(); i++) {
            for (int j = i + 1; j < scores.size(); j++) {
                if (scores.get(j).score < scores.get(i).score) {
                    Score temp = scores.get(i);
                    scores.set(i, scores.get(j));
                    scores.set(j, temp);
                }
            }
        }
        getPlace(scores);
        for (int i = 0; i < scores.size(); i++){
            if (scores.get(i).name.equalsIgnoreCase("Glen")){
                Glen.largestBassPlace = scores.get(i).place;
            }
            if (scores.get(i).name.equalsIgnoreCase("Jack")){
                Jack.largestBassPlace = scores.get(i).place;
            }
            if (scores.get(i).name.equalsIgnoreCase("Bob")){
                Bob.largestBassPlace = scores.get(i).place;
            }
            if (scores.get(i).name.equalsIgnoreCase("Brent")){
                Brent.largestBassPlace = scores.get(i).place;
            }
            if (scores.get(i).name.equalsIgnoreCase("Mark")){
                Mark.largestBassPlace = scores.get(i).place;
            }
        }
    }

    private static void updateLargestPerch(){
        ArrayList<Score> scores = new ArrayList<>();

        scores.add(new Score("Glen", Glen.getLongestPerch()));
        scores.add(new Score("Jack", Jack.getLongestPerch()));
        scores.add(new Score("Bob", Bob.getLongestPerch()));
        scores.add(new Score("Brent", Brent.getLongestPerch()));
        scores.add(new Score("Mark", Mark.getLongestPerch()));

        for (int i = 0; i < scores.size(); i++) {
            for (int j = i + 1; j < scores.size(); j++) {
                if (scores.get(j).score < scores.get(i).score) {
                    Score temp = scores.get(i);
                    scores.set(i, scores.get(j));
                    scores.set(j, temp);
                }
            }
        }
        getPlace(scores);
        for (int i = 0; i < scores.size(); i++){
            if (scores.get(i).name.equalsIgnoreCase("Glen")){
                Glen.largestPerchPlace = scores.get(i).place;
            }
            if (scores.get(i).name.equalsIgnoreCase("Jack")){
                Jack.largestPerchPlace = scores.get(i).place;
            }
            if (scores.get(i).name.equalsIgnoreCase("Bob")){
                Bob.largestPerchPlace = scores.get(i).place;
            }
            if (scores.get(i).name.equalsIgnoreCase("Brent")){
                Brent.largestPerchPlace = scores.get(i).place;
            }
            if (scores.get(i).name.equalsIgnoreCase("Mark")){
                Mark.largestPerchPlace = scores.get(i).place;
            }
        }
    }

    private static void updateLargestCrappie(){
        ArrayList<Score> scores = new ArrayList<>();

        scores.add(new Score("Glen", Glen.getLongestCrappie()));
        scores.add(new Score("Jack", Jack.getLongestCrappie()));
        scores.add(new Score("Bob", Bob.getLongestCrappie()));
        scores.add(new Score("Brent", Brent.getLongestCrappie()));
        scores.add(new Score("Mark", Mark.getLongestCrappie()));

        for (int i = 0; i < scores.size(); i++) {
            for (int j = i + 1; j < scores.size(); j++) {
                if (scores.get(j).score < scores.get(i).score) {
                    Score temp = scores.get(i);
                    scores.set(i, scores.get(j));
                    scores.set(j, temp);
                }
            }
        }
        getPlace(scores);
        for (int i = 0; i < scores.size(); i++){
            if (scores.get(i).name.equalsIgnoreCase("Glen")){
                Glen.largestCrappiePlace = scores.get(i).place;
            }
            if (scores.get(i).name.equalsIgnoreCase("Jack")){
                Jack.largestCrappiePlace = scores.get(i).place;
            }
            if (scores.get(i).name.equalsIgnoreCase("Bob")){
                Bob.largestCrappiePlace = scores.get(i).place;
            }
            if (scores.get(i).name.equalsIgnoreCase("Brent")){
                Brent.largestCrappiePlace = scores.get(i).place;
            }
            if (scores.get(i).name.equalsIgnoreCase("Mark")){
                Mark.largestCrappiePlace = scores.get(i).place;
            }
        }
    }

    private static void updateMostFish(){
        ArrayList<Score> scores = new ArrayList<>();

        scores.add(new Score("Glen", Glen.getTotalFish()));
        scores.add(new Score("Jack", Jack.getTotalFish()));
        scores.add(new Score("Bob", Bob.getTotalFish()));
        scores.add(new Score("Brent", Brent.getTotalFish()));
        scores.add(new Score("Mark", Mark.getTotalFish()));

        for (int i = 0; i < scores.size(); i++) {
            for (int j = i + 1; j < scores.size(); j++) {
                if (scores.get(j).score < scores.get(i).score) {
                    Score temp = scores.get(i);
                    scores.set(i, scores.get(j));
                    scores.set(j, temp);
                }
            }
        }
        getPlace(scores);
        for (int i = 0; i < scores.size(); i++){
            if (scores.get(i).name.equalsIgnoreCase("Glen")){
                Glen.mostFishPlace = scores.get(i).place;
            }
            if (scores.get(i).name.equalsIgnoreCase("Jack")){
                Jack.mostFishPlace = scores.get(i).place;
            }
            if (scores.get(i).name.equalsIgnoreCase("Bob")){
                Bob.mostFishPlace = scores.get(i).place;
            }
            if (scores.get(i).name.equalsIgnoreCase("Brent")){
                Brent.mostFishPlace = scores.get(i).place;
            }
            if (scores.get(i).name.equalsIgnoreCase("Mark")){
                Mark.mostFishPlace = scores.get(i).place;
            }
        }
    }
    private static void updateMostFishInOneDay(){
        ArrayList<Score> scores = new ArrayList<>();

        scores.add(new Score("Glen", Glen.getMostFishInOneDay()));
        scores.add(new Score("Jack", Jack.getMostFishInOneDay()));
        scores.add(new Score("Bob", Bob.getMostFishInOneDay()));
        scores.add(new Score("Brent", Brent.getMostFishInOneDay()));
        scores.add(new Score("Mark", Mark.getMostFishInOneDay()));

        for (int i = 0; i < scores.size(); i++) {
            for (int j = i + 1; j < scores.size(); j++) {
                if (scores.get(j).score < scores.get(i).score) {
                    Score temp = scores.get(i);
                    scores.set(i, scores.get(j));
                    scores.set(j, temp);
                }
            }
        }
        getPlace(scores);
        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i).name.equalsIgnoreCase("Glen")) {
                Glen.mostFishInOneDayPlace = scores.get(i).place;
            }
            if (scores.get(i).name.equalsIgnoreCase("Jack")) {
                Jack.mostFishInOneDayPlace = scores.get(i).place;
            }
            if (scores.get(i).name.equalsIgnoreCase("Bob")) {
                Bob.mostFishInOneDayPlace = scores.get(i).place;
            }
            if (scores.get(i).name.equalsIgnoreCase("Brent")) {
                Brent.mostFishInOneDayPlace = scores.get(i).place;
            }
            if (scores.get(i).name.equalsIgnoreCase("Mark")) {
                Mark.mostFishInOneDayPlace = scores.get(i).place;
            }
        }
    }
    private static void updateMostWalleye(){
        ArrayList<Score> scores = new ArrayList<>();

        scores.add(new Score("Glen", Glen.getTotalWalleye()));
        scores.add(new Score("Jack", Jack.getTotalWalleye()));
        scores.add(new Score("Bob", Bob.getTotalWalleye()));
        scores.add(new Score("Brent", Brent.getTotalWalleye()));
        scores.add(new Score("Mark", Mark.getTotalWalleye()));

        for (int i = 0; i < scores.size(); i++) {
            for (int j = i + 1; j < scores.size(); j++) {
                if (scores.get(j).score < scores.get(i).score) {
                    Score temp = scores.get(i);
                    scores.set(i, scores.get(j));
                    scores.set(j, temp);
                }
            }
        }
        getPlace(scores);
        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i).name.equalsIgnoreCase("Glen")) {
                Glen.mostWalleyePlace = scores.get(i).place;
            }
            if (scores.get(i).name.equalsIgnoreCase("Jack")) {
                Jack.mostWalleyePlace = scores.get(i).place;
            }
            if (scores.get(i).name.equalsIgnoreCase("Bob")) {
                Bob.mostWalleyePlace = scores.get(i).place;
            }
            if (scores.get(i).name.equalsIgnoreCase("Brent")) {
                Brent.mostWalleyePlace = scores.get(i).place;
            }
            if (scores.get(i).name.equalsIgnoreCase("Mark")) {
                Mark.mostWalleyePlace = scores.get(i).place;
            }
        }
    }

    private static void getPlace(ArrayList<Score> scores){
        int count = 0;
        for (int i = 0; i < scores.size(); i++){
            if (scores.get(i).score == 0){
                count++;
            }
        }
        for (int i = 0; i < scores.size(); i++){
            if (scores.get(i).score == 0){
                scores.get(i).place = 6 - count;
            } else {
                //scores.get(i).place = i + 1 - count;
                scores.get(i).place = 5 - i;
            }

        }
        for (int i = 1; i < scores.size(); i++){
            if (scores.get(i-1).score == scores.get(i).score){
                scores.get(i).place = scores.get(i-1).place;
            }
        }
    }
}

