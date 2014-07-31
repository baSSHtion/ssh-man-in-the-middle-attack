This program demonstrates man-in-the-middle attack with
the key manipulation for ssh. JSch[1] will be used.

[1] http://www.jcraft.com/jsch/


Running
============

Start the program:

```bash
sbt "run  2222 127.0.0.1 22"
```

Connect to the proxy:

```bash
ssh 127.0.0.1 -p2222
```



