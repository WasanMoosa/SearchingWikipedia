package org.search.wikipedia;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Check if args has value, if not close the program
        if (args.length == 0) {
            System.out.println("Insure to insert the topic title in the args");
            return;
        }
        // Read the topic from args
        String topic = args[0];


        RequestAPI requestAPI = new RequestAPI();
        ManageResponse manageResponse = new ManageResponse(requestAPI.search(topic));
        ArrayList<PageInfo> pageInfos = manageResponse.getInformation();
        for (int i = 0; i < pageInfos.size(); i++) {
            pageInfos.get(i).display();
        }

        if (pageInfos.size() == 0) {
            System.out.println("No pages found!");
        }


    }
}