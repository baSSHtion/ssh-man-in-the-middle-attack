package com.jcraft.jsch.mitm


object SSHMessageIds {

  val SSH_MESSAGE_IDS = collection.mutable.HashMap.empty[Int,String]

  def extractMessageIds(clazz : Class[_]): Unit = {
    clazz.getDeclaredFields.foreach{decl =>


      val name = decl.getName

      if (name.startsWith("SSH_MSG") ) {
        decl.setAccessible(true)
        val value : Int = decl.getInt(null)
        //println(s"field $name with value $value")
        SSH_MESSAGE_IDS += (value -> name)
      }
  }}
  extractMessageIds( classOf[ com.jcraft.jsch.Session])
  extractMessageIds( classOf[ com.jcraft.jsch.UserAuth])


  def mapSSHMessageToString(ssh_msg : Int): String = {
    s"$ssh_msg (${SSH_MESSAGE_IDS(ssh_msg)})"
  }
}
