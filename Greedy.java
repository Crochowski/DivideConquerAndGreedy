package assignment2;

import java.util.LinkedList;

public class Greedy {

    public static LinkedList<Activity> activitySelection(LinkedList<Activity> activities) {
        // TASK 1.B.a
        LinkedList<Activity> A = new LinkedList<Activity>();  // Create empty linked list to store activities (Initialise solution set)

        A.addLast(activities.getFirst()); // Add the first activity to the new list

        Activity j = activities.pop(); // Remember the first activity & remove it from the list

        int length = activities.size(); // Get size of remaining activity list

        for(int i=0; i<length; i++) {   // Loop through activities list (As long as there are decisions left)
            // Get current activity
            Activity current = activities.pop();

            if (! (current.overlap(j))) {    // If current activity does not overlap last activity
                A.addLast(current);          // Add the current activity to the list
                j = current;                 // Remember this activity was added last
            }
        }

        return A;       // Return the chosen list of non-overlapping activities
    }

    public static LinkedList<Integer> makeChange(int amount, int[] denominations) {
        // TASK 1.B.b
        LinkedList<Integer> change = new LinkedList<Integer>();     // Initialise solution set

        for (int i=0; i<denominations.length; i++) {       // Loop through available denominations
            int current_denomination = denominations[i];  // Store current denomination being considered

            while (amount - current_denomination >= 0) {  // While the amount - current_denomination does not result in a negative value
                change.addLast(current_denomination);     //  Add the denomination to the list
                amount -= current_denomination;           // Subtract the denomination from the amount
            }
        }

        return change;      // Return the list of denominations
    }

    public static void main(String[] args) {
        LinkedList<Activity> activities = new LinkedList<Activity>();
        activities.add(new Activity(1,1, 4));
        activities.add(new Activity(2, 3, 5));
        activities.add(new Activity(3, 0, 6));
        activities.add(new Activity(4, 5, 7));
        activities.add(new Activity(5, 3, 8));
        activities.add(new Activity(6, 5, 9));
        activities.add(new Activity(7, 6, 10));
        activities.add(new Activity(8, 8, 11));
        activities.add(new Activity(9, 8, 12));
        activities.add(new Activity(10, 2, 13));
        activities.add(new Activity(11, 12, 14));
        activitySelection(activities).forEach(a -> a.print());

        System.out.println();
        makeChange(1234, new int[] { 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1 }).forEach(i -> System.out.println(i));
    }
}
