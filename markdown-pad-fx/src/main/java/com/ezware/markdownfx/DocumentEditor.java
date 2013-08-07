package com.ezware.markdownfx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.scene.web.WebView;

import com.github.rjeschke.txtmark.Processor;

public class DocumentEditor extends SplitPane {

    private WebView webView;
    private TextArea textArea;
    
    private boolean dirty = false;
    
    public DocumentEditor( String text ) {
        
        webView = new WebView();
        webView.getStyleClass().add("browser");

        textArea = new TextArea(text);
        textArea.setWrapText(true);
        
        Font font = textArea.fontProperty().get();
        textArea.setFont( Font.font(font.getName(), font.getSize() *1.1 ));
        
        textArea.textProperty().addListener( new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> ob, String newText, String oldText) {
                reparse(newText);
                dirty = true;
            }
        });
        
        getItems().addAll( textArea, webView);

    }
    
    private static String doc = "<!DOCTYPE html><html><head><link href=\"%s\" rel=\"stylesheet\"/></head><body>%s</body></html>";
    private static String css = //"https://raw.github.com/nicolashery/markdownpad-github/master/markdownpad-github.css"; 
            "http://kevinburke.bitbucket.org/markdowncss/markdown.css";
    
    
    private void reparse( String text ) {
        
        String textHtml = Processor.process(text); 
        
        String html = String.format( doc, css, textHtml);
//        System.out.println(html);
        webView.getEngine().loadContent( html, "text/html");
//        webView.getEngine().executeScript("window.scrollTo(100,100);");
    }   
    
    public boolean isDirty() {
        return dirty;
    }
    
    
}
