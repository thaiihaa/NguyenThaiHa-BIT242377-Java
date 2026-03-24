package com.mycompany.baitapluyen12;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import java.net.URI;

public class ChatController {
    @FXML private TextArea txtChatArea;
    @FXML private TextField txtInput;
    
    private WebSocketClient client;

    @FXML
    public void initialize() {
        connectToServer();
    }

    private void connectToServer() {
        try {
            client = new WebSocketClient(new URI("ws://localhost:8887")) {
                @Override
                public void onOpen(ServerHandshake handshakedata) {
                    Platform.runLater(() -> txtChatArea.appendText("[Hệ thống] Đã kết nối tới server!\n"));
                }

                @Override
                public void onMessage(String message) {
                    // Cập nhật UI từ thread của WebSocket sang JavaFX Thread
                    Platform.runLater(() -> txtChatArea.appendText(message + "\n"));
                }

                @Override
                public void onClose(int code, String reason, boolean remote) {
                    Platform.runLater(() -> txtChatArea.appendText("[Hệ thống] Mất kết nối.\n"));
                }

                @Override
                public void onError(Exception ex) { ex.printStackTrace(); }
            };
            client.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleSend() {
        String msg = txtInput.getText().trim();
        if (!msg.isEmpty() && client.isOpen()) {
            // Gửi kèm tên (ví dụ Tú hoặc User B)
            client.send("User: " + msg); 
            txtInput.clear();
        }
    }
}