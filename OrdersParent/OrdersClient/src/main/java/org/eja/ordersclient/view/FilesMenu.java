package org.eja.ordersclient.view;

import org.eja.ordersclient.controller.ExitAction;
import javafx.scene.control.Menu;
import org.eja.ordersclient.Messages;

public class FilesMenu extends Menu {

    public FilesMenu() {
        super(Messages.Files.createMess());
        getItems().addAll(ExitAction.instance.genMenuItem());
    }

}
