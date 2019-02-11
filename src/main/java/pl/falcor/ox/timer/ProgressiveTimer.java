package pl.falcor.ox.timer;

public class ProgressiveTimer implements Timer {

    @Override
    public void startTimer() {

        long startTime = System.currentTimeMillis();
        long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.print(elapsedTime + " sek\r");

        while (elapsedTime < 10000) {
            long timeTillNextDisplayChange = 1000 - (elapsedTime % 1000);
            try {
                Thread.sleep(timeTillNextDisplayChange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long elapsedSeconds = (System.currentTimeMillis() - startTime) / 1000;
            System.out.print(elapsedSeconds + " sek\r");
            elapsedTime = System.currentTimeMillis() - startTime;
        }
    }
}