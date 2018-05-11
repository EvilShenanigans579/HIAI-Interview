# HIAI-Interview
Please create 2 identical Ubuntu VMs using the iso below:
http://mirror.hmc.edu/ubuntu-releases/18.04/ubuntu-18.04-desktop-amd64.iso

Install the necessary JDK requirements using 
```
sudo apt-get install default-jdk
```

Run a copy of AgentSystem.java on each machine, passing the "PingAgent" or "PongAgent" command line argument on your respectively designated machine.
```
sudo java AgentSystem PingAgent
sudo java AgentSystem PongAgent
```
