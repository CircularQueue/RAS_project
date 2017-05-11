package GUI.employee;

import javax.swing.SwingUtilities;

import javafx.embed.swing.SwingNode;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EmployeeGUIWrapper {

	public EmployeeGUIWrapper() {
        final SwingNode swingNode = new SwingNode();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);

		
        createSwingContent(swingNode);

        BorderPane pane = new BorderPane();
        pane.getChildren().add(swingNode);
        
        stage.setTitle("Swing in JavaFX");
        stage.setScene(new Scene(pane));
        stage.showAndWait();
        }

    private void createSwingContent(final SwingNode swingNode) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	new EmployeeGUI().setVisible(true);;
//                swingNode.setContent(empGUI);
            	
            	
            }
        });
    }
	

}
