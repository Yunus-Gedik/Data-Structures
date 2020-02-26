package source;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        ExperimentList list = new ExperimentList();
        Random generator = new Random();
        generator.setSeed(3);
        boolean completed = true;
        float acc;
        int day;
        String time = "timeInfo";
        for(int i=0; i<20; i++)
        {
            System.out.println("----------------------");
            day =  generator.nextInt(4) ;
            String setup = "setup"+Integer.toString(i);
            acc = (float) (i*0.1);
            Experiment e = new Experiment(setup, time , completed, day, acc);
            System.out.println("Add new experiment:");
            System.out.println(e.toString());
            list.addExp(e);
            list.listAll();
        }

        System.out.println("----------------------");
        System.out.println("getExp(0,3) Result:");
        Experiment e = list.getExp(0,3);
        System.out.println(e.toString());
        System.out.println("----------------------");
        System.out.println("setExp(0,3), accuracy=1.0");
        e.accuracy = (float) 1.0;
        list.setExp(0,3, e);
        e = list.getExp(0,3);
        System.out.println("----------------------");
        System.out.println("getExp Result:");
        e = list.getExp(0,3);
        System.out.println(e.toString());
        System.out.println("----------------------");
        System.out.println("listExp(0) Result:");
        list.listExp(0);
        System.out.println("----------------------");
        System.out.println("removeExp(0,0) Result:");
        list.removeExp(0, 0);
        list.listAll();
        System.out.println("----------------------");
        System.out.println("removeExp(1,0) Result:");
        list.removeExp(1, 0);
        list.listAll();
        System.out.println("----------------------");
        System.out.println("removeExp(1,0) Result:");
        list.removeExp(1, 0);
        list.listAll();
        System.out.println("----------------------");
        System.out.println("removeExp(3,6) Result:");
        list.removeExp(3, 6);
        list.listAll();
        System.out.println("----------------------");
        System.out.println("orderExperiment Result:");
        ExperimentList orderedList = list.orderExperiments();
        orderedList.listAll();
        System.out.println("----------------------");
        System.out.println("Original list:");
        list.listAll();
        System.out.println("----------------------");
        System.out.println("orderday(3) Result:");
        list.orderDay(3);
        list.listAll();
    }
}
