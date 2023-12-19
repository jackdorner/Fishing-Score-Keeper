import java.io.*;
import java.util.*;
public class Fisherman {
    private int score = 0;
    public int largestWalleyePlace = 0;
    public int largestPikePlace = 0;
    public int largestBassPlace = 0;
    public int largestPerchPlace = 0;
    public int largestCrappiePlace = 0;
    public int hotMultiSpeciesActionPlace = 0;
    public int mostFishPlace = 0;
    public int DT6PackTrollingPlace = 0;
    public int mostFishInOneDayPlace = 0;
    public int mostWalleyePlace = 0;
    public int meatHoleBumperBoatsPlace = 0;
    public int landSharkPlace = 0;
    public int bassHoleGoneWildPlace = 0;
    public int sizeMattersPlace = 0;
    private final String name;
    private ArrayList<Fish> arrWalleye= new ArrayList<Fish>();
    private ArrayList<Fish> arrBass= new ArrayList<Fish>();
    private ArrayList<Fish> arrPerch= new ArrayList<Fish>();
    private ArrayList<Fish> arrNorthern= new ArrayList<Fish>();
    private ArrayList<Fish> arrMusky= new ArrayList<Fish>();
    private ArrayList<Fish> arrCrappie= new ArrayList<Fish>();
    private ArrayList<Fish> arrD1= new ArrayList<Fish>();
    private ArrayList<Fish> arrD2= new ArrayList<Fish>();
    private ArrayList<Fish> arrD3= new ArrayList<Fish>();
    private ArrayList<Fish> arrD4= new ArrayList<Fish>();
    private ArrayList<Fish> arrD5= new ArrayList<Fish>();
    private ArrayList<Fish> arrD6= new ArrayList<Fish>();
    private ArrayList<Fish> arrD7= new ArrayList<Fish>();

    public Fisherman(String name){
        this.name = name;
    }

    public void addFish(int day, char type, double length){
        Fish temp = new Fish(type, length);
        //adds to fish array
        if(type == 'w'){
            arrWalleye.add(temp);
        } else if(type == 'b'){
            arrBass.add(temp);
        } else if(type == 'p'){
            arrPerch.add(temp);
        } else if(type == 'n'){
            arrNorthern.add(temp);
        } else if(type == 'm'){
            arrMusky.add(temp);
        } else if(type == 'c'){
            arrCrappie.add(temp);
        }

        //adds to day array
        if(day == 1){
            arrD1.add(temp);
        } else if(day == 2){
            arrD2.add(temp);
        } else if(day == 3){
            arrD3.add(temp);
        } else if(day == 4){
            arrD4.add(temp);
        } else if(day == 5){
            arrD5.add(temp);
        } else if(day == 6){
            arrD6.add(temp);
        } else if(day == 7){
            arrD7.add(temp);
        }
    }

    public void removeFish(int day, char type, double length){//Doesn't work right now
        Fish temp = new Fish(type, length);
        int i;
        //removes from fish array
        if(type == 'w'){
            i = arrWalleye.indexOf(temp);
            if(i != -1){
                arrWalleye.remove(i);
            }
        } else if(type == 'b'){
            i = arrBass.indexOf(temp);
            if(i != -1){
                arrBass.remove(i);
            }
        } else if(type == 'p'){
            i = arrPerch.indexOf(temp);
            if(i != -1){
                arrPerch.remove(i);
            }
        } else if(type == 'n'){
            i = arrNorthern.indexOf(temp);
            if(i != -1){
                arrNorthern.remove(i);
            }
        } else if(type == 'm'){
            i = arrMusky.indexOf(temp);
            if(i != -1){
                arrMusky.remove(i);
            }
        } else if(type == 'c'){
            i = arrCrappie.indexOf(temp);
            if(i != -1){
                arrCrappie.remove(i);
            }
        }

        //removes day array
        if(day == 1){
            i = arrD1.indexOf(temp);
            if(i != -1){
                arrD1.remove(i);
            }
        } else if(day == 2){
            i = arrD2.indexOf(temp);
            if(i != -1){
                arrD2.remove(i);
            }
        } else if(day == 3){
            i = arrD3.indexOf(temp);
            if(i != -1){
                arrD3.remove(i);
            }
        } else if(day == 4){
            i = arrD4.indexOf(temp);
            if(i != -1){
                arrD4.remove(i);
            }
        } else if(day == 5){
            i = arrD5.indexOf(temp);
            if(i != -1){
                arrD5.remove(i);
            }
        } else if(day == 6){
            i = arrD6.indexOf(temp);
            if(i != -1){
                arrD6.remove(i);
            }
        } else if(day == 7){
            i = arrD7.indexOf(temp);
            if(i != -1){
                arrD7.remove(i);
            }
        }
    }

