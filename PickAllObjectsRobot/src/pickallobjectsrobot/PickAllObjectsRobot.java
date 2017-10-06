package pickallobjectsrobot;

//////////////////////////////////////////////////////////////////////////////////////////////////////
// PickAllObjectsRobot.java                                                                         //
// =========================                                                                        //
// This Java file executes the following operations:                                                //
//                                                                                                  //
//     (i)    Creates a city called Jerusalem that encompasses 4 connected walls in the shape of    //
//            a square.                                                                             //
//     (ii)   Creates objects (mainly books -including one iPod) on all of the intersections of     //
//            the area within the walls except for the last intersection.                           //
//     (iii)  Places TWO OBJECTS (book and iPod) at the same intersection (st 4, ave 3).            //
//     (iv)   Run code that makes the robot (Adam) pick up all the objects.                         //
//     (v)    The robot (Adam) does not know the exact location of the objects nor                  //
//            the length/size of the distance it will traverse.                                     //
//                                                                                                  //
//                                                                                                  //
// AUTHOR: Ibrahim Salem (ibmundus@gmail.com)                                                    //
// CREATED: 2017-4-06                                                                               //
// UPDATED: 2017-4-08                                                                               //
//////////////////////////////////////////////////////////////////////////////////////////////////////

import becker.robots.*;

public class PickAllObjectsRobot {

    public static void main(String[] args)
    {
        // Create an instance of a city object and call it Jerusalem
        City jerusalem = new City();
        // Invoke an instance of the method makeWalls in order to create the city walls
        makeWalls(jerusalem);
        // Invoke an instance of the method createThings to place the objects (Things) within the city walls
        createThings(jerusalem);
        // Create a robot called Adam and place it at the following intersection: st 1, ave 0
        Robot adam = new Robot(jerusalem, 1, 0, Direction.EAST);
        
        /* Invoke an instance of traverseTwoStreets -please refer to the method's signature/body for comments concerning 
         * its function/s-. */
        traverseTwoStreets(adam);
        /* Invoke an instance of exceptionCase -please refer to the method's signature/body for comments concerning 
         * its function/s-. */
        exceptionCase(adam);
        /* Invoke an instance of stopCase -please refer to the method's signature/body for comments concerning
         * its function/s-. */
        stopCase(adam);
    }    
    
    /* As has been mentioned in class: in this course we will always use private static.
     * Hence, all of the methods created below are defined as 'private'. */
    
    // This method allows the robot to traverse any given two streets in any given square
    /* The robot moves forward as it traverses the first street and backward as it traverses the second street. */
    public static void traverseTwoStreets(Robot r)
    {
        /* Initialize an integer counter (sentinel value) in order to calculate the distance the robot covers
         * as it traverses the first street.*/
        int counter = 0;
        while(r.frontIsClear()) // While the front is clear pick all objects, move forward, and increment counter
        {
            pickAllThings(r);
            r.move();
            counter++; // Increment the numeric value of counter
            while(r.frontIsClear()==false) // While the front is not clear turn right, move, then turn right again,
            {                              // then traverse the second street while picking up all the objects
                pickAllThings(r);
                turnRight(r);
                r.move();
                pickAllThings(r);
                turnRight(r);
                moveAndPickAllThings(r, counter); // Pick all objects, and traverse as many steps as the counter allows.                                               
                exceptionCase(r); // Invoke the exception case. If its logic is true stop the robot, if not continue 
            }                    //  traversing the streets and picking up the remaining objects
        }                       //   (i.e. invoke traverseTwoStreets method).
    }
    
    /* This method allows the robot/program to validate whether the entire square area has been traversed or not. */
    // If the entire square area has been traversed the program will stop, if not the program will continue
    public static void exceptionCase(Robot r)
    {
        r.turnLeft();
        if(r.frontIsClear() == false) // If after traversing street x forward and street y backward
        {                            //  the front is not clear (i.e. the robot has traversed the entire square area),
            stopCase(r);            //   then stop the program/robot by invoking the stopCase method
        }
        else
        {
            // If the front is clear (i.e. the entire square area has not been fully traversed yet), continue
            r.move();
            pickAllThings(r);
            r.turnLeft();
            traverseTwoStreets(r); // Invoke traverseTwoStreets method [traverse street1 forward and street2 backwards]
        }
    }
    
    /* This methods stops the program/robot if the front is not clear AND all objects have been picked. */
    public static void stopCase(Robot r)
    {
        while(r.frontIsClear() == false)
            while(r.canPickThing() == false)
            break;
    }
    
    /* This method moves the robot forward in compliance with the value of the integer parameter. While moving,
     * the robot also picks all of the objects it finds along the path of its traversal. */
    private static void moveAndPickAllThings(Robot r, int x)
    {
        for(int i=0; i<x; i++)
        {
            r.move();
            while(r.canPickThing())
            {
                r.pickThing();
            }
        }
        
    }
    
    // This methods makes the robot pick all of the objects it finds along the path of its traversal
    private static void pickAllThings(Robot r)
    {
        while(r.canPickThing())
        {
            r.pickThing();
        }
    }
    
    // This method allows the robot to turn right (by means of making the robot turn left 3 times)
    private static void turnRight(Robot r) 
    {
        for(int i=0; i<3;i++)
        {
            r.turnLeft();
        }
    }
    
    
    // This method creates the walls of the program's city. A for loop has been used to minimize the code's size
    private static void makeWalls(City city) 
    {
        Wall[] walls = new Wall[6];
        
        for(int i=0; i<6; i++)
        {
            walls[i] = new Wall(city, i+1, 5, Direction.EAST);
            walls[i] = new Wall(city, i+1, 0, Direction.WEST);
            walls[i] = new Wall(city, 1, i, Direction.NORTH);
            walls[i] = new Wall(city, 6, i, Direction.SOUTH);
        }
    }
    
    /* This method creates the city's objects and places them within the city walls.
     * A for loop has been used to minimize the code's size. */
    private static void createThings(City city)
    {
        int i =0, j =1;
        Thing book = new Thing(city, j, i);
        Thing ipod = new Thing(city, j, i);
        
        //Most of the curly braces were excluded here for stylistic purposes [minimizing the code length]
        
        /* For loop with nested if else statements: //purpose\\: fill out the walls area with objects 
         * without having to type down standalone code for each object on its own. */
        for(i=0; i<6; i++)
            for(j=1; j<7; j++)
            if(i == 5 && j == 6)
            continue;  // Forgo placing an object at the aforementioned intersection
        else
            if(i == 3 && j == 3)
        {   // Place TWO OBJECTS at the same intersection (st 4, ave 3)
            book = new Thing(city, j, i);
            ipod = new Thing(city, j, i);
        }
        else // continue with placing the remaining objects
        {
            book = new Thing(city, j, i);
        }
    }
}