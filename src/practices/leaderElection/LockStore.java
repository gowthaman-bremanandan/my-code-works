package practices.leaderElection;

import java.util.concurrent.*;

class LockStore {

    private static final ConcurrentHashMap<String, Long> locks = new ConcurrentHashMap<>();

    public static synchronized boolean tryAcquire(String key, long expiryMillis) {

        long now = System.currentTimeMillis();

        if (!locks.containsKey(key) || locks.get(key) < now) {
            locks.put(key, now + expiryMillis);
            return true;
        }

        return false;
    }

    public static synchronized void renew(String key, long expiryMillis) {
        locks.put(key, System.currentTimeMillis() + expiryMillis);
    }
}
