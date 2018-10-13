package quizdate.controller;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import quizdate.model.ChatRoom;
import quizdate.model.MatchService;
import quizdate.model.User;
import quizdate.model.UserRepository;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ChatController implements Initializable {
    @FXML
    private Button btn_settings;
    @FXML
    private Button btn_home;
    @FXML
    private ListView view;

    private static final MainController MAIN_CONTROLLER = MainController.getMainController();
    private static final MatchService MATCH_SERVICE = MatchService.getInstance();
    private static final UserRepository USER_REPOSITORY = UserRepository.getInstance();
    private User currentUser = MAIN_CONTROLLER.getCurrentUser();
    private static int debug = 1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(debug==1) {
            System.out.println("debug");
            User u1 = USER_REPOSITORY.get(2);
            MATCH_SERVICE.createMatch(currentUser,u1);
            u1.getChat(0).sendMessage("hello",u1);
            u1.getChat(0).sendMessage("How are you",u1);
            u1.getChat(0).sendMessage("Can i come over?",u1);
            u1.getChat(0).sendMessage("Sexy girls in your region",u1);
            debug++;
        }

        System.out.println("getting matches");
        List<ChatRoom> chats = currentUser.getChats();
        view.getItems().removeAll();

        for(ChatRoom c: chats){
            StringBuilder name = new StringBuilder();
            for(User u : c.getUsers()){
                if(u != currentUser) {
                    name.append(u);
                }
            }
            Button button = new Button(name.toString());
            button.setPrefSize(500, 100);
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    MAIN_CONTROLLER.switchSceneChatWindow(event, button,c);
                }
            });
            view.getItems().add(button);
        }

    }
    public void settingsButtonPressed(ActionEvent event) {
        System.out.println("settings button clicked...");
        MAIN_CONTROLLER.switchSceneEditUser(event, btn_settings);
    }

    public void homeButtonPressed(ActionEvent event) {
        System.out.println("Home button clicked...");
        MAIN_CONTROLLER.switchSceneFindMatch(event, btn_home);
    }


}
