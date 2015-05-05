package idv.steven.rv;
 
import com.tibco.tibrv.Tibrv;
import com.tibco.tibrv.TibrvException;
import com.tibco.tibrv.TibrvMsg;
import com.tibco.tibrv.TibrvRvdTransport;
import com.tibco.tibrv.TibrvTransport;

public class SyncClient {
    private String service = null;
    private String network = null;
    private String daemon  = null;
    
    private TibrvTransport transport = null;
    private double timeout = 5; //second
    
    public void run(String[] args) {
        int i = loadParameters(args);
        if (i > args.length-2) {
            usage();
            return;
        }
        
        try {
            Tibrv.open(Tibrv.IMPL_NATIVE);
            
            transport = new TibrvRvdTransport(service,network,daemon);
             
            String subject = args[args.length-2];
            String sendData = args[args.length-1];
            
            TibrvMsg msg = new TibrvMsg();
            msg.setSendSubject(subject);
            msg.update("sendData", sendData);
            
            TibrvMsg replyMsg = null;
            replyMsg = transport.sendRequest(msg, timeout);
            
            if (replyMsg == null)
                System.out.println("request time-out");
            else 
                System.out.println("Receive reply msg:" + replyMsg);
        } catch (TibrvException e) {
            e.printStackTrace();
        }
        finally {
            try {
                Tibrv.close();
            } catch (TibrvException e) {
                e.printStackTrace();
            }
        }
    }
    
    int loadParameters(String[] args)
    {
    	int i=0;
        while(i < args.length-1 && args[i].startsWith("-"))
        {
            if (args[i].equals("-service"))
            {
                service = args[i+1];
                i += 2;
            }
            else
            if (args[i].equals("-network"))
            {
                network = args[i+1];
                i += 2;
            }
            else
            if (args[i].equals("-daemon"))
            {
                daemon = args[i+1];
                i += 2;
            }
            else
                usage();
        }
        return i;
    }
    
    void usage()
    {
        System.err.println("Usage: java idv.steven.rv.Client [-service service] [-network network]");
        System.err.println("            [-daemon daemon] <subject> <messages>");
        System.exit(-1);
    }

    public static void main(String[] args) {
        new SyncClient().run(args);
    }

}
 