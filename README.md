Man in the middle attack for SHH
======================================

This program demonstrates man-in-the-middle attack with key manipulation for ssh. [JSch](http://www.jcraft.com/jsch/) will be used.

If this PoC is run it listens to a port on the local machine, and logically forwards the connection to an SSH server running on the network. It does so my termiating the SSH conection from the client, and establishing its own connection to the 'real' server:  `client -ssh connection #1-> PoC -ssh connection #2-> SSH server`.

This PoC pnly supports password authentication.

The original implementation has been done by [ymnk](https://github.com/ymnk/man-in-the-middle-attack.git). I (Jens) just added this file, more logging, adn the `sbt` configuration.

Running
============
Best run this in a screen session with three open terminal 'tabs'.

### Start sshd
```bash
# This will start an SSH server on port 3333 that accepts password authentication
sudo /usr/sbin/sshd -p 3333 -d -o PasswordAuthentication=yes
```

### Start the program:

```bash
# This will start the mitm proxy on port 2222, it will "forward" the connection to 127.0.0.1:3333
sbt "run  2222 127.0.0.1 3333"
```

### Connect to the proxy:

```bash
ssh 127.0.0.1 -p2222
```



