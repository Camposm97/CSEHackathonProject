package cabrera.view.control;

import cabrera.controllers.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ChatPane {
	VBox box;
	TextArea text;
	Label label;
	TextField textF;

	public ChatPane() {
		box = new VBox();
		
		label = new Label("Chatting with: ");
		label.setFont(new Font(20));
		box.getChildren().add(label);
		
		text = new TextArea();
		text.setEditable(false);
		text.setPrefHeight(300);
		box.getChildren().add(text);
		
		textF = new TextField();
		textF.setPromptText("Enter message here");
		textF.setOnAction(e ->{
			sendMessage();
		});
		box.getChildren().add(textF);
		
		Button button = new Button("Send");
		button.setPrefWidth(200);
		button.setOnAction(e ->{
			sendMessage();
		});
		box.getChildren().add(button);
		
		box.setAlignment(Pos.CENTER);
		box.setSpacing(10);
		box.setPadding(new Insets(0,0,0,20));
	}

	private void sendMessage() {
		//Will change to users username
		String message = "<userName> " + textF.getText() + "\n";
		Controller.addMessage(message);
		text.appendText(message);
		textF.clear();
	}

	public VBox getVBox() {
		return box;
	}
	public TextArea getText() {
		return text;
	}
	public Label getLabel() {
		return label;
	}
}
