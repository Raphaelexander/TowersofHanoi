import java.util.Arrays;

public class Hanoi {

    public static void main(String args[]) {
        int[] tower1 = {1, 2, 3};
        int[] tower2 = {0, 0, 0};
        int[] tower3 = {0, 0, 0};

        System.out.println("Three towers stand: " + Arrays.toString(tower1) + Arrays.toString(tower2) + Arrays.toString(tower3));
        Hanoi.Towers(tower1, tower2, tower3);
        System.out.println("After recursion, three towers still stand: " + Arrays.toString(tower1) + Arrays.toString(tower2) + Arrays.toString(tower3));
    }

    public static int[] Towers(int[] tower1, int[] tower2, int[] tower3) {
        int top1 = 0; 
        int top2 = 0;
        int top3 = 0;
        if (tower3[0] == 0) { //if target tower is empty
            for (int i = 0; i < tower1.length; i++) { //find largest block in start tower
                if (tower1[i] > top1) {
                    top1 = tower1[i];
                }
            }
            tower3[0] = top1; //base of target tower is largest block from start tower
            top1 = 0;
            return Towers(tower1, tower2, tower3); //recursion

        } else if (top1 < tower3[0]) { //if new largest block from start tower is bigger than block on top of target tower
            if (tower2[0] == 0) { //if aux tower is empty
                for (int i = 0; i < tower1.length; i++) { //find largest block in start tower
                if (tower1[i] > top1) {
                    top1 = tower1[i];
                }
            }
                tower2[0] = top1;//base of aux tower is largest block from start tower
                top2 = 0; //top of start tower is null
                return Towers(tower1, tower2, tower3);

            } else if (tower2[1] != 0){ //if aux tower has a block
                for (int i = 0; i < tower3.length; i++ ) {
                    if (tower3[i] > top3) {
                        top3 = tower3[i];
                    }
                }
                tower2[1] = top3; //then top block from target tower goes on top of aux tower
                tower3[0] = 0; //target tower is empty
                
                return Towers(tower1, tower2, tower3);
            }
        } else if (tower3[0] == 1) { //if base of target has largest block
            for (int i = 0; i < tower2.length; i++) { //find largest block in aux
                if (tower2[i] > top2) {
                    top2 = tower2[i];
                }
            }
            if (top2 > tower1[0]) { //if start tower has no block
                tower1[0] = top2; //base of start tower is previous top of aux tower
                tower2[top2] = 0; //top of aux tower empty
                Towers(tower1, tower2, tower3);
            } else if (top2 < tower1[0]) { //if start tower does have block
                for (int i = 0; i < tower2.length; i++) { //find largest block in aux
                    if (tower2[i] > top2) {
                        top2 = tower2[i];
                }
            }
                tower3[1] = top2;
                tower2[top2] = 0;
                Towers(tower1, tower2, tower3);
            } else if (tower3[1] == 2) {
                for (int i = 0; i < tower1.length; i++) { //find largest block in start
                    if (tower1[i] > top1) {
                        top1 = tower1[i];
                    }
                }
                tower3[2] = top1;
                tower1[0] = 0;
            }
        }
        return tower3;
    }
}

//     public boolean checkTowers(int[] tower1, int[] tower2, int[] tower3){
//         boolean check = true;
//         if(tower3[2] != 3){
//             for (int block : tower1) {
//             }
//             for (int block : tower2) {
//                 if(tower2[block] > tower2[block + 1]){
//                     check = false;
//                 }
//             }
//             for (int block : tower3) {
//                 if(tower3[block] > tower3[block + 1]){
//                     check = false;
//                 }
//             }
//         }
//         return check;
//     }
// }


// tower1 base move to tower3
// if block on top of base
// find smallest block, move to target
//if no block on top of tower1 base
//try to move to tower3
//if smaller block below, move that block to tower2
//else move to tower3
//if big block at base of tower3, if smallest block on tower2, move to tower1
//else move remaining block from tower2 to tower 3
// reiterate


//smallest block is 2, try to move to target
//move to aux tower
//reiterate
