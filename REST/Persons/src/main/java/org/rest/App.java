/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rest;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

/**
 *
 * @author danecek
 */
public class App extends Application {

    public static void main(String[] args) {
        App.launch(App.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        startServer();
        Button btn = new Button();
        btn.setText("Say 'Hello Worln();\n"
                + "        btn.setText(\"Say 'Hello Wd'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        ListView<Person> lv = new ListView<>();
        lv.setItems(FXCollections.<Person>observableArrayList(Proxy.inst.persons()));

        Pane root = new VBox();
        root.getChildren().addAll(lv, new Text(Proxy.inst.persons(1).toString()));

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private static Server startServer() throws Exception {
        JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
        sf.setAddress(Proxy.ENDPOINT_ADDRESS);
        sf.setResourceClasses(PersonsResource.class);
        Server server = sf.create();
        server.start();
        return server;
    }

}
