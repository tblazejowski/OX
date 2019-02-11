package pl.falcor.ox.timer;

public class RegressiveTimer implements Timer {

    private long milis;

    public RegressiveTimer(long milis) {
        this.milis = milis;
    }

    @Override
    public void startTimer() {

        long reachPointTime = System.currentTimeMillis() + milis;
        long distanceRemained = reachPointTime - System.currentTimeMillis();

        System.out.print((distanceRemained / 1000) + " sek\r");

        while (distanceRemained > 0) {
            long timeTillNextDisplayChange = 1000 - ((reachPointTime - System.currentTimeMillis()) % 1000);
            try {
                Thread.sleep(timeTillNextDisplayChange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            distanceRemained = reachPointTime - System.currentTimeMillis();
            System.out.print((distanceRemained / 1000) + " sek\r");
        }
    }
}