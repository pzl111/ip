package smolbrain.command;

import smolbrain.Storage;
import smolbrain.Ui;
import smolbrain.task.TaskList;

/**
 * Handles listing of all tasks of chatbot.
 */
public class ListCommand implements Command {

    private boolean isLoading;

    /**
     * Creates a list command.
     */
    public ListCommand() {

    }

    /**
     * Executes this command.
     *
     * @param tasks List of tasks of chatbot.
     * @param ui Ui manager of chatbot.
     * @param storage Storage manager of chatbot.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.displayTasks(ui);
    }

    /**
     * Sets the flag that chatbot is loading to true.
     */
    @Override
    public void setLoading() {
        this.isLoading = true;
    }

}
