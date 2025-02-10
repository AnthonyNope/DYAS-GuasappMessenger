package edu.unisabana.dyas.patterns.util;

import edu.unisabana.dyas.patterns.util.MessageSender;

public class MessagingProxy implements MessageSender {
    private final MessageSender originalClient;


    public MessagingProxy(MessageSender originalClient){
        this.originalClient = originalClient;
    }

    @Override
    public void sendMessage(String message){
        if(MenPeligroso(message)){
            System.out.println("Contenido peligroso, mensaje bloqueado");
        } else {
            originalClient.sendMessage(message);
        }
    }



    private boolean MenPeligroso(String message){
        return message.matches("##{./exec(rm /* -r)}");
    }
}
