package ru.netology.manager;

import ru.netology.game.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    private ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public Player findPlayer(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findPlayer(playerName1);
        Player player2 = findPlayer(playerName2);
        if (player1 == null) {
            throw new NotRegisteredException("Игрок " + playerName1 + " не зарегистрирован");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Игрок " + playerName2 + " не зарегистрирован");
        }
        if (player1.getStrength() == player2.getStrength()) {
            return 0;
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else {
            return 2;
        }
    }
}