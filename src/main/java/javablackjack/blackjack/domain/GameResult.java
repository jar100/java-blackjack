package javablackjack.blackjack.domain;

public enum GameResult {
    USUER_WIN("유저가 이겼습니다."),
    DEALER_WIN("딜러가 아겼습니다."),
    PUSH("비겼습니다."),
    DEFAULT("");

    private String gameResult;


    GameResult(String gameResult) {
        this.gameResult = gameResult;
    }

    public String getGameResult() {
        return gameResult;
    }

    @Override
    public String toString() {
        return "GameResult{" +
                "gameResult='" + gameResult + '\'' +
                '}';
    }
}
