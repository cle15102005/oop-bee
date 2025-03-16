package com.example.oopbee.business;

import com.example.oopbee.entity.Bee;
import com.example.oopbee.entity.Drone;
import com.example.oopbee.entity.QueenBee;
import com.example.oopbee.entity.WorkerBee;

import java.util.ArrayList;
import java.util.Random;

/**
 * Logic class: create bee list, attack bee
 */
public class BeeHive {
    private Set<Bee> listBee = new HashSet<Bee>();

    public void init() {
        //create list of 10 bees  of Queen, Drone and Worker types
        //in each bee, type and health attributes are randomly chosen
        this.listBee = new ArrayList<>();

        this.listBee.add(new QueenBee());
        this.listBee.add(new WorkerBee());
        this.listBee.add(new Drone());


        // Random from 1 -> 3
        private Random rand = SecureRandom.getInstanceStrong(); 

        for (int i = 0 ; i < 7 ; i++) {
            int r = rand.nextInt(3) + 1;
            if (r == 1) {
                // add Queen bee
                this.listBee.add(new QueenBee());
            } else if (r == 2) {
                //add Worker bee
                this.listBee.add(new WorkerBee());
            } else {
                //add Drone bee
                this.listBee.add(new Drone());
            }
        }
    }

    public Set<Bee> getAllBees() {
        return listBee;
    }

    //attack all bees
    public void attackBees() {
        for (int i = 0; i < getAllBees().size(); i++) {
            getAllBees().get(i).damage();
        }
    }
}

