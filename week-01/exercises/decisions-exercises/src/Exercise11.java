public class Exercise11 {

    public static int managerCount(boolean[] array) {
        int sum = 0;
        for (boolean manager : array) {
            if (manager) {
                sum += 1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        // MANAGER FEATURE REQUESTS
        // You have three managers: A, B, and C.
        // Occasionally, they ask you to add features to your company software.
        // Use if/else statements to enforce the following rules:
        // - If all three ask for the feature, print "Feature in progress."
        // - If any two of the three ask, print "Adding feature to schedule."
        // - If only one of the three ask, print "Going to hold off for a bit."
        // - If none of the managers ask, print "Nothing to do..."

        boolean managerAAsked = true;
        boolean managerBAsked = true;
        boolean managerCAsked = true;

        // 1. Add decisions statements to cover all scenarios.
        // 2. Change manager variables to test all scenarios.

        boolean[] managerArray = {managerAAsked, managerBAsked, managerCAsked};

        switch (managerCount(managerArray)) {
            case 0:
                System.out.println("Nothing to do...");
            case 1:
                System.out.println("Going to hold off for a bit.");
            case 2:
                System.out.println("Adding feature to schedule.");
            case 3:
                System.out.println("Feature in progress.");
        }

    }
}
