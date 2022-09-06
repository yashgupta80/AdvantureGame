package AvantureGame;

import java.util.Random;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        /**
         * Game variable
         */
        String[] enemies = {"gorzila", "hitMan", "senfiar", "lionking"};
        int maximumHealth = 80;
        int enemyDamage = 15;

        // player variable:
        int health = 100;
        int attackDamage = 50;
        int numOfHealthPotion = 3;
        int healthPointAmount = 30;
        int healthPotionDropChance= 50;

        // logic of game
        boolean running = true;
        System.out.println("Welcome to the Adventure Game : ---->>>");
        GAME:
        while (running){
            System.out.println("-------------------------------------------------------");

            int enemyHealth = random.nextInt(maximumHealth);
            String enemy = enemies[random.nextInt(enemies.length)];

            System.out.println("\t # " + enemy + " has appeared ! " + "# \n");

             while (enemyHealth > 0){
                 System.out.println("\t your HP: " + health);
                 System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                 System.out.println("\n\t" + "What would you like to do ?");
                 System.out.println("\t1. Attack");
                 System.out.println("\t2. Drink health potion");
                 System.out.println("\t3. Run");

                 String input = sc.nextLine();
                 if (input.equals("1")){
                     int damageDefeat= random.nextInt(attackDamage);
                     int damageTaken = random.nextInt(enemyDamage);

                     enemyHealth -= damageDefeat;
                     health -= damageTaken;

                     System.out.println(
                             "\t > you Strike the "  + enemy + " for " + damageDefeat + " damage "
                     );

                     System.out.println("\t you recieve " + damageTaken + " retation");
                     if (health < 1){
                         System.out.println("you have taken so much of damage ! you are so weak Go!");
                         break ;
                     }
                 }
                 else if (input.equals("2")){
                     if (numOfHealthPotion > 0){
                         health += healthPointAmount;
                         numOfHealthPotion--;
                         System.out.println("\t you drink healthPotion ! yourself for " + healthPointAmount );
                         System.out.println("\t Now your health is " + health + " HP:");
                         System.out.println("you have " + numOfHealthPotion + " healthPotion left !");
                     }else {
                         System.out.println("you have no healthPotion defeat enemy for chance to take healthPotion !");
                     }
                 }
                 else if (input.equals("3")){
                     System.out.println("you are run away from " + enemy);
                     continue GAME;
                 }else {
                     System.out.println("Invalid command !! ");
                 }


             }

             if (health <1){
                 System.out.println("you limp for the damage weak for the battle");
                 break ;
             }

            System.out.println("------------------------------------------------------");
            System.out.println("# " + enemy + " was defeated !! ");
            System.out.println("@@ you have health HP: " + health);
            if (random.nextInt(100) < healthPotionDropChance) {
                numOfHealthPotion++;
                System.out.println(" # " + enemy + " drop the healthPotion ## ...");
                System.out.println("# now you have " + numOfHealthPotion + "HealthPotion !!## ");
            }

            System.out.println("-------------------------------------------------------------");
            System.out.println("\t what would you like to do ? ");
            System.out.println("\t 1. continue fighting");
            System.out.println("\t 2. Exit ");
            String inputs = sc.nextLine();
            while (!inputs.equals("1") && !inputs.equals("2")){
                System.out.println("Invalid Command !! ");
                inputs  = sc.nextLine();


            }

            if (inputs.equals("1")){
                System.out.println("you are continuing playing the game ::::::::");
            }else if (inputs.equals("2")){
                System.out.println("you are exit the adventure game :::::");
                break ;
            }


        }

        System.out.println("##############################");
        System.out.println("THANK YOU FOR PLAY THE GAME :)");
        System.out.println("###############################");



    }
}
