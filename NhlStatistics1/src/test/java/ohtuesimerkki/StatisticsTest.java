/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author r
 */
public class StatisticsTest {
 
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Staatistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }  
    
    @Test
    public void testTeam() {
        System.out.println("team");
        String teamName = "EDM";
        List<Player> result = stats.team(teamName);
        assertEquals("Semenko", result.get(0).getName());
    }
    
    @Test
    public void testSearch() {
        System.out.println("search");
        String name = "Kurri";
        Player result = stats.search(name);
        assertEquals(name, result.getName());
    }

    @Test
    public void testSearchNotFound() {
        System.out.println("search");
        String name = "Kalinen";
        Player result = stats.search(name);
        assertEquals(null, result);
    }
     
    @Test
    public void testTopScorers() {
        System.out.println("topScorers");
        int howMany = 1;
        List<Player> result = stats.topScorers(howMany);
        assertEquals("Gretzky", result.get(0).getName());
    }
    
}
