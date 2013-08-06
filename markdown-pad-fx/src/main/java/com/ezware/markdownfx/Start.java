package com.ezware.markdownfx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import com.github.rjeschke.txtmark.Processor;

public class Start extends javafx.application.Application {

//    private PegDownProcessor processor = new PegDownProcessor();
    private WebView webView;
    private TextArea textArea; 

    @Override public void start(Stage primaryStage) {

        webView = new WebView();
        webView.getStyleClass().add("browser");

        textArea = new TextArea();
        textArea.setWrapText(true);
        Font font = textArea.fontProperty().get();
        textArea.setFont( Font.font(font.getName(), font.getSize() *1.1 ));
        textArea.textProperty().addListener( new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> ob, String newText, String oldText) {
                reparse(newText);
            }
        });
        
        BorderPane browser = new BorderPane();
        ToolBar toolBar = new ToolBar();
        toolBar.getItems().add( new ComboBox<String>());
        browser.setTop( toolBar);
        browser.setCenter( webView);
        
        SplitPane splitter = new SplitPane();
        splitter.getItems().addAll( textArea, browser);
        
        TabPane tabs = new TabPane();
        Tab tab = new Tab( "New File" );
        tab.setContent(splitter);
        tabs.getTabs().add(tab);
        
        
        primaryStage.setTitle("Markdown FX");
        primaryStage.setScene(new Scene(tabs));
        primaryStage.show();
    }

    String doc = "<!DOCTYPE html><html><head><link href=\"%s\" rel=\"stylesheet\"/></head><body>%s</body></html>";
    String css = //"https://raw.github.com/nicolashery/markdownpad-github/master/markdownpad-github.css"; 
            "http://kevinburke.bitbucket.org/markdowncss/markdown.css";
    
    
    private void reparse( String text ) {
        
        String textHtml = Processor.process(text); //processor.markdownToHtml(text)
        
        String html = String.format( doc, css, textHtml);
        System.out.println(html);
        webView.getEngine().loadContent( html, "text/html");
        webView.getEngine().executeScript("window.scrollTo(100,100);");
    }

    public static void main(String[] args) {
        launch(args);
    }

}
