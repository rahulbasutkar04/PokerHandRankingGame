import com.amaap.pokerhandranking.AppConfig;
import com.amaap.pokerhandranking.controller.HandController;
import com.amaap.pokerhandranking.controller.RankController;
import com.amaap.pokerhandranking.service.exception.CardsNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws CardsNotFoundException {
        AppConfig appConfig = new AppConfig();
        HandController handController = appConfig.handController();
        RankController rankController = appConfig.rankController();

        List<String> userHand = new ArrayList<>();
        userHand.add("HA");
        userHand.add("SA");
        userHand.add("DA");
        userHand.add("CA");
        userHand.add("S8");

        handController.receiveCards(userHand);
        rankController.getHandRank();
    }
}
