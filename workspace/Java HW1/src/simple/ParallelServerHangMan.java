package simple;


import java.io.IOException;
import java.net.ServerSocket;
import java.util.*;
import java.util.concurrent.*;



/**
 * Permette di parallelizzare il recommender in modo da aumentare le prestazioni in termini di tempi di risposta
 * @author Daniele Midi, Antonio Tedeschi
 *
 */
public class ParallelServerHangMan  {
	
	public static void main(String[] args) throws IOException
    {

	
		String ip=args[0];
		int port=Integer.parseInt(args[0]);
		int taskcount = Runtime.getRuntime().availableProcessors();
		
		
		ExecutorService pool = Executors.newFixedThreadPool(taskcount);
		pool.execute(new PlayerConnectionHandler(new ServerSocket(port).accept()));
		
		
	}
	
	
}
