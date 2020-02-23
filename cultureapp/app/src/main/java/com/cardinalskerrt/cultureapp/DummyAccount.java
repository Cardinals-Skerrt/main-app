package com.cardinalskerrt.cultureapp;

import java.util.ArrayList;

public class DummyAccount {

    String artistName;
    String shortDesc;
    String[] artistArtString;
    int profilePicID;
    int[] artistArt;

    DummyAccount(String artistName, int profilePicID, int []artistArt, String[] artistArtString, String shortDesc){
        this.artistName = artistName;
        this.profilePicID = profilePicID;
        this.artistArt = artistArt;
        this.shortDesc = shortDesc;
        this.artistArtString = artistArtString;
    }

    public ArrayList<DummyAccount> getDummyAccounts(){

        ArrayList<DummyAccount> dummyAccounts = new ArrayList<>();

        int[] tempArray  = {R.drawable.suki,R.drawable.sabit,R.drawable.dany};
        String[] tempArray2 = {"Suki", "Sabit", "Dany"};
        dummyAccounts.add(new DummyAccount("Gabriel Rokda", R.drawable.gaby_artist, tempArray, tempArray2
                , "His work has evolved from oil paintings and mirror installations. Now he focuses on daily lives of Filipino people. " +
                "Won CCP’s Thirteen Artists Award in 2012 and the Ateneo Art Awards’ Fernando Zobel Prize for Visual Arts in 2017."));

        tempArray  = new int[] {R.drawable.pader,R.drawable.buhayngin,R.drawable.ikaw};
        tempArray2 = new String[] {"Pader", "Buhayngin", "Ikaw"};
        dummyAccounts.add(new DummyAccount("King McKing", R.drawable.king_artist, tempArray, tempArray2
                ,"His sculptures explores themes of femininity, sensuality, and mental health. Mainly on the perception of families."));

        tempArray  = new int[] {R.drawable.lipunan,R.drawable.hardin,R.drawable.palengke};
        tempArray2 = new String[] {"Lipunan", "Hardin", "Palengke"};
        dummyAccounts.add(new DummyAccount("Julie Flitoy", R.drawable.julie_artist, tempArray, tempArray2
                ,"Fresh out of college, her artworks exhibits the fusion of pop-art and abstract realism."));

        tempArray  = new int[] {R.drawable.blackout,R.drawable.sinag,R.drawable.lagusan};
        tempArray2 = new String[] {"Blackout", "Sinag", "Lagusan"};
        dummyAccounts.add(new DummyAccount("Rambert 'Mamba' Joaquinez", R.drawable.bert_artist, tempArray, tempArray2
                ,"Though he often works with traditional painting media such as oil and acrylic on canvas, he has experimented with rust" +
                " to serve as both a material and subject."));

        tempArray  = new int[] {R.drawable.balanse,R.drawable.dany,R.drawable.bakit};
        tempArray2 = new String[] {"Sapul", "Dany", "Bakit"};
        dummyAccounts.add(new DummyAccount("Francisco Balagtas Jr.", R.drawable.francis_artist, tempArray, tempArray2
                ,"A young aspiring artist delving to whimsical and colorful works. He does view the world in a very unique way."));

        tempArray  = new int[] {R.drawable.stand,R.drawable.langit,R.drawable.bulag};
        tempArray2 = new String[] {"Stand", "Langit", "Bulag"};
        dummyAccounts.add(new DummyAccount("Lex 'Lexicon' Miranda", R.drawable.lex_artist, tempArray, tempArray2
                ,"Young sculptor and visual artist explores themes of femininity, sensuality, and mental health. Mainly on the " +
                "perception of families."));

        tempArray  = new int[] {R.drawable.sandal,R.drawable.higa,R.drawable.balanse};
        tempArray2 = new String[] {"Sandal", "Higa", "Balanse"};
        dummyAccounts.add(new DummyAccount("Justin Salmendo", R.drawable.ja_artist, tempArray, tempArray2
                ,"A young aspiring artist delving to solid and dark works. He does view the world in a very unique way. "));

        tempArray  = new int[] {R.drawable.eba,R.drawable.bulag,R.drawable.maskara};
        tempArray2 = new String[] {"Eba", "Bulag", "Maskara"};
        dummyAccounts.add(new DummyAccount("Kamille Lonz", R.drawable.kams_artist, tempArray, tempArray2
                ,"Fresh out of college, her works exhibits the fusion of pop-art and abstract realism. "));

        return dummyAccounts;
    }

}
