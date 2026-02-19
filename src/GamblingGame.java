public interface GamblingGame {
    String[] play();
    int getWinnings(String[] result, int bet);
    String getRules();
}