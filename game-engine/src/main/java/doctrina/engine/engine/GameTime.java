package doctrina.engine.engine;

import java.util.concurrent.TimeUnit;

public final class GameTime {

    private static GameTime instance;

    private final int FPS_TARGET = 60;
    private int currentFPS;
    private int fpsCount;
    private long fpsTimeDelta;
    private long gameStartTime;
    private long syncTime;

    public static GameTime getInstance() {
        if (instance == null) {
            instance = new GameTime();
        }
        return instance;
    }

    protected GameTime() {
        updateSyncTime();
        gameStartTime = System.currentTimeMillis();
        fpsTimeDelta = 0;
        currentFPS = 0;
    }

    public long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public int getCurrentFps() {
        return (currentFPS > 0) ? currentFPS : fpsCount;
    }

    public long getElapsedTime() {
        return System.currentTimeMillis() - gameStartTime;
    }

    public String getFormattedElapsedTime() {
        long seconds = getElapsedTime() / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        return String.format("%02d:%02d:%02d", hours, minutes % 60, seconds % 60);
    }

    protected void sync() {
        update();
        try {
            Thread.sleep(getSleep());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        updateSyncTime();
    }

    private void update() {
        fpsCount++;
        long currentSecond = TimeUnit.MILLISECONDS.toSeconds(getElapsedTime());
        if (fpsTimeDelta != currentSecond) {
            currentFPS = fpsCount;
            fpsCount = 0;
        }
        fpsTimeDelta = currentSecond;
    }

    private long getSleep() {
        long targetTime = 1000L / FPS_TARGET;
        long sleep = targetTime - (System.currentTimeMillis() - syncTime);
        if (sleep < 0) {
            sleep = 4;
        }
        return sleep;
    }

    private void updateSyncTime() {
        syncTime = System.currentTimeMillis();
    }

}
