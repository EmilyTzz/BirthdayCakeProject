package emily.birthday_cake.birthdaycakeproject;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

/**
 * This class is the controller for the secondary window of the birthday letter
 */
public class LetterController {

    @FXML
    private TextArea letterTextArea;

    /**
     * This method helps to add a Happy Birthday message on to the letter
     */
    public void initialize(){
        letterTextArea.setText("**Happy Birthday!**\n" +
                "\n" +
                "Happy birthday! I hope you have an amazing day and get to spend it with the people you love. I hope this year brings you lots of happiness, good memories, and new experiences.\n" +
                "\n" +
                "I’m really grateful to have you in my life, and I appreciate all the memories, conversations, and moments we’ve shared. You’re such an important person to me, and I hope you know how much you’re appreciated.\n" +
                "\n" +
                "I hope you get everything you’ve been wishing for and that all your goals and dreams come true. You deserve a year filled with happiness, success, and plenty of reasons to smile.\n" +
                "\n" +
                "Happy birthday again! I hope you have a wonderful day and an even better year ahead.\n");
    }

}
