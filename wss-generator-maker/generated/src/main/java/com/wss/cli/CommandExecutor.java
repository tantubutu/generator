package com.wss.maker.cli;

import com.wss.maker.cli.command.ConfigCommand;
import com.wss.maker.cli.command.GenerateCommand;
import com.wss.maker.cli.command.ListCommand;
import picocli.CommandLine;

/**
 * ClassName: CommandExecutor
 * Package: com.wss.cli
 * Description:
 *
 * @Author
 * @Create 2025/3/7 14:13
 * @Version 1.0
 */
@CommandLine.Command(name = "acm-template-pro-generator", mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable {

    private final CommandLine commandLine;

    {
        commandLine = new CommandLine(this)
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ConfigCommand())
                .addSubcommand(new ListCommand());
    }

    @Override
    public void run() {
        // 不输入子命令时，给出友好提示
        System.out.println("请输入具体命令，或者输入 --help 查看命令提示");
    }

    /**
     * 执行命令
     *
     * @param args
     * @return
     */
    public Integer doExecute(String[] args) {
        return commandLine.execute(args);
    }
}