    public int getTotalWalleye(){
        return arrWalleye.size();
    }
    public int getTotalBass(){
        return arrBass.size();
    }
    public int getTotalPerch(){
        return arrPerch.size();
    }
    public int getTotalPike(){
        return arrMusky.size() + arrNorthern.size();
    }
    public int getTotalCrappie(){
        return arrCrappie.size();
    }

    public int getTotalFish(){
        return getTotalWalleye() + getTotalBass() + getTotalPerch() + getTotalPike() + getTotalCrappie();
    }

    public int getMostFishInOneDay(){
        int day1 = arrD1.size();
        int day2 = arrD2.size();
        int day3 = arrD3.size();
        int day4 = arrD4.size();
        int day5 = arrD5.size();
        int day6 = arrD6.size();
        int day7 = arrD7.size();

        if (day1 >= day2 && day1 >= day3 && day1 >= day4 && day1 >= day5 && day1 >= day6 && day1 >= day7){
            return day1;
        } else if (day2 >= day1 && day2 >= day3 && day2 >= day4 && day2 >= day5 && day2 >= day6 && day2 >= day7){
            return day2;
        } else if (day3 >= day1 && day3 >= day2 && day3 >= day4 && day3 >= day5 && day3 >= day6 && day3 >= day7){
            return day3;
        } else if (day4 >= day1 && day4 >= day3 && day4 >= day2 && day4 >= day5 && day4 >= day6 && day4 >= day7){
            return day4;
        } else if (day5 >= day1 && day5 >= day3 && day5 >= day4 && day5 >= day2 && day5 >= day6 && day5 >= day7){
            return day5;
        } else if (day6 >= day1 && day6 >= day3 && day6 >= day4 && day6 >= day5 && day6 >= day2 && day6 >= day7){
            return day6;
        } else {
            return day7;
        }
    }

    public double getLongestWalleye(){
        double longest = 0;
        for(int i = 0; i < arrWalleye.size(); i++){
            if(arrWalleye.get(i).getLength() > longest){
                longest = arrWalleye.get(i).getLength();
            }
        }
        return longest;
    }

    public double getLongestBass(){
        double longest = 0;
        for(int i = 0; i < arrBass.size(); i++){
            if(arrBass.get(i).getLength() > longest){
                longest = arrBass.get(i).getLength();
            }
        }
        return longest;
    }

    public double getLongestPerch(){
        double longest = 0;
        for(int i = 0; i < arrPerch.size(); i++){
            if(arrPerch.get(i).getLength() > longest){
                longest = arrPerch.get(i).getLength();
            }
        }
        return longest;
    }

    public double getLongestPike(){
        double longest = 0;
        for(int i = 0; i < arrNorthern.size(); i++){
            if(arrNorthern.get(i).getLength() > longest){
                longest = arrNorthern.get(i).getLength();
            }
        }
        for(int i = 0; i < arrMusky.size(); i++) {
            if (arrMusky.get(i).getLength() > longest) {
                longest = arrMusky.get(i).getLength();
            }
        }
        return longest;
    }

    public double getLongestCrappie(){
        double longest = 0;
        for(int i = 0; i < arrCrappie.size(); i++){
            if(arrCrappie.get(i).getLength() > longest){
                longest = arrCrappie.get(i).getLength();
            }
        }
        return longest;
    }

    public void printFish(int day){
        System.out.println("Day: " + day);
        if(day == 1){
            print(arrD1);
        } else if(day == 2){
            print(arrD2);
        } else if(day == 3){
            print(arrD3);
        } else if(day == 4){
            print(arrD4);
        } else if(day == 5){
            print(arrD5);
        } else if(day == 6){
            print(arrD6);
        } else if(day == 7){
            print(arrD7);
        }
    }

    private void print(ArrayList<Fish> temp){
        System.out.println(name);
        if(temp.size() != 0) {
            for (int i = 0; i < temp.size() - 1; i++) {
                System.out.print(temp.get(i).getLength() + " " + temp.get(i).getType() + ", ");
            }
            System.out.println(temp.get(temp.size() - 1).getLength() + " " + temp.get(temp.size() - 1).getType());
        }
    }

    public int getScore() {
        score = largestWalleyePlace + largestPikePlace + largestBassPlace + hotMultiSpeciesActionPlace + largestPerchPlace +
                largestCrappiePlace + mostFishPlace + DT6PackTrollingPlace + mostFishInOneDayPlace + mostWalleyePlace +
                meatHoleBumperBoatsPlace + landSharkPlace + bassHoleGoneWildPlace + sizeMattersPlace;
        return score;
    }
}
