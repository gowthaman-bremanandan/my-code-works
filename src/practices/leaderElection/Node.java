package practices.leaderElection;

class Node implements Runnable {

    private final String nodeId;
    private boolean isLeader = false;

    public Node(String nodeId) {
        this.nodeId = nodeId;
    }

    @Override
    public void run() {

        while (true) {

            if (!isLeader) {
                boolean acquired = LockStore.tryAcquire("LEADER", 5000);

                if (acquired) {
                    isLeader = true;
                    System.out.println(nodeId + " became LEADER");
                }
            } else {
                LockStore.renew("LEADER", 5000);
                System.out.println(nodeId + " renewing leadership");
            }

            try { Thread.sleep(2000); }
            catch (InterruptedException e) { }
        }
    }
}
