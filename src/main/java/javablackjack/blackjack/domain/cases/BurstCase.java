package javablackjack.blackjack.domain.cases;

import javablackjack.blackjack.domain.GameResult;
import javablackjack.blackjack.domain.player.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class BurstCase extends AbstractResultCases {
    @Override
    public List<Function<Pair, GameResult>> caseList() {
        List<Function<Pair, GameResult>> list = new ArrayList<>();
        list.add((pair) -> getGameResult(pair.isUserBurst(), GameResult.DEALER_WIN));
        list.add((pair) -> getGameResult(pair.isDealerBurst(), GameResult.USER_WIN));
        return list;
    }
}
