package authoring.eventhandlers;

import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import authoring.view.propertiesview.PropertiesView;
import authoring.view.spritesview.GameObjectGraphic;

public class GameObjectClickHandler implements GameHandler<MouseEvent>{

	private PropertiesView myProperties;
	
	public GameObjectClickHandler(PropertiesView props){
		myProperties = props;
	}
	
	@Override
	public void handle(MouseEvent event) {
		GameObjectGraphic g = (GameObjectGraphic) event.getSource();
		//System.out.println(g.getGameObject().getCurrentImageName());
		myProperties.makeProperties(g.getGameObject());
		
	}

	@Override
	public EventType<MouseEvent> getEventType() {
		return MouseEvent.MOUSE_PRESSED;
	}

}
