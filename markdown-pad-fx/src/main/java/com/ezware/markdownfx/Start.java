package com.ezware.markdownfx;

import java.util.Arrays;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import org.controlsfx.control.action.AbstractAction;
import org.controlsfx.control.action.ActionGroup;
import org.controlsfx.control.action.ActionUtils;

public class Start extends javafx.application.Application implements DocumentEditorProvider {

    private TabPane tabs = new TabPane();
    
    @Override public void start(Stage primaryStage) {
        
        createDocumentEditor();
        
        MenuBar menuBar = ActionUtils.createMenuBar( Arrays.asList( 
          new ActionGroup("File",
              new ActionNewEditor()),       
          new ActionGroup("Edit")       
        ));
        
        
        BorderPane content = new BorderPane();
        content.setTop(menuBar);
        content.setCenter(tabs);
//        Pane statusBar = new Pane( new Label("v 1.0.0"));
//        statusBar.setPadding(new Insets(5,5,5,5));
//        content.setBottom(statusBar);
        
        primaryStage.setTitle("Markdown Pad FX");
        primaryStage.setScene(new Scene(content));
        primaryStage.show();
    }
    
    private DocumentEditor createDocumentEditor() {
        DocumentEditor editor = new DocumentEditor();
        Tab tab = new Tab( "New Document" );
        tab.setContent(editor);
        tabs.getTabs().add(tab);
        tabs.getSelectionModel().select(tab);
        return editor;
    }



    public static void main(String[] args) {
        launch(args);
    }

    public DocumentEditor getDocumentEditor() {
        Tab tab = tabs.getSelectionModel().getSelectedItem();
        return  tab == null? null: (DocumentEditor) tab.getContent();
    }
    
    
/////// Actions //////////////////////////////////////////////////////////////////////////////    

    class ActionNewEditor extends AbstractAction {

        public ActionNewEditor() {
            super("New");
        }

        @Override public void execute(ActionEvent e) {
            createDocumentEditor();
        }
        
    }    
    
}


