package sample;

import java.util.ArrayList;

interface UserInterface {
    public void giveStatus(String status);
    public int askForCommand(String question, String[] options);
}