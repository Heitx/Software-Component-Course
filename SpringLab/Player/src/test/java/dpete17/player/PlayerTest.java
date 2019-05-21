/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpete17.player;

import dpete17.data.GameData;
import dpete17.data.entityparts.MovingPart;
import dpete17.data.entityparts.PositionPart;
import dpete17.system.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author dennis
 */
public class PlayerTest {
    private Player player;
    
    public PlayerTest() {
        
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
        player = new Player();
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testForwardMovement() {        
        PositionPart position = new PositionPart(0, 0, 0);
        MovingPart moving = new MovingPart(10, 200, 300, 5);
        
        player.add(position);
        player.add(moving);
        
        GameData gameData = new GameData();
        gameData.setDisplayWidth(2000);
        gameData.setDisplayHeight(2000);
        gameData.setDelta(1 / 60.0F);
        
        moving.setUp(true);
        moving.process(gameData, player);
        
        assertTrue(position.getX() != 0 || position.getY() != 0 || position.getRadians() != 0);
    }
}
