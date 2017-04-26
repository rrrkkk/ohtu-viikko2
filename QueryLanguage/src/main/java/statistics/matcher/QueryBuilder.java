/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import statistics.Player;

/**
 *
 * @author r
 */
public class QueryBuilder {
    Matcher matcher;

    public QueryBuilder() {
        matcher = new MockMatcher();
    }

    public QueryBuilder playsIn(String team) {
        this.matcher = new PlaysIn(matcher, team);
        return this;
    }

    public Matcher build(){
        return matcher;
    }
}
