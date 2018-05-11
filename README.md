# HIAI-Interview
Please create 2 identical Ubuntu VMs in VirtuaLBox using the iso below:
http://mirror.hmc.edu/ubuntu-releases/18.04/ubuntu-18.04-desktop-amd64.iso

Esnure that both VMs are connected on the same NAT Network under each VM's Network tab, and ensure the ports are the same as the ones used in AgentSysten.java (22). If they are different, adjust the ports in AgentSystem.java accordingly.

Install the necessary JDK requirements using 
```
sudo apt-get install default-jdk
```
Compile AgentSystem.java to an executable class file
```
javac AgentSystem.java
```
Run a copy of AgentSystem.java on each machine, passing the "PingAgent" or "PongAgent" command line argument on your respectively designated machine.
```
sudo java AgentSystem PingAgent
sudo java AgentSystem PongAgent
```
