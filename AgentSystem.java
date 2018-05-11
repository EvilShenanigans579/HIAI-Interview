
        import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
        import java.io.FileNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
        import java.util.ArrayList;
        import java.util.List;
import java.net.NetworkInterface;
import java.util.Collections;


public class AgentSystem {

    // Agent Class
    public static class Agent {
        public int ID = 0;
        public String type = new String();
        // constructor
        public Agent(int a, String b) {
            ID = a;
            type = b;
        }
    }

    public static class PingAgent extends Agent {
        public PingAgent(int a, String b) {
            super(a,b);
            ID = a;
            type = b;
        }

        public void findPong(Agent[] allAgents) {

            int[] allPongIDsTemp = new int[allAgents.length];
            int j = 0;
            for(int i = 0; i < allAgents.length; i++) {
                if(allAgents[i].type.equals("pong")) {
                    allPongIDsTemp[j] = allAgents[i].ID;
                    j++;
                }
            }

            int[] allPongIDs = new int[j];
            for(int k = 0; k < j; k++) {
                allPongIDs[k] = allPongIDsTemp[k];
                System.out.println(allPongIDs[k]);
            }


        }

        public void askForPong(String IP) {

        }
    }

    public static class PongAgent extends Agent {
        public PongAgent(int a, String b) {
            super(a,b);
            ID = a;
            type = b;
        }


        public void findPing(Agent[] allAgents) {

            int[] allPingIDsTemp = new int[allAgents.length];
            int j = 0;
            for(int i = 0; i < allAgents.length; i++) {
                if(allAgents[i].type.equals("ping")) {
                    allPingIDsTemp[j] = allAgents[i].ID;
                    j++;
                }
            }

            int[] allPingIDs = new int[j];
            for(int k = 0; k < j; k++) {
                allPingIDs[k] = allPingIDsTemp[k];
                System.out.println(allPingIDs[k]);
            }


        }

    }


    public static void main(String args[]) throws FileNotFoundException {

        int IDcounter = 100;
        List<PingAgent> pingList = new ArrayList<PingAgent>();
        List<PongAgent> pongList = new ArrayList<PongAgent>();
        // for(int argCounter = 0; argCounter < args.length; argCounter++) {
        //     if(args[argCounter].equalsIgnoreCase("PingAgent")) {
        //         pingList.add(new PingAgent(IDcounter, "ping"));
        //         IDcounter++;
        //     }
        //     else if(args[argCounter].equalsIgnoreCase("PongAgent")) {
        //         pongList.add(new PongAgent(IDcounter, "pong"));
        //         IDcounter++;
        //     }
        // }


        // Agent basic = new Agent(1,"ping");
        // Agent basic1 = new Agent(2,"ping");
        // Agent basic2 = new Agent(3,"pong");
        // Agent basic3 = new Agent(4,"pong");

        // PingAgent ping = new PingAgent(28, "ping");
        // // PongAgent pong = new PongAgent(56, "pong");

        // Agent[] agents = new Agent[4];
        // agents[0] = basic;
        // agents[1] = basic1;
        // agents[2] = basic2;
        // agents[3] = basic3;
        // ping.findPong(agents);
        // pong.findPing(agents);
        // for(int i = 0; i < pingList.size(); i++) {
        //     System.out.println(pingList.get(i).ID);
        // }
        // for(int i = 0; i < pongList.size(); i++) {
        //     System.out.println(pongList.get(i).ID);
        // }
        // // System.out.println(pingList.get(0).ID);
        // // System.out.println(pongList.get(0).ID);

        if(args[0].equalsIgnoreCase("pongagent")) {
            PongAgent pong = new PongAgent(IDcounter, "pong");
            IDcounter++;
            System.out.println("PongAgent[id=" + pong.ID + "]: Waiting for Pings...");
            while(true) {
                try {
		    //Socket s2 = new Socket("10.0.2.6", 6666);
                    //DataOutputStream dos = new DataOutputStream(s2.getOutputStream());
                    //String output = Integer.toString(pong.ID);
                    //dos.writeUTF(output);
                    ServerSocket ss = new ServerSocket(6666);
                    Socket s = ss.accept(); // establishes connnection
                    DataInputStream dis = new DataInputStream(s.getInputStream());
                    String str = (String)dis.readUTF();
                    System.out.println("PongAgent[id=" + pong.ID + "]:  Received ping from PingAgent[id=" + str + "]");
                    System.out.println("PongAgent[id=" + pong.ID + "]:  Sending pong to PingAgent[id=" + str + "]");
                    
                    ss.close();
                    //s2.close();
                }
                catch(Exception e) {
                    System.out.println(e);
                }
            }
        } else if(args[0].equalsIgnoreCase("pingagent")) {
            PingAgent ping = new PingAgent(IDcounter, "ping");
            IDcounter++;
            System.out.println("PingAgent[id=" + ping.ID + "]: Looking for PongAgents...");
            while(true) {
                try {
		
                    ServerSocket ss = new ServerSocket(22);
                    Socket s = ss.accept(); // establishes connnection
                    DataInputStream dis = new DataInputStream(s.getInputStream());
                    String str = (String)dis.readUTF();
                   // if(!(str.equalsIgnoreCase("pong"))) {
                        System.out.println("PingAgent[id=" + ping.ID + "]:  Found PongAgent[id=" + str + "]");
                        System.out.println("PingAgent[id=" + ping.ID + "]:  Sending ping to PongAgent[id=" + str + "]");
                        //Socket s2 = new Socket("10.0.2.6", 6666);
                       // DataOutputStream dos = new DataOutputStream(s2.getOutputStream());
                        //String output = Integer.toString(ping.ID);
                        //dos.writeUTF(output);
                        //s2.close();
                   // } else {
                        System.out.println("PingAgent[id=" + ping.ID + "]:  Received pong from PongAgent[id=" + str + "]");
                   // }
                    
                    
                    ss.close();
                    
                }
                catch(Exception e) {
                    System.out.println(e);
                }
            }
        }


    }

}

