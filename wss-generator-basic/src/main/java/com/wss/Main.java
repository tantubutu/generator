package com.wss;

import com.wss.cli.CommandExecutor;

/**
 * ClassName: ${NAME}
 * Package: com.wss
 * Description:
 *
 * @Author
 * @Create ${DATE} ${TIME}
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
       // args = new String[]{"generate", "-l", "-a", "-o"};
      //  args = new String[]{"config"};
        //args = new String[]{"list"};
        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.doExecute(args);
    }
}