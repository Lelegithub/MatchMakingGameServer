package simple;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.net.Socket;

import compute.Task;

public class PlayerConnectionHandler implements Runnable
{
    private final Socket clientSocket;
	private InfoMatch infoMatch;

    public PlayerConnectionHandler(Socket clientSocket)
    {
        this.infoMatch = new InfoMatch();
    	this.clientSocket = clientSocket;
    }

    public void run()
    {
    	ObjectInputStream in;
    	ObjectOutputStream out;

        try
        {
            in = new ObjectInputStream(clientSocket.getInputStream());
            out = new ObjectOutputStream(clientSocket.getOutputStream());
        } catch (IOException e)
        {
            System.out.println(e.toString());
            return;
        }

        Object command;
        
        try {
            command = in.readObject();
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe.toString());
            return;
        } catch (OptionalDataException ode) {
            System.out.println(ode.toString());
            return;
        } catch (IOException ioe) {
            System.out.println(ioe.toString());
            return;
        }

        if (command instanceof Command) {
        	this.handleCommand((Command) command);
            
        }

        

        try {
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            Object taskObj = null;
			out.writeObject(taskObj);
            out.flush();
        } catch (IOException e) {
            System.out.println(e.toString());
        }

        
        try
        {
            out.close();
            in.close();
            clientSocket.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

	private void handleCommand(Command command) {
		// TODO Auto-generated method stub
		
		
	}
}
