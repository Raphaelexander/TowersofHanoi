import java.util.Arrays;

public class Hanoi {

    public static void main(String args[]) { 
        int[] tower1 = {1, 2, 3}; // 1 is the smallest disk, 3 is the largest disk
        int[] tower2 = {0, 0, 0};// 0 means no disk
        int[] tower3 = {0, 0, 0};

        // print the initial state of the three towers
        System.out.println("Three towers stand: " + Arrays.toString(tower1) + Arrays.toString(tower2) + Arrays.toString(tower3)); 
        Towers(tower1.length, tower1, tower2, tower3);// move all disks from tower1 to tower3
        System.out.println("After recursion, three towers still stand: " + Arrays.toString(tower1) + Arrays.toString(tower2) + Arrays.toString(tower3));// print the final state of the three towers
    } // end of main

    public static void Towers(int n, int[] tower1, int[] tower2, int[] tower3) {
        if (n > 0) { // move n-1 disks from tower1 to tower2 using tower3
            Towers(n - 1, tower1, tower3, tower2);// move n-1 disks from tower1 to tower2 using tower3
            moveDisk(tower1, tower3);// move the top disk from tower1 to tower3
            System.out.println("Moved disk from tower1 to tower3: " + Arrays.toString(tower1) + Arrays.toString(tower2) + Arrays.toString(tower3));
             // print the state after moving disk
            Towers(n - 1, tower2, tower1, tower3);// move n-1 disks from tower2 to tower3 using tower1
        }// end of if
    }// end of Towers

    public static void moveDisk(int[] fromTower, int[] toTower) { // move the top disk from fromTower to toTower
        int fromIndex = -1; // find the index of the top disk in fromTower
        int toIndex = -1; 

        for (int i = 0; i < fromTower.length; i++) { 
            // find the index of the first non-zero element in fromTower
            if (fromTower[i] != 0) {
                fromIndex = i;// store the index of the top disk in fromTower
                break;
            }
        }

        for (int i = toTower.length - 1; i >= 0; i--) {// find the index of the first zero element in toTower
            if (toTower[i] == 0) {
                toIndex = i;// store the index of the top disk in toTower
                break;
            }
        }

        if (fromIndex != -1 && toIndex != -1) { // move the top disk from fromTower to toTower
            toTower[toIndex] = fromTower[fromIndex];
            fromTower[fromIndex] = 0; // remove the top disk from fromTower
       
        } // end of if
    } // end of moveDisk
} // end of Hanoi.java
//ouput of the program is: Three towers stand: [1, 2, 3][0, 0, 0][0, 0, 0]
//Moved disk from tower1 to tower3: [0, 2, 3][0, 0, 0][0, 0, 1]
//Moved disk from tower1 to tower3: [0, 0, 3][0, 0, 1][0, 0, 2]
//Moved disk from tower1 to tower3: [0, 0, 0][0, 0, 3][0, 1, 2]
//Moved disk from tower1 to tower3: [0, 0, 0][0, 1, 2][0, 0, 3]
//Moved disk from tower1 to tower3: [0, 0, 2][0, 0, 3][0, 0, 1]
//Moved disk from tower1 to tower3: [0, 0, 0][0, 0, 1][0, 2, 3]
//Moved disk from tower1 to tower3: [0, 0, 0][0, 0, 0][1, 2, 3]
//After recursion, three towers still stand: [0, 0, 0][0, 0, 0][1, 2, 3]