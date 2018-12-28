/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package differTrade.project;
import java.net.URI;
import java.io.IOException;
import java.lang.InterruptedException;
import javax.websocket.*;
/**
 *
 * @author adie
 */

@ClientEndpoint
public class WSClient {
    @OnOpen
    public void onOpen(Session session) throws java.io.IOException
    {
        session.getBasicRemote().sendText("{\"ticks\": \"R_100\"}");
    }

    @OnMessage
    public void onMessage(String message)
    {
        System.out.println("ticks update: " + message);
    }

    public static void main(String[] args)
        throws IOException, DeploymentException, InterruptedException
    {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        URI apiUri = URI.create("wss://ws.binaryws.com/websockets/v3?app_id=1088");
        Session session = container.connectToServer(WSClient.class, apiUri);
        Thread.sleep(10000);
        System.out.println(session);
    }
}
