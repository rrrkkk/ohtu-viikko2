/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

/**
 *
 * @author r
 */
public class QueryBuilder {
    Matcher matcher;

    public QueryBuilder() {
        matcher = new MockMatcher();
    }

    public Matcher build(){
        return matcher;
    }

    public QueryBuilder playsIn(String team) {
        this.matcher = new And (this.matcher, new PlaysIn(matcher, team));
        return this;
    }

    public QueryBuilder hasAtLeast(int i, String s) {
        this.matcher = new And (this.matcher, new HasAtLeast(matcher, i, s));
        return this;
    }

    public QueryBuilder hasFewerThan(int i, String s) {
        this.matcher = new And (this.matcher, new HasFewerThan(matcher, i, s));
        return this;
    }
}
