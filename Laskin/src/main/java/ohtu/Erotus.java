/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import javax.swing.JTextField;

/**
 *
 * @author r
 */
public class Erotus implements Komento {
    
    private Sovelluslogiikka sov;
    private JTextField tulos, syote;
    private int vanha_tulos;

    public Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        sov = sovellus;
        tulos = tuloskentta;
        syote = syotekentta;
    }
    
    public void suorita() {
        vanha_tulos = sov.tulos();
        sov.miinus(Integer.parseInt(syote.getText()));
        syote.setText("");
        tulos.setText("" + sov.tulos());
    }
    
    public void peru() {
        sov.aseta(vanha_tulos);
        syote.setText("");
        tulos.setText("" + sov.tulos());
    }
    
}
