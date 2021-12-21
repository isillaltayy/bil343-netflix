import javax.swing.*;

public class Films {
    private String filmName;
    private String genre;
    private boolean lockControl;
    private ImageIcon imageIcon;

    public Films(String filmName,String genre, boolean lockControl,ImageIcon imageIcon){
       this.filmName=filmName;
       this.genre=genre;
       this.lockControl=lockControl;
       this.imageIcon=imageIcon;
    }
    public String getFilmName() {
        return filmName;
    }
    public String getGenreName() {
        return genre;
    }
    public boolean getLockControl() {
        return lockControl;
    }
    public ImageIcon getImageIcon(){return imageIcon;}

}
