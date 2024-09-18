package doctrina.engine.engine;

public class GameTime {

    private static GameTime instance;
    private static final int SLEEP = 25;
    private long syncTime;

    public static GameTime getInstance() {
        if (instance == null) {
            instance = new GameTime();
        }
        return instance;
    }

    private GameTime() {
        updateSyncTime();
    }

    public static long getCurrentTime() {
        return System.currentTimeMillis();
    }

    private long getSleep() {
        long sleep = SLEEP - (System.currentTimeMillis() - syncTime);
        if (sleep < 4) {
            sleep = 4;
        }
        return sleep;
    }

    private void updateSyncTime() {
        syncTime = System.currentTimeMillis();
    }

    public void sleep() {
        long sleep = getSleep();

        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        updateSyncTime();
    }
}
