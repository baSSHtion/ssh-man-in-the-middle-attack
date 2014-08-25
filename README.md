Man in the middle attack for SHH
======================================

This program demonstrates man-in-the-middle attack with key manipulation for ssh that intercepts the plaintext communication, and the password used for authentication.

If this PoC is run, it listens to a port on the local machine, and logically forwards the connection to a SSH server running on the network. It does so my terminating the SSH connection from the client, and establishing its own connection to the 'real' server. This allows the PoC to read the communication in plain.


(Original implementation by [ymnk](https://github.com/ymnk/man-in-the-middle-attack.git))

```text
Connection 1:
client --> PoC 

Connection 2:
PoC --> SSH server
```

SSH provides a native defense against this kind of attack: the servers host keys, and the `known_hosts` file. 

The lesson to take away is: always verify the host key on first connect, and always be very suspicious, when the hostkey changes.


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

Misc
======
* This PoC only supports password authentication.
* [JSch](http://www.jcraft.com/jsch/) is the SSH library used. 
* The original implementation has been done by [ymnk](https://github.com/ymnk/man-in-the-middle-attack.git). I (Jens) just added this file, more logging, and the `sbt` configuration.
