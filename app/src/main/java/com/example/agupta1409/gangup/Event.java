package com.example.agupta1409.gangup;

import java.util.ArrayList;

/**
 * Created by a.gupta1409 on 03-07-2016.
 */
public class Event {


    public class event {
        String event;
        int image;

        public event(String event, int image) {
            this.event = event;
            this.image = image;
        }
    }

    public ArrayList<event> getEvents(String groupId) {
        ArrayList<event> events = new ArrayList<>();
        switch (groupId) {
            case "F.R.I.E.N.D.S.":
                events.add(new event("Monica hosts ThanksGiving ", R.drawable.kitchenfriends));
                events.add(new event("Monica marries Chandler", R.drawable.wedding));
                events.add(new event("Phoebe marries Mike", R.drawable.phoebewedding));
                events.add(new event("Rachel gives birth to Emma", R.drawable.rachelbaby));
                events.add(new event("Monica and Chandler Adopts kids", R.drawable.friendsadoption));
                events.add(new event("Monica and Chandler leaves for CountrySide", R.drawable.theend));
                break;
            case "HIMYM" :
                events.add(new event("Ted meets Marshall",R.drawable.tedmeetsmarshall));
                events.add(new event("Lily marries Marshall",R.drawable.lilymarshallwedding));
                events.add(new event("Barney marries Robin",R.drawable.barneyrobinwedding));
                events.add(new event("Ted found The Mother. Finally!",R.drawable.tedmeetsthemother));
                events.add(new event("Ted marries his One True Love",R.drawable.mosbymaary));
                events.add(new event("A daughter is born to Barney",R.drawable.barneydaughter));
                events.add(new event("The Mother Dies.",R.drawable.motherdies));
                break;
        }
        return events;

    }
}
