import javax.swing.*;
import java.util.ArrayList;

public class FilmRepo {
    ArrayList<Films> films;

    public FilmRepo()
    {
        films = new ArrayList<Films>();
        films.add(new Films("Wonder Woman","Action & Adventure",true, new ImageIcon((getClass().getResource("films/0.png")))));
        films.add(new Films("Black Panther","Action & Adventure",true,new ImageIcon((getClass().getResource("films/1.png")))));
        films.add(new Films("End Game","Action & Adventure",true,new ImageIcon((getClass().getResource("films/2.png")))));
        films.add(new Films("Charlie and the Chocolate Factory","Children & Family",true,new ImageIcon((getClass().getResource("films/3.png")))));
        films.add(new Films("Minions","Children & Family",true,new ImageIcon((getClass().getResource("films/4.png")))));
        films.add(new Films("Shrek","Children & Family",true,new ImageIcon((getClass().getResource("films/5.png")))));
        films.add(new Films("The Croods","Children & Family",true,new ImageIcon((getClass().getResource("films/6.png")))));
        films.add(new Films("Due date","Comedies",false,new ImageIcon((getClass().getResource("films/7.png")))));
        films.add(new Films("Last Vegas","Comedies",false, new ImageIcon((getClass().getResource("films/8.png")))));
        films.add(new Films("Hangover","Comedies",false,new ImageIcon((getClass().getResource("films/9.png")))));
        films.add(new Films("Schumacher","Documentaries",true,new ImageIcon((getClass().getResource("films/10.png")))));
        films.add(new Films("The Mind, Explained","Documentaries",true,new ImageIcon((getClass().getResource("films/11.png")))));
        films.add(new Films("Cosmos","Documentaries",true,new ImageIcon((getClass().getResource("films/12.png")))));
        films.add(new Films("Get Out","Horror",false,new ImageIcon((getClass().getResource("films/13.png")))));
        films.add(new Films("Orphan","Horror",false,new ImageIcon((getClass().getResource("films/14.png")))));
        films.add(new Films("IT","Horror",false, new ImageIcon((getClass().getResource("films/15.png")))));
        films.add(new Films("The Conjuring","Horror",false,new ImageIcon((getClass().getResource("films/16.png")))));
        films.add(new Films("The Notebook","Romantic",false,new ImageIcon((getClass().getResource("films/17.png")))));
        films.add(new Films("Call Me by Your Name","Romantic",false,new ImageIcon((getClass().getResource("films/18.png")))));
        films.add(new Films("Eternal Sunshine","Romantic",true,new ImageIcon((getClass().getResource("films/19.png")))));
        films.add(new Films("Before Sunrise","Romantic",true,new ImageIcon((getClass().getResource("films/20.png")))));
        films.add(new Films("Lucy","Sci-fi & Fantasy",true,new ImageIcon((getClass().getResource("films/21.png")))));
        films.add(new Films("Black Mirror: Bandersnatch","Sci-fi & Fantasy",true,new ImageIcon((getClass().getResource("films/22.png")))));
        films.add(new Films("The Platform","Sci-fi & Fantasy",true,new ImageIcon((getClass().getResource("films/23.png")))));
    }
}
