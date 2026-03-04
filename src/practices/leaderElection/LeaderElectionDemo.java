package practices.leaderElection;

public class LeaderElectionDemo {

    public static void main(String[] args) {

        new Thread(new Node("Node-1")).start();
        new Thread(new Node("Node-2")).start();
        new Thread(new Node("Node-3")).start();
    }
}