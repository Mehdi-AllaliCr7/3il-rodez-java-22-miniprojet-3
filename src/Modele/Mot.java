package Modele;

import java.io.*;
import java.util.*;

public class Mot {
    private String mot;
    private String definition;

    public Mot(String mot, String definition) {
        this.mot = mot;
        this.definition = definition;
    }

    public String getMot() {
        return mot;
    }

    public String getDefinition() {
        return definition;
    }
}


